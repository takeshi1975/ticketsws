package com.epl.ticketws.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="greeting")
public class Greeting {
	@XmlAttribute(name="gid")
	private int id;
	@XmlAttribute(name="gname")
	private String name;
	
    public Greeting() {
		// Don't do anything
	}
    
    public Greeting(int id, String name){
    	setId(id);
    	setName(name);
    }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
