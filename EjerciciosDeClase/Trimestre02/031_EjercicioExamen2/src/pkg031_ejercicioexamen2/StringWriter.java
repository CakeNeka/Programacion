package pkg031_ejercicioexamen2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringWriter implements SerializingHelper {

    @Override
    public void writeText(String path, String text) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(text);
        } catch (IOException ex) {
            Logger.getLogger(StringWriter.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void appendText(String path, String text) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(text);
        } catch (IOException ex) {
            Logger.getLogger(StringWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void writeObject(String path, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void appendObject(String path, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readTextFile(String path) {
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            
        } catch (IOException ex) {
            Logger.getLogger(StringWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Object> readBinaryFile(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
