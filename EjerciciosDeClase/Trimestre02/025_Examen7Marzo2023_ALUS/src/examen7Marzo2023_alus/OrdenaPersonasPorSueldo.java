package examen7Marzo2023_alus;

import java.util.Comparator;

public class OrdenaPersonasPorSueldo implements Comparator<Persona> {

    @Override
    public int compare(Persona t, Persona t1) {
        return Double.compare(t.cobrar(), t1.cobrar());
    }
    
}
