package com.epl.ticketws.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ONEBOX_SERVICIO")
public class Servicio {

	@Id
	private long id;
	@Column(name="servicio",length=100, nullable=false, unique=true)
	private String servicio;
	private Date fecha;
	private Date inicioEvento;
	private Date finEvento;	

	public Servicio(){
		// None just for Hibernate 
	}
	
	public Servicio(long id, String servicio) {
		setServicio(servicio);
		setId(id);
		setFecha(new Date());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}		
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getInicioEvento() {
		return inicioEvento;
	}

	public void setInicioEvento(Date inicioEvento) {
		this.inicioEvento = inicioEvento;
	}

	public Date getFinEvento() {
		return finEvento;
	}

	public void setFinEvento(Date finEvento) {
		this.finEvento = finEvento;
	}

	@Override
	public String toString(){
		return String.format("%d %s", id, servicio);
	}
			
}
