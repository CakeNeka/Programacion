/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenandohashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 *
 * @author Rut
 */
public class OrdenandoHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, Personilla> padres = new HashMap<>();
        Personilla p1 = new Personilla("Juanillo", "Valderrama", 10);
        Personilla p2 = new Personilla("Santi", "Valderrama", 12);
        Personilla p3 = new Personilla("Sofía", "Fernández", 22);
        Personilla p4= new Personilla("Alba", "González", 19);
        padres.put("María", p1);
        padres.put("Pepe", p1);
        padres.put("Oleg", p2);
        padres.put("Silvia", p2);
        padres.put("Alex", p3);
        padres.put("Diana", p4);
        System.out.println("Hashmap padres: ");
        showParents(padres);
        
        // Ordenación con TreeMap (se ordena según el orden natural de las claves)
        System.out.println("ORDENACIÓN DE CLAVES CON TREEMAP");
        TreeMap<String, Personilla> ordenaKeys = new TreeMap<>(padres);
        // o BIEN: ordenaKeys.putAll(padres);
        showParents(ordenaKeys);
        
        // Ordenación con ArrayList (perderíamos los pares clave-valor)
        ArrayList<String> hijos = new ArrayList<>();
        for (Personilla value : padres.values()) {
            hijos.add(value.getNombre() + " " + value.getApellidos());
        }
        Collections.sort(hijos);
        System.out.println("HIJOS ORDENADOS");
        for (String hijo : hijos) {
            System.out.println(hijo);
        }
        
        // Ordenación con Streams (a partir de Java8)
        System.out.println("Ordenación con STREAMS");
        padres.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("¿Sigue igual el HashMap? Sí, no me lo ha ordenado");
        showParents(padres);
        
        // Para pasar este conjunto ordenado a un LinkedHashMap (es el único Map
        // que me garantiza el orden de la iteración)
        // La notación :: son lambdas. Mete llave y valor en un LinkedHashMap 
        // con el nombre de variable viejo
        System.out.println("LINKEDHASHMAP con Collectors.toMap");
        Map<String, Personilla> resultado = padres.entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
                                (viejo, nuevo) -> viejo, LinkedHashMap::new));
        showParents(resultado);
        
        
         //Con la librería Guava (Hay que importarla en Maven,con Netbeans 15 or higher
    
//        Ordering naturalOrdering = Ordering.natural().onResultOf(Functions.forMap(padres, null));
//        ImmutableSortedMap.copyOf(map, naturalOrdering);
        
    }
    
    //Aquí usamos el polimorfismo (en vez de hashmap o treemap, usamos map para todo)
    public static void showParents(Map<String, Personilla> pama){
        for (Map.Entry<String, Personilla> entry : pama.entrySet()) {
            String padre = entry.getKey();
            String nombre = entry.getValue().getNombre() + " " 
                            + entry.getValue().getApellidos();
            int y = entry.getValue().getYears();
            System.out.printf("Padre: %s, Hijo/a: %s, Años: %d\n", padre, nombre, y);
        }
    }
    
   
    
   
}
