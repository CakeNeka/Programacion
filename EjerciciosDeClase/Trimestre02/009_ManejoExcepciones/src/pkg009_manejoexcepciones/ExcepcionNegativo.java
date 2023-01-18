/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg009_manejoexcepciones;

/**
 *
 * @author Diurno
 */
public class ExcepcionNegativo extends Exception {
    
    ExcepcionNegativo(){
        super("El número no puede ser negativo");
    }
    
}
