/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Usuario;

/**
 *
 * @author Yair
 */
public interface UsuarioDAO {
    
    public void registrar(Usuario usuario) throws Exception;
    
    public void modificar(Usuario usuario) throws Exception;
    
    public void eliminar(String idUsuario) throws Exception;
    
    public Usuario validarCredenciales(String idUsuario, String clave) throws Exception;
    
    public Usuario traerUnUsuario(String idUsuario) throws Exception;
    
    public List<Usuario> listar(String departamento) throws Exception;
    
}
