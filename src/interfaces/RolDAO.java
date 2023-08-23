/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Rol;

/**
 *
 * @author Yair
 */
public interface RolDAO {
    
    public void registrar(Rol rol) throws Exception;
    
    public void modificar(Rol rol) throws Exception;
    
    public void eliminar(Rol rol) throws Exception;
    
    public List<Rol> listar() throws Exception;
    
}
