//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.07 a las 03:21:24 PM CET 
//


package com.epl.tickets.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{}codcon"/>
 *         &lt;element ref="{}codtrf"/>
 *         &lt;element ref="{}codsmo"/>
 *         &lt;element ref="{}codcha"/>
 *         &lt;element ref="{}capmax"/>
 *         &lt;element ref="{}capmin"/>
 *         &lt;element ref="{}adlmax"/>
 *         &lt;element ref="{}ninmax"/>
 *         &lt;element ref="{}cupest"/>
 *         &lt;element ref="{}impnoc"/>
 *         &lt;element ref="{}impcom"/>
 *         &lt;element ref="{}tipapl"/>
 *         &lt;element ref="{}porage"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{}AT_11" />
 *       &lt;attribute name="refdis" use="required" type="{}AT_12" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codcon",
    "codtrf",
    "codsmo",
    "codcha",
    "capmax",
    "capmin",
    "adlmax",
    "ninmax",
    "cupest",
    "impnoc",
    "impcom",
    "tipapl",
    "porage"
})
@XmlRootElement(name = "infsmo")
public class Infsmo {

    @XmlElement(required = true)
    protected String codcon;
    @XmlElement(required = true)
    protected String codtrf;
    @XmlElement(required = true)
    protected String codsmo;
    @XmlElement(required = true)
    protected String codcha;
    protected int capmax;
    protected int capmin;
    protected int adlmax;
    protected int ninmax;
    @XmlElement(required = true)
    protected String cupest;
    protected int impnoc;
    @XmlElement(required = true)
    protected float impcom;
    @XmlElement(required = true)
    protected String tipapl;
    @XmlElement(required = true)
    protected float porage;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "refdis", required = true)
    protected int refdis;

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
     * Obtiene el valor de la propiedad codcha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodcha() {
        return codcha;
    }

    /**
     * Define el valor de la propiedad codcha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodcha(String value) {
        this.codcha = value;
    }

    /**
     * Obtiene el valor de la propiedad capmax.
     * 
     */
    public int getCapmax() {
        return capmax;
    }

    /**
     * Define el valor de la propiedad capmax.
     * 
     */
    public void setCapmax(int value) {
        this.capmax = value;
    }

    /**
     * Obtiene el valor de la propiedad capmin.
     * 
     */
    public int getCapmin() {
        return capmin;
    }

    /**
     * Define el valor de la propiedad capmin.
     * 
     */
    public void setCapmin(int value) {
        this.capmin = value;
    }

    /**
     * Obtiene el valor de la propiedad adlmax.
     * 
     */
    public int getAdlmax() {
        return adlmax;
    }

    /**
     * Define el valor de la propiedad adlmax.
     * 
     */
    public void setAdlmax(int value) {
        this.adlmax = value;
    }

    /**
     * Obtiene el valor de la propiedad ninmax.
     * 
     */
    public int getNinmax() {
        return ninmax;
    }

    /**
     * Define el valor de la propiedad ninmax.
     * 
     */
    public void setNinmax(int value) {
        this.ninmax = value;
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
     * Obtiene el valor de la propiedad impnoc.
     * 
     */
    public int getImpnoc() {
        return impnoc;
    }

    /**
     * Define el valor de la propiedad impnoc.
     * 
     */
    public void setImpnoc(int value) {
        this.impnoc = value;
    }

    /**
     * Obtiene el valor de la propiedad impcom.
     * 
     * @return
     *     possible object is
     *     {@link float }
     *     
     */
    public float getImpcom() {
        return impcom;
    }

    /**
     * Define el valor de la propiedad impcom.
     * 
     * @param value
     *     allowed object is
     *     {@link float }
     *     
     */
    public void setImpcom(float value) {
        this.impcom = value;
    }

    /**
     * Obtiene el valor de la propiedad tipapl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipapl() {
        return tipapl;
    }

    /**
     * Define el valor de la propiedad tipapl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipapl(String value) {
        this.tipapl = value;
    }

    /**
     * Obtiene el valor de la propiedad porage.
     * 
     * @return
     *     possible object is
     *     {@link float }
     *     
     */
    public float getPorage() {
        return porage;
    }

    /**
     * Define el valor de la propiedad porage.
     * 
     * @param value
     *     allowed object is
     *     {@link float }
     *     
     */
    public void setPorage(float value) {
        this.porage = value;
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

    /**
     * Obtiene el valor de la propiedad refdis.
     * 
     */
    public int getRefdis() {
        return refdis;
    }

    /**
     * Define el valor de la propiedad refdis.
     * 
     */
    public void setRefdis(int value) {
        this.refdis = value;
    }

}
