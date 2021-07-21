package com.mycompany.luglio2020;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="MovieMap")
public class MovieMap {
    private List<MovieEntry> entryList = new ArrayList<MovieEntry>();
    
    
    
    @XmlElement(nillable = false, name="entry") 
    public List<MovieEntry> getEntries(){
        return entryList;
    }

    
    @XmlType(name = "MovieEntry")
    public static class MovieEntry {
        
        private Integer id;
        private Movie movie;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Movie getMovie() {
            return movie;
        }

        public void setMovie(Movie movie) {
            this.movie = movie;
        }
        
        
    }
    
    
}
