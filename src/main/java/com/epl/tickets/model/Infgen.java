//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.07 a las 03:21:24 PM CET 
//


package com.epl.tickets.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codtse",
    "nomser",
    "coddiv",
    "impbas",
    "codtou",
    "codser",
    "cupest",
    "prozge",
    "infsmo"
})
@XmlRootElement(name = "infgen")
public class Infgen {

    @XmlElement(required = true)
    protected String codtse;
    @XmlElement(required = true)
    protected String nomser;
    @XmlElement(required = true)
    protected String coddiv;
    @XmlElement(required = true)
    protected BigDecimal impbas;
    @XmlElement(required = true)
    protected String codtou;
    protected int codser;
    @XmlElement(required = true)
    protected String cupest;
    @XmlElement(required = true)
    protected Prozge prozge;
    @XmlElement(required = true)
    protected List<Infsmo> infsmo;
    @XmlAttribute(name = "id", required = true)
    protected int id;

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
     * Obtiene el valor de la propiedad impbas.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImpbas() {
        return impbas;
    }

    /**
     * Define el valor de la propiedad impbas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImpbas(BigDecimal value) {
        this.impbas = value;
    }

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
     * Obtiene el valor de la propiedad codser.
     * 
     */
    public int getCodser() {
        return codser;
    }

    /**
     * Define el valor de la propiedad codser.
     * 
     */
    public void setCodser(int value) {
        this.codser = value;
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
     * Obtiene el valor de la propiedad prozge.
     * 
     * @return
     *     possible object is
     *     {@link Prozge }
     *     
     */
    public Prozge getProzge() {
        return prozge;
    }

    /**
     * Define el valor de la propiedad prozge.
     * 
     * @param value
     *     allowed object is
     *     {@link Prozge }
     *     
     */
    public void setProzge(Prozge value) {
        this.prozge = value;
    }

    /**
     * Gets the value of the infsmo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infsmo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfsmo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Infsmo }
     * 
     * 
     */
    public List<Infsmo> getInfsmo() {
        if (infsmo == null) {
            infsmo = new ArrayList<Infsmo>();
        }
        return this.infsmo;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}
