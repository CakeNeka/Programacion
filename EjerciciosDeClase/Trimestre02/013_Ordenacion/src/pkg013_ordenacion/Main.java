package pkg013_ordenacion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        ordenacion();
//      ordenaArrays();
    }

    static void ordenaArrays() {
        // Ordenación ascendente;
        int[] numeros = {23, 6, 364, 6, 4, 6, 34, 342, 1};
        Arrays.sort(numeros);
        System.out.println(Arrays.toString(numeros));
        
        // Ordenación descendente
        Integer[] numbers = {23, 6, 364, 6, 4, 6, 34, 342, 1};
        Arrays.sort(numbers, Collections.reverseOrder());
        System.out.println(Arrays.toString(numbers));
        
        // Ordenación ascendente de parte del array:
        numbers = new Integer[] {23, 6, 364, 6, 4, 6, 34, 342, 1};
        Arrays.sort(numbers, 0,4);
        System.out.println(Arrays.toString(numbers));
        
        // Ordenación descendente de parte del array:
        numbers = new Integer[] {23, 6, 364, 6, 4, 6, 34, 342, 1};
        Arrays.sort(numbers, 0,4, Collections.reverseOrder());
        System.out.println(Arrays.toString(numbers));
    }

    static void ordenacion() {
        Person[] personas = new Person[10];

        for (int i = 0; i < personas.length; i++) {
            personas[i] = Person.generatePerson("juuana" + i, (byte) (20 + i), "male",
                    ThreadLocalRandom.current().nextInt(11111111, 99999999) + "j");
        }
        
        Person[] arr = personas.clone();
        Arrays.sort(arr, Collections.reverseOrder());
        showPupils(arr);
        Arrays.toString(arr);
        
        // Ordenamos personas idCard
        // Usamos la clase que implementa Comparador
        System.out.println("\nPersonas Ordenadas Por IdCard");
        arr = personas.clone();
        Comparator comparador = new PersonaOrdenadaPorIdCard();
        Arrays.sort(arr, comparador);
        showPupils(arr);
        
        // Para el orden inverso necesitamos otro comparador
        System.out.println("\nPersonas Ordenadas por IdCard inversamente");
        arr = personas.clone();
        Arrays.sort(arr, Collections.reverseOrder(comparador));
        showPupils(arr);
        
        // Ordenamos por Edad
        System.out.println("\nPersonas Ordenadas Por edad");
        arr = personas.clone();
        comparador = new PersonaOrdenadaPorEdad();
        Arrays.sort(arr, comparador);
        showPupils(arr);
    }

    static void showPupils(Person[] people) {
        for (Person person : people) {
            System.out.println(person.showNameId() + " " + person.getAge());
        }
    }

    static void comparacion() {
        Person javi = Person.generatePerson("javi", (byte) 7, "male", "31111111q");
        Person fren = Person.generatePerson("fren", (byte) 100, "male", "22222222h");
        System.out.println(javi.compareTo(fren));
    }
    
    // Ejercicio:
    // 0· Array de 20 Personas
    // 1· Guardar el DNI con la letra mayúscula
    // 2· Que el orden natural sea por edad
    // 3· Que podamos ordenar por letra del DNI
    // 4· Ordenar a la vez por edad y por dni
    
}
