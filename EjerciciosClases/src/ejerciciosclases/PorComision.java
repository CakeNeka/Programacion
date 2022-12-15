/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosclases;

/**
 *
 * @author Diurno
 */
public class PorComision extends Empleado {
    
    int sales;
    double comision;    //comisión de las ventas en %

    @Override
    public double getSalary() 
    {
        double salary = sales*(comision/100);
        if(salary < 900)
            return 900;
        else
            return salary;
    }

    public int getSales() 
    {
        return sales;
    }

    public void setSales(int sales) 
    {
        this.sales = sales;
    }

    public double getComision() 
    {
        return comision;
    }

    public void setComision(float comision) 
    {
        this.comision = comision;
    }

    private PorComision(int sales, double comision) {
        this.sales = sales;
        this.comision = comision;
    }
    
    
}
