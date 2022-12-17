/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg005_pooo;

/**
 *
 * @author Diurno
 */
public class Coche {
    int idCoche;
    private String marca;
    private String modelo;
    private double velocidadMaxima;

    /**
     * El constructor de un coche
     * 
     * @param idCoche <b> El coche en cuestión </b>
     * @param marca La marca del coche en cuestión
     * @param modelo el modelo del vehículo en cuestión
     * @param velocidadMaxima La <b> velocidad </b> máxima del vehículo en cuestión.
     * @throws Exception ¡LANZAMIENTO!
     */
    public Coche(int idCoche, String marca, String modelo, double velocidadMaxima) throws Exception{
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;     
    }
    
}
