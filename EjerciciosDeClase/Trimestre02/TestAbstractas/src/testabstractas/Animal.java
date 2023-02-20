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
public abstract class Animal extends SerVivo {

    
    @Override
    public abstract void alimentarse();

    @Override
    public String toString() {
        return "Soy un Animal";
    }
    
    
    
}
