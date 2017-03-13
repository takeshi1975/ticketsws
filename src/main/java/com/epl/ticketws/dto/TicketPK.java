package com.epl.ticketws.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TicketPK implements Serializable{

	private static final long serialVersionUID = -899751442974461825L;
	private long idModalidad;
	private long id;
	
	public TicketPK() {
		// Default constructor
	}
	
	public TicketPK(long id, long modalidad_id) {
		this.idModalidad=modalidad_id;
		this.id=id;
	}
	
	public long getIdModalidad() {
		return idModalidad;
	}
	
	public void setIdModalidad(long idModalidad) {
		this.idModalidad = idModalidad;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}		
	
}
