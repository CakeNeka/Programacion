package pkg027_archivosbinarios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * ARCHIVOS BINARIOS: Guardan Objetos
 * Para que un objeto pueda ser guardado en un archivo binario
 * debe implementar la interfaz 'Serializable'.
 * Cuando convertimos un archivo binario en objeto, se devuelve
 * el tipo Object, que puede ser casteado al tipo
 * 
 * 2 Clases: ObjectOutputStream y ObjectInputStream
 * @author Diurno
 */
public class Main {
   
    public static void main(String[] args) {
        // Para leer el fichero utiliza ReadObject. 
        // En los archivos de texto utilizamos la condición
        // de que es distinto a null, en los archivos binarios
        // se utiliza un bucle infinito while(true) hasta que
        // lanza la excepción EOFException (End Of File Exception)  
        //
        // En primer lugar hay que escribir un archivo binario y 
        // después leerlo. Para añadir contenido a un archivo binario
        // el segundo parámetro del constructor debe ser verdadero
        
        // Puede aparecer la excepción StreamCorruptedException porque siempre 
        // empieza a escribir con una cabecera y al añadir contenido se vuelve a 
        // añadir una cabecera. Esto se arregla creando una clase diferente que 
        // herede de objectOutputStream y sobreescribimos el método WriteStreamHeader
        // y ponemos Reset
        
        
        List<Pony> ponis = new ArrayList<>();
        ponis.add(new Pony("Rainbow Dash", "Pegasus"));
        ponis.add(new Pony("Twilight Sparkle", "Unicorn"));
        ponis.add(new Pony("Rarity", "Unicorn"));
        ponis.add(new Pony("Applejack", "Earth Pony"));
        ponis.add(new Pony("Pinkie Pie", "Earth Pony"));
        ponis.add(new Pony("Fluttershy", "Pegasus"));
        
        savePoniesToFile(ponis);
        readPoniesFromFile();
        
//      Añadir elementos a un archivo binario:
        Pony[] newPonies = new Pony[3];
        newPonies[0] = new Pony("Celestia","Unicorn");
        newPonies[1] = new Pony("Big Macintosh", "Earth Pony");
        newPonies[2] = new Pony("Trixie", "Unicorn");
        addPonyToFile(newPonies);
    }
    
    /**
     * Para escribir objetos a un archivo binario
     * saves everypony in the list to a binary file
     * @param ponies 
     */
    private static void savePoniesToFile(List<Pony> ponies) {
        try {
            // Cualquier extensión es válida pero utilizamos '.bin'
            // Abrimos el fichero binario para escritura
            FileOutputStream archivo = new FileOutputStream("equestria.pony");
            ObjectOutputStream outputStream = new ObjectOutputStream(archivo);
            
            // Escribimos los objetos
            for (Pony pony : ponies) {
                // Si la clase no implementa serializable aquí dará un error
                outputStream.writeObject(pony);
//              outputStream.writeObject("asñdf");   
                // En un mismo archivo binario puede haber diferentes tipos de clases
            }
            
            // Cerramos el archivo
            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("El archivo no ha sido encontrado");
        }
    }
    
    /**
     * Añadir objetos a un archivo ya existente, sin sobreescribir.
     * Adds everypony in the array to an existing binary file
     * @param pony 
     */
    private static void addPonyToFile(Pony... ponies) {
        try {
            FileOutputStream archivo = new FileOutputStream("equestria.pony", true);
            // Usar ObjectOutputStream llevará a errores (StreamCorruptedException).
            // En su lugar
            AppendObjectOutputStream outputStream = new AppendObjectOutputStream(archivo);   
            for (Pony pony : ponies) {
                outputStream.writeObject(pony);
            }
            
            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("El archivo no ha sido encontrado");
        }
    }
    
    /**
     * Para leer objetos de un archivo binario
     */
    private static void readPoniesFromFile() {
        ObjectInputStream inputStream = null;
        try {
            FileInputStream archivo = new FileInputStream("equestria.pony");
            inputStream = new ObjectInputStream(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("La operación ha fallado");
        }
        
        // Leer de un archivo binario            
        Pony currentPony;
        boolean endOfFile = false;
        while (!endOfFile) {
            try {
                currentPony = (Pony) inputStream.readObject();
                System.out.println(currentPony);
            } catch (EOFException e) { // END OF FILE exception
                endOfFile = true;
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Otra forma de hacer esto es utilizar un bucle
        // while(true) -->
        
        try {
            // Cerramos el archivo
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        while true
            miCoche = (Coche) lectura.readObject();
            sout(MiCoche);
        

        */
}
}
