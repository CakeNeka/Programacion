package pkg029_preguntaexamen;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable{
    
    private String modelo;
    private String matricula;

    public Car(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return modelo + " " + matricula;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return Objects.equals(this.matricula, other.matricula);
    }
    
    
    
    
    
    
}
