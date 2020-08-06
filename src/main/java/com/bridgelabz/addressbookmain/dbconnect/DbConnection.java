package com.bridgelabz.addressbookmain.dbconnect;
import java.sql.*;
public class DbConnection {
    public static void main(String[] args) {
        {
            try {
                String query = "select * from person_detail";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook", "admin",
                        "password");
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("firstname"));
                    System.out.println(resultSet.getString("lastname"));
                    System.out.println(resultSet.getString("address"));
                    System.out.println(resultSet.getString("city"));
                    System.out.println(resultSet.getString("state"));
                    System.out.println(resultSet.getString("zip"));
                    System.out.println(resultSet.getString("phonenumber"));
                }
                statement.close();
                myConn.close();
                //TODO Custom exception
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
