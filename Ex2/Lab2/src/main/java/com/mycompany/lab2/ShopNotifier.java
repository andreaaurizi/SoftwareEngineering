package com.mycompany.lab2;

import java.util.Properties;
import java.util.logging.Level;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ShopNotifier implements MessageListener{

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    Properties props = null;
    Context jndiContex = null;
    private TopicConnectionFactory connFactory = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic destination = null;
    private TopicSubscriber subscriber = null;
    private TopicPublisher publisher = null;
    
    public ShopNotifier(){}
    
    void start()   {
       InitialContext ctx = null;
        
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
        
        try {
            jndiContex = new InitialContext(props);
            
            ctx = new InitialContext(props);
            this.connFactory = (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
            this.destination = (Topic) ctx.lookup("dynamicTopics/Orders");
            
        } catch (NamingException ex) {
            LOG.error("Error in creation context :" + ex.toString());
        }
         
            
        try {
            this.connection = this.connFactory.createTopicConnection();
            this.session = this.connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            this.subscriber = this.session.createSubscriber(this.destination, null, true);
            this.publisher = this.session.createPublisher(this.destination);
            
            this.connection.start();
            subscriber.setMessageListener(this);
        } catch (JMSException ex) {
            LOG.error("Error in creation connection or session :" + ex.toString());
        }
        
        LOG.info("waiting for shop request . . . ");

    }
    
    public void onMessage(Message msg){
		TextMessage message;
		String user = null;
		String name = null;
		float price;
		int quantity;
		boolean status = (float)Math.random() < 0.5;
		try {
			message = (TextMessage) msg;
			user = message.getStringProperty("User");
			name = message.getStringProperty("Name");
			price = message.getFloatProperty("Price");
			quantity = message.getIntProperty("Quantity");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			session = connection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);
			publisher = session.createPublisher(destination);
			message = session.createTextMessage();
			message.setStringProperty("User", user);
			message.setStringProperty("Name", name);
			message.setBooleanProperty("Status", status);
			message.setIntProperty("Quantity", quantity);
			message.setFloatProperty("Price", price);
			
			LOG.info(
					"************************************************" + "\n" +
					"Notifica richiesta di acquisto" + "\n" +
					"ID user: " + user + "\n" +
					"Title: " + name + "\n" +
					"Quantity: " + quantity + "\n" +
					"Price: " + price + "\n" +
					"Accepted: " + status + "\n" +
					"************************************************"
				);

			publisher.send(message);
		} catch (Exception err) {
			err.printStackTrace();
		}
    }
    
    public static void main (String[] args){
        ShopNotifier sn = new ShopNotifier();
        sn.start();                
    }
}
