/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Yair
 */
public class Comprobante {
    private int idComprobante;
    private String matriculaAlumno;
    private String idPeriodo;
    private String usuarioRecibe;
    private String departamentoRecibe;
    private String fechaRecibido = setDate();
    private String conceptos;
    private byte[] comprobante;

    private String setDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es","ES");
        return (now.format(DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM 'de' yyyy ", spanishLocale)));
    }

    public Comprobante() {
    }

 
    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getUsuarioRecibe() {
        return usuarioRecibe;
    }

    public void setUsuarioRecibe(String usuarioRecibe) {
        this.usuarioRecibe = usuarioRecibe;
    }

    public String getDepartamentoRecibe() {
        return departamentoRecibe;
    }

    public void setDepartamentoRecibe(String departamentoRecibe) {
        this.departamentoRecibe = departamentoRecibe;
    }

    public String getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(String fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getConceptos() {
        return conceptos;
    }

    public void setConceptos(String conceptos) {
        this.conceptos = conceptos;
    }

    public byte[] getComprobante() {
        return comprobante;
    }

    public void setComprobante(byte[] comprobante) {
        this.comprobante = comprobante;
    }
    
    
}
