//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.02 a las 05:38:41 PM CET 
//


package com.epl.onebox.model;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class TicketType
    extends JAXBElement<String>
{

    protected final static QName NAME = new QName("http://www.oneboxtm.es/ns/data-query/venue", "name");

    public TicketType(String value) {
        super(NAME, ((Class) String.class), null, value);
    }

    public TicketType() {
        super(NAME, ((Class) String.class), null, null);
    }

}
