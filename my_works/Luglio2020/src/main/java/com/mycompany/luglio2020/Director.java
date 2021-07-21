package com.mycompany.luglio2020;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(DirectorAdapter.class)
public interface Director {
    public String getName();
    public String getYearOfBirth();
}
