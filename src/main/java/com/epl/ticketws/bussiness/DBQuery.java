package com.epl.ticketws.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;
import com.epl.ticketws.dto.Modalidad;
import com.epl.ticketws.dto.Servicio;
import com.epl.ticketws.dto.Ticket;
import com.epl.ticketws.repo.ModalidadRepo;
import com.epl.ticketws.repo.ServicioRepo;
import com.epl.ticketws.repo.TicketRepo;

@Component
@ComponentScan("com.epl.ticketws.repo")
public class DBQuery {
	
	private final Logger log = Logger.getLogger(DBQuery.class);
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private ModalidadRepo modalidadRepo;	

	@Autowired
	private ServicioRepo servicioRepo;
	
	private DisponibilidadGeneralRespuesta getXMLResponse(Iterable<Servicio> servicios, Date ... dates ){
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
	
	public DisponibilidadGeneralRespuesta getGeneralAvail(){
		log.info("Se va a pedir una disponibilidad");
		Iterable<Servicio> servicios= servicioRepo.findAll();
		return getXMLResponse(servicios);
	}
	
	public DisponibilidadGeneralRespuesta getFilteredAvail(String fecha1, String fecha2){
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

	
}
