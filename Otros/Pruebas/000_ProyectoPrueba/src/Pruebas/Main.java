package Pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;
public class Main {
    
    public static void main(String[] args) {
        streams();
    }
    
    public static void removeDuplicates(ArrayList<String> strings) {
        ArrayList<String> noDuplicates = new ArrayList<>();
        
        for (String string : strings) {
            if (!noDuplicates.contains(string)){
                noDuplicates.add(string);
            }
        }
        
//      strings = noDuplicates;     // No funcionará
        
        
        strings.clear();
        strings.addAll(noDuplicates);
        
    }
    
    public static void streams(){
        List<Person> people = getPeople();
        
        List<Person> females = people.stream()
                .filter(p -> p.getGender().equals(Gender.F))
                .collect(Collectors.toList());
        
        females.forEach(p -> changePerson(p));
        females.forEach(System.out::println);
        
        females.forEach(p -> {
           System.out.println(p);
        });
        System.out.println("--");
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        
        boolean match = people.stream().allMatch(p -> p.getAge() > 18);
        System.out.println(match);
        
        /* MAX */                                                                   
        Person oldest = people.stream().max(Comparator.comparing(p -> p.getAge())).get(); // .get() porque max() devuelve Optional<Person>
        System.out.println(oldest);
        
        /* NAME OF YOUNGEST MALE */
        String name = people.stream()
                .filter(p -> p.getGender().equals(Gender.M))
                .min(Comparator.comparing(Person::getAge))
                .get().getName();
        System.out.println(name);
    }

    private static List<Person> getPeople() {
        return Arrays.asList(
            new Person("Lara Croft", 32, Gender.F),
            new Person("Chincho Merinde", 34, Gender.M),
            new Person("Master Chief", 24, Gender.M),
            new Person("Sam Fischer", 29, Gender.M),
            new Person("Sam Gideon", 34, Gender.M),
            new Person("Bayonetta", 33, Gender.F),
            new Person("Solid Snake", 33, Gender.M)
        );
    }
    
    static void changePerson(Person person){
        person.setName(person.getName() + " Master");
    }
}
