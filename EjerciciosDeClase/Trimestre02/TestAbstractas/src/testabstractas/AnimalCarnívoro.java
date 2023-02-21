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
public class AnimalCarnívoro extends Animal {
    
    public static final int numEstomagos = 1;
    
    @Override
    public void alimentarse() {
        System.out.println("Soy carnívoro y solo como carne");
    }

    @Override
    public String toString() {
        return  " y soy Carnívoro";
    }

    @Override
    public void respirar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
