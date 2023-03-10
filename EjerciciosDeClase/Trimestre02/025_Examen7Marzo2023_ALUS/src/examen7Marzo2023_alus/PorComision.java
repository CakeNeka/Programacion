package examen7Marzo2023_alus;

import java.util.concurrent.ThreadLocalRandom;

public final class PorComision extends Trabajador {

    private double importeVentas;
    private double fijo;
    
    public PorComision(String nombre, double importeVentas) throws ExcepVentas {
        super(nombre);
        if (importeVentas > 0) {
            this.importeVentas = importeVentas;
        } else {
            throw new ExcepVentas();
        }
        fijo = ThreadLocalRandom.current().nextDouble(MINIMO, MAXFIJO);
    }
    
    @Override
    public double cobrar() {
        double comisionVentas = importeVentas * 0.2;
        return fijo + comisionVentas;
    }

}
