/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.soapclient3;
import java.util.List;
import java.util.Map;
import com.andreaaurizi.softwareengineering.soapserver.*;
/**
 *
 * @author studente
 */
public class SOAPClient3 {
    public static void main(String[] args) {
        
        Student s1 = new Student();
        s1.setName("Massimo");
        SOAPClient3.helloStudent(s1);
        
        Student s2 = new Student();
        s2.setName("Monica");
        SOAPClient3.helloStudent(s2);
        
        List<StudentEntry> result = SOAPClient3.getStudents().getEntry();
        for (int i = 0 ; i<result.size(); i++){
            System.out.println(((StudentEntry)result.get(i)).getStudent().getName());
    }
        
    }

    private static StudentMap getStudents() {
        com.andreaaurizi.softwareengineering.soapserver.WSImplService service = new com.andreaaurizi.softwareengineering.soapserver.WSImplService();
        com.andreaaurizi.softwareengineering.soapserver.WSInterface port = service.getWSImplPort();
        return port.getStudents();
    }

    private static String helloStudent(com.andreaaurizi.softwareengineering.soapserver.Student arg0) {
        com.andreaaurizi.softwareengineering.soapserver.WSImplService service = new com.andreaaurizi.softwareengineering.soapserver.WSImplService();
        com.andreaaurizi.softwareengineering.soapserver.WSInterface port = service.getWSImplPort();
        return port.helloStudent(arg0);
    }
    
}
