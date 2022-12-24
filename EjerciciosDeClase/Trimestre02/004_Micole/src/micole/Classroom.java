package micole;

import java.util.Arrays;

public class Classroom {
    
    public static final int DEFAULT_CAPACITY = 30;
    
    private int classroomId;
    private int capacity;
    private School school;
    
    public Classroom(int id){
        this.classroomId = id;
        this.capacity = DEFAULT_CAPACITY;
    }
    
    public Classroom(int id, int capacity) {
        this.classroomId = id;
        this.capacity = capacity;
    }

    public Classroom(int id, int capacity, School school) {
        this.classroomId = id;
        this.capacity = capacity;
        this.school = school;
    }
    
    // Getters & Setters
    
    public int getID() {
        return classroomId;
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
    
    
}
