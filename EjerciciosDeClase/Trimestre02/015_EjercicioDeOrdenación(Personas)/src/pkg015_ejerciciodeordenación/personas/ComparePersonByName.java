package pkg015_ejerciciodeordenación.personas;

import java.util.Comparator;


public class ComparePersonByName implements Comparator<Person>{

    
    @Override
    public int compare(Person t, Person t1) {
        return t.getName().compareTo(t1.getName());
    }
    
}
