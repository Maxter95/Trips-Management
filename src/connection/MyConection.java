/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maxter
 */



public class MyConection {
    
    public String url="jdbc:mysql://localhost:3306/agence";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static MyConection instance;
    
    private MyConection(){
        try {
            cnx=DriverManager.getConnection(url,login,pwd);
            System.out.println("gg ez fff 15 !!!!");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    }
    public static MyConection getInstance(){
        if(instance==null)
        {
            instance=new MyConection();
        }
        return instance;
}
    
    public Connection getConection(){
      return cnx;  
    }
}

