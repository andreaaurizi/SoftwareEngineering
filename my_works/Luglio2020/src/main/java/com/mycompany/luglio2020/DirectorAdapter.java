package com.mycompany.luglio2020;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DirectorAdapter extends XmlAdapter<DirectorImpl, Director>{
    
    @Override
    public DirectorImpl marshal(Director director) throws Exception{
        if (director instanceof DirectorImpl)
            return (DirectorImpl) director;
        return new DirectorImpl(director.getName(), director.getYearOfBirth());
    }
    
    @Override
    public Director unmarshal(DirectorImpl d) throws Exception{
        return d;
    }
}