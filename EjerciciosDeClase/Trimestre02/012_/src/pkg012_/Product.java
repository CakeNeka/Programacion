package pkg012_;

import java.util.Objects;

/**
 * Todos los objetos tienen dos metodos para compararse entre sí. boolean Equals
 * (comprobar si son iguales) int CompareTo (comparar mayor/menor)
 *
 * @author Diurno
 */
public class Product {

    private String name;
    private float costPrice;
    private float VAT;
    private float gains;

    private Product(String name, float precio, float VAT, float gains) {
        this.name = name;
        this.costPrice = precio;
        this.VAT = VAT;
        this.gains = gains;
    }

    public static boolean productIsCorrect(String name, float precioCoste, float VAT, float gains) throws VATOutOfRangeException, OutOfRangeException {
        if (VAT < 0 || VAT > 100) {
            throw new VATOutOfRangeException();
        }
        if (precioCoste < 0 || gains < 0) {
            throw new OutOfRangeException();
        }
        return nameIsCorrect(name);
    }

    public static Product generateProduct(String name, float precioCoste, float VAT, float gains) throws OutOfRangeException, VATOutOfRangeException {
        if (productIsCorrect(name, precioCoste, VAT, gains)) {
            return new Product(name, precioCoste, VAT, gains);
        }
        return null;
    }

    public static boolean nameIsCorrect(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i)) && s.charAt(i) != ' ') {
                return false;
            }
        }
        return !s.trim().isEmpty();
    }

    @Override
    public String toString() {
        String firstLetter = name.substring(0, 1).toUpperCase();
        name = firstLetter + name.substring(1);
        return name;
    }

    // CompareTo
    // 0 si son iguales
    // Número negativo si objeto1 es menor que objeto2
    // Número positivo si objeto1 es mayor que objeto2
    int comparaProducto() {
        return 0;
    }

    public int compareTo(Product other) {
//      if (this.precioCoste < other.precioCoste)  return -1;
//      if (this.precioCoste > other.precioCoste)  return 1;
//      return 0;
//      return this.name.compareTo(other.name);
        return Double.compare(this.costPrice, other.costPrice);
    }
    
    // Equals & HashCode
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        /*
        if (Float.floatToIntBits(this.precioCoste) != Float.floatToIntBits(other.precioCoste)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
        */
        return this.name.equalsIgnoreCase(other.name) 
                && this.costPrice ==  other.costPrice
                && this.VAT       ==  other.VAT
                && this.gains     ==  other.gains;
    }
    

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrecioCoste() {
        return costPrice;
    }

    public void setPrecioCoste(float precioCoste) {
        this.costPrice = precioCoste;
    }

    public float getVAT() {
        return VAT;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
    }

    public float getGains() {
        return gains;
    }

    public void setGains(float gains) {
        this.gains = gains;
    }

}
