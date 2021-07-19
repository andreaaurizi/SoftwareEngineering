package com.andreaaurizi.softwareengineering.jmsserver;

import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.*;


public class QuotesProducer {
	private String[] organicationNames;
	private static final int MAX_QUOTE = 20;
	private static final 	String JMS_NAME = "dynamicTopics/Quotazioni"; 
	private static final Logger LOG = LoggerFactory.getLogger(QuotesProducer.class);
	
	public QuotesProducer() {
		organicationNames = new String[] {"Granarolo", "Nike", "Adidas", "AsrRoma"};
	}
	
	private String chooseRandomOrganizationName () {
		LOG.info("Choosing random organization name");
		int randomNumber = (int) (Math.random()*organicationNames.length);
		return organicationNames[randomNumber];
	}
	
	private float chooseRandomQuote () {
		LOG.info("Choosing random organization quote");
		return (float) (Math.random()*MAX_QUOTE);
	}
	
	public void start() {
		
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
	
	
	private void sendMessage(Session session, MessageProducer producer) throws JMSException {
		
		TextMessage message = null;
		String organizationName = null;
		
		try {
			message = session.createTextMessage();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		float quote;
		
		int i = 0;
		
		while (true) {
			i++;
			organizationName = chooseRandomOrganizationName();
			quote = chooseRandomQuote();
			message.setStringProperty("Name", organizationName);
			message.setFloatProperty("Quote", quote);
			
			message.setText("Item " + i + ": " + organizationName + ", Value : " + quote);
			
			LOG.info(this.getClass().getName() + "Send quote: " + message.getText());
			
			producer.send(message);
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}










