package pkg024_archivosdetexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Archivos de texto y binarios
 *  TEXTO   ->  pueden abrirse y leerse con cualquier editor de textos.
 *  BINARIO ->  Codificada para almacenamiento y procesamiento en ordenadores
 * 
 * Clases File, FileReader, BufferedReader, FileWriter (importante cerrar archivo)
 * 
 * @author Diurno
 * 03-03-2023
 * 13-03-2023
 */
public class Main {
//  * Todas las excepciones deben estar dentro de bloques try/catch *
// La excepción más general son IOException, otras son FileNotFoundException
    public static void main(String[] args) {
        // La base de todos los ficheros es la clase file.
        // Crear un arhivo:
        
        File archivo = new File("dirPrueba/Comentarii_de_Bello_Gallico.txt");
        
        
        try {
            // Si no existe crea el archivo, si existe no hace nada.
            if(archivo.createNewFile())
                System.out.println("Archivo creado correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        escribeFichero(archivo);
        
        leeFichero(archivo);
         
    }

    private static void escribeFichero(File archivo) {
        // Clases FileWriter y BufferedWriter para escribir sobre el arhivo
        try {
            FileWriter writer = new FileWriter(archivo,true);
//          writer.append("Gallia est omnis dīvīsa in partēs trēs, quārum ūnam incolunt Belgae,\n"
//                  + "aliam Aquītānī, tertiam quī ipsōrum linguā Celtae, nostrā Gallī appellantur.");
//          writer.close();
//            
            BufferedWriter bWriter = new BufferedWriter(writer);
            bWriter.write(" Hī omnēs linguā, īnstitūtīs, legibus inter sē differunt. Gallōs ab Aquītānīs \n" +
                    "Garumna flūmen, ā Belgīs Matrona et Sēquana dīvidit");
            bWriter.close();
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el fichero");
            
        }
    }
    
    private static void leeFichero(File archivo) {
        try {
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String linea = bufferedReader.readLine();
            String texto = "";
            while (linea != null) {
                texto += linea;
                System.out.println(linea);
                linea = bufferedReader.readLine();
            }
            
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException ex) {
            System.out.println("Algo no fue bien");
        }
    }
    
    public static void crearDir() {
        File directorio = new File("carpetaJesus");
        if(directorio.mkdir()) {
            System.out.println("Directorio creado");
        } else {
            System.out.println("Algo ha ido mal");
        }
    }
    
    
    public static void añadirTexto(File archivo) {
        try {
            // El segundo parámetro indica si se añadirá texto o se sobreescribirá
            FileWriter writer = new FileWriter(archivo,true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            bWriter.write(" Hī omnēs linguā, īnstitūtīs, legibus inter sē differunt. Gallōs ab Aquītānīs \n" +
                    "Garumna flūmen, ā Belgīs Matrona et Sēquana dīvidit");
            bWriter.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el fichero");
            
        }
    }
}
