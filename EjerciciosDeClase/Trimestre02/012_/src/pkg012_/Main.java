package pkg012_;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args) {
        System.out.println(Character.isAlphabetic('ñ'));
        Product producto = null;
        try {
            producto = Product.generateProduct("biciclesa", 0, 0, 0);
        } catch (OutOfRangeException ex) {
            System.err.println(ex.getMessage());
        } catch (VATOutOfRangeException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(producto);
    }
    
}
