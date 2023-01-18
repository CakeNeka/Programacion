/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg009_manejoexcepciones;

/**
 *
 * @author Diurno
 * Fecha   18-01-2023
 * Excepciones Personalizadas
 */
public class ExcepcionCero extends Exception{

    public ExcepcionCero() {
        super("El número introducido no puede ser 0");
        
    }
    
}
