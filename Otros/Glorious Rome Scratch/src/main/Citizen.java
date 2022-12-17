package main;

public interface Citizen {
    
    void die();
    
    public String getType();
    
    public String getFirstName();
    
    public String getFullName();
    
    public Profession getProfession();

    public int getStrength();

    public int getWisdom();

    public int getDexterity();

    public void setFirstName(String text);

    public int getSalary();

    public float getProduction();

    public void setProfession(Profession get);

}
