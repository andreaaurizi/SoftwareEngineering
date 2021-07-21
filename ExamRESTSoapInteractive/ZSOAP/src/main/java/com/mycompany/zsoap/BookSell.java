/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zsoap;

import java.util.LinkedList;
import javax.jws.WebService;



@WebService(endpointInterface= "com.mycompany.zsoap.BookSellInterface")
public class BookSell implements BookSellInterface {
    
    private Information info;
    
    private LinkedList<Seller> list;

    public BookSell() {
        
        list = new LinkedList<Seller>();
        Seller sell1 = new Seller("mario");
        Seller sell2 = new Seller("mario2");
        Seller sell3 = new Seller("mario3");
        
        list.add(sell1);
        list.add(sell2);
        list.add(sell3);
        
    }

    @Override
    public Information getInformations(int id) {
        String data;
        int price;
        
        
        if(id == 1){
            price = 10;
            data = "1";

        }
        else if (id == 2){
            price = 20;
            data = "2";
            
        }
        else if (id == 3){
            price = 30;
            data = "3";
        }
        else if(id == 4){
            price = 40;
            data = "4";
            
        }
        else{
            price = 50;
            data = "5";
            
        }
        
        info = new Information(id, price, data, list);
        
        return info;
 
    }
    
}
