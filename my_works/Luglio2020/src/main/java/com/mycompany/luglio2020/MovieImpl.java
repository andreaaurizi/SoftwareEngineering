package com.mycompany.luglio2020;

import javax.xml.bind.annotation.XmlType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MovieImpl implements Movie{
    private int id;
    private String title;
    private String year;
    private Director director;
    
    public MovieImpl(String title, String year, Director director){
        this.title = title;
        this.year = year;
        this.director = director;
    }
}
