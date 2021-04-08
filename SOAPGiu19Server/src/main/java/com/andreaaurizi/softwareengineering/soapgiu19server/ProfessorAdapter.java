/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.soapgiu19server;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author studente
 */
public class ProfessorAdapter extends XmlAdapter<ProfessorImpl,Professor>{
    public ProfessorImpl marshal(Professor prof) throws Exception {
        if (prof instanceof ProfessorImpl)
            return (ProfessorImpl) prof;
        return new ProfessorImpl(prof.getName(), prof.getSurname());
    }

    @Override
    public Professor unmarshal(ProfessorImpl v) throws Exception {
        return v;
    }
}
