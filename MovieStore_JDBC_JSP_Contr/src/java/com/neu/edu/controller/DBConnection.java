/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Divyansh
 */
public class DBConnection {
    public static Connection getConnectionJDBC() throws IOException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("mysql JDBC Driver missing");
        }
        try {
            String url = "jdbc:mysql://localhost:3306/moviedb";
            connection = DriverManager.getConnection(url, "root", "extraordinary");

        } catch (SQLException e) {
            System.out.println("Connection not done!");
        }
        if (connection != null) {
            System.out.println("Connection established");
        }

        return connection;
    }
}
