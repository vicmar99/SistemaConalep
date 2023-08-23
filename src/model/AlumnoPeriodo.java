/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yair
 */
public class AlumnoPeriodo {
    private String idPeriodo;
    private String matricula;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private int semestre;
    private String grupo;
    private String estatusEntrega1;
    private String estatusEntrega2;
    private String estatusEntrega3;
    
    
    public AlumnoPeriodo() {
    }

    public AlumnoPeriodo(String idPeriodo, String matricula, String nombre, String aPaterno, String aMaterno, int semestre, String grupo, String estatusEntrega1, String estatusEntrega2, String estatusEntrega3) {
        this.idPeriodo = idPeriodo;
        this.matricula = matricula;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.semestre = semestre;
        this.grupo = grupo;
        this.estatusEntrega1 = estatusEntrega1;
        this.estatusEntrega2 = estatusEntrega2;
        this.estatusEntrega3 = estatusEntrega3;
    }

    public AlumnoPeriodo(String idPeriodo, String matricula, int semestre, String grupo, String estatusEntrega1, String estatusEntrega2, String estatusEntrega3) {
        this.idPeriodo = idPeriodo;
        this.matricula = matricula;
        this.semestre = semestre;
        this.grupo = grupo;
        this.estatusEntrega1 = estatusEntrega1;
        this.estatusEntrega2 = estatusEntrega2;
        this.estatusEntrega3 = estatusEntrega3;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEstatusEntrega1() {
        return estatusEntrega1;
    }

    public void setEstatusEntrega1(String estatusEntrega1) {
        this.estatusEntrega1 = estatusEntrega1;
    }

    public String getEstatusEntrega2() {
        return estatusEntrega2;
    }

    public void setEstatusEntrega2(String estatusEntrega2) {
        this.estatusEntrega2 = estatusEntrega2;
    }

    public String getEstatusEntrega3() {
        return estatusEntrega3;
    }

    public void setEstatusEntrega3(String estatusEntrega3) {
        this.estatusEntrega3 = estatusEntrega3;
    }

    
   
}
