package pkg021_ejercicioanimales;

class Ave extends Vertebrado {
    
    static final String RESPIRACION = "Pulmones";
    
    @Override
    public void respirar() {
        System.out.println("*Respira mediante " + RESPIRACION + "*");
    }

    @Override
    public void alimentar() {
        System.out.println("*Se alimenta como un ave*");
    }

    @Override
    public void desplazarse() {
        System.out.println("*Se desplaza como un ave*");
    }

    @Override
    public void reproducirse() {
        System.out.println("*Se reproduce como un ave*");
    }
    
}
