/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabstractas;

/**
 *
 * @author Rut
 */

// Añadimos los campos nombre, especie, numEstomagos;
// Además, necesitamos introducir la clase Rumiante y no puedo tener clases hijas
// de Rumiante

public abstract class SerVivo {
    
    private String nombre;
    private String especie;
    
    public abstract void alimentarse();
    public abstract void respirar();
    
    public void morir(){
        System.out.println("He muerto");
    }
}
