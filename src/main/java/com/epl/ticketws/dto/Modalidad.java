package com.epl.ticketws.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name="ONEBOX_MODALIDAD")
public class Modalidad implements Serializable{
	
	private static final long serialVersionUID = 5063512548876010364L;

	private transient  Logger logger = Logger.getLogger(Modalidad.class);
	
	@Id	
	private long id;
	
	@Column(name="mod",length=100, nullable=false, unique=false)
	private String modalidad;
	private Date fecha;		
	private Date inicioVenta;
	private Date finVenta;
	private Date inicioSesion;
	
	@ManyToOne
	@JoinColumn(name="servicio_id")
	private Servicio servicio;
	
	public Modalidad(){
		// None just for Hibernate 
	}
	
	public Modalidad(long id, String modalidad, Servicio servicio) {
		setId(id);
		setModalidad(modalidad);	
		setFecha(new Date());
		setServicio(servicio);
		logger.debug("Se ha asignado un servicio");
	}				

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getModalidad() {
		return modalidad;
	}
	
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return String.format("%d %d %s", this.getServicio().getId(), id, modalidad);
	}

	public Date getInicioVenta() {
		return inicioVenta;
	}

	public void setInicioVenta(Date inicioVenta) {
		this.inicioVenta = inicioVenta;
	}

	public Date getFinVenta() {
		return finVenta;
	}

	public void setFinVenta(Date finVenta) {
		this.finVenta = finVenta;
	}

	public Date getInicioSesion() {
		return inicioSesion;
	}

	public void setInicioSesion(Date inicioSesion) {
		this.inicioSesion = inicioSesion;
	}

	
	
}
