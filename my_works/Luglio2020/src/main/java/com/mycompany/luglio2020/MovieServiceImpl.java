package com.mycompany.luglio2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "com.mycompany.luglio2020.MovieService")
public class MovieServiceImpl implements MovieService{
    private Connection conn;
    private Statement stat;
    
    //private Map<Integer, Movie> movies = new LinkedHashMap<Integer, Movie>();
    public MovieServiceImpl(){
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection("jdbc:sqlite:/home/studente/Desktop/Luglio2020");
            stat = conn.createStatement();
            //stat.setQueryTimeout(30);
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Movie getMovieByTitle(String title) {
        return findMovieByTitle(title);
    }


    public Map<Integer, Movie> getMovies() {
        return findAllMovies();
    }
    
    private Map<Integer, Movie> findAllMovies() {
        Map<Integer, Movie> movieList = new HashMap<>();
        PreparedStatement stat = null;
        int directorId =-1;
        try {
            stat = conn.prepareStatement("select * from movie");
        
        ResultSet rs = stat.executeQuery();
        int i = 0;
        while (rs.next()) {
            MovieImpl movie = new MovieImpl();
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setYear(rs.getString("year"));
            movie.setDirector(findDirectorById(rs.getInt("directorID")));
            movieList.put(i,movie);
            i++;
            Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.INFO, "Accessed : " + movie);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movieList;
    }
    
    private Movie findMovieByTitle(String title){
        PreparedStatement stat = null;
        MovieImpl movie = null;
        int directorId = -1;
        
        try {
            stat = conn.prepareStatement("select * from movie where title = ?");
            stat.setString(1, title);
        
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                movie = new MovieImpl();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                directorId = rs.getInt("directorID");
                Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.INFO, "Accessed : " + movie);
            }
            
            movie.setDirector(findDirectorById(directorId));

            rs.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return movie;
    }

    private Director findDirectorById(int directorId) {
        PreparedStatement stat = null;
        DirectorImpl director = null;
        try {
            stat = conn.prepareStatement("select * from director where id = ?");
            stat.setString(1, String.valueOf(directorId));
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
                director = new DirectorImpl();
                director.setId(rs.getInt("id"));
                director.setName(rs.getString("name"));
                director.setYearOfBirth(rs.getString("yearOfBirth"));
                Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.INFO, "Accessed : " + director);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return director;
    }

    
}
