/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg023_interfaces;

/**
 *
 * @author Diurno
 */
public class MusicoEstudiante implements Estudiante, Musico {

    private String nombre;
    
    @Override
    public void estudiar() {
        System.out.println("*estudia*");
    }

    @Override
    public void hablar() {
        System.out.println("*mal asunto*");
    }

    @Override
    public void tocarMusica() {
        System.out.println("*toca musica*");
    }

    @Override
    public void setNombre(String nombre) {
        
    }
    
    @Override
    public String getNombre(){
        return nombre;
    }
    
}
