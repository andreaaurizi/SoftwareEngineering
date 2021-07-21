package com.mycompany.luglio2020;

import javax.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class DirectorImpl implements Director{
    private int id;
    private String name;
    private String yearOfBirth;
    
    public DirectorImpl(String name, String yearOfBirth){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }
}
