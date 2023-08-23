/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yair
 */
public class DataBase {
    
    //Paramaetros para realizar la conexion con la bd
    protected Connection conexion;
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=sistema";
    private final String USER = "sa";
    private final String PASSWORD = "123";
    
    /**
     * Método para realizar la conexión con la base de datos
     */
    public void conectar() {
        try {
            conexion = DriverManager.getConnection(URL,  USER, PASSWORD);
            Class.forName(DRIVER);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para cerrar la conexión con la base de datos
     * @throws SQLException 
     */
    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
   
}
