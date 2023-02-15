package pkg021_ejercicioanimales;


public class Pez extends Vertebrado {

    static final String RESPIRACION = "Branquia";
    
    @Override
    public void respirar() {
        System.out.println("*Respira mediante " + RESPIRACION + "*");
    }

    @Override
    public void alimentar() {
        System.out.println("*Se alimenta como pez*");
    }

    @Override
    public void desplazarse() {
        System.out.println("*Se desplaza como pez*");
    }

    @Override
    public void reproducirse() {
        System.out.println("*se reproduce como pez*");
    }
    
}
