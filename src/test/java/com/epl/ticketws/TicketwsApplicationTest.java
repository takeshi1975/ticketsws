package com.epl.ticketws;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
public class TicketwsApplicationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(TicketwsApplicationTest.class);
	
	
	// Comprueba una carga normal de producto.
	@Test
	public void exampleAvail() {
		// realizamos una carga de datos
		this.restTemplate.getForObject("/tickets/load", String.class);
		// Comprobar que devuelve dispo
		String json = this.restTemplate.getForObject("/tickets/avail", String.class );		
		logger.info(json);
		assertThat(json).contains("infgen");
	}
	
	private Date getRandomDate() {
		Calendar cal = new GregorianCalendar();
		cal.set(2017, 1 + (int) (Math.random() * 11), 1 + (int) (Math.random() * 25));
		return cal.getTime();
	}

	private Date addDate(Date date, int n) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, n);
		return cal.getTime();
	}		
	
	@Test
	public void testAvailWithDates(){
		this.restTemplate.getForObject("/tickets/load", String.class);
		String url = "/tickets/avail/from/%s/to/%s";		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
		Date randomDate = getRandomDate();
		url = String.format(url, df.format(randomDate), df.format(addDate(randomDate,1+(int)Math.random()*5)));		 		
		this.restTemplate.getForObject(url, String.class);		
	}		

}
	

