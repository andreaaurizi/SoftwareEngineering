/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.soapgiu19server;

/**
 *
 * @author studente
 */
public class ProfessorImpl implements Professor {
    private String firstName;
    private String lastName;
    
public ProfessorImpl() {}
public ProfessorImpl(String name, String surname){
    this.firstName = name;
    this.lastName = surname;
}

@Override
public String getName() {
    return this.firstName;
}

@Override
public String getSurname() {
    return this.lastName;
}

    
    
    public void setName(String name) {
        this.firstName = name;
    }

    
    public void setSurname(String surname) {
        this.lastName = surname;
    }
    
}
