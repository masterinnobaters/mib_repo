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
        connectionProps.put("user", "a4201940_admin");
        connectionProps.put("password", "2rAKebra");
        
        Connection con = DriverManager.getConnection(
                   "jdbc:mysql://" +
                   "mysql7.000webhost.com" +
                   ":3306/",
                   connectionProps);
        
        System.out.println("success!");
    }
}
