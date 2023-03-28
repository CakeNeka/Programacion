package org.cakeneka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOHelper {
    
    private String path;

    public IOHelper(String path) {
        this.path = path;
    }
    
    public String[] readAllLines() {
        try {
            List<String> lines = new ArrayList<>();
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = bufferedReader.readLine();
            
            while (linea != null) {
                lines.add(linea);
                linea = bufferedReader.readLine();
            }
            
            bufferedReader.close();
            return lines.toArray(new String[0]);
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
    

