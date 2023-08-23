/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Periodo;

/**
 *
 * @author Yair
 */
public interface PeriodoDAO {

    public void registrar(Periodo periodo) throws Exception;

    public void modificar(Periodo periodo) throws Exception;

    public void eliminar(Periodo periodo) throws Exception;

    public List<Periodo> listar() throws Exception;
    
}
