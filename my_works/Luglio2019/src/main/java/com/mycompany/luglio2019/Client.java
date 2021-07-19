package com.mycompany.luglio2019;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class Client {
    
    private static final String BASE_URL = "http://localhost:8080/movies/";
    private static CloseableHttpClient client;
    
    public static void main(String[] args) throws IOException {
        
        client = HttpClients.createDefault();

        // Example GET
        
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(BASE_URL + "7");
        
        InputStream input = url.openStream();
        
        Movie mv = (Movie)mapper.readValue(input, Movie.class);        
        System.out.println(mv);
        
        
        
    }
}
