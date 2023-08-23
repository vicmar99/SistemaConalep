/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaconalep;

import bd.DataBase;
import interfaces.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Yair
 */
public class UsuarioDAOImpl extends DataBase implements UsuarioDAO{

    @Override
    public void registrar(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (nombre, apellidos, usuario, clave, departamento, rol) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getApellidos());
            st.setString(3, usuario.getUsuario());
            st.setString(4, usuario.getClave());
            st.setString(5, usuario.getDepartamento());
            st.setString(6, usuario.getRol());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificar(Usuario usuario) throws Exception {
         String sql = "UPDATE usuario SET nombre = ?, apellidos = ?, usuario = ?, clave = ?, departamento = ?, rol = ? WHERE idUsuario = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getApellidos());
            st.setString(3, usuario.getUsuario());
            st.setString(4, usuario.getClave());
            st.setString(5, usuario.getDepartamento());
            st.setString(6, usuario.getRol());
            st.setInt(7, usuario.getIdUsuario());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void eliminar(String IdUsuario) throws Exception {
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, IdUsuario);

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public Usuario traerUnUsuario(String idUsuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        Usuario usuario = new Usuario();
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idUsuario);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setDepartamento(rs.getString("departamento"));
                usuario.setRol(rs.getString("rol"));
                
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar(String departamento) throws Exception {
        String sql = "SELECT * FROM usuario WHERE departamento = ?";
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, departamento);
            
            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setDepartamento(rs.getString("departamento"));
                usuario.setRol(rs.getString("rol"));

                lista.add(usuario);
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
    public Usuario validarCredenciales(String idUsuario, String clave) throws Exception {
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND clave = ?";
        Usuario usuario = new Usuario();
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idUsuario);
            st.setString(2, clave);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setDepartamento(rs.getString("departamento"));
                usuario.setRol(rs.getString("rol"));
                
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
        return usuario;
    }
    
}
