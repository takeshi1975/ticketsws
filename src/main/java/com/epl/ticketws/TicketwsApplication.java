package com.epl.ticketws;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan({"com.epl.ticketws.controller", "com.epl.ticketws.profile"})
public class TicketwsApplication extends SpringBootServletInitializer{
	
	private static final Logger logger = Logger.getLogger(TicketwsApplication.class);		
	
	public static void main(String[] args) {
		logger.info("Se inicia la aplicacion");	
		SpringApplication.run(TicketwsApplication.class, args);
	}		

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("Se configura la aplicación");
		return application.sources(TicketwsApplication.class);
	}	

}
