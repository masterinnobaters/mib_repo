/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Johne
 */
public class ConnectionSingleton {
    
    public static void main(String args[])throws Exception{
        
        Properties connectionProps = new Properties();
        connectionProps.put("user", "b5_18514851");
        connectionProps.put("password", "fepRebU3");
        
        Connection con = DriverManager.getConnection(
                   "jdbc:mysql://" +
                   "sql208.byethost5.com" +
                   ":3306/b5_18514851_theaddress",
                   connectionProps);
        
        // jdbc:mysql://localhost:3306/karthicraj
        
        System.out.println("success!");
    }
}
