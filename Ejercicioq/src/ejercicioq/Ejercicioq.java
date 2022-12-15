/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioq;

import java.util.ArrayList;
import java.util.Arrays;
    import javax.swing.JOptionPane;

/**
 *
 * @author Diurno
 */
public class Ejercicioq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        trabajoArrays();
    }
    
    public static void ejercicioQ()
    {
        Factura[] facturas = new Factura[2];
        
        
        
        for (int i = 0; i<facturas.length ;i++)
        {
            facturas[i] = new Factura();        
            
            facturas[i].codArticulo = JOptionPane.showInputDialog(null, "introduce"
                    + " el código del artículo nº" + (i+1));
            facturas[i].litrosVendidos = Float.parseFloat(JOptionPane.showInputDialog(null, "introduce"
                    + " la cantidad vendida en litros del artículo " + facturas[i].codArticulo));
            facturas[i].precioPorLitro = Float.parseFloat(JOptionPane.showInputDialog(null, "introduce"
                    + " el precio por litro del artículo " + facturas[i].codArticulo));
        }
        
        //Facturación total:
        float facturacionTotal = 0f;
        for (int i = 0; i< facturas.length;i++)
            facturacionTotal += facturas[i].getPrice();
        
        //Litros vendidos en total
        float litrosTotales = 0f;
        for (int i = 0; i < facturas.length ; i++)
            litrosTotales += facturas[i].litrosVendidos;
        
        //Cuantas se vendieron por más de 1000;
        byte masDeMil = 0;
        for (int i = 0; i< facturas.length; i++)
        {
            if (facturas[i].getPrice() > 1000f)
                masDeMil++;
        }
        
        int i = 0;
        while(i != 4)
        {
            
            i = Integer.parseInt(JOptionPane.showInputDialog(null,"·1- Facturación total\n·2- Litros Totales\n"
            + "·3- Facturas por encima de 1\n·4- Salir del programa"));
            switch(i)
            {
                case 1:
                    JOptionPane.showMessageDialog(null, "La facturación total es " + facturacionTotal);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"En total se han vendido " + litrosTotales + " litros");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Se han hecho " + masDeMil + " ventas de más de 1000 euros");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Introduce un valor adecuado");
            }
        }

    }
    
 
    
    public static void trabajoArrays()
    {
        
        //inicializar un array con 'new'
        int[] tabla1 = new int[3]; //Entre corchetes irá el tamaño máximo del array
        
        
        // Inicializar un array com llaves:
        int[] tabla = {1,2,3,4,5,6}; // se introducen los valores a mano
        
        tabla[0] = 23;               // 
        
        
        
        // Mostrar los elementos guardados en los índices pares 
        // de un array de 10 elementos, llamado numeros y que
        // se inicializará a mano
        
        int[] numeros = {-1, 3, -1, 7, 4, -123, 23451235, 123, -451235, 666, -12, -999};
        
//        for (int i = 1; i < numeros.length; i+=2) 
//        {
//            System.out.println(numeros[i]);
//        }
//        
//        for (int i = 1; i < numeros.length; i++) 
//        {
//            if(numeros[i] < 0)
//                System.out.println(numeros[i]);
//        }
        
        // Recorrer al array anterior y mostramos la suma de aquellos números
        // que sean negativos y cuyo indice sea impar
        int suma = 0;
        for (int i = 1; i < numeros.length; i+=2) 
        {
            if (numeros[i] < 0)
                suma+=numeros[i];
        }
        System.out.println(suma);
    }
}





