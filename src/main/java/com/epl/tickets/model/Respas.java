//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.09 a las 11:31:33 AM CET 
//


package com.epl.tickets.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}fecnac"/&gt;
 *         &lt;element ref="{}tippas"/&gt;
 *         &lt;element ref="{}impnoc"/&gt;
 *         &lt;element ref="{}impcom"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fecnac",
    "tippas",
    "impnoc",
    "impcom"
})
@XmlRootElement(name = "respas")
public class Respas implements Serializable{

	private static final long serialVersionUID = -1823595506352637049L;
	@XmlElement(required = true)
    protected String fecnac;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String tippas;
    @XmlElement(required = true)
    protected BigInteger impnoc;
    @XmlElement(required = true)
    protected BigDecimal impcom;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;

    /**
     * Obtiene el valor de la propiedad fecnac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecnac() {
        return fecnac;
    }

    /**
     * Define el valor de la propiedad fecnac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecnac(String value) {
        this.fecnac = value;
    }

    /**
     * Obtiene el valor de la propiedad tippas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTippas() {
        return tippas;
    }

    /**
     * Define el valor de la propiedad tippas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTippas(String value) {
        this.tippas = value;
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

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

}
