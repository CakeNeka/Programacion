/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringapp;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Problem {
    
    static Scanner scan = new Scanner(System.in);
    
    public static void cesar()
    {
        System.out.println("Introduce texto");
        String input = scan.nextLine();
        char[] arr = input.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] += 1;
        }
        System.out.println(String.valueOf(arr));
    }
}
