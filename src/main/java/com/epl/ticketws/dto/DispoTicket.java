package com.epl.ticketws.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class DispoTicket{
	
	@Id	
	private long id;	
	private String servicio; // Port Aventura o Ferrari Land	
	private String modalidad;// PK --> Identificador del ticket.
	private String descripcion;
	private String caracteristica;	// AD, NI	
	private Date fecha;	
	private int dias;	
	private int disponible;	
	private float precio;
	
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

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString(){
		return String.format("disponibilidad %s: %s", servicio, modalidad);
	}
	
	
}	
