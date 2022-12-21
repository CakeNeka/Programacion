package pkg003_clasesestaticas;

/**
 *
 * @author CakeNeka
 * Date: 2022-12-21
 */
//import marinesespaciales.Spartan;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Spartan masterChief = new Spartan(117, 2, "Green", "Jefe Maestro");
        System.out.println(masterChief);
        
        // Prueba importar dos paquetes con el mismo nombre
        marinesespaciales.Spartan  sp = new marinesespaciales.Spartan(118, "ñalsdkf");
    }
}
