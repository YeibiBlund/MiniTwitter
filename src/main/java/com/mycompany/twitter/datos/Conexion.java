/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twitter.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author brune
 */
public class Conexion {

    // URL de mi conexión
    private static final String JBDC_URL = "jdbc:mysql://localhost:3306/bdTwitter?useSSL=false&"
            + "useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    // Usuario de mi base de datos
    private static final String JDBC_USER = "root";

    // Contraseña de mi base de datos
    private static final String JDBC_PASS = "1234";

    // Método que me permite establecer mi conexión contra mi base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JBDC_URL, JDBC_USER, JDBC_PASS);
    }

    // Método que me permite cerrar el ResultSet
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    // Método que me permite cerrar el Statement
    public static void close(Statement st) throws SQLException {
        st.close();
    }

    // Método que me permite cerrar una Conexión
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
