/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioq;

/**
 *
 * @author Diurno
 */
public class Factura {
    public String codArticulo;
    public float litrosVendidos;
    public float precioPorLitro;
    
    public float getPrice()
    {
        return litrosVendidos * precioPorLitro;
    }
}
