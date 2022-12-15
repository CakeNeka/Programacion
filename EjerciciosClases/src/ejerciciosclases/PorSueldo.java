/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosclases;

import javax.swing.JOptionPane;

/**
 *
 * @author Diurno
 */
public class PorSueldo extends Empleado{
    
    double baseSalary;
    int trienios;

    @Override
    public double getSalary() 
    {    
        return baseSalary + trienios * 100;
    }
    
    public double getBaseSalary() 
    {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) 
    {
        if(baseSalary >=900)
            this.baseSalary = baseSalary;
        else
            this.baseSalary = 900;
    }

    public int getTrienios() 
    {
        return trienios;
    }

    public void setTrienios(int trienios) 
    {
        if (trienios >= 0)
            this.trienios = trienios;
        else
            JOptionPane.showMessageDialog(null, "Los trienios no pueden ser"
                    + " negativos");
    }
}
