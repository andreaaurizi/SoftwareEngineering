package com.mycompany.luglio2020client;

import com.mycompany.luglio2020.*;
import java.util.List;

public class Client {
    public static void main(String[] args){
        MovieService port = new MovieServiceImplService().getMovieServiceImplPort();
        List<MovieEntry> movies = port.getMovies().getEntry();
        
        for(MovieEntry entry : movies){
            MovieImpl movie = entry.getMovie();
        
            System.out.println(movie.getTitle() + " produced in " + movie.getYear() + " by " +
                     movie.getDirector().getName() + " burned in " + movie.getDirector().getYearOfBirth());
        }
        
        MovieImpl movie = port.getMovieByTitle("The imitation game");
        System.out.println("");
        System.out.println("");
        System.out.println(movie.getTitle() + " (the story of a genius) produced in "
                + movie.getYear() + " by " + movie.getDirector().getName() + 
                " burnt in " + movie.getDirector().getYearOfBirth());
    }
}
