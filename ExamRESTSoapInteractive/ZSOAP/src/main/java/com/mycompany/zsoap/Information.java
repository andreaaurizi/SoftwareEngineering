/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zsoap;

import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author studente
 */
public class Information {
    
    
    private int id;
    private int price;
    private String date;
    private LinkedList<Seller> sellers;
    

    public Information() {
    }

    public Information(int id, int price, String date, LinkedList<Seller> sellers) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.sellers = sellers;
    }

    public int getId() {
        return id;
    }

    @XmlElement(name="id",required=true)
    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
    
    @XmlElement(name="Price",required=true)
    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }
    
    @XmlElement(name="Date",required=true)
    public void setDate(String date) {
        this.date = date;
    }

    public LinkedList<Seller> getSellers() {
        return sellers;
    }
    
    @XmlElement(name="ListSellers",required=true)
    public void setSellers(LinkedList<Seller> sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "Information{" + "id=" + id + ", price=" + price + ", date=" + date + ", sellers=" + sellers + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + this.price;
        hash = 31 * hash + Objects.hashCode(this.date);
        hash = 31 * hash + Objects.hashCode(this.sellers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Information other = (Information) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.sellers, other.sellers)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
