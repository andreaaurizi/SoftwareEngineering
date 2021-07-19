/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2019;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Fligth")
public class Movie {
    private Integer id;
    private String title;
    private String year;
    private Integer directorID;
    private Director director;
}
