package pkg018_herencia;

public class Student extends Person {
    
    private int studentId;
    private float finalMark;

    public Student(int studentId, float finalMark, String name, String surname, int edad) {
        super(name, surname, edad);
        this.studentId = studentId;
        this.finalMark = finalMark;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public float getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }
    
    
    /**
     * Explicación String.format
     *  · Los campos de la clase padre solo son accesibles mediante el getter
     *  · %s para String, %d para números enteros y %f para números de coma flotante
     *  · %-20s significa que el String ocupará 20 caracteres (si mide menos
     *          el resto se rellena con espacios en blanco)
     */
    public void showStudent() {
        String nombre    =  String.format("%-20s %s\n",     "Nombre:",      getName());
        String apellidos =  String.format("%-20s %s\n",     "Apellidos:",   getSurname());
        String edad      =  String.format("%-20s %d\n",     "Edad:",        getEdad());
        String id        =  String.format("%-20s %d\n",     "Identificación:", studentId);
        String notaFinal =  String.format("%-20s %.02f\n",  "Nota Final:",  finalMark);
        
        System.out.println(nombre + apellidos + edad + id + notaFinal);
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", finalMark=" + finalMark + '}';
    }
    
    
    
}
