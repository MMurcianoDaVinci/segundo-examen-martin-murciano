package main.java.jdbc;

import java.sql.*;

public class MyJDBC01 {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM estudiante");

            while(resultSet.next()){
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("dni") +
                        " " + resultSet.getString("nombre") + " " + resultSet.getString("apellido")) ;
            }

        } catch (SQLException sqlException){
            System.out.println(sqlException);
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException sqlException2){
                System.out.println(sqlException2);
            }
        }
    }
}
