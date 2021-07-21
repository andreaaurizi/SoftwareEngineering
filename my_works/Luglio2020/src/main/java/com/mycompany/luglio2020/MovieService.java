package com.mycompany.luglio2020;

import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface MovieService {
    public Movie getMovieByTitle(String title);
    
    @XmlJavaTypeAdapter(MovieMapAdapter.class)
    public Map<Integer, Movie> getMovies();
}
