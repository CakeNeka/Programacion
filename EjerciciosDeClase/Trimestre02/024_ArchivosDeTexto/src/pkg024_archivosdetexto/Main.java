package pkg024_archivosdetexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Archivos de texto y binarios
 *  TEXTO   ->  pueden abrirse y leerse con cualquier editor de textos.
 *  BINARIO ->  Codificada para almacenamiento y procesamiento en ordenadores
 * 
 * Clases File, FileReader, BufferedReader, FileWriter (importante cerrar archivo)
 * 
 * @author Diurno
 * 03-03-2023
 */
public class Main {
//  * Todas las excepciones deberían estar dentro de bloques try/catch *
    public static void main(String[] args) throws IOException {
        // La base de todos los ficheros es la clase file.
        // Crear un arhivo:
        File archivo = new File("Comentarii_de_Bello_Gallico.txt");
        
        // Si no existe crea el archivo, si existe no hace nada.
        if(archivo.createNewFile())    
            System.out.println("Archivo creado correctamente");
        
        // Clase FileWriter para escribir sobre el arhivo
        FileWriter writer = new FileWriter(archivo,true);
        writer.append("Gallia est omnis dīvīsa in partēs trēs, quārum ūnam incolunt Belgae,\n"
                + "aliam Aquītānī, tertiam quī ipsōrum linguā Celtae, nostrā Gallī appellantur.");
        writer.close();
        
        // Clase BufferedReader y FileReader
        FileReader fileReader = new FileReader(archivo);
        BufferedReader reader = new BufferedReader(fileReader);
    }
    
}
