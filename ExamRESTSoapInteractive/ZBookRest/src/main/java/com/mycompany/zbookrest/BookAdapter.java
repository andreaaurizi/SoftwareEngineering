/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zbookrest;

import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/book")
@Produces("text/xml")
public class BookAdapter {
    
    public CollectionsBook collection;
    
    public LinkedList<Book> list;

    public BookAdapter() {
        
        Book book1 = new Book("Titolo1", "Author1", "Year1", 1);
        Book book2 = new Book("Titolo2", "Author2", "Year2", 2);
        Book book3 = new Book("Titolo3", "Author3", "Year3", 3);
        Book book4 = new Book("Titolo4", "Author4", "Year4", 4);
        Book book5 = new Book("Titolo5", "Author5", "Year5", 5);
        Book book6 = new Book("Titolo6", "Author6", "Year6", 6);
        Book book7 = new Book("Titolo7", "Author7", "Year7", 7);
        Book book8 = new Book("Titolo8", "Author8", "Year8", 8);
        Book book9 = new Book("Titolo9", "Author9", "Year9", 9);
        Book book10 = new Book("Titolo10", "Author10", "Year10", 10);
        
        
        list = new LinkedList<Book>();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        list.add(book6);
        list.add(book7);
        list.add(book8);
        list.add(book9);
        list.add(book10);
        collection = new CollectionsBook(list);
        
        
    }
    
    @GET
    @Path("")
    public CollectionsBook getListBook(){
        LinkedList<Book> listanuova = new LinkedList<>();
        for(Book l : list){
            listanuova.add(l);
        }
        return collection;
    }
    
    
    @GET
    @Path("{id}")
    public Book getCourse(@PathParam("id") int id) {
        return findBookById(id);
    
    }

    private Book findBookById(int id) {
        for(Book ue : collection.getLista()){
            if(id == ue.getId()){
                return ue;
            }
        }
        return null;
    }
    
    
    
}
