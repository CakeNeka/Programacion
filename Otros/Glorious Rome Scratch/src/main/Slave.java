package main;

public class Slave implements Citizen{
    
    final static int PRICE = 70;
    
    private String type;
    private String name;
    private Profession profession;
    
    private int strength;
    private int dexterity;
    private int wisdom;
    
    @Override
    public String getType() {
         return type;
    }

    @Override
    public String getFirstName() {
        return name;
    }

    @Override
    public String getFullName() {
        return name;
    }
    
    @Override
    public Profession getProfession() {
        return profession;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getWisdom() {
        return wisdom;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public void setFirstName(String text) {
        this.name = text;
    }

    @Override
    public int getSalary() {
        return 2;
    }

    @Override
    public float getProduction() {
        float strProd = strength * profession.getStrengthMod() * 0.5f;
        float dexProd = dexterity * profession.getDexterityMod() * 0.5f;
        float wisProd = wisdom * profession.getWisdomMod() * 0.5f;
        
        return Math.max(strProd, Math.max(wisProd,dexProd));
    }
    
    @Override
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    
    @Override
    public void die() {
        System.out.println(name + " muere");
    }
    
    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
    
    Slave(String name, int strength, int dexterity, int wisdom) {
        this.type = "Slave";
        this.profession = Profession.IDLER;
        this.name = name;
        
        this.strength = strength;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        
    }
}
