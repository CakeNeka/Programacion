package micole;

import java.util.Arrays;


public class School {
    
    private String name;
    private Classroom[] classrooms;

    public School(String name) {
        this.name = name;
        this.classrooms = new Classroom[0];
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
    
    
}
