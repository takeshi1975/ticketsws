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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para session-search-info element declaration.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;element name="session-search-info">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}internalName"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}name"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/dates}dates"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/venue}venue"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/venue}space"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/event}event-basic-info"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}forSale"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}hasProducts"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}admission"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}supportedVisitorType"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}hideSessionDates"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}showDate"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}showDatetime"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/availability}availability-info"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}activity-ticket-types-availability"/>
 *           &lt;element ref="{http://www.oneboxtm.es/ns/availability}visitorGroupAvailability"/>
 *         &lt;/sequence>
 *         &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *         &lt;attribute name="rates" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "internalName",
    "name",
    "dates",
    "venue",
    "space",
    "eventBasicInfo",
    "forSale",
    "hasProducts",
    "admission",
    "supportedVisitorType",
    "hideSessionDates",
    "showDate",
    "showDatetime",
    "availabilityInfo",
    "activityTicketTypesAvailability",
    "visitorGroupAvailability"
})
@XmlRootElement(name = "session-search-info", namespace = "http://www.oneboxtm.es/ns/data-query/session")
public class BasicInfoSessionSearchInfo {

    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session", required = true)
    protected String internalName;
    @XmlElementRef(name = "name", namespace = "http://www.oneboxtm.es/ns/data-query/session", type = SessionSearchInfo.class)
    protected SessionSearchInfo name;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/dates", required = true)
    protected Dates dates;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/venue", required = true)
    protected Venue venue;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/venue", required = true)
    protected Space space;
    @XmlElement(name = "event-basic-info", required = true)
    protected EventBasicInfo eventBasicInfo;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean forSale;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean hasProducts;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session", required = true)
    protected String admission;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session", required = true)
    protected String supportedVisitorType;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean hideSessionDates;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean showDate;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean showDatetime;
    @XmlElement(name = "availability-info", namespace = "http://www.oneboxtm.es/ns/availability", required = true)
    protected AvailabilityInfo availabilityInfo;
    @XmlElement(name = "activity-ticket-types-availability", namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected ActivityTicketTypesAvailability activityTicketTypesAvailability;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/availability", required = true)
    protected VisitorGroupAvailability visitorGroupAvailability;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "rates", required = true)
    protected String rates;

    /**
     * Obtiene el valor de la propiedad internalName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalName() {
        return internalName;
    }

    /**
     * Define el valor de la propiedad internalName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalName(String value) {
        this.internalName = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link SessionSearchInfo }
     *     
     */
    public SessionSearchInfo getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionSearchInfo }
     *     
     */
    public void setName(SessionSearchInfo value) {
        this.name = value;
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
     * Obtiene el valor de la propiedad venue.
     * 
     * @return
     *     possible object is
     *     {@link Venue }
     *     
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Define el valor de la propiedad venue.
     * 
     * @param value
     *     allowed object is
     *     {@link Venue }
     *     
     */
    public void setVenue(Venue value) {
        this.venue = value;
    }

    /**
     * Obtiene el valor de la propiedad space.
     * 
     * @return
     *     possible object is
     *     {@link Space }
     *     
     */
    public Space getSpace() {
        return space;
    }

    /**
     * Define el valor de la propiedad space.
     * 
     * @param value
     *     allowed object is
     *     {@link Space }
     *     
     */
    public void setSpace(Space value) {
        this.space = value;
    }

    /**
     * Obtiene el valor de la propiedad eventBasicInfo.
     * 
     * @return
     *     possible object is
     *     {@link EventBasicInfo }
     *     
     */
    public EventBasicInfo getEventBasicInfo() {
        return eventBasicInfo;
    }

    /**
     * Define el valor de la propiedad eventBasicInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link EventBasicInfo }
     *     
     */
    public void setEventBasicInfo(EventBasicInfo value) {
        this.eventBasicInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad forSale.
     * 
     */
    public boolean isForSale() {
        return forSale;
    }

    /**
     * Define el valor de la propiedad forSale.
     * 
     */
    public void setForSale(boolean value) {
        this.forSale = value;
    }

    /**
     * Obtiene el valor de la propiedad hasProducts.
     * 
     */
    public boolean isHasProducts() {
        return hasProducts;
    }

    /**
     * Define el valor de la propiedad hasProducts.
     * 
     */
    public void setHasProducts(boolean value) {
        this.hasProducts = value;
    }

    /**
     * Obtiene el valor de la propiedad admission.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmission() {
        return admission;
    }

    /**
     * Define el valor de la propiedad admission.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmission(String value) {
        this.admission = value;
    }

    /**
     * Obtiene el valor de la propiedad supportedVisitorType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportedVisitorType() {
        return supportedVisitorType;
    }

    /**
     * Define el valor de la propiedad supportedVisitorType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportedVisitorType(String value) {
        this.supportedVisitorType = value;
    }

    /**
     * Obtiene el valor de la propiedad hideSessionDates.
     * 
     */
    public boolean isHideSessionDates() {
        return hideSessionDates;
    }

    /**
     * Define el valor de la propiedad hideSessionDates.
     * 
     */
    public void setHideSessionDates(boolean value) {
        this.hideSessionDates = value;
    }

    /**
     * Obtiene el valor de la propiedad showDate.
     * 
     */
    public boolean isShowDate() {
        return showDate;
    }

    /**
     * Define el valor de la propiedad showDate.
     * 
     */
    public void setShowDate(boolean value) {
        this.showDate = value;
    }

    /**
     * Obtiene el valor de la propiedad showDatetime.
     * 
     */
    public boolean isShowDatetime() {
        return showDatetime;
    }

    /**
     * Define el valor de la propiedad showDatetime.
     * 
     */
    public void setShowDatetime(boolean value) {
        this.showDatetime = value;
    }

    /**
     * Obtiene el valor de la propiedad availabilityInfo.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityInfo }
     *     
     */
    public AvailabilityInfo getAvailabilityInfo() {
        return availabilityInfo;
    }

    /**
     * Define el valor de la propiedad availabilityInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityInfo }
     *     
     */
    public void setAvailabilityInfo(AvailabilityInfo value) {
        this.availabilityInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad activityTicketTypesAvailability.
     * 
     * @return
     *     possible object is
     *     {@link ActivityTicketTypesAvailability }
     *     
     */
    public ActivityTicketTypesAvailability getActivityTicketTypesAvailability() {
        return activityTicketTypesAvailability;
    }

    /**
     * Define el valor de la propiedad activityTicketTypesAvailability.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityTicketTypesAvailability }
     *     
     */
    public void setActivityTicketTypesAvailability(ActivityTicketTypesAvailability value) {
        this.activityTicketTypesAvailability = value;
    }

    /**
     * Obtiene el valor de la propiedad visitorGroupAvailability.
     * 
     * @return
     *     possible object is
     *     {@link VisitorGroupAvailability }
     *     
     */
    public VisitorGroupAvailability getVisitorGroupAvailability() {
        return visitorGroupAvailability;
    }

    /**
     * Define el valor de la propiedad visitorGroupAvailability.
     * 
     * @param value
     *     allowed object is
     *     {@link VisitorGroupAvailability }
     *     
     */
    public void setVisitorGroupAvailability(VisitorGroupAvailability value) {
        this.visitorGroupAvailability = value;
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
     * Obtiene el valor de la propiedad rates.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRates() {
        return rates;
    }

    /**
     * Define el valor de la propiedad rates.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRates(String value) {
        this.rates = value;
    }

}
