package pkg021_ejercicioanimales;

import java.util.ArrayList;
import java.util.List;

        /**
         * Ejercicio: 
         * reino animal vertebrados --> peces (pelo, aletas, branquias)
         *                          --> mamiferos (pelo
         *                          --> Anfibios
         *                          --> Aves (plumas
         *                          --> reptiles (escamas, pulmones)
         * 
         *              invertebrados --> Con protección corporal
         *                                  --> artrópodos moluscos equinodermos
         *                                  --> Sin protección corporal( gusanos, celentéreos )
         * 
         * Dos ejemplos de cada subclase.
         * MÉTODOS: alimentar desplazarse reproducción
         */

public class Main {

    /**
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {
        /* _Polimorfismo_ */
        
       /**
        * <String>
        */
        List<Animal> lista = new ArrayList<>();
        
        Animal e = new Mamifero();
        Animal p = new Pez();
        e.alimentar();
        lista.add(e);
        lista.add(p);
    }
    
}
