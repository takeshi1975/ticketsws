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
 *         &lt;element ref="{}codtrc"/&gt;
 *         &lt;element ref="{}codcon"/&gt;
 *         &lt;element ref="{}codsmo"/&gt;
 *         &lt;element ref="{}codral"/&gt;
 *         &lt;element ref="{}codtrf"/&gt;
 *         &lt;element ref="{}nomtrf"/&gt;
 *         &lt;element ref="{}cupest"/&gt;
 *         &lt;element ref="{}numuni"/&gt;
 *         &lt;element ref="{}porage"/&gt;
 *         &lt;element ref="{}impcom"/&gt;
 *         &lt;element ref="{}codprv"/&gt;
 *         &lt;element ref="{}estpas"/&gt;
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
    "codtrc",
    "codcon",
    "codsmo",
    "codral",
    "codtrf",
    "nomtrf",
    "cupest",
    "numuni",
    "porage",
    "impcom",
    "codprv",
    "estpas"
})
@XmlRootElement(name = "estsmo")
public class Estsmo implements Serializable {

	private static final long serialVersionUID = 4945565289505195248L;
	@XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codtrc;
    @XmlElement(required = true)
    protected String codcon;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codsmo;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codral;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codtrf;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String nomtrf;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String cupest;
    @XmlElement(required = true)
    protected BigInteger numuni;
    @XmlElement(required = true)
    protected BigDecimal porage;
    @XmlElement(required = true)
    protected BigDecimal impcom;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codprv;
    @XmlElement(required = true)
    protected Estpas estpas;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;

    /**
     * Obtiene el valor de la propiedad codtrc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodtrc() {
        return codtrc;
    }

    /**
     * Define el valor de la propiedad codtrc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodtrc(String value) {
        this.codtrc = value;
    }

    /**
     * Obtiene el valor de la propiedad codcon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodcon() {
        return codcon;
    }

    /**
     * Define el valor de la propiedad codcon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodcon(String value) {
        this.codcon = value;
    }

    /**
     * Obtiene el valor de la propiedad codsmo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodsmo() {
        return codsmo;
    }

    /**
     * Define el valor de la propiedad codsmo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodsmo(String value) {
        this.codsmo = value;
    }

    /**
     * Obtiene el valor de la propiedad codral.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodral() {
        return codral;
    }

    /**
     * Define el valor de la propiedad codral.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodral(String value) {
        this.codral = value;
    }

    /**
     * Obtiene el valor de la propiedad codtrf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodtrf() {
        return codtrf;
    }

    /**
     * Define el valor de la propiedad codtrf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodtrf(String value) {
        this.codtrf = value;
    }

    /**
     * Obtiene el valor de la propiedad nomtrf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomtrf() {
        return nomtrf;
    }

    /**
     * Define el valor de la propiedad nomtrf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomtrf(String value) {
        this.nomtrf = value;
    }

    /**
     * Obtiene el valor de la propiedad cupest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCupest() {
        return cupest;
    }

    /**
     * Define el valor de la propiedad cupest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCupest(String value) {
        this.cupest = value;
    }

    /**
     * Obtiene el valor de la propiedad numuni.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumuni() {
        return numuni;
    }

    /**
     * Define el valor de la propiedad numuni.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumuni(BigInteger value) {
        this.numuni = value;
    }

    /**
     * Obtiene el valor de la propiedad porage.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorage() {
        return porage;
    }

    /**
     * Define el valor de la propiedad porage.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorage(BigDecimal value) {
        this.porage = value;
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
     * Obtiene el valor de la propiedad codprv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodprv() {
        return codprv;
    }

    /**
     * Define el valor de la propiedad codprv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodprv(String value) {
        this.codprv = value;
    }

    /**
     * Obtiene el valor de la propiedad estpas.
     * 
     * @return
     *     possible object is
     *     {@link Estpas }
     *     
     */
    public Estpas getEstpas() {
        return estpas;
    }

    /**
     * Define el valor de la propiedad estpas.
     * 
     * @param value
     *     allowed object is
     *     {@link Estpas }
     *     
     */
    public void setEstpas(Estpas value) {
        this.estpas = value;
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
