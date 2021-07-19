/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreaaurizi.softwareengineering.soapgiu19server;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface = "com.andreaaurizi.softwareengineering.soapgiu19server.WSInterface")
public class WSInterfaceImpl  implements WSInterface{
    public List<Professor> professor;
	
    public WSInterfaceImpl() {
		professor = new ArrayList<>();
		
		professor.add(new ProfessorImpl("Mario", "Rossi"));
		professor.add(new ProfessorImpl("Giovanni", "Bianchi"));
		professor.add(new ProfessorImpl("Sara", "Gialli"));
		professor.add(new ProfessorImpl("Marco", "Girasole"));
		professor.add(new ProfessorImpl("Lyan", "Gin"));
		professor.add(new ProfessorImpl("Er MITICOOO", "CIIIICIANI"));
	}
    
    @Override
    public Professor getDetails(String id){
     
        return professor.get(Integer.parseInt(id)-1);
        
    }
}
