package pkg016_futbolistas;

public class Main {
    public static void main(String[] args) {
        
        Equipo local = new Equipo(null,null);
        Equipo visitante = new Equipo(null,null);
        
        // Locales:
        local.anadirFutbolista(new Futbolista("chincho", "Merinde", "", 0, 0,null, 0,0,0));
        local.anadirFutbolista(new Futbolista("Marcelo", "Martinez", "", 0, 1,null, 0,0,0));
        local.anadirFutbolista(new Futbolista("Nes", "Magic", "", 0, 2,null, 0,0,0));
        local.anadirFutbolista(new Futbolista("Doctor", "Gol", "", 0, 3,null, 0,0,0));
        local.anadirFutbolista(new Futbolista("Manuel", "Goles", "", 0, 4,null, 0,0,0));
        
        // Visitantes:
        visitante.anadirFutbolista(new Futbolista("Chicristiano", "Pequeñaldo", "", 0, 0,null, 0,0,0));
        visitante.anadirFutbolista(new Futbolista("Renato", "Augusto", "", 0, 1,null, 0,0,0));
        visitante.anadirFutbolista(new Futbolista("Esquivel", "Goles", "", 0, 2,null, 0,0,0));
        visitante.anadirFutbolista(new Futbolista("John", "Rambo", "", 0, 3,null, 0,0,0));
        visitante.anadirFutbolista(new Futbolista("Monje", "Sumerio", "", 0, 4,null, 0,0,0));
        
        local.entrenar(Entrenamiento.ESTIRAR);
        visitante.entrenar(Entrenamiento.ESTIRAR);
        
        local.convocar(local.getFutbolistas()[0]);
        local.convocar(local.getFutbolistas()[1]);
        local.convocar(local.getFutbolistas()[2]);
        local.convocar(local.getFutbolistas()[3]);
        local.convocar(local.getFutbolistas()[4]);
        
        visitante.convocar(visitante.getFutbolistas()[0]);
        visitante.convocar(visitante.getFutbolistas()[1]);
        visitante.convocar(visitante.getFutbolistas()[2]);
        visitante.convocar(visitante.getFutbolistas()[3]);
        visitante.convocar(visitante.getFutbolistas()[4]);
        

        
        Partido classic = new Partido();
        classic.setLocalesConvocados(local.getConvocados());
        classic.setVisitantesConvocados(visitante.getConvocados());
        
        classic.jugar();
        classic.imprimirGoles("Local");
        classic.imprimirGoles("Visitante");
        classic.entrevistar();
    }
    
}
