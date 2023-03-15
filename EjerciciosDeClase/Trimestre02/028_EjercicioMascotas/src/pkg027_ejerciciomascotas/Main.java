package pkg027_ejerciciomascotas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* 1. Crear un array de 10 nombres de persona, llamado nombres. */
        String[] names = {"Celestia", "Fernando", "Chincho Merinde", "Johaness",
            "Julia", "Lucía", "Octavio Augusto", "Cicerón", "Polibio", "Zenobia"};

        /* 2. Crear un array de 10 objetos Animal, llamado animales. */
        Animal[] animals = {new Animal("Rattata", "Pokemon"), new Animal("Rayquaza", "Pokemon"), new Animal("Moltres", "Pokemon"),
            new Animal("Zapdos", "Pokemon"), new Animal("Luperca", "Lobo"), new Animal("Ganso Nocturno", "Ganso"),
            new Animal("Pato Diurno", "Pato"), new Animal("Pikachu", "Pokemon"), new Animal("Cota", "Perro"),
            new Animal("Copito de nieve", "Gatito")};

        /*    
        3. Escoger aleatoriamente de estos arrays un nombre y un animal, y
        con ellos crear un Hashmap<String, Animal> llamado mascotas. Como no 
        controlamos si se repiten o no los nombres, el tamaño del hashmap no lo 
        podremos saber a priori.
        VOLUNTARIO: Hacer que este hashmap, mascotas, tenga un tamaño de 6 
        elementos exactamente 
         */
        HashMap<String, Animal> mascotas = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int nameIndex = random.nextInt(names.length - 1 - i);
            int animalIndex = random.nextInt(animals.length - 1 - i);
            mascotas.put(names[nameIndex], animals[animalIndex]);

            swapName(names, nameIndex, names.length - 1 - i);
            swapAnimal(animals, animalIndex, animals.length - 1 - i);
        }

        for (Map.Entry<String, Animal> entry : mascotas.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

        /* 4. Una vez creado el hashmap, mostrar por pantalla las mascotas según 
           la especie (de forma ASC) */
        System.out.println("\nMascotas ordenadas por especie de forma ASC");
        List<Animal> animalsList = new ArrayList(mascotas.values());
        animalsList.sort(new CompareBySpecies());
        for (Animal animal : animalsList) {
            System.out.println(animal);
        }

        /* 5. Mostrar por pantalla las mascotas ordenadas por nombre de forma DESC */
        System.out.println("\nMascotas ordenadas por nombre de forma DESC");
        animalsList.sort(Comparator.reverseOrder());
        for (Animal animal : animalsList) {
            System.out.println(animal);
        }

        /*Preguntar al usuario nombres de mascotas y eliminar del hashmap todas 
        aquellas mascotas que tengan este nombre*/
        Scanner scan = new Scanner(System.in);
        System.out.print("\nIntroduce el nombre de la mascota a eliminar: ");
        String input = scan.nextLine();
        while (!input.isEmpty()) {
            if (removeValue(mascotas, input)){
                System.out.println("La mascota ha sido eliminada");
            } else {
                System.out.println("No se ha encontrado ninguna mascota con ese nombre");
            }
            System.out.print("\nIntroduce otro nombre de la mascota a eliminar: ");
            input = scan.nextLine();
        }
        
        System.out.println("\nEl HashMap queda así: ");
        for (Map.Entry<String, Animal> entry : mascotas.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    private static void swapName(String[] names, int a, int b) {
        String temp = names[a];
        names[a] = names[b];
        names[b] = temp;
    }

    private static void swapAnimal(Animal[] animals, int a, int b) {
        Animal temp = animals[a];
        animals[a] = animals[b];
        animals[b] = temp;
    }

    private static boolean removeValue(HashMap<String, Animal> mascotas, String valueToRemove) {
        Iterator<Map.Entry<String, Animal>> it = mascotas.entrySet().iterator();
        boolean removed = false;
        while (it.hasNext()) {
            Map.Entry<String, Animal> pair = it.next();
            if (pair.getValue().getName().equals(valueToRemove)) {
                removed = true;
                it.remove();
            }
        }
        return removed;
    }

}
