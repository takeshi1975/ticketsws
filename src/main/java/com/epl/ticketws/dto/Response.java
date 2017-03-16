package com.epl.ticketws.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
		
	private String result;		
	private String errorMsg;
	private String time;
	
	public Response(String result) {
		setResult(result);
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(Date fecha){
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy hh:ss");
		time = df.format(fecha);		
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}		
		
}
