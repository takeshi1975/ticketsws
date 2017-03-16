package com.epl.ticketws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.ticketws.dto.Greeting;

@RestController
public class GreetingController {

	private static final Logger logger= LoggerFactory.getLogger(GreetingController.class);
	
	@RequestMapping("/greeting")
	public Greeting greeting(){
		logger.debug("Hola Mundo");
		return new Greeting(1,"Hola mundo");
	}
	
}
