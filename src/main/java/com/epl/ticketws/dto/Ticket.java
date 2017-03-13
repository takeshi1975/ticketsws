package com.epl.ticketws.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class Ticket  {
	
	@EmbeddedId
	private TicketPK ticketPK;				
	
	@Column(name="codchar", length=50 )
	String caracteristica;
	@Column(name="price", nullable=false)	
	float precio;
	
	@Column(name="days", nullable=false)
	int dias;
	
	@ManyToOne
	@JoinColumn(name="servicio_id")
	private Servicio servicio;
	
	@MapsId("idModalidad")
	@ManyToOne	
	@JoinColumn(name="modalidad_id")
	private Modalidad modalidad;	
	
	public Ticket(){
		// Ticket...
	}		
	
	public Ticket(long id,String caracteristica, float precio, int dias, Modalidad modalidad, Servicio servicio){		
		this.setTicketPK(new TicketPK(id,modalidad.getId()));				
		this.setCaracteristica(caracteristica);
		this.setPrecio(precio);
		this.setDias(dias);
		this.setModalidad(modalidad);
		this.setServicio(servicio);
	}		
	
	public TicketPK getTicketPK() {
		return ticketPK;
	}

	public void setTicketPK(TicketPK ticketPK) {
		this.ticketPK = ticketPK;
	}

	public String getCaracteristica() {
		return caracteristica;
	}
	
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public int getDias() {
		return dias;
	}
	
	public void setDias(int dias) {
		this.dias = dias;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}		
	
}	
