package com.epl.ticketws.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;
import com.epl.ticketws.dto.Ticket;
import com.epl.ticketws.repo.ErrorRepo;
import com.epl.ticketws.repo.ServicioCupoRepo;
import com.epl.ticketws.repo.TicketRepo;

import es.oneboxtm.ns.data_query.event.EventInfo;
import es.oneboxtm.ns.data_query.session.SessionInfo;
import es.oneboxtm.ns.data_query.session.SessionsInfo;

/**
 * Created by gcortes on 09/03/2017.
 */
@Component
public class Availability {

	@Value("${app.onebox.url.event.info}")
	private String urlEventInfo;

	@Value("${app.onebox.url.session.info}")
	private String urlSessionInfo;

	@Autowired
	private TicketRepo ticketRepo;

	@Autowired
	private ServicioCupoRepo servicioCupoRepo;

	@Autowired
	private QueryService<EventInfo> oneboxEventInfo;

	@Autowired
	private QueryService<SessionInfo> oneboxSessionInfo;
	private boolean infiniteCapacity;
	// @Autowired
	// private QueryService<SessionInfo> oneboxSession;

	private static final Logger log = Logger.getLogger(Availability.class);

	@Autowired
	private ErrorRepo errorRepo;

	/**
	 * Obtener información de disponibilidad por evento y fecha...
	 * 
	 * @param idEvent
	 * @param fecha1
	 * @param fecha2
	 */
	public Optional<DisponibilidadGeneralRespuesta> sessionInfo(int idSession) {

		urlEventInfo = String.format(urlEventInfo, idSession);
		try {
			SessionInfo sessionInfo = oneboxSessionInfo.query(urlSessionInfo, "GET", "XML", SessionInfo.class, null);
			int cupo = sessionInfo.getAvailabilityInfo().getAvailable().intValue();
			log.info("El cupo obtenido es ... " + cupo);
		} catch (Throwable thx) {
			log.error("Error en availabilityInfo", thx);
			errorRepo.handleError("Error en la disponibilidad de ticket", thx);
		}
		return Optional.empty();
	}

	private DisponibilidadGeneralRespuesta getXMLResponse(int idEvent, int idSession, EventInfo eventInfo) {
		DisponibilidadGeneralRespuesta dgr = new DisponibilidadGeneralRespuesta();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		dgr.setIdeses(String.valueOf(idEvent));
		Infgen infgen = new Infgen();
		infgen.setCoddiv("EUR");
		infgen.setCupest("DS");
		infgen.setCodtou("EPL");
		infgen.setCodtse("ACTI");
		infgen.setId(idEvent);
		infgen.setNomser(eventInfo.getTitle());
		infiniteCapacity = false;
		servicioCupoRepo.findAll().forEach(p -> infiniteCapacity |= (idEvent == p.getId() && p.getCupo().equals("N")));
		if (!infiniteCapacity) {
			SessionInfo sessionInfo = eventInfo.getSessionsInfo().getSessionInfo().get(0);
			infgen.setCodser(idEvent);
			Date inicioSesion = sessionInfo.getDates().getDatetime().get(0).getValue().toGregorianCalendar().getTime();

			// Tickets/Caracteríticas
			sessionInfo.getActivityTicketTypesAvailability().getActivityTicketTypeAvailability().forEach( atta-> {
				Infsmo infsmo = new Infsmo();
				infsmo.setCodcha(atta.getName()); // Tipo de característica...
				infsmo.setCodsmo(idSession + "#" + df.format(inicioSesion));
				infsmo.setCodcon(idSession + "#" + atta.getId());
				int cupoCaracteristica = atta.getAvailabilityInfo().getAvailable().intValue();
				infsmo.setId(atta.getId().intValue());
				infsmo.setCapmax(cupoCaracteristica);
				infsmo.setCupest((cupoCaracteristica > 0) ? "DS" : "ND");
				infsmo.setImpcom(atta.getIndividualPrice().getPromotedPrice().floatValue());
				infsmo.setRefdis(0);
				infgen.getInfsmos().add(infsmo);
			});
		} else {
			ticketRepo.findByModalidadId(idSession).forEach(ticket -> {
				Infsmo infsmo = new Infsmo();
				infsmo.setCodcha(ticket.getCaracteristica());
				infsmo.setCodsmo(idSession + "#" );
				infsmo.setCodcon(idSession + "#" + ticket.getTicketPK().getId());				
				infsmo.setId((int) ticket.getTicketPK().getId());
				infsmo.setCapmax(9999);
				infsmo.setCupest("DS");
				infsmo.setImpcom(ticket.getPrecio());
				infsmo.setRefdis(0);
				infgen.getInfsmos().add(infsmo);
			});
		}
		dgr.getInfgens().add(infgen);
		return dgr;
	}

	/**
	 * Información del evento para controlar el cupo!
	 * 
	 * @param idEvent
	 *            --> Servicio
	 * @param idSession
	 *            --> Modalidad Devuelve el cupo de los 4 tipos de pasajeros.
	 * @return
	 */
	public Optional<DisponibilidadGeneralRespuesta> eventInfo(int idEvent, int idSession) {
		try {
			urlEventInfo = String.format(urlEventInfo, idEvent);
			EventInfo eventInfo = oneboxEventInfo.query(urlEventInfo, "GET", "XML", EventInfo.class, null);
			SessionsInfo sessionsInfo = new SessionsInfo();
			sessionsInfo.setSessionInfo(eventInfo.getSessionsInfo().getSessionInfo().stream()
					.filter(p -> p.getId().intValue() == idSession).collect(Collectors.toList()));
			eventInfo.setSessionsInfo(sessionsInfo);
			DisponibilidadGeneralRespuesta dgr = getXMLResponse(idEvent, idSession, eventInfo);
			return Optional.of(dgr);
		} catch (Throwable thx) {
			log.error("Error en la disponibilidad de ticket", thx);
			errorRepo.handleError("Error en la disponibilidad de ticket", thx);
		}
		return Optional.empty();
	}
	/*
	 * private void loadTickets(DisponibilidadGeneralRespuesta dgr,
	 * EventSearchInfo eventSearchInfo) { Infgen infgen = new Infgen();
	 * infgen.setCoddiv("EUR"); infgen.setCupest("DS"); infgen.setCodtou("EPL");
	 * infgen.setId((int) eventSearchInfo.getId());
	 * infgen.setNomser(eventSearchInfo.getTitle()); infgen.setCodser((int)
	 * eventSearchInfo.getId()); // Todo implementar la generacion de Infgen y
	 * Infsmo for (BasicInfoSessionSearchInfo sessionsSearchInfo :
	 * eventSearchInfo.getSessionsSearchInfo() .getSessionSearchInfo()) { for
	 * (ActivityTicketTypeAvailability activityTicketTypeAvailability :
	 * sessionsSearchInfo
	 * .getActivityTicketTypesAvailability().getActivityTicketTypeAvailability()
	 * ) { String available =
	 * activityTicketTypeAvailability.getAvailabilityInfo().getAvailable() !=
	 * null ?
	 * String.valueOf(activityTicketTypeAvailability.getAvailabilityInfo().
	 * getAvailable()) : "DS"; if (!"0".equals(available)) { Infsmo infsmo = new
	 * Infsmo(); infsmo.setCodsmo(String.valueOf(eventSearchInfo.getId()) + "#"
	 * + sessionsSearchInfo.getRates());// #modalidad+#descmodalidad
	 * infsmo.setCodcon( String.valueOf(eventSearchInfo.getId()) + "#" +
	 * activityTicketTypeAvailability.getId()); // descripcion // modalidad
	 * infsmo.setCodcha(activityTicketTypeAvailability.getName().getValue());
	 * infsmo.setCupest("DS");
	 * infsmo.setAdlmax(activityTicketTypeAvailability.getName().getValue().
	 * contains("Adulto") ? 1 : 0);
	 * infsmo.setNinmax(activityTicketTypeAvailability.getName().getValue().
	 * contains("Junior") ? 1 : 0);
	 * infsmo.setRefdis(activityTicketTypeAvailability.getId()); // #Ticket
	 * float price = Float.valueOf(
	 * activityTicketTypeAvailability.getIndividualPrice().getPromotedPrice().
	 * floatValue()); for (Charge charge :
	 * activityTicketTypeAvailability.getIndividualPrice().
	 * getPromotedPriceCharges() .getCharge()) { // Añade precios de los cargos.
	 * price += charge.getValue().floatValue(); } infsmo.setImpcom(price);
	 * infsmo.setCupest(available); infgen.getInfsmos().add(infsmo); } }
	 * 
	 * } dgr.getInfgens().add(infgen); }
	 */
}
