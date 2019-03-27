package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Acer on 5/27/2016.
 */
public class Database_connection {
    String url = "jdbc:mysql://localhost:3306/voting";
    String username = "root";
    String password = "";
    Connection connection = null;

    public Database_connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);//for database connection//
            System.out.println("database connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String query) {//
        try {
            return connection.prepareStatement(query);//
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;//
    }

}








