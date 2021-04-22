/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2client;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
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
import javax.swing.JOptionPane;

/**
 *
 * @author studente
 */
class ShopJMSManager extends Observable implements MessageListener {
    private ShopFrame shopFrame = null;
    Properties properties = null;
    Context jndiContext = null;
    private TopicConnectionFactory connectionFactory = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic destination = null;
    private TopicSubscriber sub;
    private TopicPublisher topicPublisher;
    
    public ShopJMSManager (Observer observer){
        super.addObserver(observer);

        try {

            InitialContext ctx = null;
            properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            jndiContext = new InitialContext(properties);        

            ctx = new InitialContext(properties);
            this.connectionFactory =
                (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
            this.destination =
                (Topic) ctx.lookup("dynamicTopics/Orders");

            this.connection =
                this.connectionFactory.createTopicConnection();
            this.session =
                this.connection.createTopicSession(
                                false, Session.AUTO_ACKNOWLEDGE
                        );
         this.topicPublisher = session.createPublisher(destination);
        } catch (NamingException err) {
                err.printStackTrace();
        } catch (JMSException err) {
                err.printStackTrace();
        } 
    }

    boolean shop(String title, float price, int quantity) {
        String user = User.getInstance().getUser();
        
        if (user == null)
            return false;
        
        try {
            TextMessage sendMex = session.createTextMessage();

            sendMex.setStringProperty("User",
                            user
                    );
            sendMex.setStringProperty("Title",
                            title
                    );
            sendMex.setFloatProperty("Price",
                            price
                    );

            sendMex.setIntProperty("Quantity", quantity);
            String query =
                            "User = '" + user + "'" +
                            " AND " +
                            "Title = '" + title + "'";
            sub = session.createSubscriber(destination, query, true);
            sub.setMessageListener(this);
            connection.start();
            topicPublisher.publish(sendMex);
    } catch (JMSException err) {
            err.printStackTrace();
            return false;
    }
    return true;

    }

    @Override
    public void onMessage(Message msg) {
        String infoMex = null;
        try {
                TextMessage recMex = (TextMessage) msg;
                

                if (recMex != null){
                    
                    if (recMex.getBooleanProperty("Status"))
                            infoMex = "L'acquisto \u00e8 andato a buon fine";
                    else
                            infoMex = "L'acquisto non \u00e8 andato a buon fine";
                }
                        /*
                 * Chiude la connessione del subscriber asincrono in modo da non
                 * ricevere altri messaggi di notifica
                 */
                sub.close();
        } catch (NumberFormatException err) {
                infoMex = "Errore nel riempimento di alcuni campi";
        } catch (JMSException err) {
                err.printStackTrace();
        }

        if (infoMex != null) {
                super.setChanged();	// rende attivo il cambiamento di stato
                super.notifyObservers(infoMex);
                JOptionPane.showMessageDialog(null, "Shop status :" + infoMex, "InfoBox: " + "ShopFrame", JOptionPane.INFORMATION_MESSAGE);
        
        }
    }
}
