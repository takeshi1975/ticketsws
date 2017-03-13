//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.08 a las 04:46:46 PM CET 
//


package com.epl.onebox.infoser;

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
 *         &lt;element ref="{}total"/>
 *         &lt;element ref="{}available"/>
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
    "total",
    "available"
})
@XmlRootElement(name = "availability-info", namespace = "http://www.oneboxtm.es/ns/availability")
public class AvailabilityInfo {

    @XmlElement(namespace = "")
    protected short total;
    @XmlElement(namespace = "")
    protected short available;

    /**
     * Obtiene el valor de la propiedad total.
     * 
     */
    public short getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     */
    public void setTotal(short value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad available.
     * 
     */
    public short getAvailable() {
        return available;
    }

    /**
     * Define el valor de la propiedad available.
     * 
     */
    public void setAvailable(short value) {
        this.available = value;
    }

}
