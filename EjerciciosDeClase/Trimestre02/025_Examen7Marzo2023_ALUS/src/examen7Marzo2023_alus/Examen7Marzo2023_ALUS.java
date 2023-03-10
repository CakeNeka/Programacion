/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen7Marzo2023_alus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rut
 */
public class Examen7Marzo2023_ALUS {

    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // 1er Bloque
        // 1. ArrayList de personas
        ArrayList<Persona> personas = new ArrayList<>();
        
        // 2. Bucle para meter personas EN EL ARRAYLIST
        System.out.println("Introduce un nombre");
        String input = entrada.nextLine();
        while (!input.isEmpty()){
            personas.add(creaPersona(input));
            System.out.println("Introduce otro nombre");
            input = entrada.nextLine();
        }
        
        

        // 2º Bloque
        if (!personas.isEmpty()) {
            System.out.println("Personas creadas: ");
            muestraPersonas(personas);
            System.out.println("\nPersonas ordenadas por sueldo");
            // 0,3
            Collections.sort(personas, new OrdenaPersonasPorSueldo());
            muestraPersonas(personas);
        }

    }

    private static Persona creaPersona(String name) {
        int tipo = random.nextInt(3);
        Persona persona;
        switch (tipo) {
            case 0:
                persona = new Parado(name);
                break;
            case 1:
                persona = new Funcionario(name);
                break;
            case 2:
                try {
                    persona = new PorComision(name, ThreadLocalRandom.current().nextDouble(1, 5000));
                } catch (ExcepVentas ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("La persona no ha sido creada");
                    persona = null;
                }
                break;
            default:
                persona = null;
                break;
        }

        return persona;
    }
    
    private static void muestraPersonas(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
