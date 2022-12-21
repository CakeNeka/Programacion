/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg002_instituto;

import java.time.LocalDate;

/**
 *
 * @author CakeNeka
 * 2022-12-20
 */
public class Alumno {

    LocalDate fechaNac;
    String nombre;
    String apellidos;
    String dni;
    
    // enum para el campo nombre del grupo
    // aRRAY BIDIMIENSIONAL PARA LAS NOTAS 
    // 3 trimestres y tres asignaturas
    // Clase grupo, y enum aula
    
    
    static boolean dniValidator(String dni) {
        
        dni = dni.trim();
        int len = dni.length();
        
        if(len != 9 || !Character.isLetter(dni.charAt(len - 1)))
            return false;
        
        char[] arr = dni.toCharArray();
        
        for (int i = 0; i < len-1; i++) {
            if (!Character.isDigit(arr[i]))
                return false;
        }
        int num = Integer.parseInt(dni.substring(0,9)) ;
        return dni.charAt(9) == dniLetter(num);
    }
        
    static char dniLetter(int dni) {
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        return dniLetters[dni % 23];
    }
    
}
