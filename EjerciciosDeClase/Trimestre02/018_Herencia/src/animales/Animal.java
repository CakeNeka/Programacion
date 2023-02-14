package animales;

import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio: Crear en otro paquete la Clase animal con los campos
 * (name, species) clases omnívoros, herbívoros y carnívoros;
 * @author Diurno
 */
public abstract class Animal {
    
    protected String name;
    private String species;
    
    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }
    
    public abstract void eat();

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", species=" + species + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    
    
}
