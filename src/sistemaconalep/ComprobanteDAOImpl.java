/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaconalep;

import bd.DataBase;
import interfaces.ComprobanteDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Comprobante;

/**
 *
 * @author Yair
 */
public class ComprobanteDAOImpl extends DataBase implements ComprobanteDAO{

    @Override
    public void registrar(Comprobante comprobante) throws Exception {
        String sql = "INSERT INTO comprobante(matriculaAlumno, idPeriodo, usuarioRecibe, departamentoRecibe,"
                + " fechaRecibido, conceptos, comprobante) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, comprobante.getMatriculaAlumno());
            st.setString(2, comprobante.getIdPeriodo());
            st.setString(3, comprobante.getUsuarioRecibe());
            st.setString(4, comprobante.getDepartamentoRecibe());
            st.setString(5, comprobante.getFechaRecibido());
            st.setString(6, comprobante.getConceptos());
            st.setBytes(7, comprobante.getComprobante());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificar(Comprobante comprobante) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Comprobante comprobante) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Comprobante> listar(String matricula) throws Exception {
        String sql = "SELECT * FROM comprobante WHERE matriculaAlumno = ?";
        List<Comprobante> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, matricula);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Comprobante comprobante = new Comprobante();
                comprobante.setIdComprobante(rs.getInt("idComprobante"));
                comprobante.setMatriculaAlumno(rs.getString("matriculaAlumno"));
                comprobante.setIdPeriodo(rs.getString("idPeriodo"));
                comprobante.setUsuarioRecibe(rs.getString("usuarioRecibe"));
                comprobante.setDepartamentoRecibe(rs.getString("departamentoRecibe"));
                comprobante.setFechaRecibido(rs.getString("fechaRecibido"));
                comprobante.setConceptos(rs.getString("conceptos"));
                comprobante.setComprobante(rs.getBytes("comprobante"));

                lista.add(comprobante);
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

    @Override
    public void visualizarPdf(int idComprobante) {
        String sql = "SELECT * FROM comprobante WHERE idComprobante = ?";
        byte[] b = null;

        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, idComprobante);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                b = rs.getBytes("comprobante");
                
                // Crear un archivo temporal para almacenar los datos binarios del PDF
                File tempFile = File.createTempFile("comprobante", ".pdf");
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(b);
                fos.close();

                // Abrir el archivo PDF en el visor predeterminado del sistema
                Desktop.getDesktop().open(tempFile);
            }

            st.close();
            rs.close();
            this.cerrarConexion();
        } catch (IOException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF: " + ex.getMessage());
        }
    }
}
