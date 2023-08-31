/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.DataBase;
import interfaces.SemestreDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Semestre;

/**
 *
 * @author Yair
 */
public class SemestreDAOImpl extends DataBase implements SemestreDAO {

    @Override
    public void registrar(Semestre semestre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Semestre semestre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Semestre semestre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Semestre> listar() throws Exception {
        String sql = "SELECT * FROM semestre";
        List<Semestre> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Semestre semestre = new Semestre();
                semestre.setIdSemestre(rs.getInt("idSemestre"));
                lista.add(semestre);
                
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
        return lista;
    }
    
}
