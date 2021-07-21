/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zsoap;

import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;


public class Seller {
    
    
    private String name;

    public Seller() {
    }

    public Seller(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @XmlElement(name="Name",required=true)
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
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
        final Seller other = (Seller) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seller{" + "name=" + name + '}';
    }
    
    
    
    
    
    
    
    
    
}
