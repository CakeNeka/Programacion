/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabstractas;

/**
 *
 * @author Rut
 */
public class Planta extends SerVivo {
    
    enum TipoDeHoja{
        EVERGREEN,
        FALLEN
    }
    
    @Override
    public void alimentarse() {
        System.out.println("Me alimento a través de la fotosíntesis");
    }

    @Override
    public void respirar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
