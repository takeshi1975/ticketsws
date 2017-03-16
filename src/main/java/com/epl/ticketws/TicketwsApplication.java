package com.epl.ticketws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.epl.ticketws.controller")
@EnableCaching
public class TicketwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketwsApplication.class, args);
	}	
	
}
