//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.02 a las 05:38:41 PM CET 
//


package com.epl.onebox.model;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class SpaceName
    extends JAXBElement<String>
{

	private static final long serialVersionUID = -377981252101039574L;
	protected final static QName NAME = new QName("http://www.oneboxtm.es/ns/data-query/prices", "name");

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public SpaceName(String value) {
        super(NAME, ((Class) String.class), null, value);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public SpaceName() {
        super(NAME, ((Class) String.class), null, null);
    }

}
