/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MovieRepository {
    
    private Connection conn;
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MovieRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection("jdbc:sqlite:"+pos);
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("")
    @Produces("application/json")
    public List<Movie> getAllMovie(){
        return findAll();
    }
    
    
    @GET
    @Path("/{movieId}")
    @Produces("application/json")
    public Movie getMovie(@PathParam("movieId") int movieId){
        Movie current_movie = findById(movieId);
        Movie temp = current_movie;
        int directorID = current_movie.getDirectorID();
        
        Director dir = null;
        PreparedStatement dir_stat;
        try{
            dir_stat = conn.prepareStatement("SELECT * FROM DIRECTOR WHERE ID = ?");
            dir_stat.setString(1, String.valueOf(directorID));
            
            ResultSet dir_rs = dir_stat.executeQuery();
            
            current_movie.setDirector(new Director(directorID, 
                    dir_rs.getString("name"), dir_rs.getString("yearOfBirth")));
            
        }catch (SQLException ex){
            Logger.getLogger(MovieRepository.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        return current_movie;
    }
    

    
    
    private Movie findById(int id) {
        
        PreparedStatement stat = null;
        Movie mv = null;
        try {
            stat = conn.prepareStatement("select * from movie where id = ?");
            stat.setString(1, String.valueOf(id));
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            mv = new Movie();
            mv.setId(rs.getInt("id"));
            mv.setTitle(rs.getString("title"));
            mv.setYear(rs.getString("year"));
            mv.setDirectorID(rs.getInt("directorID"));
            Logger.getLogger(MovieRepository.class.getName()).log(Level.INFO, "Accessed : " + mv);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        /* simple version 
        for (Map.Entry<Integer, Fligth> fligth : fligths.entrySet()) {
            if (fligth.getKey() == id) {
                return fligth.getValue();
            }
        }
        */
        return mv;   
    }
    
    private List<Movie> findAll() {
        List<Movie> movieList = new ArrayList<Movie>();
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement("select * from movie ");
        
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            Movie mv = new Movie();
            mv.setId(rs.getInt("id"));
            mv.setTitle(rs.getString("title"));
            mv.setYear(rs.getString("year"));
            mv.setDirectorID(rs.getInt("directorID"));
            Logger.getLogger(MovieRepository.class.getName()).log(Level.INFO, "Accessed : " + mv);
            movieList.add(mv);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movieList;   
    }
}
