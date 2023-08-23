/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Departamento;

/**
 *
 * @author Yair
 */
public interface DepartamentoDAO {
    
    public void registrar(Departamento departamento) throws Exception;
    
    public void modificar(Departamento departamento) throws Exception;
    
    public void eliminar(Departamento departamento) throws Exception;
    
    public List<Departamento> listar() throws Exception;
    
}
