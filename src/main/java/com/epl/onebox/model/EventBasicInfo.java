//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.02 a las 05:38:41 PM CET 
//


package com.epl.onebox.model;

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
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}externalReferenceCode"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}title"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}subtitle" minOccurs="0"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}shortDescription"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}longDescription"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/communication}communication-elements"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}taxonomy"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/languages}languages"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/dates}dates"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}entidad"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}promotor"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}severalVenues"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}severalLocations"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}supraEvent"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}giftTicket"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}nominal"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}eventType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "externalReferenceCode",
    "title",
    "subtitle",
    "shortDescription",
    "longDescription",
    "communicationElements",
    "taxonomy",
    "languages",
    "dates",
    "entidad",
    "promotor",
    "severalVenues",
    "severalLocations",
    "supraEvent",
    "giftTicket",
    "nominal",
    "eventType"
})
@XmlRootElement(name = "event-basic-info")
public class EventBasicInfo {

    @XmlElement(required = true)
    protected ExternalReferenceCode externalReferenceCode;
    @XmlElement(required = true)
    protected String title;
    protected String subtitle;
    @XmlElement(required = true)
    protected String shortDescription;
    @XmlElement(required = true)
    protected String longDescription;
    @XmlElement(name = "communication-elements", namespace = "http://www.oneboxtm.es/ns/communication", required = true)
    protected CommunicationElements communicationElements;
    @XmlElement(required = true)
    protected Taxonomy taxonomy;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/languages", required = true)
    protected Languages languages;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/dates", required = true)
    protected Dates dates;
    @XmlElement(required = true)
    protected Entidad entidad;
    @XmlElement(required = true)
    protected Promotor promotor;
    protected boolean severalVenues;
    protected boolean severalLocations;
    protected boolean supraEvent;
    protected boolean giftTicket;
    protected boolean nominal;
    @XmlElement(required = true)
    protected String eventType;
    @XmlAttribute(name = "id", required = true)
    protected short id;

    /**
     * Obtiene el valor de la propiedad externalReferenceCode.
     * 
     * @return
     *     possible object is
     *     {@link ExternalReferenceCode }
     *     
     */
    public ExternalReferenceCode getExternalReferenceCode() {
        return externalReferenceCode;
    }

    /**
     * Define el valor de la propiedad externalReferenceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalReferenceCode }
     *     
     */
    public void setExternalReferenceCode(ExternalReferenceCode value) {
        this.externalReferenceCode = value;
    }

    /**
     * Obtiene el valor de la propiedad title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define el valor de la propiedad title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Obtiene el valor de la propiedad subtitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Define el valor de la propiedad subtitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtitle(String value) {
        this.subtitle = value;
    }

    /**
     * Obtiene el valor de la propiedad shortDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Define el valor de la propiedad shortDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad longDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * Define el valor de la propiedad longDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongDescription(String value) {
        this.longDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad communicationElements.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationElements }
     *     
     */
    public CommunicationElements getCommunicationElements() {
        return communicationElements;
    }

    /**
     * Define el valor de la propiedad communicationElements.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationElements }
     *     
     */
    public void setCommunicationElements(CommunicationElements value) {
        this.communicationElements = value;
    }

    /**
     * Obtiene el valor de la propiedad taxonomy.
     * 
     * @return
     *     possible object is
     *     {@link Taxonomy }
     *     
     */
    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    /**
     * Define el valor de la propiedad taxonomy.
     * 
     * @param value
     *     allowed object is
     *     {@link Taxonomy }
     *     
     */
    public void setTaxonomy(Taxonomy value) {
        this.taxonomy = value;
    }

    /**
     * Obtiene el valor de la propiedad languages.
     * 
     * @return
     *     possible object is
     *     {@link Languages }
     *     
     */
    public Languages getLanguages() {
        return languages;
    }

    /**
     * Define el valor de la propiedad languages.
     * 
     * @param value
     *     allowed object is
     *     {@link Languages }
     *     
     */
    public void setLanguages(Languages value) {
        this.languages = value;
    }

    /**
     * Obtiene el valor de la propiedad dates.
     * 
     * @return
     *     possible object is
     *     {@link Dates }
     *     
     */
    public Dates getDates() {
        return dates;
    }

    /**
     * Define el valor de la propiedad dates.
     * 
     * @param value
     *     allowed object is
     *     {@link Dates }
     *     
     */
    public void setDates(Dates value) {
        this.dates = value;
    }

    /**
     * Obtiene el valor de la propiedad entidad.
     * 
     * @return
     *     possible object is
     *     {@link Entidad }
     *     
     */
    public Entidad getEntidad() {
        return entidad;
    }

    /**
     * Define el valor de la propiedad entidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Entidad }
     *     
     */
    public void setEntidad(Entidad value) {
        this.entidad = value;
    }

    /**
     * Obtiene el valor de la propiedad promotor.
     * 
     * @return
     *     possible object is
     *     {@link Promotor }
     *     
     */
    public Promotor getPromotor() {
        return promotor;
    }

    /**
     * Define el valor de la propiedad promotor.
     * 
     * @param value
     *     allowed object is
     *     {@link Promotor }
     *     
     */
    public void setPromotor(Promotor value) {
        this.promotor = value;
    }

    /**
     * Obtiene el valor de la propiedad severalVenues.
     * 
     */
    public boolean isSeveralVenues() {
        return severalVenues;
    }

    /**
     * Define el valor de la propiedad severalVenues.
     * 
     */
    public void setSeveralVenues(boolean value) {
        this.severalVenues = value;
    }

    /**
     * Obtiene el valor de la propiedad severalLocations.
     * 
     */
    public boolean isSeveralLocations() {
        return severalLocations;
    }

    /**
     * Define el valor de la propiedad severalLocations.
     * 
     */
    public void setSeveralLocations(boolean value) {
        this.severalLocations = value;
    }

    /**
     * Obtiene el valor de la propiedad supraEvent.
     * 
     */
    public boolean isSupraEvent() {
        return supraEvent;
    }

    /**
     * Define el valor de la propiedad supraEvent.
     * 
     */
    public void setSupraEvent(boolean value) {
        this.supraEvent = value;
    }

    /**
     * Obtiene el valor de la propiedad giftTicket.
     * 
     */
    public boolean isGiftTicket() {
        return giftTicket;
    }

    /**
     * Define el valor de la propiedad giftTicket.
     * 
     */
    public void setGiftTicket(boolean value) {
        this.giftTicket = value;
    }

    /**
     * Obtiene el valor de la propiedad nominal.
     * 
     */
    public boolean isNominal() {
        return nominal;
    }

    /**
     * Define el valor de la propiedad nominal.
     * 
     */
    public void setNominal(boolean value) {
        this.nominal = value;
    }

    /**
     * Obtiene el valor de la propiedad eventType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Define el valor de la propiedad eventType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventType(String value) {
        this.eventType = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

}
