//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
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
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}name"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}code"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}individualPrice"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}visitorGroupPricingType"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}color"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/availability}availability-info"/>
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
    "name",
    "code",
    "individualPrice",
    "visitorGroupPricingType",
    "color",
    "availabilityInfo"
})
@XmlRootElement(name = "activity-ticket-type-availability", namespace = "http://www.oneboxtm.es/ns/data-query/prices")
public class ActivityTicketTypeAvailability {

    @XmlElementRef(name = "name", namespace = "http://www.oneboxtm.es/ns/data-query/prices", type = SpaceName.class)
    protected SpaceName name;
    @XmlElementRef(name = "code", namespace = "http://www.oneboxtm.es/ns/data-query/prices", type = SpaceCode.class)
    protected SpaceCode code;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected IndividualPrice individualPrice;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected String visitorGroupPricingType;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected String color;
    @XmlElement(name = "availability-info", namespace = "http://www.oneboxtm.es/ns/availability", required = true)
    protected AvailabilityInfo availabilityInfo;
    @XmlAttribute(name = "id", required = true)
    protected long id;

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link SpaceName }
     *     
     */
    public SpaceName getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link SpaceName }
     *     
     */
    public void setName(SpaceName value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link SpaceCode }
     *     
     */
    public SpaceCode getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link SpaceCode }
     *     
     */
    public void setCode(SpaceCode value) {
        this.code = value;
    }

    /**
     * Obtiene el valor de la propiedad individualPrice.
     * 
     * @return
     *     possible object is
     *     {@link IndividualPrice }
     *     
     */
    public IndividualPrice getIndividualPrice() {
        return individualPrice;
    }

    /**
     * Define el valor de la propiedad individualPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualPrice }
     *     
     */
    public void setIndividualPrice(IndividualPrice value) {
        this.individualPrice = value;
    }

    /**
     * Obtiene el valor de la propiedad visitorGroupPricingType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitorGroupPricingType() {
        return visitorGroupPricingType;
    }

    /**
     * Define el valor de la propiedad visitorGroupPricingType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitorGroupPricingType(String value) {
        this.visitorGroupPricingType = value;
    }

    /**
     * Obtiene el valor de la propiedad color.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Define el valor de la propiedad color.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
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
     * Obtiene el valor de la propiedad id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

}
