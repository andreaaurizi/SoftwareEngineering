/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbsimplemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBManager {
    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:/home/studente/Desktop/andrea");
        Statement stat = conn.createStatement();

        
            stat.executeUpdate("drop table if exists fligth;");
            stat.executeUpdate("create table fligth (id, name);");
            PreparedStatement prep = conn.prepareStatement(
                    "insert into fligth values (?, ?);");
            prep.setString(1, "1");
            prep.setString(2, "AZ140");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "2");
            prep.setString(2, "LH999");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "3");
            prep.setString(2, "FR123");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "4");
            prep.setString(2, "US666");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            
            ResultSet rs = stat.executeQuery("select * from fligth;");
            while (rs.next()) {
                System.out.print("Fligth = " + rs.getString("id") + " is : ");
                System.out.println(rs.getString("name"));
            }
            rs.close();
        
        conn.close();
    }
}
