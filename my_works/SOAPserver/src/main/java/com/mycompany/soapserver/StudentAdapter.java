/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapserver;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class StudentAdapter extends XmlAdapter<StudentImpl, Student>{
    
    public StudentAdapter(){}
    
    public StudentImpl marshal(Student student) throws Exception {
        if (student instanceof StudentImpl)
            return (StudentImpl) student;
        return new StudentImpl(student.getName());
    }
    
    @Override
    public Student unmarshal(StudentImpl v) throws Exception{
        return v;
    }
}
