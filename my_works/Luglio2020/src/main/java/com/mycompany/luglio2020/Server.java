package com.mycompany.luglio2020;

import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String args[]) throws InterruptedException {
        MovieServiceImpl implementor = new MovieServiceImpl();
        String address = "http://localhost:8080/MovieService";
        Endpoint.publish(address, implementor);
        while(true) {}
        //Thread.sleep(60 * 1000);
        //System.exit(0);
    }
}
