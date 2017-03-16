package com.epl.ticketws.bussiness;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.epl.onebox.model.ActivityTicketTypeAvailability;
import com.epl.onebox.model.BasicInfoSessionSearchInfo;
import com.epl.onebox.model.Charge;
import com.epl.onebox.model.EventSearchInfo;
import com.epl.onebox.model.EventsSearch;
import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;
import com.epl.ticketws.services.QueryService;

/**
 * Created by gcortes on 09/03/2017.
 */
@Service
public class Availability {
	
    @Value("${app.onebox.url.search}")
    private static  String url_dispo = "http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/events/search";

    @Autowired
    private  QueryService<EventsSearch> oneboxDispo;

    public DisponibilidadGeneralRespuesta availabilityTicket(String idEvent, String fecini, String fecfin){

        DisponibilidadGeneralRespuesta dgr = new DisponibilidadGeneralRespuesta();

        String url = url_dispo + "?endDate="+fecfin+"&eventType=ACTIVITY&eventType=EVENT&startDate="+fecini;

        EventsSearch eventsSearch = oneboxDispo.query(url, "GET", EventsSearch.class, null);
        Optional<EventSearchInfo> eventSearchInfo = filterTicketsById(idEvent,eventsSearch );
        if (eventSearchInfo.isPresent()) {
            loadTickets(dgr,eventSearchInfo.get());
        }

        return dgr;

    }

    private Optional<EventSearchInfo> filterTicketsById( String idEvent,   EventsSearch eventsSearch ){

        return eventsSearch.getEventSearchInfo().stream().filter(e -> e.getId() == Integer.parseInt(idEvent)).findFirst();
    }

    private void loadTickets(        DisponibilidadGeneralRespuesta dgr ,    EventSearchInfo eventSearchInfo ){
        Infgen infgen = new Infgen();
        infgen.setCoddiv("EUR");
        infgen.setCupest("DS");
        infgen.setCodtou("EPL");
        infgen.setId((int) eventSearchInfo.getId());
        infgen.setNomser(eventSearchInfo.getTitle());
        infgen.setCodser((int) eventSearchInfo.getId());
        //Todo implementar la generacion de Infgen y Infsmo
        for (BasicInfoSessionSearchInfo sessionsSearchInfo: eventSearchInfo.getSessionsSearchInfo().getSessionSearchInfo()){
            for (ActivityTicketTypeAvailability activityTicketTypeAvailability : sessionsSearchInfo.getActivityTicketTypesAvailability().getActivityTicketTypeAvailability()){
                String available = activityTicketTypeAvailability.getAvailabilityInfo().getAvailable() != null ? String.valueOf(activityTicketTypeAvailability.getAvailabilityInfo().getAvailable()):"DS";
                if (!"0".equals(available)) {
                    Infsmo infsmo = new Infsmo();
                    infsmo.setCodsmo(String.valueOf(eventSearchInfo.getId()));
                    infsmo.setCodcon(sessionsSearchInfo.getRates());
                    infsmo.setCodcha(activityTicketTypeAvailability.getName().getValue());
                    infsmo.setCupest("DS");
                    infsmo.setAdlmax(activityTicketTypeAvailability.getName().getValue().contains("Adulto") ? 1 : 0);
                    infsmo.setNinmax(activityTicketTypeAvailability.getName().getValue().contains("Junior") ? 1 : 0);
                    infsmo.setRefdis(activityTicketTypeAvailability.getId());
                    float price = Float.valueOf(activityTicketTypeAvailability.getIndividualPrice().getPromotedPrice().floatValue());
                    for (Charge charge : activityTicketTypeAvailability.getIndividualPrice().getPromotedPriceCharges().getCharge()) { //Añade precios de los cargos.
                        price += charge.getValue().floatValue();
                    }
                    infsmo.setImpcom(price);
                    infsmo.setCupest(available);
                    infgen.getInfsmo().add(infsmo);
                }
            }

        }
        dgr.getInfgen().add(infgen);

    }
}
