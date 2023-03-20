package pkg030_repasoexamen;

import java.util.Comparator;

public class CompararPorApellidoYNombre implements Comparator<Persona> {

    @Override
    public int compare(Persona t, Persona t1) {
        int apellido = t.getSurname().compareTo(t1.getSurname());
        if (apellido != 0) 
            return apellido;
        return t.getName().compareTo(t1.getName());
    }
    
}
