package main;

import javax.swing.JOptionPane;

class Worker implements Citizen{
    
    private final String type;
    private String name;
    private String surname;
    private Profession profession;
    
    private int strength;
    private int dexterity;
    private int wisdom;
    
    // La producción será su mayor atributo multiplicado por el modificador de profesión
    
    // Getters & Setters
    @Override
    public String getFirstName() {
        return name;
    }
    
    @Override
    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public void setFirstName(String name) {
        this.name = name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Profession getProfession() {
        return profession;
    }

    @Override
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    
    @Override
    public float getSalary() {
        return profession.getBaseSalary();
    }
    
    // Other Methods
    @Override
    public void die() {
        JOptionPane.showMessageDialog(Main.menu, "The citizen " + getFullName() + " has perished, may their soul go to heaven", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    @Override
    public float getProduction(){
        float strProd = (float) strength * profession.getStrengthMod();
        float dexProd = (float) dexterity * profession.getDexterityMod();
        float wisProd = (float) wisdom * profession.getWisdomMod();
        
        return Math.max(strProd, Math.max(wisProd,dexProd));
//      return strProd + wisProd + dexProd;
    }
    
    
    @Override
    public String toString() {
        return name +" "+ surname + " (" + type + ")";
    }
    
    
    
    // Constructors
    Worker() {
        this.type = "Worker";
        this.name = "Unnamed";
        this.surname = "";
        this.strength = 0;
        this.wisdom = 0;
        this.dexterity = 0;
    }
    
    public Worker(String name, String surname, int FUE, int CAR, int DES) {
        this.type = "Worker";
        this.profession = Profession.IDLER;
        
        this.name = name;
        this.surname = surname;
        this.strength = FUE;
        this.wisdom = CAR;
        this.dexterity = DES;
    }   
}