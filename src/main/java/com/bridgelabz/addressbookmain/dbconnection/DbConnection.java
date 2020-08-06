package com.bridgelabz.addressbookmain.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
    public static Connection myConn = null;

    public static void makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook", "admin", "password");
        } catch (SQLException | ClassNotFoundException e) {
            try {
                myConn.close();
            } catch (SQLException r) {
                r.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}

