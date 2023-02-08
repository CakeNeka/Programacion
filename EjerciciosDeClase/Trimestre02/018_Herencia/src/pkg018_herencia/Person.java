package pkg018_herencia;

public class Person {

    private String name;
    private String surname;
    private int edad;

    public Person(String name, String surname, int edad) {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString() + "Person{" + "name=" + name + ", surname=" 
                + surname + ", edad=" + edad + '}';
    }
    
    
}
