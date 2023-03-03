/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenandohashmap;

import java.util.Objects;

/**
 *
 * @author Rut
 */
public class Personilla implements Comparable<Personilla>{
    String nombre;
    String apellidos;
    int years;

    public Personilla(String nombre, String apellidos, int years) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.years = years;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
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
        final Personilla other = (Personilla) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Personilla{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", years=" + years + '}';
    }

    @Override
    public int compareTo(Personilla t) {
        return nombre.compareToIgnoreCase(t.getNombre());
    }
    
}
