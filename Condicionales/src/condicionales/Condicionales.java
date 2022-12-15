/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condicionales;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Diurno
 */
public class Condicionales {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) 
    {
        
        
    }

    static void tardeDomingo()
    {
        byte age = 18;
        float money = 20f;
        boolean avatar = true;
        final float[] precios = {20 , 3 , 8 , 10 , 2.5f};
        
        String input;
        
        input = JOptionPane.showInputDialog("tratas de entrar a la dicoteca \n¿Qué edad tienes?");
        age = Byte.parseByte(input);
        input = JOptionPane.showInputDialog("¿Cuanto dinero tienes?");
        money = (float)Double.parseDouble(input);
        float initialMoney = money;
        
        //discoloop
        if (age >= 18 && money > precios[0])
        {
            money -= precios[0];
            
            JOptionPane.showMessageDialog(null , "Accedes a la discoteca" );
             
            if (money > precios[1])
            {
                JOptionPane.showMessageDialog(null , "Te compras una coca cola por " + precios[1] + " euros" );
                money -= precios[1];
            }
                
            
            JOptionPane.showMessageDialog(null , "¡OSTRAS! el tiburón fiestero\n"
                    + "Bailas Tiburón Fiestero a todo gas hasta el amanecer" );
            JOptionPane.showMessageDialog(null , "Accedes a tener sexo" );
        }
        //casaLoop

        //cinemaloop
        else
        {
            if (money < precios[0] && age >= 18)
                JOptionPane.showMessageDialog(null , "No puedes entrar a la discoteca"
                        + " porque no tienes dinero\nDecides ir al cine" );
            if (age < 18)
                JOptionPane.showMessageDialog(null , "No puedes entrar a la discoteca"
                        + " porque eres menor\nDecides ir al cine" );
                
            byte randomAvatar = (byte)Math.round(Math.random());
            //ThreadLocalRandom.current().nextInt(min,max + 1)
            avatar = randomAvatar == 1;
  
            
            if (avatar && money > precios[2])
            {
                JOptionPane.showMessageDialog(null, "¡que suerte! ponen avatar esta noche");
                if (money > precios[2])
                {
                    JOptionPane.showMessageDialog(null, "Ves avatar y te super encanta");
                    money -= precios[2];
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "¡Vaya! No te queda más dinero\nVuelves a casa llorando");
                }
                
            }
                
            else if (money > precios[3])
            {
                JOptionPane.showMessageDialog(null, "No ponen avatar esta noche, te vas a la bolera");
            }
                
            if (money > precios[4])
            {
                JOptionPane.showMessageDialog(null, "Al finalizar tu actividad, "
                    + "te tomas un helado rosa que sabe a fresa");
                money -= precios[4];
            }
            
            
        }  
        float spent = initialMoney - money;
        JOptionPane.showMessageDialog(null, "al final del día te quedan " + money + " euros\n"
                + "Te has gastado la cantidad salvaje de " + spent + "€, animal");
    }
    
    static void order3(int n1, int n2, int n3)
    {
        String order = "ddf";
        for (int i = 0; i < 3; i++)
        {
            if (n1 >= n2 && n1 >= n3)
            {
                order += Integer.toString(n1) + ", ";
                n1 = Integer.MIN_VALUE;
            }
            else if (n2 >= n1 && n2 >= n3)
            {
                order += Integer.toString(n2) + ", ";
                n2 = Integer.MIN_VALUE;
            }
            else if (n3 >= n1 && n3 >= n2)
            {
                order += Integer.toString(n3) + ", ";
                n3 = Integer.MIN_VALUE;
            }
                
        }
        
        JOptionPane.showMessageDialog(null, order);
    }
    
    static void order3Again(int n1,int n2,int n3)
    {
        if (n1 > n2)
        {
            if (n2 > n3)
                System.out.println(n1 + ", " + n2 + ", " + n3);
            else if (n3 > n1)
                System.out.println(n3 + ", " + n1 + ", " + n2);
            else
                System.out.println(n1 + ", " + n3 + ", " + n2);
        }
        else //n2 > n1
        {
            if (n1 > n3)
                System.out.println(n2 + ", " + n1 + ", " + n3);
            else if (n3 > n2)
                System.out.println(n3 + ", " + n2 + ", " + n1);
            else
                System.out.println(n2 + ", " + n3 + ", " + n1);
        }
    }
    
    
    static void altOrder3(int n1,int n2,int n3)
    {
        int temp;
      /*if (x > y) swap(x, y);
        if (y > z) swap(y, z)
        if (x > y) swap(x, y);*/
        
        if (n1<n2)
        {  
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        if (n2 < n3)
        { 
            temp = n2;
            n2 = n3;
            n3 = temp;
        }
        if (n1 < n2)
        {
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        System.out.println(n1 + ", " + n2 + ", " + n3);
    }

    public static void ejemploSwitch2()
    {
        byte dice = (byte)ThreadLocalRandom.current().nextInt(1,7);
        System.out.println(dice);
        switch (dice)
        {
            case 2:
            case 3:
            case 6: System.out.println("Gano una lámpara");
            break;
            
            case 1:
            case 5: System.out.println("Gano un viaje");
            break;
            
            case 4: System.out.println("Gano un apartamento en Torrevieja");
            break;
            default: System.out.println("ERROR FATAL :(");
            break;
        }
    }
    
    public static void ejemploSwitch3()
    {
        byte month = (byte) ThreadLocalRandom.current().nextInt(1,13);
        System.out.print("El mes " + month + " es: ");
        
        
        
        
        
        switch (month)
        {
            case 1: System.out.println("Enero");
            break;
            case 2: System.out.println("Febrero");
            break;
            case 3: System.out.println("Marzo");
            break;
            case 4: System.out.println("Abril");
            break;
            case 5: System.out.println("Mayo");
            break;
            case 6: System.out.println("Junio");
            break;
            case 7: System.out.println("Julio");
            break;
            case 8: System.out.println("Agosto");
            break;
            case 9: System.out.println("Septiembre");
            break;
            case 10: System.out.println("Octubre");
            break;
            case 11: System.out.println("Noviembre");
            break;
            case 12: System.out.println("Diciembre");
            break;
            
            default: System.out.println("Fatal error :c");
            break;
        }
    }
    
    public static void ejercicioSwitchi()
    {   
        System.out.print("Introduce el día: ");
        byte day = input.nextByte();
        input.nextLine();
        
        System.out.print("Introduce el mes: ");
        byte month = input.nextByte();
        input.nextLine();
        
        System.out.print("Introduce el año: ");
        short year = input.nextShort();
        input.nextLine();
        
        
        
    }
    
    public static void ejercicioE()
    {
        int hoursWorked = 0;
        int salary = 0;
        
        System.out.println("Introduce las horas trabajadas");
        hoursWorked = input.nextInt();
        
        if (hoursWorked > 40)
        {
            salary = 40 * 16;
            hoursWorked -= 40;
            salary +=  hoursWorked * 20;
        }
        else
        {
            salary = hoursWorked * 16;
        }
        System.out.println("El salario obtenido serán " + salary);
    }
    
    /*BUCLES */
    public static void ejer1y2()
    {
        byte i = 10;
        while (i >= 0)
        {
            System.out.println(i);
            i-=2;
        }
        i = 1;
        while (i<10)
        {
            System.out.println(i);
            i += 2;
        }
    }
    
  
    public static void ejercicio3()
    {
        int i;
        do
        {
            System.out.println("Introduce un número entero"); 
            i = input.nextInt();
            input.nextLine();
            System.out.println(i);
        }while(i != 0);
    }
    
    public static void ejercicio4()
    {
        byte num = 1;
        while(num != 4)
        {   
            System.out.println("(1) Beber\n(2) Comer\n(3) Copas\n(4) Salir"); 
            num = input.nextByte();

            
            switch (num) {
                case 1:
                    System.out.println("Bebes");
                    break;
                case 2:
                    System.out.println("Comes");
                    break;
                case 3:
                    System.out.println("Te vas de copas");
                    break;
                case 4:
                    System.out.println("Te vas");
                    
                    break;
                default:
                    System.out.println("Vuelve a introducir un número");
                    break;
            }
            
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
        }
    }

    public static void ejercicio5()
    {
        long num = 0;
        byte i = 0;
        System.out.println("Introduce un número");
        num = input.nextLong();
        input.nextLine();
        
        while(num != 0)
        {
            num /= 10;
            i++;   
        }
        System.out.println("el número tiene " + i + " dígitos");
    }

    public static void ejercicio6() //pedir números al usuario hasta que introduzca un 0
    {                               //decir cuantos de los números introducidos son negativos, cuantos son pares y la suma de todos
        short negatives = 0;
        short evens = 0;
        long sum = 0;
        
        
        int i = -1;
        
        while(i != 0)
        {
            System.out.println("Introduce un número");
            i = input.nextInt();
            input.nextLine();
            
            
            sum += i;
            if (i % 2 == 0)
                evens++;
            if (i < 0)
                negatives++;
        }
        System.out.printf("Has introducido %d numeros negativos %d numeros pares"
                + "\nLa suma de todos los números es:  %d",negatives,evens,sum);
    }
    
    public static void examen()
    {
        boolean encontrado = false;
        byte intentos = 0;
        short secretNum = 50;
        int userIn;
        
        while (!encontrado && intentos<=10)
        {
            System.out.println("introduce numero");
            userIn = input.nextInt();
            
            if (userIn == secretNum)
                encontrado = true;
            intentos++;
        }
    }
    
    public static void count10for()
    {
        System.out.println("1 al 10 con bucle for:");
        for (int i = 1; i<=10;i++)
            System.out.println(i);
    }
    
    public static void count10While()
    {
        System.out.println("\n1 al 10 con bucle while:");
        int i = 1;
        while(i <= 10)
        {
            System.out.println(i);
            i++;
        }
    }
    
    public static void count10doWhile()
    {
        System.out.println("\n1 al 10 con bucle do while:");
        int i = 1;
        do
        {
            i++;
            System.out.println(i);
        }while(i<10);
    }
    public static void countBackFor()
    {
        System.out.println("\n10 al 0 de 2 en 2:");
        for (int i = 10; i >= 0; i-=2)
            System.out.println(i);
    }
    
    public static void countBackWhile()
    {
        int i = 10;
        while (i<0)
        {
            System.out.println(i);
            i-=2;
        }
    }
    

    
    
    
}
