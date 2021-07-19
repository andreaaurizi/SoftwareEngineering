/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complexrestservice;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import java.util.ArrayList;
import java.util.List;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author studente
 */
public class Server {
    private final static String DB_PATH = "/home/studente/Desktop/andrea";
    
    public static void main(String args[]) throws Exception {

        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(FligthRepository.class);
        FligthRepository fr = new FligthRepository();
        fr.setConnection(DB_PATH);
        factoryBean.setResourceProvider(new SingletonResourceProvider(fr));
        factoryBean.setAddress("http://localhost:8080/");

        List<Object> providers = new ArrayList<Object>();
        providers.add(new JacksonJaxbJsonProvider());

        factoryBean.setProviders(providers);

        BindingFactoryManager manager = factoryBean.getBus().getExtension(BindingFactoryManager.class);
        JAXRSBindingFactory restFactory = new JAXRSBindingFactory();
        restFactory.setBus(factoryBean.getBus());
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, restFactory);

        org.apache.cxf.endpoint.Server server = factoryBean.create();

        System.out.println("Server ready...");

        while (true) {
        }
    }
    
}
