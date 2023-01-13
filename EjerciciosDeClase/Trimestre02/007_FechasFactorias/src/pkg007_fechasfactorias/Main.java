package pkg007_fechasfactorias;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Diurno Fecha: 11/01/2023
 */
public class Main {

    public static void main(String[] args) {
        Date d = Date.generateDate(29, 2, 2000);
        System.out.println(d);

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
