/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Alumno;

/**
 *
 * @author Yair
 */
public interface AlumnoDAO {
    
    public void registrar(Alumno alumno) throws Exception;

    public void modificar(Alumno alumno) throws Exception;

    public void eliminar(String matricula) throws Exception;

    public List<Alumno> listar() throws Exception;
    
    public Alumno traerUnAlumno(String matricula) throws Exception;
    
    public void registrarLista(List<Alumno> listaAlumnos) throws Exception;
    
    public List<Alumno> listar2(String semestre, String grupo) throws Exception;
    
}
