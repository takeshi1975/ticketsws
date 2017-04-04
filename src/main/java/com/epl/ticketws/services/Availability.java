package com.epl.ticketws.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epl.onebox.model.ActivityTicketTypeAvailability;
import com.epl.onebox.model.BasicInfoSessionSearchInfo;
import com.epl.onebox.model.Charge;
import com.epl.onebox.model.EventSearchInfo;
import com.epl.onebox.model.EventsSearch;
import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;
import com.epl.ticketws.repo.ErrorRepo;

/**
 * Created by gcortes on 09/03/2017.
 */
@Component
public class Availability {

	@Value("${app.onebox.url.info}")
	private String urlInfo;

	@Autowired
	private QueryService<EventsSearch> oneboxDispo;
	private static final Logger log = Logger.getLogger(Availability.class);

	@Autowired
	private ErrorRepo errorRepo;

	public Optional<DisponibilidadGeneralRespuesta> availabilityTicket(String idEvent) {		
		DisponibilidadGeneralRespuesta dgr = new DisponibilidadGeneralRespuesta();
		try {						
			String url = String.format(urlInfo, idEvent);

			EventsSearch eventsSearch = oneboxDispo.query(url, "GET", "XML", EventsSearch.class, null);
			Optional<EventSearchInfo> eventSearchInfo = filterTicketsById(idEvent, eventsSearch);
			if (eventSearchInfo.isPresent()) {
				loadTickets(dgr, eventSearchInfo.get());
			}
		} catch (Throwable thx) {
			log.error("Error en la disponibilidad de ticket", thx);
			errorRepo.handleError("Error en la disponibilidad de ticket", thx);
			dgr = null;
		}
		return Optional.of(dgr); // Posible quizás necesite info de la bbdd....??? 
	}

	private Optional<EventSearchInfo> filterTicketsById(String idEvent, EventsSearch eventsSearch) {
		return eventsSearch.getEventSearchInfo().stream().filter(e -> e.getId() == Integer.parseInt(idEvent))
				.findFirst();
	}

	private void loadTickets(DisponibilidadGeneralRespuesta dgr, EventSearchInfo eventSearchInfo) {
		Infgen infgen = new Infgen();
		infgen.setCoddiv("EUR");
		infgen.setCupest("DS");
		infgen.setCodtou("EPL");
		infgen.setId((int) eventSearchInfo.getId());
		infgen.setNomser(eventSearchInfo.getTitle());
		infgen.setCodser((int) eventSearchInfo.getId());
		// Todo implementar la generacion de Infgen y Infsmo
		for (BasicInfoSessionSearchInfo sessionsSearchInfo : eventSearchInfo.getSessionsSearchInfo()
				.getSessionSearchInfo()) {
			for (ActivityTicketTypeAvailability activityTicketTypeAvailability : sessionsSearchInfo
					.getActivityTicketTypesAvailability().getActivityTicketTypeAvailability()) {
				String available = activityTicketTypeAvailability.getAvailabilityInfo().getAvailable() != null
						? String.valueOf(activityTicketTypeAvailability.getAvailabilityInfo().getAvailable()) : "DS";
				if (!"0".equals(available)) {
					Infsmo infsmo = new Infsmo();
					infsmo.setCodsmo(String.valueOf(eventSearchInfo.getId())+"#"+sessionsSearchInfo.getRates());// #modalidad+#descmodalidad
					infsmo.setCodcon(String.valueOf(eventSearchInfo.getId())+"#"+activityTicketTypeAvailability.getId()); // descripcion modalidad
					infsmo.setCodcha(activityTicketTypeAvailability.getName().getValue());
					infsmo.setCupest("DS");
					infsmo.setAdlmax(activityTicketTypeAvailability.getName().getValue().contains("Adulto") ? 1 : 0);
					infsmo.setNinmax(activityTicketTypeAvailability.getName().getValue().contains("Junior") ? 1 : 0);
					infsmo.setRefdis(activityTicketTypeAvailability.getId()); // #Ticket
					float price = Float.valueOf(
							activityTicketTypeAvailability.getIndividualPrice().getPromotedPrice().floatValue());
					for (Charge charge : activityTicketTypeAvailability.getIndividualPrice().getPromotedPriceCharges()
							.getCharge()) { // Añade precios de los cargos.
						price += charge.getValue().floatValue();
					}
					infsmo.setImpcom(price);
					infsmo.setCupest(available);
					infgen.getInfsmos().add(infsmo);
				}
			}

		}
		dgr.getInfgens().add(infgen);

	}

}
