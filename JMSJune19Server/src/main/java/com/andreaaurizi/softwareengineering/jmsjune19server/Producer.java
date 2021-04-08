/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.jmsjune19server;

import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Producer {
    private static final String JMS_NAME = "dynamicTopics/professors"; 
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    private static final  int MAXID = 6;
    private static final int MAXRANK = 100;
    
    public void start(){
        
        
            Context jndiContext = null;
            ConnectionFactory connectionFactory = null;
            Connection connection = null;
            Session session = null;
            Destination destination = null;
            MessageProducer producer = null;

            /* inizializzazione contesto*/
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            try {
                    jndiContext = new InitialContext(props);
            } catch (NamingException e) {
                    LOG.error("Error initizialization jndiContext" + e.toString());
                    System.exit(1);
            }

            /* creazione configurazione di connessione e della coda di destinazione diciò che si produce */
            try {
                    connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
                    destination = (Destination) jndiContext.lookup(JMS_NAME);
            } catch (NamingException e) {
                    LOG.error("Error in connection_factory o destination creation" + e.toString());
                    System.exit(1);
            }
		
		/*connessione come produttore alla coda*/
		try {
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			producer = session.createProducer(destination);
		} catch (JMSException e) {
			LOG.error("Error creating connection, session or producer" + e.toString());
			
			try {
				if(connection!=null) connection.close();
			} catch (JMSException e1) {
				LOG.error("Closing connection");
			}
		}
		
		
		try {
			sendMessage(session, producer);
		} catch (JMSException e) {
			LOG.error("Error in sending message " + e.toString());
		}
        
        
    }
    
    private int chooseRandomID(){
        int id = (int)(Math.random()*MAXID +1);
        return id;
    }
    
    private float chooseRandomRanking(){
        float rank = (float) (Math.random()*MAXRANK+1);
        return rank;
    }
    
    private void sendMessage(Session session, MessageProducer producer) throws JMSException {
		
		TextMessage message = null;
		String organizationName = null;
		
		try {
			message = session.createTextMessage();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id;
                float rank;
		
		int i = 0;
		
		while (true) {
			i++;
			id = String.valueOf(chooseRandomID());
                        rank = chooseRandomRanking();
			message.setStringProperty("id", id);
                        message.setFloatProperty("rank", rank);
			
			message.setText("Item " + i + " => ID = "+ id +" \n       => rank = " + rank);
                        

			LOG.info(this.getClass().getName() + "Send id: " + message.getText());
			
			producer.send(message);
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
    
}
