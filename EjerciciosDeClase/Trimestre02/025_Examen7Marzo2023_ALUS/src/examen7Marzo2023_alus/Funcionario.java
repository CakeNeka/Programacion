package examen7Marzo2023_alus;

import java.util.concurrent.ThreadLocalRandom;

public final class Funcionario extends Trabajador {
    
    private double nomina;
    
    public Funcionario(String nombre) {
        super(nombre);
        nomina = ThreadLocalRandom.current().nextDouble(MINIMO, MAXNOMINA);
    }
    
    @Override
    public double cobrar() {
        return nomina;
    }
    
}
