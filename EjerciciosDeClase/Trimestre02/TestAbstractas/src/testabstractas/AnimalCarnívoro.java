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
    
    @Override
    public void alimentarse() {
        System.out.println("Soy carnívoro y solo como carne");
    }

    @Override
    public String toString() {
        return  " y soy Carnívoro";
    }
    
    
    
}
