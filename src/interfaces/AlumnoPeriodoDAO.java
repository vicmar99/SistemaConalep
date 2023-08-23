/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Alumno;
import model.AlumnoPeriodo;
/**
 *
 * @author Yair
 */
public interface AlumnoPeriodoDAO {
    
    public void registrar(AlumnoPeriodo alumnoPeriodo) throws Exception;
    
    public void modificarAl(AlumnoPeriodo alumnoPeriodo) throws Exception;

    public void modificar(AlumnoPeriodo alumnoPeriodo) throws Exception;
    
    public void modificar1(AlumnoPeriodo alumnoPeriodo) throws Exception;

    public void modificar2(AlumnoPeriodo alumnoPeriodo) throws Exception;
    
    public void modificar3(AlumnoPeriodo alumnoPeriodo) throws Exception;
    
    public void eliminar(AlumnoPeriodo alumnoPeriodo) throws Exception;
    
    public AlumnoPeriodo traerUnAlumnoPeriodo(String periodo, String matricula) throws Exception;

    public List<AlumnoPeriodo> listar(String periodoEscolar) throws Exception;
    
    public List<AlumnoPeriodo> listar2(String periodoEscolar, String Semestre) throws Exception;
    
    public List<AlumnoPeriodo> listar3(String periodoEscolar, String Semestre, String grupo) throws Exception;
    
    public AlumnoPeriodo traerUnAlumno(String periodo) throws Exception;
    
    public void registrarLista(List<Alumno> listaAlumnoPeriodos, String periodo) throws Exception;
    
 
    

}
