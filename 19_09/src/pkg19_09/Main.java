/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19_09;
import java.util.*;

/**
 *
 * @author YO
 * 
 */
public class Main {

    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    
    public static void main(String[] args) 
    {
        findNumber(rand.nextInt(101));  
        writePiramid(8);
    }
    
    static void findNumber(int numberToFind)
    {
        String userInput = "";
        boolean isNotDigit = true;
        // Entrada del usuario: 
        while(isNotDigit)                                           //Mientras que la entrada no sea correcta:
        {
            System.out.println("Introduce un número");
            userInput = scan.nextLine();
            
            isNotDigit = false;
            for (char c : userInput.toCharArray())                  //comprueba que todos los caracteres sean números
            {
                if (!Character.isDigit(c))
                {
                    System.out.println("El número introducido no es un número");
                    isNotDigit = true;
                    break;
                }
            }
            if (userInput.isEmpty() || userInput.length() > 9)      //el número no puede estar vacio ni  ser demasiado grande
            {
                System.out.println("Introduce un número adecuado por favor");
                isNotDigit = true;
            }
        }
        
        // Comprobaciones: (es correcto, es mayor o es menor)        
        if (Integer.parseInt(userInput) == numberToFind)
        {
            System.out.println("el número es correcto");
            return;                                   		    //si es correcto finaliza la función
        }
        if (Integer.parseInt(userInput) < numberToFind)
            System.out.println("el número a encontrar es mayor");
        if (Integer.parseInt(userInput)> numberToFind)
            System.out.println("el número a encontrar es menor");
        
        findNumber(numberToFind);                                   //recursion salvaje (aunque creo que sería mejor simplemente meterlo en un bucle while)
    }
    
    static void writePiramid(int rows) //hace una pirámide de asteriscos
    {
        int spaces = rows - 1;        //el tema espacios creo que no esta del todo bien hecho
        for (int i = 1; i <= rows + 3; i+=2)
        { 
            String spacesStr = new String(new char[spaces]).replace("\0", " "); // \0 es un caracter nulo
            String repeated = new String(new char[i]).replace("\0", "*"); //repite el caracter '*' i veces
            System.out.println(spacesStr + repeated); 
            spaces--;
        }
    }
    
}  
    //              *  ' '
    //   *          1   3
    //  ***         3   2
    // *****        5   1
    //*******       7   0

