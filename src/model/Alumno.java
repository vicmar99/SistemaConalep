/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yair
 */
public class Alumno {
    
    private String matricula;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private int semestre;
    private String grupo;

    public Alumno() {
    }

    public Alumno(String matricula, String nombre, String aPaterno, String aMaterno, int semestre, String grupo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.semestre = semestre;
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
}
