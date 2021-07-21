/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zclient;

import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */

@XmlRootElement( name = "CollectionsOfBook" )
public class CollectionsBook {
    
    private LinkedList<Book> lista;
    
    
    public CollectionsBook(){
    }

    public CollectionsBook(LinkedList<Book> lista) {
        this.lista = lista;
    }

    public LinkedList<Book> getLista() {
        return lista;
    }
    
    @XmlElement(name="ListBook")
    public void setLista(LinkedList<Book> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "CollectionsBook{" + "lista=" + lista + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.lista);
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
        final CollectionsBook other = (CollectionsBook) obj;
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }
    
    
    
}
