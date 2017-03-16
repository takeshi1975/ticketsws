//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.09 a las 11:31:33 AM CET 
//


package com.epl.tickets.model;

import java.math.BigDecimal;
import java.math.BigInteger;
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}pasid"/&gt;
 *         &lt;element ref="{}impnoc"/&gt;
 *         &lt;element ref="{}impcom"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pasid",
    "impnoc",
    "impcom"
})
@XmlRootElement(name = "estpas")
public class Estpas {

    @XmlElement(required = true)
    protected BigInteger pasid;
    @XmlElement(required = true)
    protected BigInteger impnoc;
    @XmlElement(required = true)
    protected BigDecimal impcom;

    /**
     * Obtiene el valor de la propiedad pasid.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPasid() {
        return pasid;
    }

    /**
     * Define el valor de la propiedad pasid.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPasid(BigInteger value) {
        this.pasid = value;
    }

    /**
     * Obtiene el valor de la propiedad impnoc.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getImpnoc() {
        return impnoc;
    }

    /**
     * Define el valor de la propiedad impnoc.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setImpnoc(BigInteger value) {
        this.impnoc = value;
    }

    /**
     * Obtiene el valor de la propiedad impcom.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImpcom() {
        return impcom;
    }

    /**
     * Define el valor de la propiedad impcom.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImpcom(BigDecimal value) {
        this.impcom = value;
    }

}
