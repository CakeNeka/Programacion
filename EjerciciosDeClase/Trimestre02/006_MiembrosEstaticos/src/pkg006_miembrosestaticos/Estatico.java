/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg006_miembrosestaticos;

/**
 *
 * @author Diurno
 */
public class Estatico {
    
    static String type = "Dios";
    String name;

    @Override
    public String toString() {
        return "Estatico{" + "name=" + name + " tipo=" + type + '}';
    }



    public Estatico(String name) {
        this.name = name;
    }
    
    
}
