package com.bridgelabz.addressbookmain.util;
import com.bridgelabz.addressbookmain.dbconnection.DbConnection;
import com.bridgelabz.addressbookmain.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.bridgelabz.addressbookmain.dbconnection.DbConnection.makeConnection;
public class DbOperations {
    public DbOperations() {
        makeConnection();
    }

    public void addRecord(Person person) {
        PreparedStatement statement = null;
        try {
            statement = DbConnection.myConn.prepareStatement("INSERT INTO person_detail VALUES(?,?,?,?,?,?,?)");
            statement.setString(1, person.firstName);
            statement.setString(2, person.lastName);
            statement.setString(3, person.address);
            statement.setString(4, person.city);
            statement.setString(5, person.state);
            statement.setString(6, person.zip);
            statement.setString(7, person.phone);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                DbConnection.myConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayRecords() {
        Statement statement = null;
        try {
            ResultSet resultSet;
            statement = DbConnection.myConn.createStatement();
            resultSet = statement.executeQuery("select * from person_detail");
            while (resultSet.next()) {
                System.out.println("\nFirstName = " + resultSet.getString(1) + "\nLastName = " + resultSet.getString(2) + "\nAddress = " + resultSet.getString(3) + "\nCity = " + resultSet.getString(4) + "\n State = " + resultSet.getString(5) + "\n Zip = " + resultSet.getString(6) + "\nPhoneNumber = " + resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                DbConnection.myConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateRecord(int colName, String firstName, String updatedValue) {
        Statement statement = null;
        String queryStr = null;
        try {
            switch (colName) {
                case 1:
                    queryStr =
                            "UPDATE person_detail SET lastName = '" + updatedValue + "' WHERE firstname = '" + firstName + "'";
                    break;
                case 2:
                    queryStr =
                            "UPDATE person_detail SET address = '" + updatedValue + "' WHERE firstname = '" + firstName + "'";
                    break;
                case 3:
                    queryStr =
                            "UPDATE person_detail SET city = '" + updatedValue + "' WHERE firstname = '" + firstName + "'";
                    break;
                case 4:
                    queryStr =
                            "UPDATE person_detail SET state = '" + updatedValue + "' WHERE firstname = '" + firstName + "'";
                    break;
                case 5:
                    queryStr =
                            "UPDATE person_detail SET zip = '" + updatedValue + "' WHERE firstname = '" + firstName + "'";
                    break;
                case 6:
                    queryStr =
                            "UPDATE person_detail SET phone = '" + updatedValue + "' WHERE firstname = '" + firstName + "'";
                    break;
                default:
                    System.out.println("wrong choice");
            }
            statement = DbConnection.myConn.createStatement();
            statement.executeUpdate(queryStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                DbConnection.myConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteRecord(String name) {
        Statement statement = null;
        try {
            statement = DbConnection.myConn.createStatement();
            String queryStr = "DELETE FROM person_detail  WHERE firstname ='" + name + "'";
            statement.executeUpdate(queryStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                DbConnection.myConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
