package Database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bassant Haider
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
    private final String user = "root";
    private final String password="";
    private final String add="jdbc:mysql://localhost/inventory";
    
    public Connection connect()throws SQLException
     {
          return DriverManager.getConnection(add , user , password);
     }
}

