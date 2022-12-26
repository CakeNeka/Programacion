package micole;

import java.io.Serializable;
import java.util.Arrays;


public class School implements Serializable{
    
    private final long SCHOOL_ID;
    
    private String city;
    private String name;
    private Classroom[] classrooms;

    public School(String name, String city) {
        this.name = name;
        this.city = city;
        this.classrooms = new Classroom[0];
        SCHOOL_ID = System.currentTimeMillis(); 
    }
    
    public void addClassroom(Classroom classroom){
        classroom.setSchool(this);
        classrooms = Arrays.copyOf(classrooms, classrooms.length + 1);
        classrooms[classrooms.length-1] = classroom;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classroom[] getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }
    
    public boolean equals(School other){
        return this.SCHOOL_ID == other.SCHOOL_ID;
    }
    
    
}
