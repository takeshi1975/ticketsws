package com.epl.ticketws.repo;

import org.springframework.data.repository.CrudRepository;

import com.epl.ticketws.dto.ServicioCupo;

public interface ServicioCupoRepo  extends CrudRepository<ServicioCupo, Long>{
	
	public Iterable<ServicioCupo> findAll();
	
}
