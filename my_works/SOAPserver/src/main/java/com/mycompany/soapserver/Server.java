package com.mycompany.soapserver;
import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String args[]) throws InterruptedException {
        WSImpl implementor = new WSImpl();
        String address = "http://localhost:8080/WSInterface";
        Endpoint.publish(address, implementor);
        while(true) {}
        //Thread.sleep(60 * 1000);
        //System.exit(0);
    }
}
