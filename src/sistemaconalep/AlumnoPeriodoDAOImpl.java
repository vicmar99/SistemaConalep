/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaconalep;

import bd.DataBase;
import interfaces.AlumnoPeriodoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import model.AlumnoPeriodo;

/**
 *
 * @author Yair
 */
public class AlumnoPeriodoDAOImpl extends DataBase implements AlumnoPeriodoDAO{

    @Override
    public void registrar(AlumnoPeriodo alumnoPeriodo) throws Exception {
        String sql = "INSERT INTO alumnoPeriodo(idPeriodo, matriculaAlumno, semestre, grupo) VALUES(?,?,?,?)";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumnoPeriodo.getIdPeriodo());
            st.setString(2, alumnoPeriodo.getMatricula());
            st.setInt(3, alumnoPeriodo.getSemestre());
            st.setString(4, alumnoPeriodo.getGrupo());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificar(AlumnoPeriodo alumnoPeriodo) throws Exception {
        String sql = "UPDATE alumnoPeriodo SET estatus_entrega1 = ? WHERE idPeriodo = ? AND matriculaAlumno = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumnoPeriodo.getEstatusEntrega1());
            st.setString(2, alumnoPeriodo.getIdPeriodo());
            st.setString(3, alumnoPeriodo.getMatricula());
            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void eliminar(AlumnoPeriodo reportePago) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AlumnoPeriodo> listar(String periodoEscolar) throws Exception {
        String sql = "SELECT * FROM VistaAlumnoPeriodo WHERE idPeriodo = ?";
        List<AlumnoPeriodo> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, periodoEscolar);
            
            lista = new ArrayList();
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                AlumnoPeriodo alumnoPeriodo = new AlumnoPeriodo();
                alumnoPeriodo.setIdPeriodo(rs.getString("idPeriodo"));
                alumnoPeriodo.setMatricula(rs.getString("matriculaAlumno"));
                alumnoPeriodo.setNombre(rs.getString("nombre"));
                alumnoPeriodo.setaPaterno(rs.getString("aPaterno"));
                alumnoPeriodo.setaMaterno(rs.getString("aMaterno"));
                alumnoPeriodo.setSemestre(rs.getInt("semestre"));
                alumnoPeriodo.setGrupo(rs.getString("grupo"));
                alumnoPeriodo.setEstatusEntrega1(rs.getString("estatus_entrega1"));
                alumnoPeriodo.setEstatusEntrega2(rs.getString("estatus_entrega2"));
                alumnoPeriodo.setEstatusEntrega3(rs.getString("estatus_entrega3"));

                lista.add(alumnoPeriodo);
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
    public AlumnoPeriodo traerUnAlumno(String periodo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrarLista(List<Alumno> listaAlumnoPeriodos, String periodo) throws Exception {
        String selectQuery = "SELECT COUNT(*) FROM alumnoPeriodo WHERE idPeriodo = ? AND matriculaAlumno = ? ";
        String insertQuery = "INSERT INTO alumnoPeriodo(idPeriodo, matriculaAlumno, semestre, grupo) VALUES(?,?,?,?)";
        String updateQuery = "UPDATE alumnoPeriodo SET idPeriodo = ?, matriculaAlumno = ?, semestre = ?, grupo = ? WHERE matriculaAlumno = ? AND idPeriodo = ?";
        
        try {
            for (Alumno alumnoPeriodo : listaAlumnoPeriodos) {
                this.conectar();
                PreparedStatement st = this.conexion.prepareStatement(selectQuery);
                st.setString(1, periodo);
                st.setString(2, alumnoPeriodo.getMatricula());
                ResultSet rs = st.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    PreparedStatement ust = this.conexion.prepareStatement(updateQuery);
                    ust.setString(1, periodo);
                    ust.setString(2, alumnoPeriodo.getMatricula());
                    ust.setInt(3, alumnoPeriodo.getSemestre());
                    ust.setString(4, alumnoPeriodo.getGrupo());
                    ust.setString(5, periodo);
                    ust.setString(6, alumnoPeriodo.getMatricula());

                    ust.execute();
                } else {
                    PreparedStatement ist = this.conexion.prepareStatement(insertQuery);
                    ist.setString(1, periodo);
                    ist.setString(2, alumnoPeriodo.getMatricula());
                    ist.setInt(3, alumnoPeriodo.getSemestre());
                    ist.setString(4, alumnoPeriodo.getGrupo());

                    ist.execute();
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
    public List<AlumnoPeriodo> listar2(String periodoEscolar, String Semestre) throws Exception {
        String sql = "SELECT * FROM VistaAlumnoPeriodo WHERE idPeriodo = ? AND semestre = ?";
        List<AlumnoPeriodo> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, periodoEscolar);
            st.setString(2, Semestre);
            
            lista = new ArrayList();
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                AlumnoPeriodo alumnoPeriodo = new AlumnoPeriodo();
                alumnoPeriodo.setIdPeriodo(rs.getString("idPeriodo"));
                alumnoPeriodo.setMatricula(rs.getString("matriculaAlumno"));
                alumnoPeriodo.setNombre(rs.getString("nombre"));
                alumnoPeriodo.setaPaterno(rs.getString("aPaterno"));
                alumnoPeriodo.setaMaterno(rs.getString("aMaterno"));
                alumnoPeriodo.setSemestre(rs.getInt("semestre"));
                alumnoPeriodo.setGrupo(rs.getString("grupo"));
                alumnoPeriodo.setEstatusEntrega1(rs.getString("estatus_entrega1"));
                alumnoPeriodo.setEstatusEntrega2(rs.getString("estatus_entrega2"));
                alumnoPeriodo.setEstatusEntrega3(rs.getString("estatus_entrega3"));

                lista.add(alumnoPeriodo);
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
    public List<AlumnoPeriodo> listar3(String periodoEscolar, String Semestre, String grupo) throws Exception {
        String sql = "SELECT * FROM VistaAlumnoPeriodo WHERE idPeriodo = ? AND semestre = ? AND grupo = ?";
        List<AlumnoPeriodo> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, periodoEscolar);
            st.setString(2, Semestre);
            st.setString(3, grupo);
            
            lista = new ArrayList();
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                AlumnoPeriodo alumnoPeriodo = new AlumnoPeriodo();
                alumnoPeriodo.setIdPeriodo(rs.getString("idPeriodo"));
                alumnoPeriodo.setMatricula(rs.getString("matriculaAlumno"));
                alumnoPeriodo.setNombre(rs.getString("nombre"));
                alumnoPeriodo.setaPaterno(rs.getString("aPaterno"));
                alumnoPeriodo.setaMaterno(rs.getString("aMaterno"));
                alumnoPeriodo.setSemestre(rs.getInt("semestre"));
                alumnoPeriodo.setGrupo(rs.getString("grupo"));
                alumnoPeriodo.setEstatusEntrega1(rs.getString("estatus_entrega1"));
                alumnoPeriodo.setEstatusEntrega2(rs.getString("estatus_entrega2"));
                alumnoPeriodo.setEstatusEntrega3(rs.getString("estatus_entrega3"));

                lista.add(alumnoPeriodo);
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
    public AlumnoPeriodo traerUnAlumnoPeriodo(String periodo, String matricula) throws Exception {
        String sql = "SELECT * FROM VistaAlumnoPeriodo WHERE idPeriodo = ? AND matriculaAlumno = ?";
        AlumnoPeriodo alumnoPeriodo = new AlumnoPeriodo();
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, periodo);
            st.setString(2, matricula);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                alumnoPeriodo.setIdPeriodo(rs.getString("idPeriodo"));
                alumnoPeriodo.setMatricula(rs.getString("matriculaAlumno"));
                alumnoPeriodo.setNombre(rs.getString("nombre"));
                alumnoPeriodo.setaPaterno(rs.getString("aPaterno"));
                alumnoPeriodo.setaMaterno(rs.getString("aMaterno"));
                alumnoPeriodo.setSemestre(rs.getInt("semestre"));
                alumnoPeriodo.setGrupo(rs.getString("grupo"));
                alumnoPeriodo.setEstatusEntrega1(rs.getString("estatus_entrega1"));
                alumnoPeriodo.setEstatusEntrega2(rs.getString("estatus_entrega2"));
                alumnoPeriodo.setEstatusEntrega3(rs.getString("estatus_entrega3"));    
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
        return alumnoPeriodo;
    }

    @Override
    public void modificar2(AlumnoPeriodo alumnoPeriodo) throws Exception {
        String sql = "UPDATE alumnoPeriodo SET estatus_entrega2 = ? WHERE idPeriodo = ? AND matriculaAlumno = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumnoPeriodo.getEstatusEntrega1());
            st.setString(2, alumnoPeriodo.getIdPeriodo());
            st.setString(3, alumnoPeriodo.getMatricula());
            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificar3(AlumnoPeriodo alumnoPeriodo) throws Exception {
        String sql = "UPDATE alumnoPeriodo SET estatus_entrega3 = ? WHERE idPeriodo = ? AND matriculaAlumno = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumnoPeriodo.getEstatusEntrega1());
            st.setString(2, alumnoPeriodo.getIdPeriodo());
            st.setString(3, alumnoPeriodo.getMatricula());
            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificar1(AlumnoPeriodo alumnoPeriodo) throws Exception {
        String sql = "UPDATE alumnoPeriodo SET estatus_entrega1 = ?, estatus_entrega2 = ?, estatus_entrega3 = ?  "
                + "WHERE idPeriodo = ? AND matriculaAlumno = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumnoPeriodo.getEstatusEntrega1());
            st.setString(2, alumnoPeriodo.getEstatusEntrega2());
            st.setString(3, alumnoPeriodo.getEstatusEntrega3());
            st.setString(4, alumnoPeriodo.getIdPeriodo());
            st.setString(5, alumnoPeriodo.getMatricula());
            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificarAl(AlumnoPeriodo alumnoPeriodo) throws Exception {
       String sql = "UPDATE alumnoPeriodo SET matriculaAlumno = ?, semestre = ?, grupo = ?  "
                + "WHERE idPeriodo = ? AND matriculaAlumno = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, alumnoPeriodo.getMatricula());
            st.setInt(2, alumnoPeriodo.getSemestre());
            st.setString(3, alumnoPeriodo.getGrupo());
            st.setString(4, alumnoPeriodo.getIdPeriodo());
            st.setString(5, alumnoPeriodo.getMatricula());
            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

}
