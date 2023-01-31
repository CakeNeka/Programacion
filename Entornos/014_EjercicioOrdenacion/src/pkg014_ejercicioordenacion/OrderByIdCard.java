/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg014_ejercicioordenacion;

import java.util.Comparator;

/**
 *
 * @author Diurno
 */
public class OrderByIdCard implements Comparator<Person>{

    @Override
    public int compare(Person t, Person t1) {
        char p1IdChar = t.getIdCard().charAt(8);
        char p2IdChar = t1.getIdCard().charAt(8);
        return p1IdChar - p2IdChar;
    }
    
}
