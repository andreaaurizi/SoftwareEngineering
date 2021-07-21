/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zbookrest;

import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement( name = "Book" )
public class Book {
    
    private String title;
    private String author;
    private String year;
    private int id;

    public Book() {
    }
    
    

    public Book(String title, String author, String year, int id) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name="Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    
    @XmlElement(name="Author")
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }
    
    @XmlElement(name="Year")
    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    @XmlElement(name="Id")
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.author);
        hash = 97 * hash + Objects.hashCode(this.year);
        hash = 97 * hash + this.id;
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
        final Book other = (Book) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", year=" + year + ", id=" + id + '}';
    }
    
    
    
}
