package com.andreaaurizi.softwareengineering.jmsclient;

import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.jms.*;
import javax.naming.*;
import org.slf4j.*;


public class ShopJMSManager extends Observable implements MessageListener{
	
	private static final Logger LOG = LoggerFactory.getLogger(ShopJMSManager.class);

	Properties properties = null;
	Context jndiContext = null;
	private TopicConnectionFactory connectionFactory = null;
	private TopicConnection connection = null;
	private TopicSession session = null;
	private Topic destination = null;
	private TopicSubscriber sub;
        private TopicPublisher topicPublisher;
    
        public ShopJMSManager(Observer observer) {
    	super.addObserver(observer);

    	try {
			
        InitialContext ctx = null;
        properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
        jndiContext = new InitialContext(properties);        
        
        ctx = new InitialContext(properties);
        this.connectionFactory = (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
		    this.destination = (Topic) ctx.lookup("dynamicTopics/Ordini");
		

		    this.connection = this.connectionFactory.createTopicConnection();
		    this.session = this.connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		    this.topicPublisher = session.createPublisher(destination);
		} catch (NamingException err) {
			LOG.error("Errore in topic publisher creation" + err.toString());
			System.exit(1);
		} catch (JMSException err) {
			LOG.error("Errore in topic publisher creation" + err.toString());
			System.exit(1);
		} 
    	
    }
	
    public boolean shop(String name, float price, int quantity) {
    	String user = User.getInstance().getUser();
    	
    	try {
			TextMessage sendMex = session.createTextMessage();

			sendMex.setStringProperty("User", user);
			sendMex.setStringProperty("Name", name);
			sendMex.setFloatProperty("Price", price);

			sendMex.setIntProperty("Quantity", quantity);
			
			String query =
					"User = '" + user + "'" +
					" AND " +
					"Name = '" + name + "'";
			
			System.out.println(query);
			
			sub = session.createSubscriber(destination, query, true);
			sub.setMessageListener(this);
			connection.start();
			topicPublisher.publish(sendMex);
		} catch (JMSException err) {
			LOG.error("Erro in creation shopping query");
			return false;
		}
		return true;
    }
    
	@Override
	public void onMessage(Message mex) {
		String infoMex = null;
		try {
			TextMessage recMex = (TextMessage) mex;
			System.out.println("Mex received : " + recMex.getBooleanProperty("Status"));
			if (recMex != null)
				if (recMex.getBooleanProperty("Status"))
					infoMex = "Shop is done";
				else
					infoMex = "Shop is not done";
			/*
			 * Chiude la connessione del subscriber asincrono in modo da non
			 * ricevere altri messaggi di notifica
			 */
			sub.close();
		} catch (NumberFormatException err) {
			LOG.error("Errore nel riempimento di alcuni campi");
			System.exit(1);
		} catch (JMSException err) {
			LOG.error("Errore nel riempimento di alcuni campi2");
			System.exit(1);
		}
		
		if (infoMex != null) {
			super.setChanged();	// rende attivo il cambiamento di stato
			super.notifyObservers(infoMex);
		}
		
	}
	
}
