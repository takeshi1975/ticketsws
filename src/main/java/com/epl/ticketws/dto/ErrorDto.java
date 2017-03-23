package com.epl.ticketws.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ONEBOX_ERROR")
public class ErrorDto {
	
	@SequenceGenerator(
	        name="ERROR_SEQUENCE_GENERATOR",
	        sequenceName="OB_ERROR_SEQ"
	    )
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ERROR_SEQUENCE_GENERATOR")	
	private long id;
	@Column(name="err_msg",length=550, nullable=false)
	private String message;
	
	private Date errorDate;
	@Column(name="sended_mail")
	private char sended;
	@Column(name="sended_date")
	private Date sendedDate;
	
	public ErrorDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorDto(String msg, Throwable ex) {
		this.setErrorDate(new Date());
		this.setMessage(msg+": "+ex.toString());
		this.setSended('N');
		this.setSendedDate(null);
	}
	
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getErrorDate() {
		return errorDate;
	}
	
	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}
	
	public char getSended() {
		return sended;
	}
	
	public void setSended(char sended) {
		this.sended = sended;
	}

	public Date getSendedDate() {
		return sendedDate;
	}

	public void setSendedDate(Date sendedDate) {
		this.sendedDate = sendedDate;
	}		
				
}
