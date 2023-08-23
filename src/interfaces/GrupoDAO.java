/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Grupo;

/**
 *
 * @author Yair
 */
public interface GrupoDAO {
    
    public void registrar(Grupo grupo) throws Exception;
    
    public void modificar(Grupo grupo) throws Exception;
    
    public void eliminar(Grupo grupo) throws Exception;
    
    public List<Grupo> listar () throws Exception;
    
}
