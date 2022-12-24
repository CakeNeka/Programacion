package micole;

import java.time.LocalDate;

public class MiPrograma {

    public static void main(String[] args) {
        Student st = new Student("Juan", "gintoni", "020202");
        st.birthDay = LocalDate.of(2000, 12, 22);
        System.out.println(st.getEdad());
        
        Classroom clase = new Classroom(109,2);
        Grupo gr = new Grupo("1 DAM A", clase);
        gr.addStudent(st);
        gr.addStudent(new Student("marcos", "zocaparda", "dni"));
        System.out.println(gr.getStudent(1));
        gr.deleteStudent(st);
        System.out.println(gr.getStudent(0));
        
        System.out.println(gr.getStudent(0).getSchool());
        School IZV = new School("El Templo Maldito");
        IZV.addClassroom(clase);
        System.out.println(gr.getStudent(0).getSchool());
        
    }
    
}
