/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrudmvcweb.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yulil
 */
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/db_empresa";
    private static final String USER = "root";
    private static final String PASS = "Yulissa_17";
    
    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    }

    
}