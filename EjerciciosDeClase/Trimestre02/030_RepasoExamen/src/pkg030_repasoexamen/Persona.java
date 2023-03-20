package pkg030_repasoexamen;

import java.io.Serializable;

class Persona implements Serializable {
    private String name;
    private String surname;
    private int edad;
    
    public Persona(String name, String surname, int edad) {
        this.name = name;
        this.surname = surname;
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return  name + " " + surname + " " + edad;
    }
    
    
}
