//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.08 a las 04:46:46 PM CET 
//


package com.epl.onebox.infoser;

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
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}bestSeatsOperationSupported"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}antibotDesired"/>
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}showTime"/>
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
    "bestSeatsOperationSupported",
    "antibotDesired",
    "showTime"
})
@XmlRootElement(name = "session-properties", namespace = "http://www.oneboxtm.es/ns/data-query/session")
public class SessionProperties {

    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean bestSeatsOperationSupported;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean antibotDesired;
    @XmlElement(namespace = "http://www.oneboxtm.es/ns/data-query/session")
    protected boolean showTime;

    /**
     * Obtiene el valor de la propiedad bestSeatsOperationSupported.
     * 
     */
    public boolean isBestSeatsOperationSupported() {
        return bestSeatsOperationSupported;
    }

    /**
     * Define el valor de la propiedad bestSeatsOperationSupported.
     * 
     */
    public void setBestSeatsOperationSupported(boolean value) {
        this.bestSeatsOperationSupported = value;
    }

    /**
     * Obtiene el valor de la propiedad antibotDesired.
     * 
     */
    public boolean isAntibotDesired() {
        return antibotDesired;
    }

    /**
     * Define el valor de la propiedad antibotDesired.
     * 
     */
    public void setAntibotDesired(boolean value) {
        this.antibotDesired = value;
    }

    /**
     * Obtiene el valor de la propiedad showTime.
     * 
     */
    public boolean isShowTime() {
        return showTime;
    }

    /**
     * Define el valor de la propiedad showTime.
     * 
     */
    public void setShowTime(boolean value) {
        this.showTime = value;
    }

}
