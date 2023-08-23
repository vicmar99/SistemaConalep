/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Semestre;

/**
 *
 * @author Yair
 */
public interface SemestreDAO {
    
    public void registrar(Semestre semestre) throws Exception;
    
    public void modificar(Semestre semestre) throws Exception;
    
    public void eliminar(Semestre semestre) throws Exception;
    
    public List<Semestre> listar() throws Exception;
    
}
