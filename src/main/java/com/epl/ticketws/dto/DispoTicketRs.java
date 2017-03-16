package com.epl.ticketws.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DispoTicketRs extends Response{
		 
	private DispoTicket[] tiposTicket;
	
	public DispoTicket[] getTiposTicket() {
		return tiposTicket;
	}
	
	public void setTiposTicket(DispoTicket[] tiposTicket) {
		this.tiposTicket = tiposTicket;
	}		
	
	public DispoTicketRs(String msg) {
		super(msg);
	}
	
}
