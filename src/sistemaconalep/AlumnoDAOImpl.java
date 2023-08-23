/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaconalep;

import bd.DataBase;
import interfaces.AlumnoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Alumno;

/**
 *
 * @author Yair
 */
public class AlumnoDAOImpl extends DataBase implements AlumnoDAO {

    @Override
    public void registrar(Alumno alumno) throws Exception {
        String sql = "INSERT INTO alumno(matricula, nombre, aPaterno, aMaterno, semestre, grupo) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumno.getMatricula());
            st.setString(2, alumno.getNombre());
            st.setString(3, alumno.getaPaterno());
            st.setString(4, alumno.getaMaterno());
            st.setInt(5, alumno.getSemestre());
            st.setString(6, alumno.getGrupo());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificar(Alumno alumno) throws Exception {
        String sql = "UPDATE alumno SET matricula = ?, nombre = ?, aPaterno = ?, aMaterno = ?, semestre = ?, grupo = ? WHERE matricula = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumno.getMatricula());
            st.setString(2, alumno.getNombre());
            st.setString(3, alumno.getaPaterno());
            st.setString(4, alumno.getaMaterno());
            st.setInt(5, alumno.getSemestre());
            st.setString(6, alumno.getGrupo());
            st.setString(7, alumno.getMatricula());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void eliminar(String matricula) throws Exception {
        String sql = "DELETE FROM alumno WHERE matricula = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, matricula);

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public List<Alumno> listar() throws Exception {
        String sql = "SELECT * FROM alumno";
        List<Alumno> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setaPaterno(rs.getString("aPaterno"));
                alumno.setaMaterno(rs.getString("aMaterno"));
                alumno.setSemestre(rs.getInt("semestre"));
                alumno.setGrupo(rs.getString("grupo"));

                lista.add(alumno);
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
    public Alumno traerUnAlumno(String matricula) throws Exception {
        String sql = "SELECT * FROM alumno WHERE matricula = ?";
        Alumno alumno = new Alumno();
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, matricula);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setaPaterno(rs.getString("aPaterno"));
                alumno.setaMaterno(rs.getString("aMaterno"));
                alumno.setSemestre(rs.getInt("semestre"));
                alumno.setGrupo(rs.getString("grupo"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
        return alumno;
    }

    @Override
    public void registrarLista(List<Alumno> listaAlumnos) throws Exception {
        String selectQuery = "SELECT COUNT(*) FROM alumno WHERE matricula = ?";
        String insertQuery = "INSERT INTO alumno(matricula, nombre, aPaterno, aMaterno, semestre, grupo) VALUES(?,?,?,?,?,?)";;
        String updateQuery = "UPDATE alumno SET matricula = ?, nombre = ?, aPaterno = ?, aMaterno = ?, semestre = ?, grupo = ? WHERE matricula = ?";
        try {
            for (Alumno alumno : listaAlumnos) {
                this.conectar();
                PreparedStatement st = this.conexion.prepareStatement(selectQuery);
                st.setString(1, alumno.getMatricula());
                ResultSet rs = st.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    PreparedStatement ust = this.conexion.prepareStatement(updateQuery);
                    ust.setString(1, alumno.getMatricula());
                    ust.setString(2, alumno.getNombre());
                    ust.setString(3, alumno.getaPaterno());
                    ust.setString(4, alumno.getaMaterno());
                    ust.setInt(5, alumno.getSemestre());
                    ust.setString(6, alumno.getGrupo());
                    ust.setString(7, alumno.getMatricula());

                    ust.executeUpdate();
                } else {
                    PreparedStatement ist = this.conexion.prepareStatement(insertQuery);
                    ist.setString(1, alumno.getMatricula());
                    ist.setString(2, alumno.getNombre());
                    ist.setString(3, alumno.getaPaterno());
                    ist.setString(4, alumno.getaMaterno());
                    ist.setInt(5, alumno.getSemestre());
                    ist.setString(6, alumno.getGrupo());

                    ist.executeUpdate();
                    ist.close();
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public List<Alumno> listar2(String semestre, String grupo) throws Exception {
        String sql = "SELECT * FROM alumno WHERE semestre = ? AND grupo = ?";
        List<Alumno> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, semestre);
            st.setString(2, grupo);
            
            lista = new ArrayList();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setaPaterno(rs.getString("aPaterno"));
                alumno.setaMaterno(rs.getString("aMaterno"));
                alumno.setSemestre(rs.getInt("semestre"));
                alumno.setGrupo(rs.getString("grupo"));

                lista.add(alumno);
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
