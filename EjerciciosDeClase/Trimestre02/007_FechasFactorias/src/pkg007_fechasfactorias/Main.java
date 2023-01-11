package pkg007_fechasfactorias;

/**
 *
 * @author Diurno
 * Fecha:  11/01/2023
 */
public class Main {

    public static void main(String[] args) {
        Date d = Date.generateDate(29,2,1600);
        System.out.println(d);
        for (int i = 0; i < 2023; i++) {
            if (Date.isLeap(i))
                System.out.println(i);
        }
    }
    
}
