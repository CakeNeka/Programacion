/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstpackage;

/**
 *
 * @author CakeNeka
 * 2022-19-12
 * 
 */
public class Alumno {
    String nombre;
    int numAlumnos;
    int[] notas;
    
    // Métodos
    /**
     * 
     * @param nombre El nombre del alumno
     * @param numAlumnos El número del alumno
     * @param notas Las notas de clase
     */
    Alumno(String nombre, int numAlumnos, int[] notas) {
        this.nombre = nombre;
        this.numAlumnos = numAlumnos;
        this.notas = notas;
    }

    public Alumno() { }
    
}
