package com.epl.ticketws.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.epl.onebox.model.ActivityTicketTypeAvailability;
import com.epl.onebox.model.BasicInfoSessionSearchInfo;
import com.epl.onebox.model.Charge;
import com.epl.onebox.model.Datetime;
import com.epl.onebox.model.EventSearchInfo;
import com.epl.onebox.model.EventsSearch;
import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;
import com.epl.ticketws.controller.TicketController;
import com.epl.ticketws.dto.Modalidad;
import com.epl.ticketws.dto.Response;
import com.epl.ticketws.dto.Servicio;
import com.epl.ticketws.dto.Ticket;
import com.epl.ticketws.repo.ErrorRepo;
import com.epl.ticketws.repo.ModalidadRepo;
import com.epl.ticketws.repo.ServicioRepo;
import com.epl.ticketws.repo.TicketRepo;

@Component
@CacheDefaults(cacheName = "oneboxCache")
@ComponentScan("com.epl.ticketws.repo")
public class DBQuery {

	private int errorService = 0;
	private int errorModality = 0;
	private int errorTicket = 0;
	private int loadedService = 0;
	private int loadedModality = 0;
	private int loadedTicket = 0;
	private List<String> errors = new ArrayList<String>();
	private Logger log = Logger.getLogger(DBQuery.class);
	private final String ERROR_DISPO ="No se ha podido obtener disponibilidad. Consulte los logs";
	
	@Value("${app.onebox.url.dispo}")
	private String urlDispo;

	@Autowired
	private QueryService<EventsSearch> oneboxEngineAvail;

	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private ModalidadRepo modalidadRepo;	

	@Autowired
	private ServicioRepo servicioRepo;

	@Autowired
	private ErrorRepo errorRepo;
	
	private Optional<DisponibilidadGeneralRespuesta> getXMLResponse(Iterable<Servicio> servicios, Date ... dates ){
		DisponibilidadGeneralRespuesta dgr = new DisponibilidadGeneralRespuesta();
		int n  = 0;
		if (servicios==null)
			return Optional.empty();
		for (Servicio servicio:servicios){
			n++;
			Infgen infgen = new Infgen();
			infgen.setCoddiv("EUR");
			infgen.setCupest("DS");
			infgen.setCodtou("EPL");
			infgen.setCodtse("ACTI");
			infgen.setId((int)servicio.getId());
			infgen.setNomser(servicio.getServicio());
			infgen.setCodser((int)servicio.getId());							
			Iterable<Modalidad> modalidades = modalidadRepo.findByServiceAndDate(servicio.getId(), new Date());
			
			for (Modalidad modalidad:modalidades){
				Iterable <Ticket> tickets = ticketRepo.findByModalidadId(modalidad.getId());
				for (Ticket ticket:tickets){
					Infsmo infsmo = new Infsmo();
					infsmo.setCodsmo(modalidad.getId()+"#"+modalidad.getModalidad());
					infsmo.setCodcon(modalidad.getId()+"#"+ticket.getTicketPK().getId());  
					infsmo.setCodcha(ticket.getCaracteristica());
					infsmo.setCupest("DS");
					infsmo.setAdlmax(ticket.getCaracteristica().contains("Adulto")?1:0);					
					infsmo.setNinmax(ticket.getCaracteristica().contains("Junior")?1:0);					
					infsmo.setRefdis((int)ticket.getTicketPK().getId());
					infsmo.setImpcom(ticket.getPrecio());
					infgen.getInfsmos().add(infsmo);
				}												 
			}
			dgr.getInfgens().add(infgen);			
		}		
		return  (n>0)?Optional.of(dgr):Optional.ofNullable(null);		
	}
				
		
	@CacheResult
	public DisponibilidadGeneralRespuesta getGeneralAvail(){
		Iterable<Servicio> servicios = servicioRepo.findAll();
		
		return getXMLResponse(servicios).orElse(DisponibilidadGeneralRespuesta.createWithError(ERROR_DISPO));
	}
	
	@CacheResult
	public DisponibilidadGeneralRespuesta getFilteredAvail(String fecha1, String fecha2){
		log.info("Disponibilidad con fechas desde "+fecha1+" hasta "+fecha2);
		Iterable<Servicio> servicios = null;
		try{
			if (fecha1==null || fecha2==null)
				return DisponibilidadGeneralRespuesta.createWithError(ERROR_DISPO);
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date inicio = df.parse(fecha1);
			Date fin = df.parse(fecha2);
			if (!inicio.before(fin)){
				Date tmp = inicio;
				inicio = fin;
				fin = tmp;
			}			
			servicios = servicioRepo.findByDates(inicio,fin);			 
			List<Servicio> lstServicios = (List<Servicio>)servicios;
			if (lstServicios!=null){
				log.info("SIZE-->"+lstServicios.size());
			}			
		}catch(Exception ex){
			log.error("Error obteniendo la disponibilidad:", ex);
			errorRepo.handleError("Error obteniendo la disponibilidad", ex);
		}
		return getXMLResponse(servicios).orElse(DisponibilidadGeneralRespuesta.createWithError(ERROR_DISPO));
	}
	
	@CacheRemoveAll
	public Optional<Response> erase() {			
		try{
			this.ticketRepo.deleteAll(); // Borrar todos los datos
			this.modalidadRepo.deleteAll();
			this.servicioRepo.deleteAll();			
		} catch(Exception ex){
			errorRepo.handleError("fallo en el borrado", ex);
			log.error("fallo en el borrado de datos");
		}
		return Optional.empty();
	}
		
	private void loadTickets(BasicInfoSessionSearchInfo bissi, Servicio servicio, Modalidad modalidad) {
		Ticket ticket = null;		
		for (ActivityTicketTypeAvailability at : bissi.getActivityTicketTypesAvailability()
				.getActivityTicketTypeAvailability()) {
			try {
				float price = Float.valueOf(at.getIndividualPrice().getPromotedPrice().floatValue());
				for (Charge charge : at.getIndividualPrice().getPromotedPriceCharges().getCharge()) // Añade
																									// precios
																									// de
																									// los
																									// cargos.
					price += charge.getValue().floatValue();
				ticket = new Ticket((long) at.getId(), at.getName().getValue(), price, 0, modalidad, servicio);
				ticketRepo.save(ticket);
				loadedTicket++;
			} catch (Exception ex) {				
				log.error("Ticked failed "+ ticket, ex);
				errors.add(ex.toString());
				errorTicket++;
			}
		}
	}

	private void loadModalities(EventSearchInfo esi, Servicio servicio) {
		Modalidad modalidad = null;
		for (BasicInfoSessionSearchInfo bissi : esi.getSessionsSearchInfo().getSessionSearchInfo()) {
			try {
				modalidad = new Modalidad(bissi.getId(), bissi.getRates(), servicio);
				log.debug(" Modalidad: " + modalidad);
				if (bissi.getDates().getDatetime().size() > 0) {
					Datetime inicio = bissi.getDates().getDatetime().get(0);
					modalidad.setInicioVenta(inicio.getValue().toGregorianCalendar().getTime());
				}
				if (bissi.getDates().getDatetime().size() > 1) {
					Datetime finalt = bissi.getDates().getDatetime().get(1);
					modalidad.setFinVenta(finalt.getValue().toGregorianCalendar().getTime());
				}

				modalidadRepo.save(modalidad);
				loadedModality++;
				loadTickets(bissi, servicio, modalidad);
			} catch (Exception ex) {
				errorModality++;
				log.error(ex.toString());
				log.error("Modality failed " + modalidad, ex );
				errors.add(ex.toString());
			}
		}
	}

	private void loadServices(EventsSearch eventsSearch) {
		errorService = 0;
		errorModality = 0;
		errorTicket = 0;
		loadedService = 0;
		loadedModality = 0;
		loadedTicket = 0;
		Servicio servicio = null;
		for (EventSearchInfo esi : eventsSearch.getEventSearchInfo()) {
			try {
				Datetime fechaFin = esi.getDates().getDatetime().get(1);
				servicio = new Servicio((long) esi.getId(), esi.getTitle());
				if (esi.getDates().getDatetime().size() >= 1) {
					Datetime fechaInicio = esi.getDates().getDatetime().get(0);
					servicio.setInicioEvento(fechaInicio.getValue().toGregorianCalendar().getTime());
				}
				if (esi.getDates().getDatetime().size() >= 2) {
					Datetime fechaInicio = esi.getDates().getDatetime().get(1);
					servicio.setInicioEvento(fechaInicio.getValue().toGregorianCalendar().getTime());
				}
				servicio.setFinEvento(fechaFin.getValue().toGregorianCalendar().getTime());
				log.debug(" Servicio:" + servicio);
				servicioRepo.save(servicio);
				loadedService++;
				loadModalities(esi, servicio);
			} catch (Exception ex) {				
				log.error("Modality failed "+ servicio, ex);
				errors.add(ex.toString());
				errorService++;
			}
		}
	}

	/**
	 * Realiza una carga con toda la disponibilidad de base de datos que tengan en Onebox
	 * @return
	 */	
	public Optional<Response> load() {
		log.info("Carga de disponibilidad sin parámetros");
		log.info("URL -->" + urlDispo);		
		String msg = null;
		try{
			errors.clear();						
			erase();// Borrar los datos previos
			EventsSearch eventsSearch = oneboxEngineAvail.query(urlDispo, "GET", "XML",
					EventsSearch.class, null);
			loadServices(eventsSearch); // Consultar onebox 
			msg = String.format("Errors S[%d/%d] M[%d/%d] T[%d/%d]", errorService, loadedService, errorModality,
				loadedModality, errorTicket, loadedTicket);									
			return Optional.of(Response.createResponse(msg));		
		} catch(Exception ex){
			log.error("Error en load", ex);
			errorRepo.handleError("Fallo en el load", ex);
			return Optional.empty();
		}		
	}	
	
}
