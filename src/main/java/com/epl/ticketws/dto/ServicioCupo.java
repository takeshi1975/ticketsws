package com.epl.ticketws.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ONEBOX_SERVICIO_CUPO")
public class ServicioCupo {
	@Id
	private int id;	
	private String cupo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCupo() {
		return cupo;
	}
	
	public void setCupo(String cupo) {
		this.cupo = cupo;
	}	
	
}
