/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosclases;

import java.time.LocalDate;


/**
 *
 * @author Diurno
 */
public abstract class Empleado implements Asalariado {
    
    String name;
    String birthDate; //dd-MM-yyyy
    
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getBirthDate() 
    {
        return birthDate;
    }

    public void setBirthDate(byte day, byte month, short year) 
    {
        if (isAdult(day,month,year))
        {
            this.birthDate = day + "-" + month + "-" + year;
        }
    }
    
    static boolean isAdult(byte day, byte month, short year)
    {
        LocalDate currentdate = LocalDate.now();
        final int CUR_YEAR = currentdate.getYear();
        final int CUR_MONTH = currentdate.getMonthValue();
        final int CUR_DAY = currentdate.getDayOfMonth();
        
        if (year > CUR_YEAR-18)
        {
            return false;
        }
        else if(year < CUR_YEAR-18)
        {
            return true;
        }
        else
        {
            if (month < CUR_MONTH)
            {
                return true;
            }
            else if(month > CUR_MONTH)
            {
                return false;
            }
            else
            {
                return day <= CUR_DAY;
            }
        }
    }
    
    @Override
    public double getSalary() 
    {
        return 0;
    }
    
    
    
}
