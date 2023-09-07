/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import vistas.DatosServidor;

/**
 *
 * @author Yair
 */
public class ConfiguracionConexion {

    private static final String PROPERTIES_FILE = "configuracion.properties";

    public static void guardarConfiguracion(String ip, String puerto, String nombreBD, String user, String password) {
        Properties properties = new Properties();
        properties.setProperty("ip", ip);
        properties.setProperty("puerto", puerto);
        properties.setProperty("nombreBD", nombreBD);
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        try (FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties cargarConfiguracion() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            // Si ocurre una excepción al cargar la configuración, muestra el formulario
            JOptionPane.showMessageDialog(null, "Porporciona la información solicitada");
            DatosServidor datosServidor = new DatosServidor();
            datosServidor.setVisible(true);
        }

        return properties;
    }
}
