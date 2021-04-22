
package com.andreaaurizi.softwareengineering.soapgiu19server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSInterfaceImplService", targetNamespace = "http://soapgiu19server.softwareengineering.andreaaurizi.com/", wsdlLocation = "http://localhost:8080/WSInterface?wsdl")
public class WSInterfaceImplService
    extends Service
{

    private final static URL WSINTERFACEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSINTERFACEIMPLSERVICE_EXCEPTION;
    private final static QName WSINTERFACEIMPLSERVICE_QNAME = new QName("http://soapgiu19server.softwareengineering.andreaaurizi.com/", "WSInterfaceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WSInterface?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSINTERFACEIMPLSERVICE_WSDL_LOCATION = url;
        WSINTERFACEIMPLSERVICE_EXCEPTION = e;
    }

    public WSInterfaceImplService() {
        super(__getWsdlLocation(), WSINTERFACEIMPLSERVICE_QNAME);
    }

    public WSInterfaceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSINTERFACEIMPLSERVICE_QNAME, features);
    }

    public WSInterfaceImplService(URL wsdlLocation) {
        super(wsdlLocation, WSINTERFACEIMPLSERVICE_QNAME);
    }

    public WSInterfaceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSINTERFACEIMPLSERVICE_QNAME, features);
    }

    public WSInterfaceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSInterfaceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "WSInterfaceImplPort")
    public WSInterface getWSInterfaceImplPort() {
        return super.getPort(new QName("http://soapgiu19server.softwareengineering.andreaaurizi.com/", "WSInterfaceImplPort"), WSInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "WSInterfaceImplPort")
    public WSInterface getWSInterfaceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soapgiu19server.softwareengineering.andreaaurizi.com/", "WSInterfaceImplPort"), WSInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSINTERFACEIMPLSERVICE_EXCEPTION!= null) {
            throw WSINTERFACEIMPLSERVICE_EXCEPTION;
        }
        return WSINTERFACEIMPLSERVICE_WSDL_LOCATION;
    }

}