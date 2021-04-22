package com.mycompany.lab2;

import java.util.Properties;
import java.util.logging.Level;
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

class Producer {
    final static float MAXVALUE = 100;
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    final String title[] = { "Roma", "Toyota", "League of Legends", 
                            "La Sapienza", "OnePlus", "Apple", "Balance",
                            "New Balance"};

    
    private String chooseRandomTitle(){
        int i = (int) (Math.random()*title.length);
        return title[i];
    }
    
    private float chooseRandomValue(){
        float value = (float) (Math.random()*MAXVALUE +1) ;
        return value;
    }

    public void start() {
        Context jndiContext = null;
        ConnectionFactory connFactory = null;
        Connection conn = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;
        String destinationName = "dynamicTopics/Quotes";
        
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        
        try {
            jndiContext = new InitialContext(props);
            connFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            destination = (Destination) jndiContext.lookup(destinationName);
        } catch (NamingException ex) {
            LOG.error("Error in creation context, lookup connFatory or destination : " + ex.toString());
            System.exit(1);
        }
        
        try {
            conn = (Connection) connFactory.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
            
            
            
            //Inizio scambio messaggi
            TextMessage message = null;
            String messageType = null;

            message = session.createTextMessage();
            
            float quote;
            
            int i = 0;
            
            while(true){
                
                i++;
                messageType = chooseRandomTitle();
                quote = chooseRandomValue();
                message.setStringProperty("Title", messageType);
                message.setFloatProperty("Quote", quote);
                
                message.setText("Item " + i + " : Title = " + messageType +", Quote = "+ quote);
                LOG.info(this.getClass().getName() + "Send quote : " + message.getText());
                
                producer.send(message);
                
                try {
				Thread.sleep(2000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
            }
        } catch (JMSException ex) {
            LOG.info("Error in creation connection, session or sending message :" + ex.toString());
            if(conn != null)
                try {
                    conn.close();
                } catch (JMSException e) {
                }
            System.exit(1);
        }
        
                
        
    }
    
}