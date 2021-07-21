/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2020;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class MovieAdapter extends XmlAdapter<MovieImpl, Movie>{
    
    @Override
    public MovieImpl marshal(Movie movie) throws Exception{
        if( movie instanceof MovieImpl)
            return (MovieImpl) movie;
        return new MovieImpl(movie.getTitle(), movie.getYear(), movie.getDirector());
    }
    
    @Override
    public Movie unmarshal(MovieImpl m) throws Exception{
        return m;
    }
}
