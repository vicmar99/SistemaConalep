/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaconalep;

import bd.DataBase;
import interfaces.PeriodoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Periodo;

/**
 *
 * @author Yair
 */
public class PeriodoDAOImpl extends DataBase implements PeriodoDAO{

    @Override
    public void registrar(Periodo periodo) throws Exception {
        String sql = "INSERT INTO periodo(idPeriodo) VALUES(?)";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, periodo.getIdPeriodo());
            st.executeUpdate();
            st.close();
        } catch (Exception e){
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificar(Periodo periodo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Periodo periodo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Periodo> listar() throws Exception {
        String sql = "SELECT * FROM periodo ORDER BY idPeriodo DESC";
        List<Periodo> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Periodo periodo = new Periodo();
                periodo.setIdPeriodo(rs.getString("idPeriodo"));
                lista.add(periodo);
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
