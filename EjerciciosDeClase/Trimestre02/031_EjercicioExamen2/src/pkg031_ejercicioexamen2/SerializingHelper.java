package pkg031_ejercicioexamen2;

import java.util.List;

public interface SerializingHelper {
    
    void writeText(String path, String text);
    void appendText(String path, String text);
    void writeObject(String path, Object obj);
    void appendObject(String path, Object obj);
    
    String readTextFile(String path);
    List<Object> readBinaryFile(String path);
}
