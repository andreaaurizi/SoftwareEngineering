/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBMSManager {
    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:/home/studente/Desktop/Luglio2020");
        Statement stat = conn.createStatement();

        
            stat.executeUpdate("DROP TABLE IF EXISTS DIRECTOR;");
            stat.executeUpdate("DROP TABLE IF EXISTS MOVIE;");
            stat.executeUpdate("CREATE TABLE DIRECTOR (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name STRING,"
                    + "yearOfBirth STRING);");
            stat.executeUpdate("CREATE TABLE MOVIE (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "directorID INTEGER,"
                    + "title STRING,"
                    + "year STRING,"
                    + "FOREIGN KEY(directorID) REFERENCES DIRECTOR(ID));");
            
            
            stat.executeUpdate("INSERT INTO DIRECTOR VALUES(0, 'Quentin Tarantino', '1963');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(0, 'Reservoir Dogs', '1992');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(0, 'Pulp Fiction', '1994');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(0, 'Kill Bill: Volume 1', '2003');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(0, 'Kill Bill: Volume 2', '2004');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(0, 'Inglourious Basterds', '2009');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(0, 'Django Unchained', '2012');");
            
            stat.executeUpdate("INSERT INTO DIRECTOR VALUES(1, 'Chris Culumbus', '1965');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(1, 'Harry Potter : La pietra filosofale', '2001');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(1, 'Harry Potter : La camera dei segreti', '2002');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(1, 'Harry Potter : Il prigioniero di Azkaban', '2004');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(1, 'Harry Potter : Il calice di fuoco', '2005');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(1, 'Harry Potter : Lo ordine della fenice', '2007');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(1, 'Harry Potter : Il principe mezzo sangue', '2009');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(1, 'Harry Potter : I doni della morte', '2011');");
            
            
            stat.executeUpdate("INSERT INTO DIRECTOR VALUES(2, 'Morten Tyldum', '1967');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(2, 'Utopia: Nobody is perfect in perfect country', '2002');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(2, 'The imitation game', '2014');");
            stat.executeUpdate("INSERT INTO MOVIE (directorID, title, year) VALUES(2, 'Passengers', '2016');");
            
            
            ResultSet rs1 = stat.executeQuery("SELECT * FROM DIRECTOR;");
            while (rs1.next()) {
                System.out.print("Director = " + rs1.getInt("id") + " is : ");
                System.out.println(rs1.getString("name") + " burnt in : " +rs1.getString("yearOfBirth"));
            }
            rs1.close();
            
            ResultSet rs2 = stat.executeQuery("SELECT * FROM MOVIE;");
            while (rs2.next()) {
                System.out.print("Movie = " + rs2.getInt("id") + " is : ");
                System.out.println(rs2.getString("title") + " produced in " +rs2.getString("year") + " by director : " + rs2.getInt("directorID"));
            }
            rs2.close();
        
        conn.close();
    }
}
