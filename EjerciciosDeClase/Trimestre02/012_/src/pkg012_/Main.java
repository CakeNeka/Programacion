package pkg012_;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args) throws OutOfRangeException, VATOutOfRangeException {
        pruebaEquals();
    }
    
    static void pruebaProductos() throws OutOfRangeException, VATOutOfRangeException {
        System.out.println(Character.isAlphabetic('ñ'));
        Product producto1 = Product.generateProduct("A", 9, 0, 40);
        Product producto2 = Product.generateProduct("A", 9, 3, 40);
        
        int comparacion = producto1.compareTo(producto2);
        System.out.println(comparacion);
        
        System.out.println(producto1);
        if (comparacion == 0) {
            System.out.println("producto1 es igual que producto2");
        } else if (comparacion < 0) {
            System.out.println("Producto1 es menor que producto2");
        } else {
            System.out.println("Producto1 es mayor que producto2");
        }
        
    }
    
    static void pruebaEquals() throws OutOfRangeException, VATOutOfRangeException {
        Product producto1 = Product.generateProduct("A", 9, 3, 40);
        Product producto2 = Product.generateProduct("A", 9, 3, 40);
        
        System.out.println(producto1.equals(producto2));
    }
    
}
