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
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}codtou"/&gt;
 *         &lt;element ref="{}ideses"/&gt;
 *         &lt;element ref="{}locata"/&gt;
 *         &lt;element ref="{}refage"/&gt;
 *         &lt;element ref="{}cupest"/&gt;
 *         &lt;element ref="{}feccre"/&gt;
 *         &lt;element ref="{}fecini"/&gt;
 *         &lt;element ref="{}fecfin"/&gt;
 *         &lt;element ref="{}coddiv"/&gt;
 *         &lt;element ref="{}impcom"/&gt;
 *         &lt;element ref="{}respas" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{}resser" maxOccurs="unbounded"/&gt;
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
    "codtou",
    "ideses",
    "locata",
    "refage",
    "cupest",
    "feccre",
    "fecini",
    "fecfin",
    "coddiv",
    "impcom",
    "respas",
    "resser"
})
@XmlRootElement(name = "ReservaCerrarRespuesta")
public class ReservaCerrarRespuesta implements Serializable{

	private static final long serialVersionUID = -6002793250562143441L;
	@XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codtou;
    @XmlElement(required = true)
    protected String ideses;
    @XmlElement(required = true)
    protected String locata;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String refage;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String cupest;
    @XmlElement(required = true)
    protected String feccre;
    @XmlElement(required = true)
    protected String fecini;
    @XmlElement(required = true)
    protected String fecfin;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String coddiv;
    @XmlElement(required = true)
    protected BigDecimal impcom;
    @XmlElement(required = true)
    protected List<Respas> respas;
    @XmlElement(required = true)
    protected List<Resser> resser;

    /**
     * Obtiene el valor de la propiedad codtou.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodtou() {
        return codtou;
    }

    /**
     * Define el valor de la propiedad codtou.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodtou(String value) {
        this.codtou = value;
    }

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
     * Obtiene el valor de la propiedad locata.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public String getLocata() {
        return locata;
    }

    /**
     * Define el valor de la propiedad locata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLocata(String value) {
        this.locata = value;
    }

    /**
     * Obtiene el valor de la propiedad refage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefage() {
        return refage;
    }

    /**
     * Define el valor de la propiedad refage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefage(String value) {
        this.refage = value;
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
     * Obtiene el valor de la propiedad feccre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeccre() {
        return feccre;
    }

    /**
     * Define el valor de la propiedad feccre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeccre(String value) {
        this.feccre = value;
    }

    /**
     * Obtiene el valor de la propiedad fecini.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecini() {
        return fecini;
    }

    /**
     * Define el valor de la propiedad fecini.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecini(String value) {
        this.fecini = value;
    }

    /**
     * Obtiene el valor de la propiedad fecfin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecfin() {
        return fecfin;
    }

    /**
     * Define el valor de la propiedad fecfin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecfin(String value) {
        this.fecfin = value;
    }

    /**
     * Obtiene el valor de la propiedad coddiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoddiv() {
        return coddiv;
    }

    /**
     * Define el valor de la propiedad coddiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoddiv(String value) {
        this.coddiv = value;
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
     * Gets the value of the respas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the respas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRespas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Respas }
     * 
     * 
     */
    public List<Respas> getRespas() {
        if (respas == null) {
            respas = new ArrayList<Respas>();
        }
        return this.respas;
    }

    /**
     * Gets the value of the resser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Resser }
     * 
     * 
     */
    public List<Resser> getResser() {
        if (resser == null) {
            resser = new ArrayList<Resser>();
        }
        return this.resser;
    }

}
