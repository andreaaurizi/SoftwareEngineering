/**
 * WarehousewsServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.leonardocapozzi.softeng.SOAPfebbraio2021;

public class WarehousewsServiceImplServiceLocator extends org.apache.axis.client.Service implements it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplService {

    public WarehousewsServiceImplServiceLocator() {
    }


    public WarehousewsServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WarehousewsServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WarehousewsServiceImplPort
    private java.lang.String WarehousewsServiceImplPort_address = "http://localhost:8080/WarehousewsService";

    public java.lang.String getWarehousewsServiceImplPortAddress() {
        return WarehousewsServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WarehousewsServiceImplPortWSDDServiceName = "WarehousewsServiceImplPort";

    public java.lang.String getWarehousewsServiceImplPortWSDDServiceName() {
        return WarehousewsServiceImplPortWSDDServiceName;
    }

    public void setWarehousewsServiceImplPortWSDDServiceName(java.lang.String name) {
        WarehousewsServiceImplPortWSDDServiceName = name;
    }

    public it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService getWarehousewsServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WarehousewsServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWarehousewsServiceImplPort(endpoint);
    }

    public it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService getWarehousewsServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplServiceSoapBindingStub _stub = new it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWarehousewsServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWarehousewsServiceImplPortEndpointAddress(java.lang.String address) {
        WarehousewsServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService.class.isAssignableFrom(serviceEndpointInterface)) {
                it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplServiceSoapBindingStub _stub = new it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplServiceSoapBindingStub(new java.net.URL(WarehousewsServiceImplPort_address), this);
                _stub.setPortName(getWarehousewsServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WarehousewsServiceImplPort".equals(inputPortName)) {
            return getWarehousewsServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://SOAPfebbraio2021.softeng.leonardocapozzi.it/", "WarehousewsServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://SOAPfebbraio2021.softeng.leonardocapozzi.it/", "WarehousewsServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WarehousewsServiceImplPort".equals(portName)) {
            setWarehousewsServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
