//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.09 a las 11:31:33 AM CET 
//


package com.epl.tickets.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}codage"/&gt;
 *         &lt;element ref="{}fecini"/&gt;
 *         &lt;element ref="{}fecfin"/&gt;
 *         &lt;element ref="{}nomser"/&gt;
 *         &lt;element ref="{}codzge"/&gt;
 *         &lt;element ref="{}codtse"/&gt;
 *         &lt;element ref="{}codser"/&gt;
 *         &lt;element ref="{}impcom"/&gt;
 *         &lt;element ref="{}estsmo" maxOccurs="unbounded"/&gt;
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
    "codage",
    "fecini",
    "fecfin",
    "nomser",
    "codzge",
    "codtse",
    "codser",
    "impcom",
    "estsmo"
})
@XmlRootElement(name = "resser")
public class Resser {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codage;
    @XmlElement(required = true)
    protected String fecini;
    @XmlElement(required = true)
    protected String fecfin;
    @XmlElement(required = true)
    protected String nomser;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codzge;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codtse;
    @XmlElement(required = true)
    protected BigInteger codser;
    @XmlElement(required = true)
    protected BigDecimal impcom;
    @XmlElement(required = true)
    protected List<Estsmo> estsmo;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;

    /**
     * Obtiene el valor de la propiedad codage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodage() {
        return codage;
    }

    /**
     * Define el valor de la propiedad codage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodage(String value) {
        this.codage = value;
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
     * Obtiene el valor de la propiedad nomser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomser() {
        return nomser;
    }

    /**
     * Define el valor de la propiedad nomser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomser(String value) {
        this.nomser = value;
    }

    /**
     * Obtiene el valor de la propiedad codzge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodzge() {
        return codzge;
    }

    /**
     * Define el valor de la propiedad codzge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodzge(String value) {
        this.codzge = value;
    }

    /**
     * Obtiene el valor de la propiedad codtse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodtse() {
        return codtse;
    }

    /**
     * Define el valor de la propiedad codtse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodtse(String value) {
        this.codtse = value;
    }

    /**
     * Obtiene el valor de la propiedad codser.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodser() {
        return codser;
    }

    /**
     * Define el valor de la propiedad codser.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodser(BigInteger value) {
        this.codser = value;
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
     * Gets the value of the estsmo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the estsmo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstsmo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Estsmo }
     * 
     * 
     */
    public List<Estsmo> getEstsmo() {
        if (estsmo == null) {
            estsmo = new ArrayList<Estsmo>();
        }
        return this.estsmo;
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
