package com.epl.ticketws;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.epl.tickets.model.Purchase;
import com.epl.tickets.model.Purchase.TicketOrder;
import com.epl.tickets.model.ReservaCerrarRespuesta;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestPurchase {
	
	@Autowired
	private TestRestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(TestSimpleAvail.class);
	
	
	@Test
	public void testPurchase() {
		logger.info("Se va a realizar un test de purchase");
		Purchase purchase = new Purchase();
		purchase.setCountryCode("ES");
		purchase.setCountrySubdivisionCode(null);
		purchase.setEmail("juanjo.alejandro@gmail.com");
		purchase.setFirstname("Juanjo");
		purchase.setLastname("Alejandro");
		purchase.setTelephone("972.65.24.89");
		List<TicketOrder> ticketOrders = new ArrayList<TicketOrder>();
		ticketOrders.add(new TicketOrder("131155","23173","1"));		
		purchase.setTicketOrders(ticketOrders);
		ReservaCerrarRespuesta respuesta = restTemplate.postForObject("/tickets/purchase", purchase, ReservaCerrarRespuesta.class);		
		assert respuesta!=null; 
		logger.info("Localizador de la compra "+respuesta.getLocata());		
	}
}
