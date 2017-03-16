//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.02 a las 05:38:41 PM CET 
//


package com.epl.onebox.model;

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
 *       &lt;sequence minOccurs="0">
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
    protected Short total;
    @XmlElement(namespace = "")
    protected Short available;

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setTotal(Short value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad available.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getAvailable() {
        return available;
    }

    /**
     * Define el valor de la propiedad available.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setAvailable(Short value) {
        this.available = value;
    }

}
