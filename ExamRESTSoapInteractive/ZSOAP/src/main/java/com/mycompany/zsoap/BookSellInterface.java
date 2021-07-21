/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zsoap;

import javax.jws.WebService;


@WebService
public interface BookSellInterface {
    
    public Information getInformations(int id);
    
}
