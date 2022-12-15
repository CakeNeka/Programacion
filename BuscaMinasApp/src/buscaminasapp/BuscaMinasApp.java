package buscaminasapp;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscaMinasApp {
    
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    static int rows = 9;
    static int cols = 9;
    


    public static void main(String[] args) 
    {
        mainLoop();
    }
    
    static char[][] generateTable(int bombs,int row, int col)
    {
        char[][] result = new char[rows][cols];
        for (int i = 0; i < result.length; i++) 
        {
            for (int j = 0; j < result[i].length; j++)
                result[i][j] = 'O';
        }
        
        for (int i = 0; i < bombs; i++) 
        {
            int randRow, randCol;
            do
            {
                randRow = random.nextInt(rows);
                randCol = random.nextInt(cols);
            }while(result[randRow][randCol] == 'X');
            
            result[randRow][randCol] = 'X';
        }
        if (result[row][col] == 'X')
            return generateTable(bombs,row,col);
        else
            return result;
    }
    
    private static int[][] generateAround(char[][] table) 
    {
        
        int[][] around = new int[cols][rows];
        int bombsAround;
        for (int i = 0; i < around.length; i++) 
        {
            for (int j = 0; j < around[i].length; j++) 
            {
                bombsAround = 0;
                char[] curSquare = getCharSq(table,i,j);
                for (char c : curSquare) 
                {
                    if (c == 'X')
                        bombsAround++;
                }
                
                around[i][j] = bombsAround;
            }
        }
        return around;
    }
    

    
    static void mainLoop()
    {
        char[][] table;
        int[][] around;
        char[][] user;
        
        int row;
        int col;
        int dif = -1;
        int gameOver = 0;
        int turns = 0;
        user = new char[rows][cols];
        for (int i = 0; i < user.length; i++)
            Arrays.fill(user[i] , '%');
        
        while(dif < 0 || dif >= rows*cols)
        {
            System.out.println("Dificultad (nº de bombas)");
            System.out.print(">>");
            dif = scan.nextInt();
        }
        System.out.println("Fila:");
        System.out.print(">>");
        row = scan.nextInt();
        System.out.println("Columna:");
        System.out.print(">>");
        col = scan.nextInt();
        table = generateTable(dif, row, col);
        around = generateAround(table);
        while(gameOver == 0)
        {            
            if (turns > 0) {
                printArr(user);
                System.out.println("Fila:");
                System.out.print(">>");
                row = scan.nextInt();
                System.out.println("Columna:");
                System.out.print(">>");
                col = scan.nextInt();
            }
            
            turns++;
            if (table[row][col] == 'X')
            {
                gameOver = -1;
            }
            else
            {
                uncover(user,around,row,col,-1,-1);
            }
        }
        printArr(table);
    }
 
    public static void uncover(char[][] user, int[][] around, int row, int col, int originRow, int originCol)
    {
        printArr(user);
        user[row][col] = (char) (around[row][col] + 48);

        if (around[row][col] == 0)
        {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (row+i < 0 || row+i >8 || col +j < 0 || col +j > 8 || (i == 0 && j == 0))
                        return;
                        
                    uncover(user, around, row+i, col+j,0,0);

                }
            }

        }
    }
    
    public static char[] getCharSq(char[][] table, int row, int col)
    {
        char[] result = new char[8];
        Arrays.fill(result, 'O');
        
        if (col > 0 && col < 8)
        {
            //en el cuadrado interior
            if(row > 0 && row < 8)
            {
                result[0] = table[row - 1][col - 1];
                result[1] = table[row - 1][col];
                result[2] = table[row - 1][col + 1];

                result[3] = table[row][col - 1];
                result[4] = table[row][col + 1];

                result[5] = table[row + 1][col - 1];
                result[6] = table[row + 1][col];
                result[7] = table[row + 1][col + 1];
            }
            
            //en el borde norte
            else if (row == 0)
            {
                result[3] = table[row][col - 1];
                result[4] = table[row][col + 1];

                result[5] = table[row + 1][col - 1];
                result[6] = table[row + 1][col];
                result[7] = table[row + 1][col + 1];
            }
            
            //en el borde sur
            else if (row==8)
            {
                result[0] = table[row - 1][col - 1];
                result[1] = table[row-1][col];
                result[2] = table[row - 1][col + 1];

                result[3] = table[row][col - 1];
                result[4] = table[row][col + 1];
            }
        }
        
        else if(row > 0 && row < 8)
        {
            //en el borde oeste
            if (col == 0)
            {
                result[1] = table[row-1][col];
                result[2] = table[row - 1][col + 1];

                result[4] = table[row][col + 1];

                result[6] = table[row + 1][col];
                result[7] = table[row + 1][col + 1];
            }
            
            //en el borde este
            else if(col == 8)
            {
                result[0] = table[row - 1][col - 1];
                result[1] = table[row-1][col];

                result[3] = table[row][col - 1];

                result[5] = table[row + 1][col - 1];
                result[6] = table[row + 1][col];
            }
        }
        
        //en la esquina noroeste
        else if(col == 0 && row == 0)
        {
            result[4] = table[row][col + 1];
            result[6] = table[row + 1][col];
            result[7] = table[row + 1][col + 1];
        }
        
        //en la esquina noreste
        else if(col == 8 && row == 0)
        {
            result[3] = table[row][col - 1];
            result[5] = table[row + 1][col - 1];
            result[6] = table[row + 1][col];
        }
        
        //en la esquina suroeste
        else if(col == 0 && row == 8)
        {
            result[1] = table[row-1][col];
            result[2] = table[row - 1][col + 1];
            result[4] = table[row][col + 1];
        }
        
        //en la esquina sureste
        else if(col == 8 && row == 8)
        {
            result[0] = table[row - 1][col - 1];
            result[1] = table[row-1][col];
            result[3] = table[row][col - 1];
        }
        return result;
    }
    
    public static void printArr(char[][] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = 0; j < arr[i].length; j++) 
            {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
    
    public static void printArr(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = 0; j < arr[i].length; j++) 
            {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}
