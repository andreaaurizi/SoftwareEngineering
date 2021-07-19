/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.clientjune19;

import com.andreaaurizi.softwareengineering.soapgiu19server.*;
        
import java.util.Properties;
import javax.jms.*;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author studente
 */
public class Client implements MessageListener{

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    private TopicConnection topicConnection;
    private TopicSession topicSession = null;
    private Destination destination = null;
    private MessageProducer producer = null;
    private WSInterface port= null;
    
    public Client() {
    	Context jndiContext = null;
    	ConnectionFactory topicConnectionFactory = null;
    	
    	String destinationName = "dynamicTopics/professors";
    	
    	Properties props = new Properties();
        
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        
        try {
            jndiContext = new InitialContext(props);
	}
        catch (NamingException e) {
            LOG.error("Error increation jndiContex " + e.toString());
            System.exit(1);
	}
    	
        WSInterfaceImplService interfaceService = new WSInterfaceImplService();
        port = interfaceService.getWSInterfaceImplPort();
        
        
    	
    	try {
   		
            topicConnectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            destination = (Destination)jndiContext.lookup(destinationName);
            topicConnection = (TopicConnection)topicConnectionFactory.createConnection();
            topicSession = (TopicSession)topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber topicSubscriber =  topicSession.createSubscriber((Topic)destination);

                       
            topicSubscriber.setMessageListener(this);
    	} catch (JMSException err) {
    		LOG.error("Error in connection topic JMS Ex " + err.toString());
			System.exit(1);
		} catch (NamingException e) {
			LOG.error("Error in connection topic NAMING Ex " + e.toString());
			System.exit(1);
		}
    }
    
    public void start() {
    	try {
			topicConnection.start();
		} catch (JMSException e) {
			LOG.error("Error in start messaging to quote topic.");
			System.exit(1);
		}
    }
    
  //Open the reception of message on quote topic
    public void stop() {
    	try {
			topicConnection.stop();
		} catch (JMSException e) {
			LOG.error("Error in stop messaging to quote topic.");
			System.exit(1);
		}
    }
    
    @Override
    public void onMessage(Message message) {
            try {
                    String id = message.getStringProperty("id");
                    
                    ProfessorImpl professor =  port.getDetails(id);
                    

                    System.out.println(id + " : \n  name : " + professor.getName() + " , surname : " + professor.getSurname() + ", rank : " + message.getFloatProperty("rank"));
            } catch (JMSException e) {
                    LOG.error("Error in extraction property name and value from quote topic " + e.toString());
                    System.exit(1);
            }
    }

    
    public static void main(String[] args){
        Client c = new Client();
        c.start();
    }
    
}
