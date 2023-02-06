package pkg016_futbolistas;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private static final int TAMANO_EQUIPO = 10;

    private Futbolista[] convocados;
    private Futbolista[] futbolistas;
    private Entrenador entrenador;
    private Medico medico;

    public Equipo(Entrenador entrenador, Medico medico) {
        this.entrenador = entrenador;
        this.medico = medico;
        this.futbolistas = new Futbolista[TAMANO_EQUIPO];
        this.convocados = new Futbolista[5];
    }

    public void entrenar(Entrenamiento tipo) {
        for (Futbolista futbolista : futbolistas) {
            if (futbolista != null) {
                System.out.println(futbolista.getNombre() + " entrenó");
                futbolista.entrenar(tipo);
            }
        }
    }

    public void anadirFutbolista(Futbolista futbolista) {
        int i = 0;
        while (i < futbolistas.length && futbolistas[i] != null) {
            i++;
        }
        if (i < futbolistas.length) {
            futbolistas[i] = futbolista;
        }
    }

    public void convocar(Futbolista futbolista) {
        boolean yaConvocado = false;
        for (Futbolista convocado : convocados) {
            if (futbolista == convocado) {
                yaConvocado = true;
                System.out.println(futbolista.getNombre() + "Ya ha sido convocado");
            }
        }
        if (!yaConvocado) {
            boolean haySitio = false;
            int i = 0;
            while (!haySitio && i < convocados.length) {
                
                if (convocados[i] == null) {
                    System.out.println(futbolista.getNombre() + " convocado");
                    convocados[i] = futbolista;
                    haySitio = true;
                }
                i++;
            }
        }
    }

    public Futbolista[] getConvocados() {
        return convocados;
    }

    public Futbolista[] getFutbolistas() {
        return futbolistas;
    }

}
