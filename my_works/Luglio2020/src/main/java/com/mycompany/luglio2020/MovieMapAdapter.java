package com.mycompany.luglio2020;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class MovieMapAdapter extends XmlAdapter<MovieMap, Map<Integer,Movie>>{
    
    @Override
    public MovieMap marshal(Map<Integer, Movie> boundMap) throws Exception{
        MovieMap valueMap = new MovieMap();
        for (Map.Entry<Integer, Movie> boundEntry : boundMap.entrySet()){
            MovieMap.MovieEntry valueEntry = new MovieMap.MovieEntry();
            valueEntry.setMovie(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
            
        }
        return valueMap;
    }
    
    @Override
    public Map<Integer, Movie> unmarshal(MovieMap m) throws Exception{
        Map<Integer, Movie> boundMap = new LinkedHashMap<Integer, Movie>();
        for(MovieMap.MovieEntry movieEntry : m.getEntries()){
            boundMap.put(movieEntry.getId(),movieEntry.getMovie());
        }
        return boundMap;
    }
}
