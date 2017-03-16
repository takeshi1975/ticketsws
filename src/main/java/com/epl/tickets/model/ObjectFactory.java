//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.07 a las 03:21:24 PM CET 
//


package com.epl.tickets.model;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epl.tickets.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ninmax_QNAME = new QName("", "ninmax");
    private final static QName _Adlmax_QNAME = new QName("", "adlmax");
    private final static QName _Coddiv_QNAME = new QName("", "coddiv");
    private final static QName _Tiperr_QNAME = new QName("", "tiperr");
    private final static QName _Codsmo_QNAME = new QName("", "codsmo");
    private final static QName _Impbas_QNAME = new QName("", "impbas");
    private final static QName _Capmax_QNAME = new QName("", "capmax");
    private final static QName _Ideses_QNAME = new QName("", "ideses");
    private final static QName _Codtrf_QNAME = new QName("", "codtrf");
    private final static QName _Tipapl_QNAME = new QName("", "tipapl");
    private final static QName _Nomser_QNAME = new QName("", "nomser");
    private final static QName _Zgedes_QNAME = new QName("", "zgedes");
    private final static QName _Codcon_QNAME = new QName("", "codcon");
    private final static QName _Codser_QNAME = new QName("", "codser");
    private final static QName _Impcom_QNAME = new QName("", "impcom");
    private final static QName _Codtse_QNAME = new QName("", "codtse");
    private final static QName _Impnoc_QNAME = new QName("", "impnoc");
    private final static QName _Codtou_QNAME = new QName("", "codtou");
    private final static QName _Capmin_QNAME = new QName("", "capmin");
    private final static QName _Cupest_QNAME = new QName("", "cupest");
    private final static QName _Porage_QNAME = new QName("", "porage");
    private final static QName _Codcha_QNAME = new QName("", "codcha");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epl.tickets.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DisponibilidadGeneralRespuesta }
     * 
     */
    public DisponibilidadGeneralRespuesta createDisponibilidadGeneralRespuesta() {
        return new DisponibilidadGeneralRespuesta();
    }

    /**
     * Create an instance of {@link Infgen }
     * 
     */
    public Infgen createInfgen() {
        return new Infgen();
    }

    /**
     * Create an instance of {@link Prozge }
     * 
     */
    public Prozge createProzge() {
        return new Prozge();
    }

    /**
     * Create an instance of {@link Infsmo }
     * 
     */
    public Infsmo createInfsmo() {
        return new Infsmo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ninmax")
    public JAXBElement<Byte> createNinmax(Byte value) {
        return new JAXBElement<Byte>(_Ninmax_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "adlmax")
    public JAXBElement<Byte> createAdlmax(Byte value) {
        return new JAXBElement<Byte>(_Adlmax_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "coddiv")
    public JAXBElement<String> createCoddiv(String value) {
        return new JAXBElement<String>(_Coddiv_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tiperr")
    public JAXBElement<String> createTiperr(String value) {
        return new JAXBElement<String>(_Tiperr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codsmo")
    public JAXBElement<String> createCodsmo(String value) {
        return new JAXBElement<String>(_Codsmo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "impbas")
    public JAXBElement<BigDecimal> createImpbas(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Impbas_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "capmax")
    public JAXBElement<Byte> createCapmax(Byte value) {
        return new JAXBElement<Byte>(_Capmax_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ideses")
    public JAXBElement<String> createIdeses(String value) {
        return new JAXBElement<String>(_Ideses_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codtrf")
    public JAXBElement<String> createCodtrf(String value) {
        return new JAXBElement<String>(_Codtrf_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tipapl")
    public JAXBElement<String> createTipapl(String value) {
        return new JAXBElement<String>(_Tipapl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nomser")
    public JAXBElement<String> createNomser(String value) {
        return new JAXBElement<String>(_Nomser_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zgedes")
    public JAXBElement<String> createZgedes(String value) {
        return new JAXBElement<String>(_Zgedes_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codcon")
    public JAXBElement<String> createCodcon(String value) {
        return new JAXBElement<String>(_Codcon_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codser")
    public JAXBElement<Integer> createCodser(Integer value) {
        return new JAXBElement<Integer>(_Codser_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "impcom")
    public JAXBElement<BigDecimal> createImpcom(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Impcom_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codtse")
    public JAXBElement<String> createCodtse(String value) {
        return new JAXBElement<String>(_Codtse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "impnoc")
    public JAXBElement<Byte> createImpnoc(Byte value) {
        return new JAXBElement<Byte>(_Impnoc_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codtou")
    public JAXBElement<String> createCodtou(String value) {
        return new JAXBElement<String>(_Codtou_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "capmin")
    public JAXBElement<Byte> createCapmin(Byte value) {
        return new JAXBElement<Byte>(_Capmin_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cupest")
    public JAXBElement<String> createCupest(String value) {
        return new JAXBElement<String>(_Cupest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "porage")
    public JAXBElement<BigDecimal> createPorage(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Porage_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codcha")
    public JAXBElement<String> createCodcha(String value) {
        return new JAXBElement<String>(_Codcha_QNAME, String.class, null, value);
    }

}
