package com.epl.ticketws.controller;

import java.util.Date;

import javax.cache.annotation.CacheResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epl.onebox.infoser.SessionInfo;
import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.InformeCrearRespuesta;
import com.epl.tickets.model.Purchase;
import com.epl.tickets.model.ReservaCerrarRespuesta;
import com.epl.ticketws.bussiness.Availability;
import com.epl.ticketws.bussiness.Book;
import com.epl.ticketws.bussiness.DBQuery;
import com.epl.ticketws.bussiness.Loader;
import com.epl.ticketws.bussiness.Voucher;
import com.epl.ticketws.dto.Response;
import com.epl.ticketws.services.QueryService;

@RestController
@RequestMapping("/tickets")
@ComponentScan({"com.epl.ticketws.services", "com.epl.ticketws.bussiness"})
public class TicketController {

	private final Logger log =Logger.getLogger(TicketController.class);
		
	@Value("${app.onebox.url.info}")
	private String urlInfo;

	@Autowired
	private QueryService<SessionInfo> oneboxEngineInfo;

	
	@Autowired
	private Availability availability; 
		
	@Autowired
	private Book book;
	
	@Autowired
	private Voucher voucher;
	
	@Autowired
	private Loader loader;
	
	@Autowired
	private DBQuery dbQuery; 
	
	@Transactional
	@RequestMapping(value="/delete",method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)	
	public Response erase(){			
		return loader.erase();
	}	
	
	/** 
	 * Realiza una lectura de los datos de OneBox y los pasa a base de datos.
	 * @return devuelve un objeto de tipo respuesta.
	 */
	@Transactional
	@RequestMapping(value="/load",method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public Response load(){			
		return loader.load();
	}			
		
	/**
	 * Disponibilidad sin parámetros.
	 * @return
	 */
	@RequestMapping(value="/avail", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@CacheResult
	public DisponibilidadGeneralRespuesta availability(){
		return dbQuery.getGeneralAvail();		
	}			
			
	/** 
	 * Devuelve todas las disponibilidades para un rango de fechas
	 * @return ResponseAvail.
	 */
	@RequestMapping(value="/avail/from/{fecha1}/to/{fecha2}", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@CacheResult
	public DisponibilidadGeneralRespuesta availability(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2){
		return dbQuery.getFilteredAvail(fecha1, fecha2);
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
	
	/** 
	 * Esta consulta también devuelve la disponibilidad "real" (no cacheada) de un producto concreto
	 * @param idEvent Código del producto
	 * @param fecha1 Fecha de inicio evento
	 * @param fecha2 Fecha de final del evento
	 * @return
	 */
	@RequestMapping("/availevent/idevent/{idEvent}/from/{fecha1}/to/{fecha2}")
	public DisponibilidadGeneralRespuesta availEvent(@PathVariable String idEvent, @PathVariable String fecha1, @PathVariable String fecha2){
		return availability.availabilityTicket(idEvent, fecha1, fecha2);

	}


	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public ReservaCerrarRespuesta purchase(@ModelAttribute Purchase purchase){
		return book.book(purchase);

	}

	@RequestMapping(value ="/voucher/orderCode/{orderCode}")
	public InformeCrearRespuesta  ticketsPdf(@PathVariable String orderCode){
		return voucher.getTicketsPdf(orderCode);
	}
	
}
