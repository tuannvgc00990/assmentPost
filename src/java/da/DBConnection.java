/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tuan5
 */
public class DBConnection {
    private static Connection connection;
    public Connection getConnection() throws ClassNotFoundException,SQLException{
    if(connection==null){
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    connection=DriverManager.getConnection("jdbc:derby://localhost:1527/post", "sa", "sa");
    }
        return connection;
    }
}
