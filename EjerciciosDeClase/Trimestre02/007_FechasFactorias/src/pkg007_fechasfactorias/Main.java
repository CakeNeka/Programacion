package pkg007_fechasfactorias;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Diurno Fecha: 11/01/2023
 */
public class Main {

    public static void main(String[] args) {
        Date d = Date.generateDate(1, 1, 2023);
        System.out.println(d);
        
        long time = System.currentTimeMillis();
        d.sumaDias(1_000_000_000);
        d.restaDias(1_000_000_000);
        time = System.currentTimeMillis() - time;
        System.out.println(time + " ms");
        

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
