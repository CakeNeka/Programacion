/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21_09;
import java.util.*;
/**
 *
 * @author Diurno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ///

        
        /*OPERADORES DE INCREMENTO Y DECREMENTO */
        byte x = 5;
        byte y = x++;
        //System.out.println(x + " " + y);
        
        x = 5;
        y = ++x;
        //System.out.println(x + " " + y);
        
        /*CLASE MATH*/
        
        /*raiz cuadrada*/
        x = 25;
        
        
        
        //Truncar un número
        double d = 3.72123;    
        x = (byte)d;                                        //trunca a entero
        float f = (float) Math.floor(1.26 * 100) / 100 ;     //trunca a n cifras decimales
                
                
        /*POTENCIA*/
        double base = 5, exponente = 3;
        double potencia = Math.pow(base, exponente);
        
        /*REDONDEAR*/
        double num3 = 4.38;
        float redondeo = Math.round(num3 * 10) / 10 ; //redondear a n cifras decimales
        System.out.println(redondeo);            
        
        //número aleatorio
        int aleatorio = (int) (Math.random() * 22 + 10);
        
    }
    
 //1,734
    //2 --> redonear
    //1 --> truncar
    
    
}
