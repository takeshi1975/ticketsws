/**
 * 
 */
package com.epl.ticketws.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epl.ticketws.dto.Servicio;

/**
 * @author Juanjo
 *
 */
public interface ServicioRepo extends CrudRepository<Servicio, Long> {
	
	/** 
	 * Para que el compilador reconozca los parametros hay que marcar una opción en Window->Preferences->Java->Compiler
	 ***/	 
	@Query("select s from Servicio s where s.inicioEvento<=:fecha1 and s.finEvento>=:fecha2")
	public Iterable<Servicio> findByDates(@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);
	@Query("select s from Servicio s")
	public Iterable<Servicio> findServices();
	public void deleteAll();
}
