package com.epl.ticketws.repo;

import org.springframework.data.repository.CrudRepository;

import com.epl.ticketws.dto.ErrorDto;

public interface ErrorRepo extends CrudRepository<ErrorDto, Long>{
	
	// Declaro un método por defecto dentro de esta interfaz
	default void handleError(String msg, Throwable ex){
		try{
			ErrorDto errorDto = new ErrorDto(msg,ex);
			save(errorDto);
		}catch(Exception fail){
			// Lo hay log si falla.
		}
	}
	
}
