package pkg003_clasesestaticas;

import java.util.Arrays;

/**
 *
 * @author Spartan-117
 */
public class Spartan {

    /**
     * Los miembros estáticos son iguales para todos los 
     * objetos de la clase. 
     * Los miembros estáticos pueden ser accedidos desde
     * la misma clase (sin hacer una instancia)
     */
    private static int valentia = 100;
    
    private int id;
    private int generation;
    private String color;
    private String rank;

    public Spartan(int id, int generation, String color, String rank) {
        this.id = id;
        this.generation = generation;
        this.color = color;
        this.rank = rank; 
    }

    // Getters & Setters
    public static int getValentia() {
        return valentia;
    }

    public static void setValentia(int valentia) {
        Spartan.valentia = valentia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Spartan{" + "id=" + id + ", generation=" + generation
                + ", color=" + color + ", valentía=" + valentia + "\n"
                + ", rank=" + rank + '}';
    }

}
