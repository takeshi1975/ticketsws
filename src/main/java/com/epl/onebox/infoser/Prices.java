//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.08 a las 04:46:46 PM CET 
//


package com.epl.onebox.infoser;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class Prices
    extends JAXBElement<String>
{
	private static final long serialVersionUID = 7032499241514598679L;
	protected final static QName NAME = new QName("http://www.oneboxtm.es/ns/data-query/prices", "name");
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Prices(String value) {
        super(NAME, ((Class) String.class), null, value);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Prices() {
        super(NAME, ((Class) String.class), null, null);
    }

}
