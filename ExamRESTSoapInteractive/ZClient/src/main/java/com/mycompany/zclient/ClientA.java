/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zclient;


import com.mycompany.zsoap.Seller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.client.Client;


public class ClientA {
    
    
    
    public static void main(String[] args) throws Exception {
    // Create objects to start comunication with RESTServer
       
        Client client = ClientBuilder.newClient();
        String baseUrl = "http://localhost:8080/book";
        WebTarget webTarget = client.target(baseUrl);
        
        Invocation.Builder ib = webTarget.request("text/xml");
        Response res;
       
        
        CollectionsBook books = ib.accept(MediaType.TEXT_XML).get(CollectionsBook.class);
        System.out.println("PRIMA RICHIESTA GET"+books.toString());
        
        System.out.println("Enter something here : ");
        String id = "1";

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            id = bufferRead.readLine();

            System.out.println(id);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        
        
        WebTarget webTarget1 = client.target(baseUrl+"/"+id);
        Invocation.Builder ib2 = webTarget1.request("text/xml");
        
        Book single = ib2.accept(MediaType.TEXT_XML).get(Book.class);
        System.out.println("SECONDA RICHIESTA GET"+single.toString());

        try { // Call Web Service Operation
            com.mycompany.zsoap.BookSellService service = new com.mycompany.zsoap.BookSellService();
            com.mycompany.zsoap.BookSellInterface port = service.getBookSellPort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
            com.mycompany.zsoap.Information result = port.getInformations(Integer.parseInt(id));
            System.out.println("Result ID and Price = " +"  "+ result.getDate()+ "   "+ result.getPrice());
            for(Seller s : result.getListSellers()){
                System.out.println(s.getName());
            
        }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

      
    }
    
    
    
    
}
