package pkg013_ordenacion;

import java.util.Comparator;

public class PersonaOrdenadaPorIdCard implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
        Person p1 = (Person) t;
        Person p2 = (Person) t1;
        
        String p1Id = (p1.getIdCard().substring(0,8));
        String p2Id = (p2.getIdCard().substring(0,8));
        
        return p1Id.compareTo(p2Id);
    }

    @Override
    public Comparator thenComparing(Comparator cmprtr) {
        return Comparator.super.thenComparing(cmprtr);
    }
    
    
    
    
}
