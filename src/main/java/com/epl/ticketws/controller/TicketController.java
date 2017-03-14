package com.epl.ticketws.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.cache.annotation.CacheResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epl.onebox.infoser.SessionInfo;
import com.epl.onebox.model.ActivityTicketTypeAvailability;
import com.epl.onebox.model.BasicInfoSessionSearchInfo;
import com.epl.onebox.model.Charge;
import com.epl.onebox.model.Datetime;
import com.epl.onebox.model.EventSearchInfo;
import com.epl.onebox.model.EventsSearch;
import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;
import com.epl.ticketws.dto.Modalidad;
import com.epl.ticketws.dto.Response;
import com.epl.ticketws.dto.Servicio;
import com.epl.ticketws.dto.Ticket;
import com.epl.ticketws.repo.ModalidadRepo;
import com.epl.ticketws.repo.ServicioRepo;
import com.epl.ticketws.repo.TicketRepo;
import com.epl.ticketws.services.QueryService;



@RestController
@RequestMapping("/tickets")
@ComponentScan({"com.epl.ticketws.services", "com.epl.ticketws.repo"})
public class TicketController {
	
	@Value("${app.onebox.url.dispo}")
	private String urlDispo;
	
	@Value("${app.onebox.url.info}")
	private String urlInfo;
	
	@Autowired
	private QueryService<EventsSearch> oneboxEngineAvail;
	
	@Autowired
	private QueryService<SessionInfo> oneboxEngineInfo;
	
	@Autowired
	private ServicioRepo servicioRepo;
	
	@Autowired
	private ModalidadRepo modalidadRepo;
	
	@Autowired
	private TicketRepo ticketRepo;
	
	private int errorService = 0;
	private int errorModality=0;
	private int errorTicket=0;
	private int loadedService=0;
	private int loadedModality=0;
	private int loadedTicket=0;
	private List<String> errors= new ArrayList<String>();
	private Logger log = Logger.getLogger(TicketController.class);
	
	private void loadTickets(BasicInfoSessionSearchInfo bissi, Servicio servicio,Modalidad modalidad){
		Ticket ticket= null;
		for (ActivityTicketTypeAvailability at: bissi.getActivityTicketTypesAvailability().getActivityTicketTypeAvailability()){
			try{	
				float price = Float.valueOf(at.getIndividualPrice().getPromotedPrice().floatValue());
				for (Charge charge:at.getIndividualPrice().getPromotedPriceCharges().getCharge()) //Añade precios de los cargos.
					price += charge.getValue().floatValue();	
				ticket = new Ticket((long)at.getId(),at.getName().getValue(), price, 0, modalidad, servicio);
				ticketRepo.save(ticket);
				loadedTicket++;
			}catch(Exception ex){
				log.error(ex.toString()+" ");
				log.error("Ticked failed "+ticket);
				errors.add(ex.toString());
				errorTicket++;
			}
		}
	}
	
	private void loadModalities(EventSearchInfo esi, Servicio servicio){
		Modalidad modalidad= null;
		for (BasicInfoSessionSearchInfo bissi: esi.getSessionsSearchInfo().getSessionSearchInfo()){	
			try{				
				modalidad =new Modalidad(bissi.getId(), bissi.getRates(), servicio);
				log.debug(" Modalidad: "+modalidad);
				if (bissi.getDates().getDatetime().size()>0){
					Datetime inicio = bissi.getDates().getDatetime().get(0);
					modalidad.setInicioVenta(inicio.getValue().toGregorianCalendar().getTime());
				}
				if (bissi.getDates().getDatetime().size()>1){
					Datetime finalt = bissi.getDates().getDatetime().get(1);
					modalidad.setFinVenta(finalt.getValue().toGregorianCalendar().getTime());
				}
				
				modalidadRepo.save(modalidad);
				loadedModality++;
				loadTickets(bissi, servicio, modalidad);
			} catch(Exception ex){
				errorModality++;			
				log.error(ex.toString());
				log.error("Modality failed "+modalidad+"");
				errors.add(ex.toString());
				
			}
		}
	}

	private void loadServices(EventsSearch eventsSearch){
		errorService = 0;
		errorModality=0;
		errorTicket=0;
		loadedService=0;
		loadedModality=0;
		loadedTicket=0;
		Servicio servicio = null;
		for (EventSearchInfo esi: eventsSearch.getEventSearchInfo()){
			try{						
				Datetime fechaFin = esi.getDates().getDatetime().get(1);
				servicio = new Servicio((long)esi.getId(),esi.getTitle());
				if (esi.getDates().getDatetime().size()>=1){
					Datetime fechaInicio = esi.getDates().getDatetime().get(0);
					servicio.setInicioEvento(fechaInicio.getValue().toGregorianCalendar().getTime());
				}
				if (esi.getDates().getDatetime().size()>=2){
					Datetime fechaInicio = esi.getDates().getDatetime().get(1);
					servicio.setInicioEvento(fechaInicio.getValue().toGregorianCalendar().getTime());
				}
				servicio.setFinEvento(fechaFin.getValue().toGregorianCalendar().getTime());
				log.debug(" Servicio:"+servicio);
				servicioRepo.save(servicio);
				loadedService++;			
				loadModalities(esi, servicio);
			}catch(Exception ex){
				log.error(ex.toString());
				log.error("Modality failed "+servicio);
				errors.add(ex.toString());				
				errorService++;
			}
		}
	}	
	
	@Transactional
	@RequestMapping(value="/delete",method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)	
	public Response erase(){			
		log.info("Disponibilidad sin parámetros");
		log.info("URL -->"+urlDispo);
		Response response = new Response("?");
		
		this.ticketRepo.deleteAll(); // Borrar todos los datos
		this.modalidadRepo.deleteAll();
		this.servicioRepo.deleteAll();
		response.setResult("delete OK");
		response.setErrorMsg("");
		return response;
	}
	
	@Transactional
	@RequestMapping(value="/load",method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public Response load(){			
		errors.clear();
		log.info("Carga de disponibilidad sin parámetros");
		log.info("URL -->"+urlDispo);
		Response response = new Response("?");				 
		erase();// Borrar los datos previos 
		EventsSearch eventsSearch = oneboxEngineAvail.query(urlDispo, "GET", EventsSearch.class);	
		loadServices(eventsSearch);  // Consultar onebox y cargar la cache.
		String msg = String.format("Errors S[%d/%d] M[%d/%d] T[%d/%d]", errorService,loadedService, 
														  errorModality, loadedModality, 
														  errorTicket, loadedTicket);
		response.setResult(msg);
		response.setErrorMsg(errors.toString());
		log.info("Fin de la carga de disponibilidad");
		return response;
	}		
	
	public DisponibilidadGeneralRespuesta getXMLResponse(Iterable<Servicio> servicios, Date ... dates ){
		DisponibilidadGeneralRespuesta dgr = new DisponibilidadGeneralRespuesta();
		for (Servicio servicio:servicios){
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
					infsmo.setCodsmo(String.valueOf(modalidad.getId()));
					infsmo.setCodcon(modalidad.getModalidad());
					infsmo.setCodcha(ticket.getCaracteristica());
					infsmo.setCupest("DS");
					infsmo.setAdlmax(ticket.getCaracteristica().contains("Adulto")?1:0);					
					infsmo.setNinmax(ticket.getCaracteristica().contains("Junior")?1:0);					
					infsmo.setRefdis((int)ticket.getTicketPK().getId());
					infsmo.setImpcom(ticket.getPrecio());
					infgen.getInfsmo().add(infsmo);
				}												 
			}
			dgr.getInfgen().add(infgen);
		}		
		return dgr;
	}
	
	
	/**
	 * Disponibilidad sin parámetros.
	 * @return
	 */
	@RequestMapping(value="/avail", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@CacheResult
	public DisponibilidadGeneralRespuesta availability(){
		log.info("Se va a pedir una disponibilidad");
		Iterable<Servicio> servicios= servicioRepo.findAll();
		return getXMLResponse(servicios);		
	}			
			
	/** 
	 * Devuelve todas las disponibilidades para un rango de fechas
	 * @return ResponseAvail.
	 */
	@RequestMapping(value="/avail/from/{fecha1}/to/{fecha2}", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@CacheResult
	public DisponibilidadGeneralRespuesta availability(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2){
		log.info("Disponibilidad con fechas desde "+fecha1+" hasta "+fecha2);
		Iterable<Servicio> servicios = null;
		try{
			if (fecha1==null || fecha2==null)
				throw new RuntimeException("No se han informado las fechas correctamente");
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date inicio = df.parse(fecha1);
			Date fin = df.parse(fecha2);
			if (!inicio.before(fin)){
				Date tmp = inicio;
				inicio = fin;
				fin = tmp;
			}
			servicios = servicioRepo.findByDates(inicio,fin);				
		}catch(Exception ex){
			log.error("Error obteniendo la disponibilidad: "+ex.toString());			
		}
		if (servicios!=null)
			return getXMLResponse(servicios);
		return null;
	}
	
	/**
	 * Devuelve un XML con los datos detallados de un determinado producto a la venta y un tipo de pasajero.
	 * El código de sesión se habrá obtenido del apartado anterior.
	 * En esta fase de la integración se devuelve la disponibilidad real del producto.
	 * @param productId
	 * @param caracteristica AD, NI.
	 * @return
	 */
	@RequestMapping(value="/detail/{modId}/{fecha}", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public boolean detail(@PathVariable String modId, int nclientes, @PathVariable Date fecha){
		log.info("Comprobación de disponibilidad");
		SessionInfo sessionInfo = oneboxEngineInfo.query(String.format(urlInfo, modId, fecha), "GET", SessionInfo.class);
		int cupo = sessionInfo.getAvailabilityInfo().getTotal()-sessionInfo.getAvailabilityInfo().getAvailable();
		return cupo>nclientes;		
	}
	
}
