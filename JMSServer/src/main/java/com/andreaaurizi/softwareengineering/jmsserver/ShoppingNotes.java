package com.andreaaurizi.softwareengineering.jmsserver;

import java.io.*;
import java.util.*;

import javax.jms.*;
import javax.naming.*;

import org.slf4j.*;

public class ShoppingNotes implements MessageListener {

		private static final Logger LOG = LoggerFactory.getLogger(ShoppingNotes.class);
		private static final String JMS_NAME = "dynamicTopics/Ordini";
		
		Properties properties = null;
		Context jndiContext = null;
		private TopicConnectionFactory connectionFactory = null;
		private TopicConnection connection = null;
		private TopicSession session = null;
		private Topic destination = null;
		private TopicSubscriber subscriber = null;
		private TopicPublisher publisher = null;
		
		private Random randomGen = new Random();
		
		public void start() {
			
			InitialContext ctx = null;
			
			properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
			
			try {
				jndiContext = new InitialContext(properties);
			} catch (NamingException e) {
				LOG.error("Error in InitialContext creation" + e.toString());
				System.exit(1);
			}
			
			
			try {
				ctx = new InitialContext(properties);
				this.connectionFactory = (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
				this.destination = (Topic) ctx.lookup(JMS_NAME);
				
			} catch (NamingException e) {
				LOG.error("Error in connection to queue name " + e.toString());
				System.exit(1);
			}
			
			
			try {
				this.connection = this.connectionFactory.createTopicConnection();
				this.session = this.connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
				this.subscriber = this.session.createSubscriber(this.destination, null, true);
				this.connection.start();
			} catch (JMSException e) {
				LOG.error("Error in connection queue " + e.toString());
				System.exit(1);
			}
			
			LOG.info(this.getClass().getName() +" is waiting for shopping request...");
			
			try {
				subscriber.setMessageListener(this);
			} catch (JMSException e) {
				LOG.error("Error in setting listener this " + e.toString());
				System.exit(1);
			}
		}

		@Override
		public void onMessage(Message msg) {
			System.out.println("C'è nessunoooooo?");
			TextMessage message;
			String user = null;
			String name = null;
			float price;
			int quantity;
			boolean status = randomGen.nextFloat() < 0.5;
			System.out.println(status);
			
			message = (TextMessage) msg;
			try {
				user = message.getStringProperty("User");
				name = message.getStringProperty("Name");
				price = message.getFloatProperty("Price");
				quantity = message.getIntProperty("Quantity");
			} catch (JMSException e) {
				LOG.error("Error in extraction property message " + e.toString());
				return;
			}
			
			try {
				session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
				publisher = session.createPublisher(destination);
				message = session.createTextMessage();
				message.setStringProperty("User", user);
				message.setStringProperty("Name", name);
				message.setBooleanProperty("Status", status);
				message.setFloatProperty("Price", price);
				message.setIntProperty("Quantity", quantity);
			
				LOG.info(this.getClass().getName() + 
					"************************************************" + "\n" +
					"Shopping notes : " + "\n" +
					"ID user: " + user + "\n" +
					"OrganizationName: " + name + "\n" +
					"Quantity: " + quantity + "\n" +
					"Price: " + price + "\n" +
					"Accepted: " + status + "\n" +
					"************************************************"
					);
				publisher.send(message);
			} catch (JMSException e) {
				LOG.error("Erron in creation topic publisher connection " + e.toString());
				System.exit(1);
			}
		}
		
		public static void main(String[] args) {
			ShoppingNotes sn = new ShoppingNotes();
			sn.start();
		}
}
