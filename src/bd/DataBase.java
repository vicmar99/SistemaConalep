/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import config.ConfiguracionConexion;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import vistas.DatosServidor;

/**
 *
 * @author Yair
 */
public class DataBase {

    private boolean configuracionCargada = false; // Agregar esta bandera

    // Parámetros para realizar la conexión con la bd
    protected Connection conexion;
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String ip;
    private String port;
    private String databaseName;
    private String user;
    private String password;

    public DataBase() {
        cargarConfiguracion();
    }

    public void cargarConfiguracion() {

        // Verificar si la configuración ya se ha cargado
        if (configuracionCargada) {
            return;
        }

        Properties propiedades = ConfiguracionConexion.cargarConfiguracion();

        // Verificar si alguno de los valores de configuración es null
        if (propiedades != null) {
            ip = propiedades.getProperty("ip");
            port = propiedades.getProperty("puerto");
            databaseName = propiedades.getProperty("nombreBD");
            user = propiedades.getProperty("user");
            password = propiedades.getProperty("password");

            // Marcar la configuración como cargada
            configuracionCargada = true;
        } else {
            // Si no se encuentra la configuración, muestra el formulario al usuario
            DatosServidor datosServidorForm = new DatosServidor();
            datosServidorForm.setVisible(true);
        }
    }

    /**
     * Método para realizar la conexión con la base de datos
     */
    public void conectar() {
        try {
            // Verifica si ya se han configurado los valores
            if (ip == null || port == null || databaseName == null || user == null || password == null) {
                // Si faltan valores, muestra el formulario
                DatosServidor datosServidorForm = new DatosServidor();
                datosServidorForm.setVisible(true);
            } else {
                // Construye la URL de conexión después de que los valores se han establecido
                String URL = "jdbc:sqlserver://" + ip + ":" + port + ";databaseName=" + databaseName;
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URL, user, password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Error de conexión, mostrar mensaje y abrir el formulario de configuración
            JOptionPane.showMessageDialog(null, "Error de conexión");
            DatosServidor datosServidorForm = new DatosServidor();
            datosServidorForm.setVisible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Método para cerrar la conexión con la base de datos
     *
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }

    public boolean isConfiguracionCompleta() {
        return ip != null && port != null && databaseName != null && user != null && password != null;
    }

    public Connection getConexion() {
        return conexion;
    }

}
