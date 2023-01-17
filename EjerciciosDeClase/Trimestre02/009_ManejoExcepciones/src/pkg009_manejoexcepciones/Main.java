package pkg009_manejoexcepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * 
 * @author Diurno
 * Fecha   17-01-2023
 * 
 * Manejo de excepciones y excepciones personalizadas
 */
public class Main {

    public static void main(String[] args) {
        /*
        leerArchivoTexto();
        
        // <editor-fold>
        try {
            leerArchivoTexto2();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, Archivo no encontrado");  
        } catch (IOException ex) {
            System.out.println("Error de Entrada/Salida");
        }
        // </editor-fold>
        
        try{
            lanzaExcepciones();
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Error aritmetico", "wololo", JOptionPane.WARNING_MESSAGE);
        }
        */
        
        for (int i = 0; i < 90; i++) {
            System.out.println(Math.sin(i));
        }
        
        try {
            leeNumeros();
        } catch (InputMismatchException ex) {
            System.out.println("Tuvo lugar una excepción " + " InputMismatchException");
        }
    }


    // Opción 1. bloque try catch
    public static void leerArchivoTexto() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Prueba.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } finally { 
            
        }
        
        
    }

    // Opción 2. Declaro que la función lanza una excepción (throws)
    public static void leerArchivoTexto2() throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("Prueba.txt"));
        
        String linea;
        linea = br.readLine();
        List<String> lineas = new ArrayList<>();
        
        while (linea != null){
            lineas.add(linea);
            linea = br.readLine();
        }
        System.out.println(lineas.toString());
    }
    
    // Excepciones personalizadas
    public static void lanzaExcepciones() {
        divideEntre0();
    }

    private static void divideEntre0() {
        int n1 = 3;
        int n2 = 0;
        int resultado = n1/n2;
        System.out.println("El resultado es " + resultado);
    }
    
    // Excepciones NO Verificadas. No obliga a try() catch().
    // Pero se puede añadir 'throws'.
    public static int leeNumeros(){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int num = scan.nextInt();
        System.out.println("Has introducido el número " + num);
        return num;
    }
    
    // Excepciones Personalizadas. 
    public void lanzaExcepcionPersonalizada() {
        
    }
}
