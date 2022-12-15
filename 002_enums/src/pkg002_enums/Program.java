/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg002_enums;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * FUncón llamda pedri dia que le pida el dia de la semana al suuario. a funcion
 * devolverá el día de la semana introducida y sis el usuario introduce algo
 * erróneo avmoas a buscar el día de la semana al sol y devolvemos este día
 */
public class Program {
    
    public static enum Week {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
    static Random random = ThreadLocalRandom.current();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        System.out.println(pedirDia());
    }
    
    public static Week pedirDia()
    {
        System.out.println("Introduce un día: ");
        System.out.print(">>");
        String input = scan.nextLine();
        input = input.toUpperCase();
        try
        {
            return Week.valueOf(input);
        }
        catch(IllegalArgumentException e)
        {
            Calendar c = Calendar.getInstance();
            return Week.values()[c.get(Calendar.DAY_OF_WEEK) - 1];
        }
    }
    
    ///
    
    public static Week verFechaDani()
    {
        Week dia;
        Date hoy = new Date();
        String diaSpain = new SimpleDateFormat("EE").format(hoy);
        switch (diaSpain)
        {
            case "lun": dia = Week.MONDAY;
            break;
            case "mar": dia = Week.TUESDAY;
            break;
            case "mie": dia = Week.WEDNESDAY;
            break;
            default: dia = Week.FRIDAY; //...
            break;
        }
        return dia;
    }
    
}
