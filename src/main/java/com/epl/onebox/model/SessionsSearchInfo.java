//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.02 a las 05:38:41 PM CET 
//


package com.epl.onebox.model;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.oneboxtm.es/ns/data-query/session}session-search-info" maxOccurs="unbounded"/>
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
    "sessionSearchInfo"
})
@XmlRootElement(name = "sessions-search-info", namespace = "http://www.oneboxtm.es/ns/data-query/session")
public class SessionsSearchInfo {

    @XmlElement(name = "session-search-info", namespace = "http://www.oneboxtm.es/ns/data-query/session", required = true)
    protected List<BasicInfoSessionSearchInfo> sessionSearchInfo;

    /**
     * Gets the value of the sessionSearchInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sessionSearchInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSessionSearchInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BasicInfoSessionSearchInfo }
     * 
     * 
     */
    public List<BasicInfoSessionSearchInfo> getSessionSearchInfo() {
        if (sessionSearchInfo == null) {
            sessionSearchInfo = new ArrayList<BasicInfoSessionSearchInfo>();
        }
        return this.sessionSearchInfo;
    }

}
