package com.epl.ticketws;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableCaching
public class AvailWithDatesTest{

	@Autowired
	private TestRestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(AvailWithDatesTest.class);

	@Test
	public void testAvailWithDates() {		
		logger.info("Se pide disponibilidad sin fechas... para obtener informacion de cupos...");
		//this.restTemplate.getForObject("/tickets/load", String.class); // Cargamos los datos
		String url = "/tickets/availevent/idevent/2880/idsession/125429";						  		
		String json = this.restTemplate.getForObject(url, String.class);
		Assert.assertNotNull("Couldn't see any response",json);	
		Assert.assertThat("Response not contains infgen", json, containsString("<infgen>"));
		logger.info(json.substring(0, 100));	
		assertThat(json).contains("<infgen>");
		logger.info(url);
		logger.info("Fin de la prueba");
	}
	
}
