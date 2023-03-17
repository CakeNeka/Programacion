package Pruebas;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diurno
 */
public class Main {
    
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Juan");
        strings.add("Juan");
        strings.add("Chincho");
        strings.add("Chincho");
        strings.add("Juan");
        
        removeDuplicates(strings);
        
        for (String string : strings) {
            System.out.println(string);  
        }
    }
    
    public static void removeDuplicates(ArrayList<String> strings) {
        ArrayList<String> noDuplicates = new ArrayList<>();
        
        for (String string : strings) {
            if (!noDuplicates.contains(string)){
                noDuplicates.add(string);
            }
        }
        
//      strings = noDuplicates;     // No funcionará
        
        
        strings.clear();
        strings.addAll(noDuplicates);
        
    }
    
}
