package pkg021_ejercicioanimales;

public class Reptil extends Vertebrado {

   static final String RESPIRACION = "Pulmones";
    
    @Override
    public void respirar() {
        System.out.println("*Respira mediante " + RESPIRACION + "*");
    }

    @Override
    public void alimentar() {
        System.out.println("*Se alimenta como reptil*");
    }

    @Override
    public void desplazarse() {
        System.out.println("*Se desplaza como reptil*");
    }

    @Override
    public void reproducirse() {
        System.out.println("*se reproduce como reptil*");
    }
    
}
