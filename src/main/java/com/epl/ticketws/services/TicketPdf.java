package com.epl.ticketws.services;

import java.awt.Dimension;
import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;
import org.zefer.pd4ml.PD4PageMark;

import com.epl.tickets.model.InformeCrearRespuesta;
import com.epl.tickets.model.Resser;

import es.oneboxtm.ns.dates.Datetime;
import es.oneboxtm.ns.dates.DatetimeType;
import es.oneboxtm.ns.purchase.order.OrderDetails;
import es.oneboxtm.ns.purchase.order.OrderItem;

/**
 * Created by gcortes on 04/04/2017.
 */
@Repository
public class TicketPdf implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Value("${app.onebox.url.ticketsPDF}")
    private String url_ticketsInfo = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/order/details";

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private QueryService<OrderDetails> oneboxTickets;


    public byte[] generateTickets(String orderCode) {
        byte[] bContent = null;
        try {
            String url = url_ticketsInfo + "?orderCode=" + orderCode;

            OrderDetails orderTickets = oneboxTickets.query(url, "GET","XML", OrderDetails.class, null);
            bContent = generateContent(orderTickets);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bContent;

    }


    private byte[] generateContent(OrderDetails orderTickets) throws Exception {
        byte[] bContent = null;
        try {
            InformeCrearRespuesta informeCrearRespuesta = new InformeCrearRespuesta();

            for (OrderItem itemTicketInfo : orderTickets.getOrderItem()) {
                Resser resser = new Resser();
                byte[] b = BarCodeGenerator.generateBarcode(itemTicketInfo.getTicketData().getBarcode(),0);
                ByteArrayInputStream bInput = new ByteArrayInputStream(b);
                byte [] buffer = new byte[bInput.available()];
                bInput.read(buffer);
                String qrImage = Base64.getEncoder().encodeToString(buffer);
                		
                resser.setBarcode(qrImage);

                b = BarCodeGenerator.generateBarcode(itemTicketInfo.getTicketData().getBarcode(),90);
                bInput = new ByteArrayInputStream(b);
                buffer = new byte[bInput.available()];
                bInput.read(buffer);
                qrImage = Base64.getEncoder().encodeToString(buffer);
                resser.setBarcodev(qrImage);

                resser.setCodage(itemTicketInfo.getTicketData().getSessionBasicInfo().getEventBasicInfo().getEntidad().getName());
                resser.setCodzge(itemTicketInfo.getTicketData().getSessionBasicInfo().getVenue().getLocation().getCity());
                resser.setCodtse(itemTicketInfo.getTicketData().getSessionBasicInfo().getEventBasicInfo().getTitle());
                resser.setNomser(itemTicketInfo.getTicketData().getSessionBasicInfo().getName() + " " + itemTicketInfo.getTicketData().getNameTicketActivityType());
                Datetime fecini = itemTicketInfo.getTicketData().getSessionBasicInfo().getDates().getDatetime().stream().filter(e -> e.getType() == DatetimeType.SESSION_SALES_BEGIN).findFirst().get();
                        Date date = fecini.getValue().toGregorianCalendar().getTime();
                resser.setFecini(formatter.format(date));
                Datetime fecfin = itemTicketInfo.getTicketData().getSessionBasicInfo().getDates().getDatetime().stream().filter(e -> e.getType() == DatetimeType.SESSION_SALES_END).findFirst().get();
                date = fecfin.getValue().toGregorianCalendar().getTime();
                resser.setFecfin(formatter.format(date));

                informeCrearRespuesta.getResser().add(resser);
            }


            ThymeleafContext context = new ThymeleafContext(Locale.ENGLISH);
            context.setThymeleafTemplate("bono_pdf");
            context.addThymeleafPropertyIfAbsent("tickets", informeCrearRespuesta);
            String response = ThymeleafEngine.getContentFrom(context);

            bContent = generatePDF(response);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bContent;
    }



    private  byte[] generatePDF(String content)
            throws Exception {


        String fontsDir = null,  headerBody = null;

        ByteArrayOutputStream fos = new ByteArrayOutputStream();

        PD4ML pd4ml = new PD4ML();
        pd4ml.setPageInsets(new Insets(1, 1, 1, 1));
        Dimension landscape = pd4ml.changePageOrientation(PD4Constants.A5);
        pd4ml.setPageSize(landscape);
        pd4ml.setHtmlWidth(1510);

        if ( fontsDir != null && fontsDir.length() > 0 ) {
            pd4ml.useTTF( fontsDir, true );
        }
        if ( headerBody != null && headerBody.length() > 0 ) {
            PD4PageMark header = new PD4PageMark();
            header.setHtmlTemplate( headerBody ); // autocompute
            pd4ml.setPageHeader( header );
        }

        StringReader input = new StringReader(content);

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("pd4ml.extra.resource.loaders", "com.epl.ticketws.services.CustomPd4mlProvider");
        pd4ml.setDynamicParams(map);

        pd4ml.render(input,fos);

        return fos.toByteArray();
    }


}
