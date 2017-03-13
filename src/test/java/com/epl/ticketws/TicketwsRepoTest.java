package com.epl.ticketws;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epl.ticketws.dto.DispoTicket;
import com.epl.ticketws.repo.DispoTicketRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.ticketws.repo")
@SpringBootTest(classes = TicketwsApplication.class)
public class TicketwsRepoTest {

	@Autowired
	private DispoTicketRepo repo;	
	private int id = 0;

	public DispoTicket newAvailability(){		
		DispoTicket dispoTicket = new DispoTicket();
		dispoTicket.setId(++id);
		dispoTicket.setCaracteristica(String.valueOf(id));
		dispoTicket.setDescripcion("Descripcion");
		dispoTicket.setDias(1);
		dispoTicket.setFecha(new Date());
		dispoTicket.setModalidad("Ticket simple para AD "+id);
		dispoTicket.setPrecio(100.0f);
		dispoTicket.setServicio("POA");
		return dispoTicket;
	}
	
	/** 
	 * Crea 10 disponibilidades en la base de datos y las recupera.
	 */
	@Test
	public void restore(){				
		for (int i=0; i<10; i++)		
			repo.save(newAvailability());  // Guardamos el registro en base de datos				
		for (DispoTicket dispoTicket:(List<DispoTicket>) repo.findAll())
			System.out.println("Recuperada una disponibilidad "+dispoTicket.toString());
	}
	
	/** 
	 * Crea 1 disponibilidad en la base de datos y la recupera.
	 */
	@Test
	public void save(){				
		repo.save(newAvailability());  // Guardamos el registro en base de datos
		System.out.println(repo.findOne(1L));
	}					
	
}
