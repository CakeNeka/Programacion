/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21_10_ejercicios;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Diurno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static Scanner teclado = new Scanner(System.in);
    
    
    public static void main(String[] args) 
    {
        /*
        int input = Integer.parseInt(JOptionPane.showInputDialog(null,"numero: "));
        double[] inputArray = new double[input];
        for (int i = 0; i < input; i++) 
        {
            inputArray[i] = Double.parseDouble(JOptionPane.
                    showInputDialog(null, "Introduce el número " + (i+1) + ":"));
        }
        
        System.out.println(recursiveMultNums(inputArray,inputArray.length-1));
        */
        
        int input = Integer.parseInt(JOptionPane.showInputDialog(null,"numero: "));
        double[] inputArray = new double[input];
        for (int i = 0; i < input; i++) 
        {
            inputArray[i] = Double.parseDouble(JOptionPane.
                    showInputDialog(null, "Introduce el número " + (i+1) + ":"));
        }
        
        System.out.println("La media es: " + arrayMean(inputArray));
    }
    
    
    
    public static void ejercicio3()
    {
        Scanner teclado = new Scanner(System.in);
        
        int factorial = 1;
        System.out.println("Introduce el número entre 2 y 20");
        int num = teclado.nextInt();
        
        while(num < 2 || num > 20)
        {
            System.out.println("no es correcto");
            System.out.println("Introduce un número  entre 2 y 20");
            num = teclado.nextInt();
        }
        
        for (int i = 2; i <= num; i++)
            factorial *= i;
        
        System.out.println(factorial);
    }   
        
    public static void piedraPapelTijera()
    {
        byte won = 0;
        while(won == 0)
        {
            byte aiInput = (byte)ThreadLocalRandom.current().nextInt(1, 4);
            System.out.println("(1)Piedra (2)Papel (3)Tijera");
            byte playerInput = teclado.nextByte();
            String strAiInput;
            
            switch(aiInput)
            {
                case 1:
                    strAiInput = "Piedra";
                    break;
                case 2:
                    strAiInput = "Papel";
                    break;
                case 3:
                    strAiInput = "Tijera";
                    break;
                default:
                    strAiInput = "Cabras";
                    break;
            }
            System.out.println("La máquina ha lanzado " + strAiInput );
            
            
            won = wins(playerInput, aiInput);   
            if (won == 0)
                System.out.println("Empate!");
        }
        
        if (won == 1) System.out.println("Has Ganado!!");
        if (won == 2) System.out.println("Has perdido");
        
    }
    static byte wins(byte playerChoice,byte aiChoice) //
    {
        switch(playerChoice)
        {
            case 1: 
                if (aiChoice == 1) return 0;
                if (aiChoice == 2) return 2;
                if (aiChoice == 3) return 1;
                break;
            case 2:
                if (aiChoice == 1) return 1;
                if (aiChoice == 2) return 0;
                if (aiChoice == 3) return 2;
                break;
            case 3:
                if (aiChoice == 1) return 2;
                if (aiChoice == 2) return 1;
                if (aiChoice == 3) return 0;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        
        return 1;                                   //(1)Player wins (2)IA wins
    }                                               //(0)No one wins
    
    public static double mult3Double()
    {
        double doble1 = Double.parseDouble(JOptionPane.showInputDialog(null, "numero: "));
        double doble2 = Double.parseDouble(JOptionPane.showInputDialog(null, "numero: "));
        double doble3 = Double.parseDouble(JOptionPane.showInputDialog(null, "numero: "));
        
        return doble1 * doble2 * doble3;
    }
    
    public static double multnNums(byte input)
    {
        double result = 1;
        double in;
        for (int i = 0; i < input; i++) 
        {
            result *= Double.parseDouble(JOptionPane.
                    showInputDialog(null, "number " + (i + 1)+ ": "));
        }
        return result;
    }
    
    public static double multnNums2(double[] inputArr, int j)
    {
        int result = 1;
        for (int i = 0; i < inputArr.length; i++) 
        {
            result *= inputArr[i];
        }
        return result;
    }
    
    public static double recursiveMultNums(double[] inputArr, int n1) //n1 should be length of array
    {
        if (n1 == 0)
            return inputArr[n1];
        else
            return inputArr[n1] * recursiveMultNums(inputArr , n1-1);
    }
    
    public static boolean esMultiplode(int max, int min)
    {
        return max % min == 0;
    }
    
    public static double arrayMean(double[] inputArr)
    {
        double suma = 0;
        for (int i = 0; i < inputArr.length; i++)
            suma += inputArr[i];
        return suma/inputArr.length;
    }
    
    
}