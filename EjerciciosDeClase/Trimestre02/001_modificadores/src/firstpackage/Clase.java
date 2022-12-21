package firstpackage;
/**
 *
 * @author CakeNeka
 * 2022-12-20
 */


public class Clase {
    final int MAX_ALUMNOS = 20; 
    
    public String nombre;       // Accesible desde todas las clases y paquetes
    private int numAlus;        // Accesible solo desde la misma clase
    Alumno[] alumnos;           // Accesible desde todas las clases del mismo paquete
    
    /**
     * 
     * @param nombre Nombre de la clase
     * @param numAlus Número de alumnos en la clase
     * @param alumnos array de Alumno 
     */
    public Clase(String nombre, int numAlus, Alumno[] alumnos) {
        this.nombre = nombre;
        this.numAlus = numAlus;
        this.alumnos = new Alumno[numAlus];
    }
    
    public Clase(){
        alumnos = new Alumno[MAX_ALUMNOS];
        nombre = "";
        numAlus = -1;
    }
    
    public void addAlumno(Alumno newAlumno, int index){
        alumnos[index] = newAlumno;
    }

    @Override
    public String toString() {
        String str = "Clase{" + "MAX_ALUMNOS=" + MAX_ALUMNOS + ", nombre=" 
                + nombre + ", numAlus=" + numAlus + "\nalumnos=";
        StringBuilder sb = new StringBuilder();
        for (Alumno alumno : alumnos) {
            sb.append(alumno);
            sb.append("\n");
        }
        return str + sb.toString();
    }
    
    // Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumAlus() {
        return numAlus;
    }
    
    /**
     * 
     * @param numAlus Número de alumnos
     */
    public void setNumAlus(int numAlus) {
        if (numAlus >= 0 && numAlus < MAX_ALUMNOS)
            this.numAlus = numAlus;
        else 
            this.numAlus = 0;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }
    
    
}
