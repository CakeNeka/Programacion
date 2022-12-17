/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku_siu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NK
 */
public class Sudoku_SIU { 

    /**
     * @param args the command line arguments
     */
    static Random random = new Random();
    static Scanner scan = new Scanner(System.in);
    

    // Genera Sudoku
    public static int[][] generateSudoku()
    {
        int[][] sudoku = new int[9][9];
        
        while(!isSudoku(sudoku))
        {
            sudoku = new int[9][9];
            sudoku = generate(sudoku);
        }
        
        return sudoku;
    }
    
    static int[][] generate(int[][] table)
    {
        boolean correctRow = false;
        long loopCount = 0;
        
        for (int i = 0; i < table.length; i++) 
        {
            correctRow = false;
            while(!correctRow && loopCount < 1_500_000) //Si loopcount > 1.5 millones
            {                                           //deja de intentar generar
                loopCount++;
                fillRow(table[i]);
                correctRow = true;
                for (int j = 0; j < table[i].length; j++) 
                {
                    int[] visible = getVisible(table,i,j);
                    Arrays.sort(visible);
                    if(Arrays.binarySearch(visible,table[i][j]) >= 0)
                        correctRow = false;

                } 
            }
            //fila completada
        }      
        return table;
    }
    
    // muestra la tabla
    public static void displayTable(int[][] table) 
    {       
        for (int i = 0; i < table.length; i++) 
        {
            for (int j = 0; j < table[i].length; j++) 
            {
                System.out.print("|" + table[i][j]);
            }
            System.out.println("|");
        }
    }
    
    // llena fila con números aleatorios que no se repiten
    static void fillRow(int[] arr)
    {
        ArrayList<Integer> nums = 
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        
        for (int i = 0; i < arr.length; i++)
            arr[i] = nums.remove(random.nextInt(nums.size()));   
        
    }
    
    // devuelve números visibles para numero (en fila, columna o cuadrado)
    static int[] getVisible(int[][] table, int row, int col)
    {
        int[] result = new int[24];
        ArrayList<Integer> visible = new ArrayList<>();
        
        //visibles en su fila
        for (int i = 0; i < 9; i++) 
        {
            if (i != col)
                visible.add(table[row][i]);
        }
        
        //visibles en su columna
        for (int i = 0; i < 9; i++) 
        {
            if (i != row)
                visible.add(table[i][col]);
        }
        
        //visibles en cuadrado:
        //coordenadas de cuadrado:
        int sqRow;
        int sqCol;
        
        if (row < 3)
            sqRow = 0;
        else if (row < 6)
            sqRow = 1;
        else
            sqRow = 2;
        
        if (col < 3)
            sqCol = 0;
        else if (col < 6)
            sqCol = 1;
        else
            sqCol = 2;
        
        int[] square = getSquare(table,sqRow,sqCol);                // el numero con el que estamos trabajando
        Arrays.sort(square);                                        // estará al menos 1 vez en el array square
        square[Arrays.binarySearch(square,table[row][col])] = 0;    // lo igualo a 0 para que no se tenga en cuenta
        Arrays.sort(square);                                        // en los números visibles
        
        //copiar números del cuadrado a números visibles
        for (int i = 1; i < square.length; i++) 
            visible.add(square[i]);
        
        //copiar ArrayList a Array:
        for (int i = 0; i < visible.size(); i++)
            result[i] = visible.get(i);
        
        
        return result;
    }
    
    // numeros en el cuadrado indicado
    static int[] getSquare(int[][] table, int row, int col)
    {
        row *= 3;
        col *= 3;
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = row; i < row + 3; i++) 
        {
            for (int j = col; j < col + 3; j++) 
            {
                res.add(table[i][j]);
            }
        }
        
        int[] arrResult = new int[res.size()];
        for (int i = 0 ; i < res.size() ; i++)
            arrResult[i] = res.get(i);
        
        return arrResult;
    }
    
    // comprueba si una tabla es o no un sudoku
    static boolean isSudoku(int[][] table)
    {
        boolean isSudoku = true;
        for (int i = 0; i < table.length; i++) 
        {
            for (int j = 0; j < table[i].length; j++) 
            {
                    int[] visible = getVisible(table,i,j);
                    Arrays.sort(visible);
                    if(Arrays.binarySearch(visible,table[i][j]) >= 0)
                        isSudoku = false;
            }
        }
        
        return isSudoku;
    }
}
