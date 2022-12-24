package micole;

import java.util.Arrays;
import java.util.Collections;

public class Grupo {

    private String name;
    private Student[] students;
    private Classroom classroom;

    public Grupo(String name) {
        this.name = name;
        this.students = new Student[Classroom.DEFAULT_CAPACITY];
    }

    public Grupo(String name, Classroom classroom) {
        this.name = name;
        this.classroom = classroom;
        this.students = new Student[classroom.getCapacity()];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNumber() {
        sortStudentArray();
        Student curSt = students[0];
        int i = 0;
        while (curSt != null && i < students.length) {
            curSt = students[i];
            i++;
        }
        return i;
    }

    public void addStudent(Student student) {
        sortStudentArray();
        int i = 0;
        while (students[i] != null) {
            i++;
        }
        if (i < students.length) {
            students[i] = student;
            student.setGrupo(this);
        } else {
            System.out.println("El grupo está lleno (not posivol) ");
        }
    }

    public Student getStudent(int index) {
        sortStudentArray();
        return students[index];
    }

    public Student deleteStudent(int index) {
        sortStudentArray();
        Student deleted = students[index];
        students[index] = null;
        return deleted;
    }

    public Student deleteStudent(Student student) {
        sortStudentArray();
        int i = 0;
        while(!student.equals(students[i]))
            i++; 
        
        return deleteStudent(i);
    }

    public Student[] getStudents() {
        sortStudentArray();
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        if (getStudentNumber() <= classroom.getCapacity()) {
            this.classroom = classroom;
            students = Arrays.copyOf(students, classroom.getCapacity());
        } else {
            System.out.println("no ha sido posible cambiar de clase");
        }
    }

    private void sortStudentArray() {
        int swaps;
        Student temp;

        do {
            swaps = 0;
            for (int i = 0; i < students.length - 1; i++) {
                if (students[i] == null && students[i + 1] != null) {
                    temp = students[i + 1];
                    students[i + 1] = students[i];
                    students[i] = temp;
                    swaps++;
                } 
                else if (students[i] != null && students[i+1] != null) {
                    if (students[i].compareTo(students[i + 1]) > 0) {
                        temp = students[i + 1];
                        students[i + 1] = students[i];
                        students[i] = temp;
                        swaps++;
                    }
                }
            }
        } while (swaps > 0);
    }

}
