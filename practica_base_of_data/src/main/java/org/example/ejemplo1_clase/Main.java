package org.example.ejemplo1_clase;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url= "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Renative1448//";
        try(Connection conn = DriverManager.getConnection(url,user,password);
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM productos");

        ) {
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id"));
                System.out.print("|");
                System.out.print(resultSet.getString("nombre"));
                System.out.print("|");
                System.out.print(resultSet.getDouble("precio"));
                System.out.print("|");
                System.out.print(resultSet.getDate("fecha_registro"));
                System.out.println("\n");
            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }
}