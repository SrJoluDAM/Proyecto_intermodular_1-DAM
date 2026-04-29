package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/gestor_biblioteca";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection conn;

    public static Connection getConexion() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (SQLException e) {
            System.out.println("Error conexión: " + e.getMessage());
        }
        return conn;
    }
}