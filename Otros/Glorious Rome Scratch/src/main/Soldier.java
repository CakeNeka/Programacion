package main;


public class Soldier implements Citizen {
    
    public static final int PRICE = 120;
    
    private String type;
    private String name;
    private String surname;
    private Profession profession;
    
    private int strength;
    private int dexterity;
    private int wisdom;


    
    @Override
    public void die() {
        System.out.println(getFullName() + "died");
    }

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
        return name + " " + surname;
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
        return profession.getBaseSalary();
    }

    @Override
    public float getProduction() {
        return 0f;
    }

    @Override
    public void setProfession(Profession get) { }
    
    @Override
    public String toString() {
        return name +" "+ surname + " (" + type + ")";
    }
    
    public Soldier(String name, String surname, Profession profession, int strength, int dexterity, int wisdom) {
        this.type = "Soldier";
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.strength = strength;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
    }
}
