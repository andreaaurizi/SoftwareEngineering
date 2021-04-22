/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.*;
import org.slf4j.LoggerFactory;

/**
 *
 * @author studente
 */
class ActionJMSListener extends Observable implements MessageListener{
    private TopicConnection connection;
    private TopicSession session = null;
    private Destination topicDestination = null;
    private MessageProducer producer = null;
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ActionJMSListener.class);   
    
    
    
    ActionJMSListener(Observer[] observers) {
        for (Observer observer : observers){
            super.addObserver(observer);
        }
        
        Context jndiContext = null;
        ConnectionFactory topicConnectionFactory = null;
        
        String destination = "dynamicTopics/Quotes";
        
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
        
        try {
            jndiContext = new InitialContext(props);
        } catch (NamingException ex) {
            LOG.error("Error in creation new context : "+ex.toString());
        }
        
        try {
            topicConnectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            topicDestination = (Destination) jndiContext.lookup(destination);
            connection = (TopicConnection) topicConnectionFactory.createConnection();
            session = (TopicSession) connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber topicSubscriber = (TopicSubscriber) session.createSubscriber((Topic) topicDestination);
            topicSubscriber.setMessageListener(this);
        } catch (NamingException ex){
            LOG.error("Error in creation new ccontext : "+ex.toString());
	} catch (JMSException err) {
            LOG.error("Error in creation connection : "+err.toString());
        }
        
    }
    
    public void start(){
        try {
            connection.start();
        } catch (JMSException ex) {
            LOG.error("Error in start connection : "+ex.toString());
        }
    }
    
    public void stop(){
        try {
            connection.stop();
        } catch (JMSException ex) {
            LOG.error("Error in stop connection : "+ex.toString());
        }
    }

    @Override
    public void onMessage(Message msg) {
        try {
            String title = msg.getStringProperty("Title");
            float quote = msg.getFloatProperty("Quote");
            
            Quote q = new Quote(title, quote);
            super.setChanged();
            super.notifyObservers(q);
            
        } catch (JMSException ex) {
            LOG.error("Error in extract info from message : "+ex.toString());
        }
    }
    
}
