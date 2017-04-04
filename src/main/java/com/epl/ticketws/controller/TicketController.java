package com.epl.ticketws.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epl.onebox.infoser.SessionInfo;
import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.InformeCrearRespuesta;
import com.epl.tickets.model.Purchase;
import com.epl.tickets.model.ReservaCerrarRespuesta;
import com.epl.ticketws.AppConfig;
import com.epl.ticketws.dto.Response;
import com.epl.ticketws.services.Availability;
import com.epl.ticketws.services.Book;
import com.epl.ticketws.services.DBQuery;
import com.epl.ticketws.services.QueryService;
import com.epl.ticketws.services.Voucher;

@RestController
@RequestMapping("/tickets")
@ComponentScan({ "com.epl.ticketws.bussiness", "com.epl.ticketws.services" })
public class TicketController {

	private static final Logger log = Logger.getLogger(TicketController.class);
	private final String ENCODING="UTF-8";		

	@Autowired
	private QueryService<SessionInfo> oneboxEngineInfo;

	@Autowired
	private Availability availability;

	@Autowired
	private Book book;

	@Autowired
	private Voucher voucher;

	@Autowired
	private DBQuery dbQuery;

	@Transactional
	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public Response erase() {
		return dbQuery.erase()
				.orElse(Response.createErrorResponse("No se ha podido borrar la cache. Consulte los logs"));
	}

	/**
	 * Realiza una lectura de los datos de OneBox y los pasa a base de datos.
	 * 
	 * @return devuelve un objeto de tipo respuesta.
	 */
	@Transactional
	@RequestMapping(value = "/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public Response load() {
		dbQuery.erase(); // Eliminamos cualquier elemento previo.
		return dbQuery.load()
				.orElse(Response.createErrorResponse("No se ha realizar la carga de datos. Consulte los logs"));

	}

	/**
	 * Disponibilidad sin parámetros.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/avail", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public String availability() {
		log.info("Se inicia la operacion de disponibildad general");
		DisponibilidadGeneralRespuesta dgr = dbQuery.getGeneralAvail();
		OutputStream outputStream = new ByteArrayOutputStream();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		try {
			try {
				OutputStreamWriter osWriter = new OutputStreamWriter(outputStream, ENCODING);				
				ctx.register(AppConfig.class);
				ctx.refresh();
				XStreamMarshaller xstream = ctx.getBean(XStreamMarshaller.class);
				xstream.setEncoding(ENCODING);
				// Perform Marshaling to Outputstream (a String...)				
				xstream.marshalWriter(dgr, osWriter);
				log.info("Marshaling completed.");
				return outputStream.toString();
			} catch (IOException ex) {
				log.error("Error en la interpretacion del fichero de disponibilidad", ex);
				return null;
			}
		} finally {
			ctx.close();
		}		
	}

	/**
	 * Devuelve todas las disponibilidades para un rango de fechas
	 * 
	 * @return ResponseAvail.
	 */
	@RequestMapping(value = "/avail/from/{fecha1}/to/{fecha2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public String availability(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2) {	
		DisponibilidadGeneralRespuesta dgr = dbQuery.getFilteredAvail(fecha1, fecha2);
		OutputStream outputStream = new ByteArrayOutputStream();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		try {
			try {
				OutputStreamWriter osWriter = new OutputStreamWriter(outputStream, ENCODING);				
				ctx.register(AppConfig.class);
				ctx.refresh();
				XStreamMarshaller xstream = ctx.getBean(XStreamMarshaller.class);
				xstream.setEncoding(ENCODING);
				// Perform Marshaling to Outputstream (a String...)				
				xstream.marshalWriter(dgr, osWriter);
				log.info("Marshaling completed.");
				return outputStream.toString();
			} catch (IOException ex) {
				log.error("Error en la interpretacion del fichero de disponibilidad", ex);
				return null;
			}
		} finally {
			ctx.close();
		}		
	}

	/**
	 * Devuelve un XML con los datos detallados de un determinado producto a la
	 * venta y un tipo de pasajero. El código de sesión se habrá obtenido del
	 * apartado anterior. En esta fase de la integración se devuelve la
	 * disponibilidad real del producto.
	 * 
	 * @param productId
	 * @param caracteristica
	 *            AD, NI.
	 * @return
	 
	@RequestMapping(value = "/detail/{modId}/{fecha}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public boolean detail(@PathVariable String modId, int nclientes, @PathVariable Date fecha) {
		log.info("Comprobación de disponibilidad");
		SessionInfo sessionInfo = oneboxEngineInfo.query(String.format(urlInfo, modId, fecha), "GET", "xml",
				SessionInfo.class, null);
		int cupo = sessionInfo.getAvailabilityInfo().getTotal() - sessionInfo.getAvailabilityInfo().getAvailable();
		return cupo > nclientes;
	}
*/
	/**
	 * Esta consulta también devuelve la disponibilidad "real" (no cacheada) de
	 * un producto concreto
	 * 
	 * @param idEvent
	 *            Código del producto/modalidad.
	 * 
	 */
	@RequestMapping(value = "/availevent/idevent/{idEvent}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public DisponibilidadGeneralRespuesta availEvent(@PathVariable String idEvent) {
		log.info("------- avail Event --------");
		return availability.availabilityTicket(idEvent).orElse(
				DisponibilidadGeneralRespuesta.createWithError("No se puede evaluar la disponibilidad del evento"));
	}

	/**
	 * Juanjo: Cambio la anotación del parámetro a RequestBody (con la de modelo
	 * no funcionaba)
	 */
	@RequestMapping(value = "/purchase", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	public ReservaCerrarRespuesta purchase(@RequestBody Purchase purchase) {
		if (book == null)
			log.warn("No se ha inicializado el objeto book");
		return book.book(purchase);
	}

	@RequestMapping(value = "/voucher/orderCode/{orderCode}", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	public InformeCrearRespuesta ticketsPdf(@PathVariable String orderCode) {
		return voucher.getTicketsPdf(orderCode);
	}

}
