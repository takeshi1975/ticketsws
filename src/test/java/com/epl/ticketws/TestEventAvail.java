package com.epl.ticketws;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableCaching
public class TestEventAvail {
	
	@Autowired
	private TestRestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(TestAvailWithDates.class);
	
	@Test
	public void doTestAvail(){
		logger.info("Se pide disponibilidad por fechas");
		
		String url = "/tickets/availevent/idevent/2880/idsession/125400/from/12-07-2017/to/14-07-2017";							   					
		String json = this.restTemplate.getForObject(url, String.class);
		logger.info(json.substring(0, 100));
		assertThat(json).contains("<infgen>");
		logger.info(url);
		logger.info("Fin de la prueba");
	}
	
}
