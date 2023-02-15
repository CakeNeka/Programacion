package pkg021_ejercicioanimales;

import static pkg021_ejercicioanimales.Pez.RESPIRACION;

public class Mamifero extends Vertebrado {

    static final String RESPIRACION = "Pulmones";
    static final boolean TIENE_PULMONES = true;
    
    @Override
    public void respirar() {
        System.out.println("*Respira mediante " + RESPIRACION + "*");
    }

    @Override
    public void alimentar() {
        System.out.println("*Mamifero come*");
    }

    @Override
    public void desplazarse() {
        System.out.println("*Se mueve como mamífero*");
    }

    @Override
    public void reproducirse() {
        System.out.println("*Se reproduce vivíparamente");
    }
    
}
