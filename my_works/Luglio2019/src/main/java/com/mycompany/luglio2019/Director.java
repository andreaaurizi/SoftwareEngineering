/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2019;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@XmlRootElement(name = "Director")
public class Director {
    private int id;
    private String name;
    private String yearOfBorth;
}
