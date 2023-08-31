/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.DataBase;
import interfaces.GrupoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Grupo;

/**
 *
 * @author Yair
 */
public class GrupoDAOImpl extends DataBase implements GrupoDAO{

    @Override
    public void registrar(Grupo grupo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Grupo grupo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Grupo grupo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Grupo> listar() throws Exception {
        String sql = "SELECT * FROM grupo";
        List<Grupo> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setIdGrupo(rs.getString("idGrupo"));
                lista.add(grupo);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            this.cerrarConexion();
        }
        return lista;
    }

    }
   
