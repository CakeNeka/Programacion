package pkg014_ejercicioordenacion;

import java.util.Arrays;

public class Main {
    // EJERCICIOS:
    // 0· Array de 20 Personas
    // 1· Guardar el DNI con la letra mayúscula
    // 2· Que el orden natural sea por edad (equals y compareTo deben ser coherentes)
    // 3· Que podamos ordenar por letra del DNI
    // 4· Ordenar a la vez por edad y por dni
    
    public static void main(String[] args) {
        ejercicio0();
    }
    
    public static void ejercicio0(){
        Person[] personas = generaArray(20);
        printArray(personas);
    }
    
    public static void ejercicio2() {
        Person[] personas = generaArray(30);
        Arrays.sort(personas);
        printArray(personas);
    }
    
    public static void ejercicio3() {
        Person[] personas = generaArray(30);
        printArray(personas);
        System.out.println("\n---\n");
        Arrays.sort(personas, new OrderByIdCard());
        printArray(personas);
    }
    
    public static Person[] generaArray(int len) {
        Person[] personas = new Person[len];
        for (int i = 0; i < personas.length; i++) {
            personas[i] = Person.generateRandomPerson();
        }
        return personas;
    }
    
    
    
    
    
    public static void printArray(Person[] people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
    
    
}
