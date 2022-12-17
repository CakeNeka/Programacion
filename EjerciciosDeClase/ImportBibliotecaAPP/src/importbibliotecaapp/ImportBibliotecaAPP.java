/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importbibliotecaapp;

import acm.program.ConsoleProgram;

public class ImportBibliotecaAPP extends ConsoleProgram {

    
    @Override
    public void run()
    {
        println("Hola Leo");
        int n1 = readInt("Introduce n1: ");
        int n2 = readInt("Introduce n2: ");
        int total = n1 + n2;
        println("El Total Es: " + total);
    }
    
    public static void main(String[] args) 
    {
        BouncingBall.main(args);
    }
    

}
