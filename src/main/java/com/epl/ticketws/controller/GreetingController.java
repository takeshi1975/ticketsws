package com.epl.ticketws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epl.ticketws.dto.Greeting;

@RestController
public class GreetingController {

	@RequestMapping("/greeting")
	public Greeting greeting(){
		return new Greeting(1,"Hola mundo");
	}
	
}
