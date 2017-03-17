package com.epl.ticketws.bussiness;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epl.tickets.model.Estsmo;
import com.epl.tickets.model.Purchase;
import com.epl.tickets.model.ReservaCerrarRespuesta;
import com.epl.tickets.model.Resser;
import com.epl.ticketws.services.QueryService;

import es.oneboxtm.ns.purchase.order.OrderDetails;
import es.oneboxtm.ns.purchase.order.OrderItem;
import es.oneboxtm.ns.shopping.cart.ShoppingCart;

/**
 * Created by gcortes on 10/03/2017.
 */

@Component
public class Book{

	private final String XML = "xml";
	
	@Value("${app.onebox.url.create}")
    private String url_create = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/shoppingCart/create";
    @Value("${app.onebox.url.addIndividualActivitySeats}")
    private String url_addIndividualActivitySeats = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/shoppingCart/addIndividualActivitySeats";
    @Value("${app.onebox.url.clientData}")
    private String url_clientData = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/shoppingCart/clientData";
    @Value("${app.onebox.url.delivery}")
    private String url_delivery = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/shoppingCart/delivery";
    @Value("${app.onebox.url.createOrder}")
    private String url_createOrder = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/order/createOrder";
    @Value("${app.onebox.url.commitOrder}")
    private String url_commitOrder = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/order/commitOrder";

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
  
    @Autowired
    private QueryService<ShoppingCart> oneboxData;

    @Autowired
    private QueryService<OrderDetails> oneboxDetails;

    public ReservaCerrarRespuesta book(Purchase purchase) {
        ReservaCerrarRespuesta rcr = new ReservaCerrarRespuesta();

        ShoppingCart shoppingCart = oneboxData.query(url_create, "POST", "xml", ShoppingCart.class, new HashMap<>());
        shoppingCart = addIndividualSeats(purchase, shoppingCart.getToken());
        shoppingCart = sendClientData(purchase, shoppingCart.getToken());
        shoppingCart = delivery(shoppingCart.getToken());
        OrderDetails orderDetails = createOrder(shoppingCart.getToken());
        orderDetails = commitOrder(shoppingCart.getToken(), orderDetails);
        completeResponse(rcr,orderDetails);

        return rcr;

    }

    private void completeResponse( ReservaCerrarRespuesta rcr ,OrderDetails orderDetails){
        rcr.setCodtou("EPL");
        rcr.setLocata( orderDetails.getOrderCode());
        rcr.setCupest("CM");
        rcr.setFeccre(sdf.format(new Date()));
        rcr.setImpcom(orderDetails.getPriceBreakdown().getFinalPrice());
        rcr.setCoddiv("EUR");

        Resser resser = new Resser();
        resser.setId(new BigInteger("1"));
        resser.setCodser(orderDetails.getOrderItem().get(0).getTicketData().getSessionBasicInfo().getEventBasicInfo().getId());
        resser.setNomser(orderDetails.getOrderItem().get(0).getTicketData().getSessionBasicInfo().getEventBasicInfo().getTitle());
        resser.setImpcom(orderDetails.getPriceBreakdown().getFinalPrice());

        for (OrderItem orderItem : orderDetails.getOrderItem()){
            Estsmo estsmo = new Estsmo();
            estsmo.setId(orderItem.getId());
            estsmo.setCodtrc("ACT");
            estsmo.setCodsmo(orderItem.getTicketData().getSessionBasicInfo().getId().toString());
            estsmo.setCupest("CM");
            estsmo.setCodtrf(orderItem.getTicketData().getIdTicketActivityType().toString());
            estsmo.setNomtrf(orderItem.getTicketData().getSessionBasicInfo().getRates() + " " + orderItem.getTicketData().getNameTicketActivityType());
            estsmo.setImpcom(orderItem.getPriceBreakdown().getFinalPrice());
            estsmo.setNumuni(new BigInteger("1"));
            estsmo.setCodcon(orderItem.getTicketData().getBarcode());
            resser.getEstsmo().add(estsmo);
        }
        rcr.getResser().add(resser);

    }

    private ShoppingCart addIndividualSeats(Purchase purchase, String token) {
        ShoppingCart clientData = null;
        SortedMap<String, String> params = new TreeMap<String, String>();
        for (Purchase.TicketOrder ticketOrder : purchase.getTicketOrders()) {
            params.clear();
            params.put("idSession", ticketOrder.getIdSession());
            params.put("numSeats", ticketOrder.getNumseat());
            params.put("token", token);
            params.put("idActivityTicketType", ticketOrder.getIdActivity());

            clientData = oneboxData.query(url_addIndividualActivitySeats, "POST",XML,  ShoppingCart.class, params);
        }

        return clientData;

    }

    private ShoppingCart sendClientData(Purchase purchase, String token) {
        SortedMap<String,String> params = new TreeMap<String, String>();
        params.put("address", "");
        params.put("city", "");
        params.put("telephone", purchase.getTelephone() != null ? purchase.getTelephone() : "");
        params.put("email", purchase.getEmail() != null ? purchase.getEmail() : "");
        params.put("token", token);
        params.put("firstName", purchase.getFirstname() != null ? purchase.getFirstname() : "");
        params.put("lastName", purchase.getLastname() != null ? purchase.getLastname() : "");
        params.put("postalCode", "");

        ShoppingCart clientData = oneboxData.query(url_clientData, "POST", XML, ShoppingCart.class, params);

        return clientData;

    }

    private ShoppingCart delivery(String token) {
        SortedMap<String,String> params = new TreeMap<String, String>();
        params.put("type", "1");
        params.put("token", token);
        params.put("orderDeliveryCost", "0.0");
        ShoppingCart clientData = oneboxData.query(url_delivery, "POST",XML,  ShoppingCart.class, params);
        return clientData;
    }

    private  OrderDetails createOrder(String token) {
        SortedMap<String,String> params = new TreeMap<String, String>();
        params.put("orderType", "PURCHASE");
        params.put("token", token);
        OrderDetails  orderDetails = oneboxDetails.query(url_createOrder, "POST",XML, OrderDetails .class, params);
        return orderDetails;
    }

    private OrderDetails commitOrder(String token, OrderDetails orderDetails) {
        SortedMap<String,String> params = new TreeMap<String, String>();
        params.put("orderCode", orderDetails.getOrderCode());
        String payments ="<payments xmlns=\"http://www.oneboxtm.es/ns/input-data/purchase/order\"><payment xmlns=\"http://www.oneboxtm.es/ns/input-data/purchase/order\" type=\"CASH\" value=\""+orderDetails.getToBePaid().toString() +"\" /></payments>";
        params.put("payments",payments );
        OrderDetails clientData = oneboxDetails.query(url_commitOrder, "POST",XML, OrderDetails.class, params);
        return clientData;

    }


}
