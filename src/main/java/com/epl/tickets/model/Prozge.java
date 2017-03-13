//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.07 a las 03:21:24 PM CET 
//


package com.epl.tickets.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}zgedes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zgedes"
})
@XmlRootElement(name = "prozge")
public class Prozge {

    @XmlElement(required = true)
    protected String zgedes;

    /**
     * Obtiene el valor de la propiedad zgedes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZgedes() {
        return zgedes;
    }

    /**
     * Define el valor de la propiedad zgedes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZgedes(String value) {
        this.zgedes = value;
    }

}
