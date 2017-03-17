package com.epl.ticketws.bussiness;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epl.onebox.model.ActivityTicketTypeAvailability;
import com.epl.onebox.model.BasicInfoSessionSearchInfo;
import com.epl.onebox.model.Charge;
import com.epl.onebox.model.Datetime;
import com.epl.onebox.model.EventSearchInfo;
import com.epl.onebox.model.EventsSearch;
import com.epl.ticketws.controller.TicketController;
import com.epl.ticketws.dto.Modalidad;
import com.epl.ticketws.dto.Response;
import com.epl.ticketws.dto.Servicio;
import com.epl.ticketws.dto.Ticket;
import com.epl.ticketws.repo.ModalidadRepo;
import com.epl.ticketws.repo.ServicioRepo;
import com.epl.ticketws.repo.TicketRepo;
import com.epl.ticketws.services.QueryService;

@Component
public class Loader {

	private int errorService = 0;
	private int errorModality=0;
	private int errorTicket=0;
	private int loadedService=0;
	private int loadedModality=0;
	private int loadedTicket=0;
	private List<String> errors= new ArrayList<String>();
	private Logger log = Logger.getLogger(TicketController.class);
	
	@Value("${app.onebox.url.dispo}")
	private String urlDispo;
		
	@Autowired
	private TicketRepo ticketRepo;	
	
	@Autowired
	private QueryService<EventsSearch> oneboxEngineAvail;
	
	@Autowired
	private ServicioRepo servicioRepo;
	
	@Autowired
	private ModalidadRepo modalidadRepo;
	
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
	
	
	public Response load(){
		errors.clear();
		log.info("Carga de disponibilidad sin parámetros");
		log.info("URL -->"+urlDispo);
		Response response = new Response("?");				 
		erase();// Borrar los datos previos 
		EventsSearch eventsSearch = oneboxEngineAvail.query(urlDispo, "GET","XML", EventsSearch.class,null);	
		loadServices(eventsSearch);  // Consultar onebox y cargar la cache.
		String msg = String.format("Errors S[%d/%d] M[%d/%d] T[%d/%d]", errorService,loadedService, 
													  errorModality, loadedModality, 
													  errorTicket, loadedTicket);
		response.setResult(msg);
		response.setErrorMsg(errors.toString());
		log.info("Fin de la carga de disponibilidad");
		return response;	
	}
	
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
	
}