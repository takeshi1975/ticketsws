//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.03.08 a las 04:46:46 PM CET 
//


package com.epl.onebox.infoser;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epl.onebox.infoser package. 
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

    private final static QName _Admission_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "admission");
    private final static QName _City_QNAME = new QName("", "city");
    private final static QName _Id_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/venue", "id");
    private final static QName _PostalCode_QNAME = new QName("", "postalCode");
    private final static QName _ShowTime_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "showTime");
    private final static QName _Available_QNAME = new QName("", "available");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _Language_QNAME = new QName("", "language");
    private final static QName _GiftTicket_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "giftTicket");
    private final static QName _EventType_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "eventType");
    private final static QName _ForSale_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "forSale");
    private final static QName _Code_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/prices", "code");
    private final static QName _OriginalBasePrice_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/prices", "originalBasePrice");
    private final static QName _Total_QNAME = new QName("", "total");
    private final static QName _PhoneNumber_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "phoneNumber");
    private final static QName _ShowDatetime_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "showDatetime");
    private final static QName _Color_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/prices", "color");
    private final static QName _Name_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "name");
    private final static QName _Value_QNAME = new QName("", "value");
    private final static QName _AntibotDesired_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "antibotDesired");
    private final static QName _ShowDate_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "showDate");
    private final static QName _Address_QNAME = new QName("", "address");
    private final static QName _VisitorGroupPricingType_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/prices", "visitorGroupPricingType");
    private final static QName _SupraEvent_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "supraEvent");
    private final static QName _IsGraphicVenue_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "isGraphicVenue");
    private final static QName _SeveralVenues_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "severalVenues");
    private final static QName _HideSessionDates_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "hideSessionDates");
    private final static QName _Nif_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "nif");
    private final static QName _Title_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "title");
    private final static QName _SupportedVisitorType_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "supportedVisitorType");
    private final static QName _BestSeatsOperationSupported_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "bestSeatsOperationSupported");
    private final static QName _CorporateName_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "corporateName");
    private final static QName _HasProducts_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "hasProducts");
    private final static QName _Nominal_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "nominal");
    private final static QName _FiscalCode_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "fiscalCode");
    private final static QName _SeveralLocations_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "severalLocations");
    private final static QName _InternalName_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/session", "internalName");
    private final static QName _Email_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/event", "email");
    private final static QName _PromotedPrice_QNAME = new QName("http://www.oneboxtm.es/ns/data-query/prices", "promotedPrice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epl.onebox.infoser
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TicketingPartit }
     * 
     */
    public TicketingPartit createTicketingPartit() {
        return new TicketingPartit();
    }

    /**
     * Create an instance of {@link SessionProperties }
     * 
     */
    public SessionProperties createSessionProperties() {
        return new SessionProperties();
    }

    /**
     * Create an instance of {@link SessionInfo }
     * 
     */
    public SessionInfo createSessionInfo() {
        return new SessionInfo();
    }

    /**
     * Create an instance of {@link Dates }
     * 
     */
    public Dates createDates() {
        return new Dates();
    }

    /**
     * Create an instance of {@link Datetime }
     * 
     */
    public Datetime createDatetime() {
        return new Datetime();
    }

    /**
     * Create an instance of {@link Venue }
     * 
     */
    public Venue createVenue() {
        return new Venue();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link CountrySubdivision }
     * 
     */
    public CountrySubdivision createCountrySubdivision() {
        return new CountrySubdivision();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link Space }
     * 
     */
    public Space createSpace() {
        return new Space();
    }

    /**
     * Create an instance of {@link EventBasicInfo }
     * 
     */
    public EventBasicInfo createEventBasicInfo() {
        return new EventBasicInfo();
    }

    /**
     * Create an instance of {@link ExternalReferenceCode }
     * 
     */
    public ExternalReferenceCode createExternalReferenceCode() {
        return new ExternalReferenceCode();
    }

    /**
     * Create an instance of {@link ShortDescription }
     * 
     */
    public ShortDescription createShortDescription() {
        return new ShortDescription();
    }

    /**
     * Create an instance of {@link LongDescription }
     * 
     */
    public LongDescription createLongDescription() {
        return new LongDescription();
    }

    /**
     * Create an instance of {@link CommunicationElements }
     * 
     */
    public CommunicationElements createCommunicationElements() {
        return new CommunicationElements();
    }

    /**
     * Create an instance of {@link Images }
     * 
     */
    public Images createImages() {
        return new Images();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
    }

    /**
     * Create an instance of {@link Taxonomy }
     * 
     */
    public Taxonomy createTaxonomy() {
        return new Taxonomy();
    }

    /**
     * Create an instance of {@link Languages }
     * 
     */
    public Languages createLanguages() {
        return new Languages();
    }

    /**
     * Create an instance of {@link Entidad }
     * 
     */
    public Entidad createEntidad() {
        return new Entidad();
    }

    /**
     * Create an instance of {@link Promotor }
     * 
     */
    public Promotor createPromotor() {
        return new Promotor();
    }

    /**
     * Create an instance of {@link ActivityTicketTypesAvailability }
     * 
     */
    public ActivityTicketTypesAvailability createActivityTicketTypesAvailability() {
        return new ActivityTicketTypesAvailability();
    }

    /**
     * Create an instance of {@link ActivityTicketTypeAvailability }
     * 
     */
    public ActivityTicketTypeAvailability createActivityTicketTypeAvailability() {
        return new ActivityTicketTypeAvailability();
    }

    /**
     * Create an instance of {@link IndividualPrice }
     * 
     */
    public IndividualPrice createIndividualPrice() {
        return new IndividualPrice();
    }

    /**
     * Create an instance of {@link OriginalBasePriceCharges }
     * 
     */
    public OriginalBasePriceCharges createOriginalBasePriceCharges() {
        return new OriginalBasePriceCharges();
    }

    /**
     * Create an instance of {@link Charge }
     * 
     */
    public Charge createCharge() {
        return new Charge();
    }

    /**
     * Create an instance of {@link PromotedPriceCharges }
     * 
     */
    public PromotedPriceCharges createPromotedPriceCharges() {
        return new PromotedPriceCharges();
    }

    /**
     * Create an instance of {@link AvailabilityInfo }
     * 
     */
    public AvailabilityInfo createAvailabilityInfo() {
        return new AvailabilityInfo();
    }

    /**
     * Create an instance of {@link Sector }
     * 
     */
    public Sector createSector() {
        return new Sector();
    }

    /**
     * Create an instance of {@link VisitorGroupAvailability }
     * 
     */
    public VisitorGroupAvailability createVisitorGroupAvailability() {
        return new VisitorGroupAvailability();
    }

    /**
     * Create an instance of {@link LocationCode }}
     * 
     */
    @XmlElementDecl(namespace = "", name = "code")
    public LocationCode createLocationCode(String value) {
        return new LocationCode(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "admission")
    public JAXBElement<String> createAdmission(String value) {
        return new JAXBElement<String>(_Admission_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "city")
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/venue", name = "id")
    public JAXBElement<Short> createId(Short value) {
        return new JAXBElement<Short>(_Id_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "postalCode")
    public JAXBElement<String> createPostalCode(String value) {
        return new JAXBElement<String>(_PostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "showTime")
    public JAXBElement<Boolean> createShowTime(Boolean value) {
        return new JAXBElement<Boolean>(_ShowTime_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "available")
    public JAXBElement<Short> createAvailable(Short value) {
        return new JAXBElement<Short>(_Available_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "language")
    public JAXBElement<String> createLanguage(String value) {
        return new JAXBElement<String>(_Language_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "giftTicket")
    public JAXBElement<Boolean> createGiftTicket(Boolean value) {
        return new JAXBElement<Boolean>(_GiftTicket_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "eventType")
    public JAXBElement<String> createEventType(String value) {
        return new JAXBElement<String>(_EventType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "forSale")
    public JAXBElement<Boolean> createForSale(Boolean value) {
        return new JAXBElement<Boolean>(_ForSale_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/prices", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/prices", name = "originalBasePrice")
    public JAXBElement<BigDecimal> createOriginalBasePrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OriginalBasePrice_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "total")
    public JAXBElement<Short> createTotal(Short value) {
        return new JAXBElement<Short>(_Total_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "phoneNumber")
    public JAXBElement<String> createPhoneNumber(String value) {
        return new JAXBElement<String>(_PhoneNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "showDatetime")
    public JAXBElement<Boolean> createShowDatetime(Boolean value) {
        return new JAXBElement<Boolean>(_ShowDatetime_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link SessionSearchInfo }}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "name")
    public SessionSearchInfo createSessionSearchInfo(String value) {
        return new SessionSearchInfo(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/prices", name = "color")
    public JAXBElement<String> createColor(String value) {
        return new JAXBElement<String>(_Color_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "value")
    public JAXBElement<BigDecimal> createValue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Value_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "antibotDesired")
    public JAXBElement<Boolean> createAntibotDesired(Boolean value) {
        return new JAXBElement<Boolean>(_AntibotDesired_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "showDate")
    public JAXBElement<Boolean> createShowDate(Boolean value) {
        return new JAXBElement<Boolean>(_ShowDate_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address")
    public JAXBElement<String> createAddress(String value) {
        return new JAXBElement<String>(_Address_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/prices", name = "visitorGroupPricingType")
    public JAXBElement<String> createVisitorGroupPricingType(String value) {
        return new JAXBElement<String>(_VisitorGroupPricingType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link SpaceName }}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/venue", name = "name")
    public SpaceName createSpaceName(String value) {
        return new SpaceName(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "supraEvent")
    public JAXBElement<Boolean> createSupraEvent(Boolean value) {
        return new JAXBElement<Boolean>(_SupraEvent_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "isGraphicVenue")
    public JAXBElement<Boolean> createIsGraphicVenue(Boolean value) {
        return new JAXBElement<Boolean>(_IsGraphicVenue_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "severalVenues")
    public JAXBElement<Boolean> createSeveralVenues(Boolean value) {
        return new JAXBElement<Boolean>(_SeveralVenues_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "hideSessionDates")
    public JAXBElement<Boolean> createHideSessionDates(Boolean value) {
        return new JAXBElement<Boolean>(_HideSessionDates_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "nif")
    public JAXBElement<String> createNif(String value) {
        return new JAXBElement<String>(_Nif_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link Prices }}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/prices", name = "name")
    public Prices createPrices(String value) {
        return new Prices(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "title")
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement<String>(_Title_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "supportedVisitorType")
    public JAXBElement<String> createSupportedVisitorType(String value) {
        return new JAXBElement<String>(_SupportedVisitorType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "bestSeatsOperationSupported")
    public JAXBElement<Boolean> createBestSeatsOperationSupported(Boolean value) {
        return new JAXBElement<Boolean>(_BestSeatsOperationSupported_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "corporateName")
    public JAXBElement<String> createCorporateName(String value) {
        return new JAXBElement<String>(_CorporateName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "hasProducts")
    public JAXBElement<Boolean> createHasProducts(Boolean value) {
        return new JAXBElement<Boolean>(_HasProducts_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "nominal")
    public JAXBElement<Boolean> createNominal(Boolean value) {
        return new JAXBElement<Boolean>(_Nominal_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "fiscalCode")
    public JAXBElement<String> createFiscalCode(String value) {
        return new JAXBElement<String>(_FiscalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "severalLocations")
    public JAXBElement<Boolean> createSeveralLocations(Boolean value) {
        return new JAXBElement<Boolean>(_SeveralLocations_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/session", name = "internalName")
    public JAXBElement<String> createInternalName(String value) {
        return new JAXBElement<String>(_InternalName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/event", name = "email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oneboxtm.es/ns/data-query/prices", name = "promotedPrice")
    public JAXBElement<BigDecimal> createPromotedPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PromotedPrice_QNAME, BigDecimal.class, null, value);
    }

}
