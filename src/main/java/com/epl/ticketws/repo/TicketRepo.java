package com.epl.ticketws.repo;

import org.springframework.data.repository.CrudRepository;

import com.epl.ticketws.dto.Ticket;

public interface TicketRepo extends CrudRepository<Ticket, Long> {	
	Iterable<Ticket> findByModalidadId(long modalidadId);
	void deleteAll();
}
