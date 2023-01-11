package main;

import AbstractFactory.*;
public class Main {

    public static void main(String[] args) {
        abstractFactoryDemo();
    }

    // Abstract Factory:
    static void abstractFactoryDemo() {
        System.out.println("Ejercito pesado");
        FabricaSoldado fs = GeneradorFabricaSoldado.generaFabrica("pesada");
        creaEjercito(fs);

        System.out.println("\nEjercito ligero:");
        fs = GeneradorFabricaSoldado.generaFabrica("ligera");
        creaEjercito(fs);
    }

    static void creaEjercito(FabricaSoldado fs) {

        Infanteria s1 = fs.creaInfanteria();
        System.out.println(s1.getTipoInfanteria());

        Caballeria c1 = fs.creaCaballeria();
        System.out.println(c1.getTipoCaballeria());
    }

}
