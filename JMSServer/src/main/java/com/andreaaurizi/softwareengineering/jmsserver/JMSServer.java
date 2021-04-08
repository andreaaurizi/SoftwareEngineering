/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.jmsserver;

public class JMSServer {
    public static void main(String[] args) {
    com.andreaaurizi.softwareengineering.jmsserver.QuotesProducer quotesProducer = new com.andreaaurizi.softwareengineering.jmsserver.QuotesProducer();
    quotesProducer.start();
    
  }
}
