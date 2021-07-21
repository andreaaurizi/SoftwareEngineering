
package com.mycompany.zsoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.zsoap package. 
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

    private final static QName _GetInformationsResponse_QNAME = new QName("http://zsoap.mycompany.com/", "getInformationsResponse");
    private final static QName _GetInformations_QNAME = new QName("http://zsoap.mycompany.com/", "getInformations");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.zsoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInformations }
     * 
     */
    public GetInformations createGetInformations() {
        return new GetInformations();
    }

    /**
     * Create an instance of {@link GetInformationsResponse }
     * 
     */
    public GetInformationsResponse createGetInformationsResponse() {
        return new GetInformationsResponse();
    }

    /**
     * Create an instance of {@link Seller }
     * 
     */
    public Seller createSeller() {
        return new Seller();
    }

    /**
     * Create an instance of {@link Information }
     * 
     */
    public Information createInformation() {
        return new Information();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInformationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://zsoap.mycompany.com/", name = "getInformationsResponse")
    public JAXBElement<GetInformationsResponse> createGetInformationsResponse(GetInformationsResponse value) {
        return new JAXBElement<GetInformationsResponse>(_GetInformationsResponse_QNAME, GetInformationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInformations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://zsoap.mycompany.com/", name = "getInformations")
    public JAXBElement<GetInformations> createGetInformations(GetInformations value) {
        return new JAXBElement<GetInformations>(_GetInformations_QNAME, GetInformations.class, null, value);
    }

}
