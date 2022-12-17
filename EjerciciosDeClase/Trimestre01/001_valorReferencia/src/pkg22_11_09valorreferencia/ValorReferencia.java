/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg22_11_09valorreferencia;

import java.util.Arrays;

/**
 * 
 * 
 */
public class ValorReferencia {

    public static void main(String[] args) 
    {
//        String Nombre1 = "Jorge Javier Vázquez";
//        String Nombre2 = "Belen Esteban";
//        swap(Nombre1,Nombre2);
//        System.out.println(Nombre1 + " " + Nombre2);
//        
//        Integer num1 = 3;
//        Integer num2 = 4;
//        swap(num1,num2);
//        System.out.println(num1 + " " + num2);
//        incremento(num1);
//        System.out.println(num1);
//        int[] edades = {23,23,45,6,778,8,Integer.MAX_VALUE};
//        System.out.println(Arrays.toString(edades));
//        incrementos(edades);
//        System.out.println(Arrays.toString(edades));
        int[] visits = {321, 2, 4, 32, 2, 536, 12, 2, -21};
        System.out.println(Arrays.toString(visits));
        bubbleSort(visits);
        System.out.println(Arrays.toString(visits));
    }
    

    
    public static void bubbleSort(int[] arr)
    {
        boolean check = true;
        while(check)
        {
            check = false;
            for (int i = 0; i < arr.length-1; i++) 
            {
                if(arr[i] > arr[i+1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    check = true;
                }
            }
        }
    }
    
    public static void binarySearch(int[] arr, int key)
    {
        int first = 0;
        int last = arr.length;
        int mid;
        while(first < last)
        {
            mid = (first + last)/2;
            
            if(key<arr[mid])
            {
                first = mid + 1;
            }
            else if(key == arr[mid])
            {
                System.out.println("Found " + key +  " at index " + mid);
            }
            else
            {
                last = mid - 1;
            }
            
        }
    }
    
    
    
    //NO INTERESA: 
    public static void incremento(Integer i) //NO funcionan así los Integer
    {
        i++;
    }
    
    public static void incrementos(int[] arr)
    {
        arr[0] = 1;         //bof
        for (int i = 0; i < arr.length; i++) {
            arr[i]++ ;
        }
    }
        
    public static void swap(Integer i ,Integer j)
    {
        int temp = i;
        i = j;
        j = temp;
    }
    
    public static void swap(String i ,String j)
    {
        String temp = new String(i);
        i.replace(i, j);
        j.replace(j, temp);
        
    }
}
