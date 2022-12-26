package micole;

import java.io.Serializable;
import java.util.Arrays;

public class Classroom implements Serializable{
    
    public static final int DEFAULT_CAPACITY = 30;
    
    public final long CLASSROOM_ID;
    
    private String classroomName;
    private int capacity;
    private School school;
    
    public Classroom(String id){
        this.classroomName = id;
        this.capacity = DEFAULT_CAPACITY;
        
        CLASSROOM_ID = System.currentTimeMillis();
    }
    
    public Classroom(String id, int capacity) {
        this.classroomName = id;
        this.capacity = capacity;
        
        CLASSROOM_ID = System.currentTimeMillis();
    }

    public Classroom(String id, int capacity, School school) {
        this.classroomName = id;
        this.capacity = capacity;
        this.school = school;
        school.addClassroom(this);
        
        CLASSROOM_ID = System.currentTimeMillis();
    }
    
    // Getters & Setters
    
    public String getName() {
        return classroomName;
    }
    
    public void setID(String id) {
        this.classroomName = id;
    }
    
    public School getSchool(){
        return school;
    }
    
    public void setSchool(School school){
        this.school = school;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean equals(Classroom other){
        return this.CLASSROOM_ID == other.CLASSROOM_ID;
    }
    
    @Override
    public String toString() {
        return "Clase " + classroomName;
    }
    
    
    
}
