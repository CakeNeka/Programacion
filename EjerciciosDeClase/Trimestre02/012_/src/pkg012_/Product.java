package pkg012_;

public class Product {
    
    private String name;
    private float precioCoste;
    private float VAT;
    private float gains;

    private Product(String name, float precio, float VAT, float gains) {
        this.name = name;
        this.precioCoste = precio;
        this.VAT = VAT;
        this.gains = gains;
    }
    
    public static boolean productIsCorrect(String name, float precioCoste, float VAT, float gains) throws VATOutOfRangeException, OutOfRangeException {
        if (VAT < 0 || VAT > 100){
            throw new VATOutOfRangeException();
        }
        if (precioCoste < 0  || gains < 0){
            throw new OutOfRangeException();
        }
        return nameIsCorrect(name);
    }
    
    public static Product generateProduct(String name, float precioCoste, float VAT, float gains) throws OutOfRangeException, VATOutOfRangeException {
        if(productIsCorrect(name, precioCoste, VAT, gains)){
            return new Product(name, precioCoste, VAT, gains);
        }
        return null;
    }
    
    private static boolean nameIsCorrect(String s){
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isAlphabetic(s.charAt(i)) && s.charAt(i) != ' ') 
                return false;
        }
        return !s.trim().isEmpty();
    }

    @Override
    public String toString() {
        String firstLetter = name.substring(0,1).toUpperCase();
        name = firstLetter + name.substring(1);
        return name;
    }
    
    
    
    // Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrecioCoste() {
        return precioCoste;
    }

    public void setPrecioCoste(float precioCoste) {
        this.precioCoste = precioCoste;
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
