/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapserver;

import java.util.*;
import javax.jws.WebService;

@WebService(endpointInterface = "com.mycompany.soapserver.WSInterface")
public class WSImpl implements WSInterface {
    
    private Map<Integer, Student> students = new LinkedHashMap<Integer, Student>();
    
    public WSImpl(){}
    
    public String hello(String name){
        return "Hello " + name;
    }
    
    public String helloStudent(Student student){
        students.put(students.size()+1, student);
        return "Hello "+ student.getName();
    }

    
    public Map<Integer, Student> getStudents(){
        return students;
    }
}
