package firstpackage;

/**
 *
 * @author CakeNeka
 * 2022-12-19
 * 
 */
public class Alumno {
    private String nombre;
    int numAlumnos;
    int[] notas;
    
    // Métodos
    /**
     * 
     * @param nombre El nombre del alumno
     * @param numAlumnos El número del alumno
     * @param notas Las notas de clase
     */
    Alumno(String nombre, int numAlumnos, int[] notas) {
        this.nombre = nombre;
        this.numAlumnos = numAlumnos;
        this.notas = notas;
    }

    /**
     * 
     * @return String representation of the object
     */
    @Override
    public String toString() {
        String str = "Alumno{" + "nombre=" + nombre + ", numAlumnos=" + numAlumnos + ", notas: ";
        for (int nota : notas) {
            str += nota + " ";
        }
        return str;
    }
    
    
    
    public Alumno() {
        this.nombre = "";
        this.numAlumnos = 1;
        notas = new int[10];
    }
    
    // Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        boolean correct = true;
        if (notas != null){
            int i = 0;
            while (i < notas.length && correct){
                if (notas[i] < 0 || notas[i] > 10)
                    correct = false;
            }
        }
        if (correct)
                this.notas = notas;
    }
    
    
    
}
