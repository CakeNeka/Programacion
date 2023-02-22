package pkg023_interfaces;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Diurno
 * 22-02-2023
 */
public class Main {

    public static void main(String[] args) {
        // Quiero que meteais esos campos y rellenar los campos 
        
        // Instanciar MusicoEstudiante
        Estudiante solid = new MusicoEstudiante();
        Musico liquid = new MusicoEstudiante();
        Persona solidus = new MusicoEstudiante();
        
        List<Persona> personas = new ArrayList<>();
        personas.add(solid);
        personas.add(liquid);
        personas.add(solidus);
        
        for (Persona persona : personas) {
            // Llamar a los métodos de la clase persona;
            persona.hablar();
            
            // Utilizar los métodos de la clase MusicoEstudiante
            MusicoEstudiante me = (MusicoEstudiante) persona;
            System.out.println(me);
            me.tocarMusica();
            me.estudiar();
        }
        
        
        
        // Implementación de interfaz con clase anónima
                
        Persona p = new Persona() {
            @Override
            public void hablar() {
                System.out.println(":)");
            }

            @Override
            public void setNombre(String nombre) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getNombre() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        } ;
        
        
    }
    
}
