package micole;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;


public class Student{
    
    private static int idGenerator = 0;
    
    private final int STUDENT_ID;
    private String name;
    private String surname;
    LocalDate birthDay;
    
    // (Todos: comprobación del dni)
    private String dni;
    
    // (Avanzado) Este campo sea un enum
    private Grupo grupo;
    
    // (Avanzado) Un array notas bidimensional, con cada una de los módulos
    // y cada uno de los trimestres.
    
    double[][] GradesPerQuarter;
    // Array de las notas medias
    double[] medias;

    
    
    // Constructor method
    public Student(String name, String surname, String dni) {
        
        STUDENT_ID = idGenerator++;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.medias = new double[6];
        this.GradesPerQuarter = new double[6][3];
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", name, surname, STUDENT_ID);
    }
    
    public int compareTo(Student other) {
        return this.surname.compareTo(other.surname);
    }

    
    public boolean equals(Student other) {
        if(this == other)
            return true;
        
        return this.name.equals(other.name) && this.surname.equals(other.surname)
                && this.STUDENT_ID == other.STUDENT_ID;
    }
    
    // Getters & Setters

    // https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
    public int getEdad(){
        LocalDate now = LocalDate.now();
        Period p = Period.between(birthDay, now);
        return p.getYears();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()<=1) 
            name = name.toUpperCase();
        else 
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname.length()<=1) 
            surname = surname.toUpperCase();
        else 
            surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        
        this.surname = surname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public double[][] getGradesPerQuarter() {
        return GradesPerQuarter;
    }

    public void setGradesPerQuarter(double[][] GradesPerQuarter) {
        this.GradesPerQuarter = GradesPerQuarter;
    }

    public double[] getMedias() {
        return medias;
    }

    public void setMedias(double[] medias) {
        this.medias = medias;
    }

    public School getSchool() {
        return grupo.getClassroom().getSchool();
    }

    
    
    
}
