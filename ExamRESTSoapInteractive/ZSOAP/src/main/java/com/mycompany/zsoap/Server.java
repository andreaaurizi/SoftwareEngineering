/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zsoap;

import javax.xml.ws.Endpoint;

/**
 *
 * @author studente
 */
public class Server {
    
    
     public static void main(String[] args) throws InterruptedException {
        BookSellInterface implementor = new BookSell();
        String address = "http://localhost:8081/BookSellInterface";
        Endpoint.publish(address, implementor);
        System.out.println("Server is running...");
        Thread.sleep(60 * 1000);
        System.exit(0);
    }
    
}
