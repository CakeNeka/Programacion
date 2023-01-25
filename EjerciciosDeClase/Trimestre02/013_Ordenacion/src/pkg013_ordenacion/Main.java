package pkg013_ordenacion;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    public static void main(String[] args) {
        ordenacion();
        
    }
    
    static void ordenacion() {
        Person[] arr = new Person[10];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Person.generatePerson("juuan" + i, (byte)(20 + i), "male",
                    ThreadLocalRandom.current().nextInt(11111111,99999999) + "j");
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (Person person : arr) {
            System.out.println(person);
        }
        Arrays.toString(arr);
    }
    
    static void comparacion(){
        Person javi = Person.generatePerson("javi", (byte)7, "male", "31111111q");
        Person fren = Person.generatePerson("fren", (byte)100, "male", "22222222h");
        System.out.println(javi.compareTo(fren));
    }
    
}
