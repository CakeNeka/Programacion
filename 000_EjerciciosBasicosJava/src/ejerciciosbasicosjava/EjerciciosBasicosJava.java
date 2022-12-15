/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosbasicosjava;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Diurno
 */
public class EjerciciosBasicosJava {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) 
    {
        //ejercicio1_1();
        //ejercicio1_2();
        //ejercicio1_4();
        //ejercicio1_5();
        //ejercicio1_6();
        //ejercicio1_8();
        //ejercicio1_9();
        //ejercicio1_10();
        //ejercicio1_11();
        //ejercicio1_14();
        ejercicio1_16();
        //ejercicio2_1()
        //ejercicio2_9();
        //ejercicio2_12();
        //ejercicio2_14();
        //ejercicio2_15();
        //ejercicio3_3();
        //ejercicio3_6(); 
        //ejercicio4_9();
        
    }
    
    //EJERCICIO 1 (Ecuación 2 grado)
    static void ejercicio1_1()
    {
        //pide los 3 números
        System.out.print("Introduce el primer número: ");
        int a = input.nextInt();
        System.out.print("Introduce el segundo número: ");
        int b = input.nextInt();
        System.out.print("Introduce el tercer número: ");
        int c = input.nextInt();
        
        double sqrt = Math.pow(b, 2)-4*a*c;
        if (sqrt < 0 || a == 0)
        {
            System.out.println("ERROR: la ecuación no tiene soluciones reales");
            return;
        }
            
        double sol1 = (-b + Math.sqrt(sqrt)) / 2 * a;
        double sol2 = (-b - Math.sqrt(sqrt)) / 2 * a;
        
        System.out.println("Primera solución: " + sol1);
        System.out.println("Segunda solución: " + sol2);
    }
    
    /* EJERCICIO 2  área de un círculo*/
    static void ejercicio1_2()
    {
        System.out.print("Introduce el radio de un círculo ");
        double rad = input.nextDouble();
        if (rad < 0 )
        {
            System.out.println("El radio no puede ser negativo");
            return;
        }
        
        double area = Math.PI * rad * rad;
        System.out.print("El área del círculo es " + area);
    }
    
    /*EJERCICIO 3 igualdad de dos números*/
    static void ejercicio1_4( )
    {
        System.out.println("Introduce el primer número entero: ");
        int a = input.nextInt();
        input.nextLine();
        System.out.println("Introduce el segundo número entero: ");
        int b = input.nextInt();
        input.nextLine();

        if (a == b)
            System.out.println("Los dos números son iguales");
        else
            System.out.println("Los números no son iguales");
    }
    
    /*EJERCICIO 1.5*/
    static void ejercicio1_5()
    {
        System.out.println("Introduce un número entero: ");
        int n = input.nextInt();
        if (n < 0)
            System.out.println("EL NÚMERO ES NEGATIVO");
        else
            System.out.println("El número es positivo");
    }
    
    /*EJERCICIO 1.6 */
    static void ejercicio1_6()
    {
        System.out.print("Introduce un número entero: ");
        int a = input.nextInt();
        input.nextLine();
        System.out.print("Introduce otro número entero: ");
        int b = input.nextInt();
        input.nextLine();
        
        String output = a + " NO es múltiplo de " + b + "\n"    ;
        if (a % b == 0)
            output = a + " es múltiplo de " + b + "\n";
        System.out.print(output);
    }
    
    /*EJERCICIO 1.8 */
    static void ejercicio1_8()
    {
        System.out.print("Introduce un número entero: ");
        int a = input.nextInt();
        input.nextLine();
        System.out.print("Introduce otro número entero: ");
        int b = input.nextInt();
        input.nextLine();
        
        while (a == b) 
        {
            System.out.println("Los dos números son iguales");
            System.out.print("Introduce un número entero: ");
            a = input.nextInt();
            input.nextLine();
            System.out.print("Introduce otro número entero: ");
            b = input.nextInt();
            input.nextLine();

        }
        
        System.out.printf("%d es mayor que %d" ,Math.max(a, b),Math.min(a, b));
    }
    
    /*EJERCICIO 1.9*/
    static void ejercicio1_9()  //es igual que el anterior
    {
        System.out.print("Introduce un número entero: ");
        int a = input.nextInt();
        input.nextLine();
        System.out.print("Introduce otro número entero: ");
        int b = input.nextInt();
        input.nextLine();
        
        while (a == b)
        {
            System.out.println("Los números son iguales");
            System.out.print("Introduce un número entero: ");
            a = input.nextInt();
            input.nextLine();
            System.out.print("Introduce otro número entero: ");
            b = input.nextInt();
            input.nextLine();
        }
        
        int max = a>b ? a : b;
        int min = max == a ? b: a;
        
        System.out.printf("%d , %d" , max , min);
    }
    
    static void ejercicio1_10()
    {
        int[] nums = new int[3];
        
        System.out.print("Introduce un número entero: ");
        nums[0] = input.nextInt();
        input.nextLine();
        
        System.out.print("Introduce otro número entero: ");
        nums[1] = input.nextInt();
        input.nextLine();
        
        System.out.print("Introduce otro número entero: ");
        nums[2] = input.nextInt();
        input.nextLine();
        
        Arrays.sort(nums);
        for (int i : nums)
            System.out.print(String.valueOf(i) + ",");
    }
    
    /*EJERCICIO 1.11*/
    static void ejercicio1_11()
    {
        System.out.print("Introduce un número entre 0 y 9.999: ");
        float num = input.nextFloat();
        input.nextLine();
        
        while (num < 0 || num > 9.999)
        {
            System.out.println("El número introducido no es correcto");
            System.out.print("Introduce un número entre 0 y 9.999: ");
            num = input.nextFloat();
            input.nextLine();
        }
        
        String strNum = String.valueOf(num);
        int stringLength = strNum.length();
        
        int i = strNum.indexOf('.');
        String decimalPlaces = strNum.substring(i + 1); //string con los números después del punto
        int digitNumber;
        
        if(decimalPlaces.length() == 1)
            digitNumber = stringLength - 2 ;

        else
            digitNumber = stringLength - 1;

        System.out.printf("El número tiene %d cifras \n" , digitNumber);
    }
    
    /*EJERCICIO 1.14*/
    static void ejercicio1_14()
    {
        System.out.print("Introduce una nota de 0 a 10: ");
        byte grade = input.nextByte();
        input.nextLine();
        /* comprobamos si la entrada es correcta */
        while (grade < 0 || grade > 10) 
        {
            System.out.println("La nota introducida no es válida");
            System.out.print("Introduce una nota de 0 a 10: ");
            grade = input.nextByte();
            input.nextLine();
        }
        
        /* comprobamos el tipo de nota*/
        if (grade < 5)
            System.out.println("INSUFICIENTE");
        
        else if (grade == 5)
            System.out.println("SUFICIENTE");
        
        else if (grade == 6)
            System.out.println("BIEN");
        
        else if (grade < 9)
            System.out.println("NOTABLE");
        
        else if (grade <= 10)
            System.out.println("SOBRESALIENTE");
        
    }
    
    /*EJERCICIO 1.16 (contiene también los ejercicios 15,17,18)  */
    static void ejercicio1_16() 
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
        
        boolean isLeap;                   //será verdadero si el año es bisiesto
        boolean correctDate = true;
        
        /*COMPROBACIÓN DE AÑO BISIESTO: */ 
        
        isLeap = (year % 4 == 0 && !(year % 100 == 0)) || (year % 4 == 0 && year % 400 == 0);
        // un año divisible por 4 y no divisible por 400 es bisiesto
        // un año divisible por 4, 100 y no divisible por 400 NO es bisiesto
        // un año divisible por 4, por 100 y por 400 es bisiesto

        
        /*COMPROBACIÓN DEL NÚMERO DE DIAS */
        byte[] dayMonths = {31,28,31,30,31,30,31,31,30,31,30,31}; //array con los días de cada mes
        
        if (isLeap)
            dayMonths[1] = 29;          //si es bisiesto febrero tendrá 29 días
        
                /*COMPROBACIÓN DEL MES */

        if(month<0 || month >12)        
        {
            correctDate = false;
        }
        else if(day < 1 || day > dayMonths[month-1] )
        {
            correctDate = false;
        }
        
        if (correctDate)
            System.out.printf("La fecha %s-%s-%s es correcta \n", day, month, year);
        else
            System.out.printf("La fecha %s-%s-%s NO es correcta \n", day, month, year);
        
   }
    
    static void ejercicio2_1()
    {
        System.out.print("Introduce un número entero: ");
        int num = input.nextInt();
        input.nextLine();
        
        while (num > 0)
        {
            System.out.printf("El cuadrado de %d es %d\n",num, num*num);
            
            System.out.print("Introduce un número entero: ");
            num = input.nextInt();
            input.nextLine();
        }
        System.out.println("El número es negativo");
    }
    
    static void ejercicio2_9() //Escribir todos los números del 100 al 0 de 7 en 7.
    {
        for (int i = 100; i > 0; i-=7) 
        {
            System.out.println(i);   
        }
    }
    
    static void ejercicio2_12() //2. 12. Pedir un número y calcular su factorial.
    {
        System.out.print("Introduce un número entero: ");
        int num = input.nextInt();
        input.nextLine();
        if (num > 0) 
        {
            long res = 1;
            for (int i = 1; i <= num; i++)
                res *= i;
            

            System.out.printf("El factorial de %d es %d \n", num, res);
        }
        else
        {
            System.out.println("No puedo realizar el factorial de un número negativo");
        }   

    }
    
    static void ejercicio2_14()
    {
        float[] salaries = new float[10];
        float sum = 0f;
        int  overThousand = 0;
                
        for (int i = 0; i < 10; i++)
        {
            System.out.printf("Introduce el salario nº %d: ",i + 1);
            salaries[i] = input.nextFloat();
            input.nextLine();
            
            sum += salaries[i];
            if (salaries[i] > 1000)
                overThousand++;
        }
        
        System.out.printf("La suma de todos los sueldos es %.2f y hay %d sueldos"
                + " mayores a 1000€.\n", sum , overThousand);
    }
    
    /*EJERCICIO 2.15*/
    static void ejercicio2_15()
    {
        int[][] alumnos = new int[2][5];
        int adults = 0;
        int talls = 0;
        
        float ageMean = 0;
        float heightMean = 0;
        
        for (int i = 0 ; i < 5; i ++)
        {
            /* EDAD */
            System.out.printf("\nIntroduce la edad del alumno nº %d: ",i);
            alumnos[0][i] = input.nextInt();
            input.nextLine();
            ageMean += alumnos[0][i];
            if(alumnos[0][i] >= 18)
                adults++;
            
            /* ALTURA */
            System.out.printf("\nIntroduce la altura en centimetros del alumno nº %d: ",i);
            alumnos[1][i] = input.nextInt();
            input.nextLine();
            heightMean += alumnos[1][i];
            if (alumnos[1][i] > 175)
                talls++;
        }
        
        ageMean /= 5;
        heightMean /= 5;
        
        System.out.printf("La edad media es %.2f y la estatura media es %.2f",
                ageMean, heightMean);
        System.out.printf("\nHay %d alumnos mayores de edad y %d alumnos que miden"
                + " más de 175 centímetros\n", adults, talls);
        
    }
    
    
    static void ejercicio3_3() //Diseña una aplicación que muestre las tablas de multiplicar del 1 al 10.
    {
        for (int i = 0; i <= 10; i++)
        {
            //tabla del i:
            System.out.println("\nTabla del " + i);
            for(int j = 0; j<=10;j++)
            {
                System.out.printf("%d x %d = %d\n", i , j , i*j);
            }
        }
    }
    
    static void ejercicio3_6() //Realizar un programa que nos pida un número n, 
    {                          //y nos diga cuantos números hay entre 1 y n que son primos.
        System.out.print("Introduce un número entero: ");
        int num = input.nextInt();
        input.nextLine();
        
        int count = 0;
        for(int i = 1; i <= num; i++)
        {
            if (isPrime(i))
                count++;
        }
        System.out.printf("Hay %d números primos entre 1 y %d" , count , num);
    }
    static boolean isPrime(int num)
    { 
        if (num == 2)
            return true;
        if (num <2)
            return false;
        
        int max = (int) Math.ceil(Math.sqrt(num));  //no es necesario comprobar todos los números hasta num para ver si es primo
                                                    //
        for (int i = 2 ; i <= max;i++)
        {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    
    /*EJERCICIO 4.9*/
    static void ejercicio4_9() //4. 9. Crear un programa que lea por teclado una tabla de 10 números enteros y la desplace 
    {        //una posición hacia abajo: el primero pasa a ser el segundo, el segundo pasa a ser el tercero y así sucesivamente. El último pasa a ser el primero.
        int[] tabla = new int[10];
        System.out.print("Introduce 10 números enteros separados por espacios: ");
        for (int i = 1; i<10 ; i++)
            tabla[i] = input.nextInt();
        tabla[0] = input.nextInt();
        
        //mostrar array:
        for (int i = 0; i<tabla.length;i++)
            System.out.print(tabla[i] + ", ");
    }
    
    
    
}
