//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.08 a las 04:46:46 PM CET 
//


package com.epl.onebox.infoser;

import java.math.BigDecimal;
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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}originalBasePrice"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}originalBasePriceCharges"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}promotedPrice"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/prices}promotedPriceCharges"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "originalBasePrice",
    "originalBasePriceCharges",
    "promotedPrice",
    "promotedPriceCharges"
})
@XmlRootElement(name = "individualPrice", namespace = "http://www.oneboxtm.es/ns/data-query/prices")
public class IndividualPrice {

    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected BigDecimal originalBasePrice;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected OriginalBasePriceCharges originalBasePriceCharges;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected BigDecimal promotedPrice;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/prices", required = true)
    protected PromotedPriceCharges promotedPriceCharges;

    /**
     * Obtiene el valor de la propiedad originalBasePrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOriginalBasePrice() {
        return originalBasePrice;
    }

    /**
     * Define el valor de la propiedad originalBasePrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOriginalBasePrice(BigDecimal value) {
        this.originalBasePrice = value;
    }

    /**
     * Obtiene el valor de la propiedad originalBasePriceCharges.
     * 
     * @return
     *     possible object is
     *     {@link OriginalBasePriceCharges }
     *     
     */
    public OriginalBasePriceCharges getOriginalBasePriceCharges() {
        return originalBasePriceCharges;
    }

    /**
     * Define el valor de la propiedad originalBasePriceCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalBasePriceCharges }
     *     
     */
    public void setOriginalBasePriceCharges(OriginalBasePriceCharges value) {
        this.originalBasePriceCharges = value;
    }

    /**
     * Obtiene el valor de la propiedad promotedPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPromotedPrice() {
        return promotedPrice;
    }

    /**
     * Define el valor de la propiedad promotedPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPromotedPrice(BigDecimal value) {
        this.promotedPrice = value;
    }

    /**
     * Obtiene el valor de la propiedad promotedPriceCharges.
     * 
     * @return
     *     possible object is
     *     {@link PromotedPriceCharges }
     *     
     */
    public PromotedPriceCharges getPromotedPriceCharges() {
        return promotedPriceCharges;
    }

    /**
     * Define el valor de la propiedad promotedPriceCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link PromotedPriceCharges }
     *     
     */
    public void setPromotedPriceCharges(PromotedPriceCharges value) {
        this.promotedPriceCharges = value;
    }

}
