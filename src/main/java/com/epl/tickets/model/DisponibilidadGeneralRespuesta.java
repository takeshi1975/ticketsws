//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.07 a las 03:21:24 PM CET 
//


package com.epl.tickets.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ideses",
    "infgen",
    "tiperr"
})
@XmlRootElement(name = "DisponibilidadGeneralRespuesta")
public class DisponibilidadGeneralRespuesta {

    @XmlElement(required = true)
    protected String ideses;
    @XmlElement(name="")
    protected List<Infgen> infgen;
    @XmlElement(required = true)
    protected String tiperr;

    /**
     * Obtiene el valor de la propiedad ideses.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdeses() {
        return ideses;
    }

    /**
     * Define el valor de la propiedad ideses.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdeses(String value) {
        this.ideses = value;
    }

    /**
     * Gets the value of the infgen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infgen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfgen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Infgen }
     * 
     * 
     */
    public List<Infgen> getInfgen() {        
        if (infgen==null)
        	infgen = new ArrayList<Infgen>();
        return infgen;        	
    }

    /**
     * Obtiene el valor de la propiedad tiperr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTiperr() {
        return tiperr;
    }

    /**
     * Define el valor de la propiedad tiperr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTiperr(String value) {
        this.tiperr = value;
    }
	   

}
