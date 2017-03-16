package com.epl.ticketws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TicketWSPerformance {

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
	public void testAvailWithDatesLoop() throws IOException {
		String restws = "http://localhost:8080/tickets/avail/from/%s/to/%s";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date initTime = new Date();
		for (int i = 0; i < 8000; i++) {
			Date randomDate = getRandomDate();
			restws = String.format(restws, df.format(randomDate),
					df.format(addDate(randomDate, 1 + (int) Math.random() * 5)));
			URL url = new URL(restws);
			URLConnection urlc = url.openConnection();
			// use post mode
			urlc.setDoOutput(false);
			urlc.setAllowUserInteraction(false);

			// get result
			BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			// String l = null; 
			// while ((l = br.readLine()) != null)
			//	System.out.println(l);
			br.close();

		}
		df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date endTime = new Date();
		System.out.println(String.format("Time Diff: %s", df.format(new Date(endTime.getTime() - initTime.getTime()))));
	}
}
