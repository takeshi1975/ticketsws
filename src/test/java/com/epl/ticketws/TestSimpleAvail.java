package com.epl.ticketws;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestSimpleAvail {
	
	@Autowired
	private TestRestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(TestSimpleAvail.class);	
		
	// Comprueba una disponibilidad general de producto.
	@Test
	public void testAvail() {
		//this.restTemplate.getForObject("/tickets/load", String.class);
		logger.info("Se va a pedir disponibilidad");
		String json = this.restTemplate.getForObject("/tickets/avail", String.class );		
		logger.info(json);
		assertThat(json).contains("infgen");
	}

}
	

