/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Comprobante;

/**
 *
 * @author Yair
 */
public interface ComprobanteDAO {
    
    public void registrar(Comprobante comprobante) throws Exception;

    public void modificar(Comprobante comprobante) throws Exception;

    public void eliminar(Comprobante comprobante) throws Exception;

    public List<Comprobante> listar(String matricula) throws Exception;
    
    public void visualizarPdf(int idPdf);
}
