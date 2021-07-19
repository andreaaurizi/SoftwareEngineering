package com.andreaaurizi.softwareengineering.jmsclient;

import java.util.Observable;
import java.util.Observer;
import java.util.Properties;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jms.*;
import javax.naming.*;

import org.slf4j.*;

public class ActionJMSListener extends Observable implements MessageListener{

	private static final Logger LOG = LoggerFactory.getLogger(ActionJMSListener.class);

	private TopicConnection topicConnection;
    private TopicSession topicSession = null;
    private Destination destination = null;
    private MessageProducer producer = null;
	
    public ActionJMSListener(Observer[] observers) {
    	for (Observer observer : observers) {
    		super.addObserver(observer);
    	}
    	
    	Context jndiContext = null;
    	ConnectionFactory topicConnectionFactory = null;
    	
    	String destinationName = "dynamicTopics/Quotazioni";
    	
    	Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
    	
    	try {
			jndiContext = new InitialContext(props);
		} catch (NamingException e) {
			LOG.error("Error increation jndiContex " + e.toString());
			System.exit(1);
		}
    	
    	
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
    
    //Open the reception of message on quote topic
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
			String name = message.getStringProperty("Name");
			float value = message.getFloatProperty("Quote");

			
			Quote quote = new Quote(name,value);
			
			super.setChanged(); //rende attivo il cambiamento di stato... quale?
			super.notifyObservers(quote);
			
		} catch (JMSException e) {
			LOG.error("Error in extraction property name and value from quote topic " + e.toString());
			System.exit(1);
		}
	}

}
