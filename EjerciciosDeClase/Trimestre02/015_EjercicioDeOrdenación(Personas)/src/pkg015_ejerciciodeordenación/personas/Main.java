package pkg015_ejerciciodeordenación.personas;

import java.util.Arrays;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {
     // Comprobar longitud de int método
     // Comprobar email;
        System.out.println(Person.eMailOK("ñ@Contratante.com"));

        
    }
    
    public static void sortingByNameAndSurname() {
        Person[] gente = generateArray(30);
        
        Arrays.sort(gente, new ComparePersonByName().thenComparing(Comparator.naturalOrder()));

        
    }
    
    public static void randomPersonTest(){
        Person[] gente = generateArray(30);
        for (Person person : gente) {
            System.out.println(person);
        }
        
        Arrays.sort(gente);
        System.out.println("\n---\n");
        for (Person person : gente) {
            System.out.println(person);
        }
    }
    
    public static Person[] generateArray(int length) {
        Person[] people = new Person[length];
        for (int i = 0; i < people.length; i++) {
            people[i] = Person.generateRandomPerson();   
        }
        return people;
    }
}
