package pkg029_preguntaexamen;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg027_archivosbinarios.Pony;

/**
 * 0. Si queremos utilizar archivos binarios escritos en otro proyecto, no sirve
 * copiar literalmente la clase 'Coche' a este proyecto. Si no que habría que 
 * importar el jar. (OtroProyecto --> 'Clean And Build' --> PreguntaExamen -->
 * Libraries --> Click Derecho --> Add JAR/FOLDER --> '\OtroProyecto\dis\coche.jar'
 * 
 * 
 * 1. Leer objetos 'Coche' de un objeto y añadirlos a un ArrayList 2. Del
 * ArrayList de coches, eliminar los repetidos 3. Escribir en un archivo binario
 * los coches sin repetir
 *
 * ACLARACION: En mi caso también genero los coches para que haya duplicados y
 * creo una nueva clase 'Car'
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Coches leídos desde el archivo binario creado en otro proyecto");
        jarFileUsage();
        
        
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Seat Panda", "6542YDB"));
        cars.add(new Car("Ford Fiesta", "FFF234"));
        cars.add(new Car("Ford Fiesta", "FFF234"));
        cars.add(new Car("Ford Fiesta", "FFF234"));
        cars.add(new Car("Ford Fiesta", "FFF234"));
        cars.add(new Car("Seat Panda", "FFF234"));
        cars.add(new Car("Ford Focus", "345432JIO"));
        cars.add(new Car("Renault 5", "7734"));
        cars.add(new Car("Seat Panda", "6542YDB"));
        cars.add(new Car("Toyota", "35423DF"));
        cars.add(new Car("Rayo McQueen", "Ka-chows"));

        writeCarsToFile(cars);
        List<Car> readCars = readCarsFromFile();
        System.out.println("\nCoches leídos desde el archivo binario: ");
        for (Car readCar : readCars) {
            System.out.println(readCar);
        }

        System.out.println("\nCoches leídos desde el archivo binario sin duplicados");
        removeDuplicates(readCars);
        for (Car readCar : readCars) {
            System.out.println(readCar);
        }

        System.out.println("\nEscribir coches a un archivo de texto");
        List<String> carNames = new ArrayList<>();
        for (Car readCar : readCars) {
            carNames.add(readCar.toString());
        }
        writeTextCars(carNames);
    }

    private static void removeDuplicates(List<Car> cars) {
        Iterator<Car> it = cars.iterator();
        List<Car> repeatedCars = new ArrayList<>();

        while (it.hasNext()) {
            Car currentCar = it.next();
            if (repeatedCars.contains(currentCar)) {
                it.remove();
            } else {
                repeatedCars.add(currentCar);
            }
        }
    }

    private static void writeCarsToFile(List<Car> cars) {
        try {
            FileOutputStream archivo = new FileOutputStream("coches.bin");
            ObjectOutputStream outputStream = new ObjectOutputStream(archivo);

            for (Car car : cars) {
                outputStream.writeObject(car);
            }

            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("El archivo no ha sido encontrado");
        }
    }

    private static List<Car> readCarsFromFile() {
        ObjectInputStream inputStream = null;
        List<Car> cars = new ArrayList<>();
        try {
            FileInputStream archivo = new FileInputStream("coches.bin");
            inputStream = new ObjectInputStream(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("La operación ha fallado");
        }
           
        boolean endOfFile = false;
        while (!endOfFile) {
            try {
                cars.add((Car) inputStream.readObject());
            } catch (EOFException e) { 
                endOfFile = true;
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cars;
    }

    private static void writeTextCars(List<String> carNames) {
        File file = new File("CochesSinRepetidos.txt");
        try {
            FileWriter writer = new FileWriter(file, false);            
            BufferedWriter bWriter = new BufferedWriter(writer);
            for (String carName : carNames) {
                bWriter.write(carName);
                bWriter.write('\n');
            }
            bWriter.close();
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el fichero");
        }
    }

    /**
     * Leer un archivo binario de otro proyecto (importando el archivo jar)
     */
    private static void jarFileUsage(){
        ObjectInputStream inputStream = null;
        List<Pony> ponies = new ArrayList<>();
        boolean endOfFile = false;
        try {
            FileInputStream archivo = new FileInputStream("equestria.pony");
            inputStream = new ObjectInputStream(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
            endOfFile = true;
        } catch (IOException ex) {
            System.out.println("La operación ha fallado");
        }
        
        
        while (!endOfFile) {
            try {
                ponies.add((Pony) inputStream.readObject());
            } catch (EOFException e) { 
                endOfFile = true;
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Pony pony : ponies) {
            System.out.println(pony);
        }
    }
}
