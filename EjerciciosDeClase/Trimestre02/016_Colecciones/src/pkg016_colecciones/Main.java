/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg016_colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * COLECCIONES 
 *  · ArrayList 
 *  · Hashmap 
 *  · Hashset
 *
 * @author Diurno 03/02/2023
 */
public class Main {

    public static void main(String[] args) {
        treeList();
    }
    
    public static void treeList() {
        // Creamos una Lista de árboles
        List<Trees> forest = new ArrayList<>();
        
        // Creamos árboles
        Trees t1 = new Trees("Oak", "t1", Leaves.FALLEN, 14235235);
        Trees t2 = new Trees("Holm Oak", "Quercus ilex", Leaves.EVERGREEN, 14235235);
        Trees t3 = new Trees("Pine", "Pinus", Leaves.EVERGREEN, 14235235);
        Trees t4 = new Trees("Spruce", "Abies Alba", Leaves.FALLEN, 14235235);
        
        forest.add(t1);
        forest.add(t2);
        forest.add(t3);
        forest.add(t4);
        
        printArrayList(forest);
        
        // Buscar un pine y si existe lo borro;
        if(forest.contains(t3)){
            Collections.sort(forest);
            forest.remove(t3);
        }
    }
    
    public static void arrayLists() {
        // ArrayLists
        ArrayList<String> colors = new ArrayList<>();

        System.out.println("\n>> Añadiendo valores a la lista");
        colors.add("red");
        colors.add("Sexo anal");
        colors.add("Chincho Merienda");
        colors.add("Macarrones");
        colors.add("Héroe benévolo");

        System.out.print("\n>> El valor contenido en el índice 0:  ");
        System.out.println(colors.get(0));

        System.out.print("\n>> El indice que contiene el valor 'red':  ");
        System.out.println(colors.indexOf("red"));

        System.out.println("\n>> Recorriendo el ArrayList");
        for (String color : colors) {
            System.out.print(color + ", ");
        }
        System.out.println();

        System.out.println("\n>> Comprobar si la lista contiene un valor");
        String color = "Yellow";
        if (colors.contains(color)) { //.Equals / CompareTo deben estar implementados
            System.out.println(color + " está en el índice " + colors.indexOf(color));
        } else {
            System.out.println("The value " + color + " does not belong to the list");
        }
        
        System.out.println("\n>> Poner un elemento en un determinado índice (menor al tamaño de la lista): ");
        colors.set(colors.size()-1, color); // Para reemplazar elementos ya existentes ._.
        
        System.out.println("\n>> Eliminando el elemento de un determinado índice");
        colors.remove(3); // Los elementos de índice > 3 reducen su índice en 1
        
        System.out.println("\n>> Eliminando el elemento 'Sexo anal' ");
        colors.remove("Sexo anal");
        
        System.out.println("\n>> Ordenamos por orden ascendente");
        Collections.sort(colors, Collections.reverseOrder());
        
        System.out.println("\n>> Mostrando el ArrayList");
        System.out.println(colors.toString());
    }

    public static <T> void printArrayList(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }
    
}
