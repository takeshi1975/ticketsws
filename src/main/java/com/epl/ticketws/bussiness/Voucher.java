package com.epl.ticketws.bussiness;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.epl.tickets.model.InformeCrearRespuesta;
import com.epl.ticketws.services.QueryService;

import es.oneboxtm.ns.purchase.order.OrderTickets;
import es.oneboxtm.ns.purchase.order.Ticket;

/**
 * Created by gcortes on 14/03/2017.
 */
@Service
public class Voucher {
    @Value("${app.onebox.url.ticketsPDF}")
    private static  String url_ticketsPDF = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/order/syncTicketsPDF";

    @Autowired
    private  QueryService<OrderTickets> oneboxTickets;

    public  InformeCrearRespuesta  getTicketsPdf(String orderCode){
        InformeCrearRespuesta informeCrearRespuesta = new InformeCrearRespuesta();
        String url = url_ticketsPDF  + "?orderCode="+orderCode;

        OrderTickets orderTickets = oneboxTickets.query(url, "GET", OrderTickets.class, null);
        for (Ticket ticket : orderTickets.getTickets().getTicket()){
            informeCrearRespuesta.getInfpdf().add(ticket.getUrl());

        }

        return informeCrearRespuesta;

    }

}
