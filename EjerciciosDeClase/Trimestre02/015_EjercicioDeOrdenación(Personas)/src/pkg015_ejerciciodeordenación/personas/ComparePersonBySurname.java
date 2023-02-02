/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg015_ejerciciodeordenación.personas;

import java.util.Comparator;

/**
 *
 * @author Neka
 */
public class ComparePersonBySurname implements Comparator<Person>{

    @Override
    public int compare(Person t, Person t1) {
        return t.getSurname().compareTo(t1.getSurname());
    }

    
    
}
