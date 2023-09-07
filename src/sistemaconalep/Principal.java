/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaconalep;

import bd.DataBase;
import java.sql.SQLException;

/**
 *
 * @author Yair
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        DataBase dataBase = new DataBase();

        // Paso 1: Cargar la configuración
        dataBase.cargarConfiguracion();

        // Paso 2: Conectar a la base de datos
        if (dataBase.isConfiguracionCompleta()) {
            dataBase.conectar();

            // Paso 3: Mostrar la ventana de inicio de sesión solo si la configuración es válida
            if (dataBase.isConfiguracionCompleta() && dataBase.getConexion() != null && !dataBase.getConexion().isClosed()) {
                Login login = new Login();
                login.setVisible(true);
            }
        }
    }
}
