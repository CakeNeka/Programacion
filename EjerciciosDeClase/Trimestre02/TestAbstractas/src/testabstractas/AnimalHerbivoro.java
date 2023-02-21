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
public class AnimalHerbivoro extends Animal {
    public static final int numEstomagos = 1;
    
    @Override
    public void alimentarse(){
        System.out.println("Me alimento a través de la fotosíntesis");
    };
    
        @Override
    public String toString() {
        return " y soy Herbívoro";
    }

    @Override
    public void respirar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
