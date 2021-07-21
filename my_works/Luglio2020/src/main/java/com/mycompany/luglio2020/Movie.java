package com.mycompany.luglio2020;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(MovieAdapter.class)
public interface Movie {
    public String getTitle();
    public String getYear();
    public Director getDirector();
}
