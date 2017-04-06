package com.epl.ticketws.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.epl.onebox.model.Datetime;
import com.epl.onebox.model.EventSearchInfo;
import com.epl.onebox.model.EventsSearch;
import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;
import com.epl.ticketws.dto.Modalidad;
import com.epl.ticketws.dto.Response;
import com.epl.ticketws.dto.Servicio;
import com.epl.ticketws.dto.ServicioCupo;
import com.epl.ticketws.dto.Ticket;
import com.epl.ticketws.repo.ErrorRepo;
import com.epl.ticketws.repo.ModalidadRepo;
import com.epl.ticketws.repo.ServicioCupoRepo;
import com.epl.ticketws.repo.ServicioRepo;
import com.epl.ticketws.repo.TicketRepo;

@Component
@CacheDefaults(cacheName = "oneboxCache")
@ComponentScan("com.epl.ticketws.repo")
public class DBQuery {

	private int errorService   = 0;
	private int errorModality  = 0;
	private int errorTicket    = 0;
	private int loadedService  = 0;
	private int loadedModality = 0;
	private int loadedTicket   = 0;
	private List<String> errors = new ArrayList<String>();
	private Logger log = Logger.getLogger(DBQuery.class);
	private final String ERROR_DISPO ="No se ha podido obtener disponibilidad. Consulte los logs";
	private boolean infiniteCapacity;
	
	@Value("${app.onebox.url.dispo}")
	private String urlDispo;

	@Autowired
	private QueryService<EventsSearch> oneboxEngineAvail;

	@Autowired
	private ServicioCupoRepo servicioCupoRepo;
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private ModalidadRepo modalidadRepo;	

	@Autowired
	private ServicioRepo servicioRepo;
	
	
	
	@Autowired
	private ErrorRepo errorRepo;	
	
	private DateFormat getDateFormat(){
		DateFormat df = null;
		try{ // For the begin session date... 
			df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		}catch(Exception ex){
			log.error("Error en el formato de fecha/getXMLReponse", ex);
		}
		return df;
	}
	
	private Optional<DisponibilidadGeneralRespuesta> getXMLResponse(Iterable<Servicio> servicios, Date inicio, Date fin ){		
		DisponibilidadGeneralRespuesta dgr = new DisponibilidadGeneralRespuesta();
		int n  = 0;
		DateFormat df = getDateFormat();		
		if (servicios==null)
			return Optional.empty();
		
		for (Servicio servicio:servicios){
			n++;
			log.info("Se procesa el servicio "+servicio.getId());
			Infgen infgen = new Infgen();
			infgen.setCoddiv("EUR");
			infgen.setCupest("DS");
			infgen.setCodtou("EPL");
			infgen.setCodtse("ACTI");
			infgen.setId((int)servicio.getId());
			infgen.setNomser(servicio.getServicio());
			infgen.setCodser((int)servicio.getId());
			Iterable<Modalidad> modalidades;
			Iterable<ServicioCupo> servicioCupos = servicioCupoRepo.findAll();
			infiniteCapacity = false;
			servicioCupos.forEach(p-> infiniteCapacity = infiniteCapacity || (p.getId()==servicio.getId() && p.getCupo().equals("N")) );			
			if (infiniteCapacity) // Si no está sujeto a cupo.. 
				modalidades = modalidadRepo.findByServiceAndDate(servicio.getId(), new Date());
			else	
				modalidades= modalidadRepo.findByServiceAndDate(servicio.getId(), new Date(), inicio, fin);						
			for (Modalidad modalidad:modalidades){
				Iterable <Ticket> tickets = ticketRepo.findByModalidadId(modalidad.getId());
				for (Ticket ticket:tickets){
					Infsmo infsmo = new Infsmo();
					infsmo.setCodsmo(modalidad.getId()+"#"+modalidad.getModalidad()+"#"+df.format(modalidad.getInicioSesion()));
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
		
		return getXMLResponse(servicios, null, null).orElse(DisponibilidadGeneralRespuesta.createWithError(ERROR_DISPO));
	}

	/**
	 * Obtiene la disponibilidad de la base de datos filtrada por fechas.
	 * No incluye cupo real!
	 * @param fecha1
	 * @param fecha2
	 * @return Disponibilidad de la cache.
	 */
	@CacheResult
	public DisponibilidadGeneralRespuesta getFilteredAvail(String fecha1, String fecha2){
		log.info("Disponibilidad con fechas desde "+fecha1+" hasta "+fecha2);
		Date inicio = null;
		Date fin = null;
		List<Servicio> servicios = null;
		try{
			if (fecha1==null || fecha2==null)
				return DisponibilidadGeneralRespuesta.createWithError(ERROR_DISPO);
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			inicio = df.parse(fecha1);
			fin = df.parse(fecha2);
			if (!inicio.before(fin)){ // Ordena las fechas de forma coherente.
				Date tmp = inicio;
				inicio = fin;
				fin = tmp;
			}			
			fin = this.addDate(fin, 1); // Añadimos un día a la fecha de fin para que incluya la disponibilidad del último día...
			servicios = (List<Servicio>)servicioRepo.findByDates(inicio,fin);			 			
			if (servicios!=null)
				log.info("SIZE-->"+servicios.size());								
			return getXMLResponse(servicios, inicio, fin).orElse(DisponibilidadGeneralRespuesta.createWithError(ERROR_DISPO));
		}catch(Exception ex){
			log.error("Error obteniendo la disponibilidad:", ex);
			errorRepo.handleError("Error obteniendo la disponibilidad", ex);
		}		
		return DisponibilidadGeneralRespuesta.createWithError(ERROR_DISPO);
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
	
	private Date addDate(Date date, int days){
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	private Optional<Date> getDateFromXML(List<Datetime> fechas, String type){
		boolean found = false;
		int index = 0;
		while (!found && index<fechas.size()){			
			found = fechas.get(index++).getType().equals(type);			
		}
		if (found)
			return Optional.of(fechas.get(--index).getValue().toGregorianCalendar().getTime());
		return Optional.empty();
	}
	
	private void loadModalities(EventSearchInfo esi, Servicio servicio) {
		Modalidad modalidad = null;
		for (BasicInfoSessionSearchInfo bissi : esi.getSessionsSearchInfo().getSessionSearchInfo()) {
			try {								
				modalidad = new Modalidad(bissi.getId(), bissi.getRates()+"/"+bissi.getName().getValue(), servicio);
				log.debug("----- Modalidad: " + modalidad);
				Date beginSales = getDateFromXML(bissi.getDates().getDatetime(), "SESSION_SALES_BEGIN").orElse(null);
				Date endSales = getDateFromXML(bissi.getDates().getDatetime(),"SESSION_SALES_END").orElse(null);
				Date sessionBegin = getDateFromXML(bissi.getDates().getDatetime(),"SESSION_BEGIN").orElse(null);				
				modalidad.setInicioVenta(beginSales);
				modalidad.setFinVenta(endSales);
				modalidad.setInicioSesion(sessionBegin);

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
		for (EventSearchInfo esi : eventsSearch.getEventSearchInfo()) {
			try {
				log.info("Servicio:"+esi.getId());
				Servicio servicio = new Servicio(esi.getId(), esi.getTitle());
				Date fechaInicio = getDateFromXML(esi.getDates().getDatetime(),"EVENT_BEGIN").orElse(null);
				Date fechaFin = getDateFromXML(esi.getDates().getDatetime(),"EVENT_END").orElse(null);
				servicio.setInicioEvento(fechaInicio);
				servicio.setFinEvento(fechaFin);				
				servicioRepo.save(servicio);
				loadedService++;
				loadModalities(esi, servicio);
			} catch (Exception ex) {				
				log.error("Service failed "+ esi.getId(), ex);
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
