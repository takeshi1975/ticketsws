package com.epl.ticketws.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epl.ticketws.dto.DispoTicket;

public interface DispoTicketRepo extends CrudRepository<DispoTicket,Long>{
	
}
