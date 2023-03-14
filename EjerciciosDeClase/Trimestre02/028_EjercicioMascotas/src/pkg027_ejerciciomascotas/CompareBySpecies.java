/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg027_ejerciciomascotas;

import java.util.Comparator;


public class CompareBySpecies implements Comparator<Animal> {

    @Override
    public int compare(Animal t, Animal t1) {
        return t.getSpecies().compareTo(t1.getSpecies());
    }
    
}
