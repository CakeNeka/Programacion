package pkg010_ejerciciofechasfactoriasexcepciones;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Diurno Fecha: 11/01/2023
 */
public class Main {

    public static void main(String[] args) {
        /*
        Date d = Date.generateDate(1, 1, 2023);
        System.out.println(d);
        
        
        long time = System.currentTimeMillis();
        d.sumaDias(40_000_000);
        time = System.currentTimeMillis() - time;
        System.out.println(time + " ms");
        System.out.println(d);
        */
        Date d = Date.generateDate(1, 1, 2023);
        long time = System.currentTimeMillis();
        d.alterSumaDias(40_000_000);
        time = System.currentTimeMillis() - time;
        System.out.println(d + " " + time + "ms");
        
        d = Date.generateDate(1, 1, 2023);
        time = System.currentTimeMillis();
        d.sumaDias(40_000_000);
        time = System.currentTimeMillis() - time;
        System.out.println(d + " " + time + "ms");
        
        
        /*
        Date.dateIsCorrect(d);
        System.out.println(d);
        d.sumaDias(400);
        System.out.println(d);
        d.restaDias(400);
        System.out.println(d);
         */
    }
    
    
}
