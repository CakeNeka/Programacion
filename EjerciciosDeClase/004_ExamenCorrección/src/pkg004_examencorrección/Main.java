/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg004_examencorrección;

/**
 *
 * @author Diurno
 */
public class Main {

    public static void main(String[] args) {

        sacaValores();
        restaurante();

    }

    // 1 pto
//     sacaValores
    public static void restaurante() {
        int numMesas = pideNumMesas();
//        int[] mesas = generaMesas(numMesas);
//        System.out.println(Arrays.toString(mesas));
//        byte comensales = pidecomensales();
//        int numMesa = asignaMesa (mesas, comensales);
//        if (numMesa != -1) System.out.printf("Mesa número %d asignada. ", numMesa);
//        else System.out.println("Lo sentimos, no hemos encontrado mesa");
    }

    public static int pideNumMesas() {
        return 2;
    }

    public static int sdsdf(int[] mesas, byte comensales) {
        
        int i = 0;
        final byte ocupTotal = 4;
        int asientosLibres = -1;
        boolean salir = false;
        int mesaAsignada = -1;
        
        while(!salir && i < mesas.length){
            if (mesas[i] == 0){
                mesaAsignada = 1;
                salir = true;
            } else{
                asientosLibres = ocupTotal - (mesas[i] + comensales);
            }
            i++;
        }
        
        
    }
}
