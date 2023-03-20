package pkg030_repasoexamen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /**
     * EJERCICIO 1. Fichero de texto (Personas) 2. Crear HashMap con las
     * siguientes estructuras: Indice: String Contenido: Personas Indice: "POXX"
     * 0 -> Número de línea del fichero XX --> Iniciales del nombre Contenido:
     * Objetos Persona leídos en el fichero 3. Escribir binario con el contenido
     * del hashmap 4. Pasamos el contenido del hashmap a un arrayList y lo
     * ordenamos según la edad con un Comparator. 5. Ordenar por apellidos y por
     * edad
     */
    public static void main(String[] args) {
        Map<String, Persona> personas = leePersonas();
        for (Map.Entry<String, Persona> entry : personas.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.addAll(personas.values());
        escribePersonas(listaPersonas);

        System.out.println("\nPersonas ordenadas por apellido y nombre");
        listaPersonas.sort(new CompararPorApellidoYNombre());
        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
    }

    private static Map<String, Persona> leePersonas() {
        Map<String, Persona> personas = new HashMap<>();
        try {
            File archivo = new File("archivo.txt");
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea = bufferedReader.readLine();
            int numeroLinea = 0;
            while (linea != null) {
                Persona value = createPerson(linea);
                String key = generatePersonCode(numeroLinea, value);
                personas.put(key, value);
                linea = bufferedReader.readLine();
                numeroLinea++;
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException ex) {
            System.out.println("Algo no fue bien");
        }
        return personas;
    }

    private static Persona createPerson(String line) {
        String[] parametros = line.split(",");
        String nombre = parametros[0].substring(18);
        String apellidos = parametros[1].substring(11);
        int edad = Integer.parseInt(parametros[2].substring(6, parametros[2].length() - 1));

        return new Persona(nombre, apellidos, edad);
    }

    private static String generatePersonCode(int line, Persona persona) {
        return "P" + line + persona.getName().charAt(0) + persona.getSurname().charAt(0)
                + persona.getSurname().charAt(persona.getSurname().indexOf(" ") + 1);
    }

    private static void escribePersonas(List<Persona> listaPersonas) {
        try {
            FileOutputStream archivo = new FileOutputStream("personas.bin");
            ObjectOutputStream outputStream = new ObjectOutputStream(archivo);

            for (Persona persona : listaPersonas) {
                outputStream.writeObject(persona);
            }

            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error");
        }
    }

    private static void usarMathRandom() {
        int maxBound = 20;
        int randomNum = (int) (Math.random() * (maxBound + 1));
    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
