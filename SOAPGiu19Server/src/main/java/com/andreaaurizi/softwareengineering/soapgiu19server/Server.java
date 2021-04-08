/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.soapgiu19server;

import javax.xml.ws.Endpoint;

/**
 *
 * @author studente
 */
public class Server {

    public static void main(String args[]) throws InterruptedException {
        WSInterfaceImpl implementor = new WSInterfaceImpl();
        String address = "http://localhost:8080/WSInterface";
        Endpoint.publish(address, implementor);
        while(true) {}
        //Thread.sleep(60 * 1000);
        //System.exit(0);
    }
}
