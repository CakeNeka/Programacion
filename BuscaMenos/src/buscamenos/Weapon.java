
package buscamenos;


public class Weapon extends Item {
    
    private int pow;
    
    public int getPow() {
        return pow;
    }
    
    public Weapon(String name, char ch, int pow) 
    {
        super(name, ch);
        this.pow = pow;
    }
    
    public static Weapon sword()
    {
        return new Weapon("Sword",'W',5);
    }

    @Override
    public String toString() 
    {
        return String.format("%S (%d AP)", super.name, pow);
    }
    
}
