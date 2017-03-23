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
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableCaching
public class TestAvailWithDates{

	@Autowired
	private TestRestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(TicketwsApplicationTest.class);
	
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
	public void testAvailWithDates() {
		logger.info("Se pide disponibilidad por fechas");
		this.restTemplate.getForObject("/tickets/load", String.class); // Cargamos los datos
		String url = "/tickets/avail/from/%s/to/%s";
							   
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date randomDate = getRandomDate();
		url = String.format(url, df.format(randomDate), df.format(addDate(randomDate, 1 + (int) Math.random() * 5)));
		String json = this.restTemplate.getForObject(url, String.class);
		logger.info(json);
		assertThat(json).contains("<infgen>");
	}

	
}
