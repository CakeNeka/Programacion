package pkg016_futbolistas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Partido {

    private Futbolista[] visitantesConvocados;
    private Futbolista[] localesConvocados;
    HashMap<String, HashMap<Integer, Integer>> goleadores;

    public Partido() {
        goleadores = new HashMap<>();
        goleadores.put("Local", new HashMap<>());
        goleadores.put("Visitante", new HashMap<>());
    }

    public void jugar() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String equipo = "Local";
        for (Futbolista futbolista : localesConvocados) {
            marcar(equipo, futbolista, random.nextInt(3));
        }

        equipo = "Visitante";
        for (Futbolista futbolista : visitantesConvocados) {
            marcar(equipo, futbolista, random.nextInt(3));
        }
    }

    public void marcar(String equipo, Futbolista futbolista, int goles) {
        futbolista.setGoles(futbolista.getGoles() + goles);
        goleadores.get(equipo).put(futbolista.getDorsal(), goles);
    }

    public Futbolista DameFutbolista(String equipo, int dorsal) {
        equipo = equipo.toLowerCase();
        Futbolista res;
        if (equipo.equals("local")) {
            for (Futbolista futbolista : localesConvocados) {
                if (futbolista.getDorsal() == dorsal) {
                    return futbolista;
                }
            }
        } else if (equipo.equals("visitante")) {
            for (Futbolista futbolista : visitantesConvocados) {
                if (futbolista.getDorsal() == dorsal) {
                    return futbolista;
                }
            }
        }
        return null;
    }

    public void imprimirGoles(String equipo) {
        HashMap<Integer, Integer> goles = goleadores.get(equipo);
        for (Map.Entry<Integer, Integer> set : goles.entrySet()) {
            System.out.println(DameFutbolista(equipo, set.getKey()).getNombre()
                    + ": " + set.getValue());
        }
    }

    public void entrevistar() {
        int maxGolesLocal = 0;
        List<Futbolista> entrevistadosLocal = new ArrayList<>();
        List<Futbolista> entrevistadosVisitante = new ArrayList<>();

        // Equipo local:
        int maxGoles = 0;
        HashMap<Integer, Integer> golesLocal = goleadores.get("Local");
        for (Map.Entry<Integer, Integer> set : golesLocal.entrySet()) {
            if (set.getValue() > maxGoles) {
                maxGoles = set.getValue();
                entrevistadosLocal.clear();
            }
            if (set.getValue() == maxGoles) {
                entrevistadosLocal.add(DameFutbolista("Local", set.getKey()));
            }
        }

        // Equipo visitante
        maxGoles = 0;
        HashMap<Integer, Integer> golesVisitante = goleadores.get("Visitante");
        for (Map.Entry<Integer, Integer> set : golesVisitante.entrySet()) {
            if (set.getValue() > maxGoles) {
                maxGoles = set.getValue();
                entrevistadosVisitante.clear();
            }
            if (set.getValue() == maxGoles) {
                entrevistadosVisitante.add(DameFutbolista("Visitante", set.getKey()));
            }
        }

        // Entrevistar
        System.out.println(entrevistadosLocal.size());
        for (Futbolista futbolista : entrevistadosLocal) {
            futbolista.entrevistarse();
        }
        for (Futbolista futbolista : entrevistadosVisitante) {
            futbolista.entrevistarse();
        }
    }

    public void setVisitantesConvocados(Futbolista[] visitantesConvocados) {
        this.visitantesConvocados = visitantesConvocados;

        HashMap<Integer, Integer> golesVisitante = goleadores.get("Visitante");
        for (Futbolista futbolista : visitantesConvocados) {
            golesVisitante.put(futbolista.getDorsal(), 0);
        }
    }

    public void setLocalesConvocados(Futbolista[] localesConvocados) {
        this.localesConvocados = localesConvocados;
        
        HashMap<Integer, Integer> golesLocal = goleadores.get("Local");
        for (Futbolista futbolista : localesConvocados) {
            
            golesLocal.put(futbolista.getDorsal(), 0);
        }
    }

}
