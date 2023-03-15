package pkg027_archivosbinarios;

import java.io.Serializable;

public class Pony implements Serializable   {

    String name;
    String type;

    public Pony(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")"; 
    }
    
    
}
