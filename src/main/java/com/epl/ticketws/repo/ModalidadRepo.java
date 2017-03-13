package com.epl.ticketws.repo;


import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epl.ticketws.dto.Modalidad;

public interface ModalidadRepo extends CrudRepository<Modalidad, Long> {
	
	@Query("select a from Modalidad a where servicio_id=:servicio and :fecha between inicio_venta and fin_venta")	
	Iterable<Modalidad> findByServiceAndDate(@Param("servicio") long servicio, @Param("fecha") Date fecha);	
	void deleteAll();
 
}
