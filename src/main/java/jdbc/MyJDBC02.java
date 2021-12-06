package main.java.jdbc;

import java.sql.*;

public class MyJDBC02 {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "");

            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO estudiante (dni, nombre, apellido) VALUES (?, ?, ?);");

            preparedStatement.setString(1, "39788132");
            preparedStatement.setString(2, "Martín");
            preparedStatement.setString(3, "Murciano");

            preparedStatement.executeUpdate();

            connection.commit();

            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM estudiante");


            while(resultSet.next()){
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("dni") +
                        " " + resultSet.getString("nombre") + " " + resultSet.getString("apellido")) ;
            }

        } catch (SQLException sqlException){

            System.out.println(sqlException);

            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException sqlException1){
                    System.out.println(sqlException1);
                }
            }
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
