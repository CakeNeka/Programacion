package micole;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;


public class Student implements Serializable{
    
    
    private final long STUDENT_ID;
    private String name;
    private String surname;
    LocalDate birthDay;
    
    // (Todos: comprobación del dni)
    private String dni;
    
    // (Avanzado) Este campo sea un enum
    private Group grupo;
    
    // (Avanzado) Un array notas bidimensional, con cada una de los módulos
    // y cada uno de los trimestres.
    
    double[][] gradesQuarter;
    // Array de las notas medias
    double[] medias;

    
    
    // Constructor method
    public Student(String name, String surname, String dni) {
        
        STUDENT_ID = System.currentTimeMillis();
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        
        this.medias = new double[3];
        this.gradesQuarter = new double[3][3];
    }

    public Student(String name, String surname, LocalDate birthDay, String dni) {
        this.STUDENT_ID = System.currentTimeMillis();
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.dni = dni;
        
        this.medias = new double[3];
        this.gradesQuarter = new double[3][3];
    }
    
    public void setMedias(){
        for (int i = 0; i < 3; i++) {
            medias[i] = 0;
            for (int j = 0; j < 3; j++) {
                medias[i] += gradesQuarter[i][j];
            }
            medias[i] /= 3.0;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s %s (%s)", name, surname, grupo);
    }
    
    public int compareTo(Student other) {
        return this.surname.compareTo(other.surname);
    }

    
    public boolean equals(Student other) {
        if(this == other)
            return true;
        
        return this.STUDENT_ID == other.STUDENT_ID;
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

    public Group getGrupo() {
        return grupo;
    }

    public void setGrupo(Group grupo) {
        this.grupo = grupo;
    }

    public double[][] getGradesQuarter() {
        return gradesQuarter;
    }

    public void setGradesQuarter(double[][] gradesQuarter) {
        this.gradesQuarter = gradesQuarter;
        setMedias();
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
