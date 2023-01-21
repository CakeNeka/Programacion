/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones.coche;

/**
 *
 * @author Neka
 */
public class MatriculaIncorrectaException extends Exception {

    public MatriculaIncorrectaException() {
        super("Valor no valido para el campo 'Matrícula'");
    }
    
}
