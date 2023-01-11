package pkg007_fechasfactorias;

/**
 *
 * @author Diurno
 * Fecha:  11/01/2023
 * La fecha mínima será 1/1/400
 */
public class Date {
    
    // Atributos estáticos
    static int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    
    // Atributos
    private int dd;
    private int mm;
    private int yy;
    
    // Constructores

    private Date(int dd, int mm, int yy) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }
    
    public static Date generateDate(int dd, int mm, int yyyy){
        if (dateIsCorrect(dd,mm,yyyy))
            return new Date(dd,mm,yyyy);
        else 
            return null;
    }

    @Override
    public String toString() {  
        return dd + " " + mm + " " + yy;
    }
    
    // Static methods
    static boolean dateIsCorrect(Date d) {
        if (d.mm < 1 || d.mm > 12 || d.yy < 400) return false;
        if (isLeap(d.yy)) monthDays[1]++;
        int maxDay = monthDays[d.mm-1];
        return (d.dd <= maxDay && d.dd > 0);
    }
    
    static boolean isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    static boolean dateIsCorrect(int dd, int mm, int yyyy){
        return dateIsCorrect(new Date(dd,mm,yyyy));
    }
    
}
