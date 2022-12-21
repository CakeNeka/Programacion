package firstpackage;

import secondpackage.Clase3;
/**
 *
 * @author Cakeneka
 * 2022-12-20
 */
public class MainClass {
    public static void main(String[] args) {
        Alumno discipulus = null;
        
        System.out.println(discipulus);         // variable discipulus vacia
         
        discipulus = new Alumno();              // inicializar variable discipulus
        
        System.out.println(discipulus);
        
        Clase dam1 = new Clase();
        
        for (int i = 0; i < 10; i++) {
            dam1.addAlumno(new Alumno("alumno" + i, i, new int[10]), i);
        }
        
        System.out.println(dam1);
        Clase3 kk = new Clase3();               // Nueva clase de otro paquete
    }
}
