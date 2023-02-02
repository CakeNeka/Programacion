package pkg014_ejercicioordenacion;

import java.util.Comparator;

public class OrderByIdCard implements Comparator<Person>{

    @Override
    public int compare(Person t, Person t1) {
        char p1IdChar = t.getIdCard().charAt(8);
        char p2IdChar = t1.getIdCard().charAt(8);
        return p1IdChar - p2IdChar;
    }

    @Override
    public Comparator<Person> thenComparing(Comparator<? super Person> cmprtr) {
        return Comparator.super.thenComparing(cmprtr);
    }
    
}
