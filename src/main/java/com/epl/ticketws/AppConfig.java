package com.epl.ticketws;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.epl.tickets.model.DisponibilidadGeneralRespuesta;
import com.epl.tickets.model.Infgen;
import com.epl.tickets.model.Infsmo;

/** 
 * Se configura XStream para que sea capaz de deserializar la clase de respuesta de disponibilidad.
 * @author Juanjo
 */
public class AppConfig {
	
	// Configurar la conversión de disponibilidad a XML...
	@Bean
	public XStreamMarshaller getXStreamMarshaller() {
		Map<String, Class<?>> aliases = new HashMap<String, Class<? extends Object>>();
		aliases.put("DisponibilidadGeneralRespuesta",DisponibilidadGeneralRespuesta.class);
		aliases.put("infgen", Infgen.class);
		aliases.put("infsmo", Infsmo.class);
		XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
		xstreamMarshaller.setAliases(aliases);
		Map<Class<?>, String> implicitCollections= new HashMap<Class<? extends Object>, String>();
		implicitCollections.put(DisponibilidadGeneralRespuesta.class,"infgens");
		implicitCollections.put(Infgen.class,"infsmos");
		xstreamMarshaller.setImplicitCollections(implicitCollections);
		xstreamMarshaller.setSupportedClasses(DisponibilidadGeneralRespuesta.class); // Configuramos la clase de disponibilidad.	
		return xstreamMarshaller;
	}
}