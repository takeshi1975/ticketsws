package com.epl.tickets.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcortes on 14/03/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ideses",
        "infpdf",
        "tiperr"
})
@XmlRootElement(name = "InformeCrearRespuesta")
public class InformeCrearRespuesta {

    @XmlElement(required = true)
    protected String ideses;
    @XmlElement(name="")
    protected List<String> infpdf;
    @XmlElement(required = true)
    protected String tiperr;

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
     * Gets the value of the infgen property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infgen property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfgen().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Infgen }
     *
     *
     */
    public List<String> getInfpdf() {
        if (infpdf==null)
            infpdf = new ArrayList<String>();
        return infpdf;
    }

    /**
     * Obtiene el valor de la propiedad tiperr.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTiperr() {
        return tiperr;
    }

    /**
     * Define el valor de la propiedad tiperr.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTiperr(String value) {
        this.tiperr = value;
    }


}
