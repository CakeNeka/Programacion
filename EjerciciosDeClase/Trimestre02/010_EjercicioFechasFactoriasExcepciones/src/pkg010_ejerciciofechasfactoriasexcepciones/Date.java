package pkg010_ejerciciofechasfactoriasexcepciones;

/**
 *
 * @author Diurno 
 * Fecha 20-01-2023
 */
public class Date {

    // Atributos estáticos
    static int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Atributos
    private int dd;
    private int mm;
    private int yy;
    private boolean leapYear;

    // Constructor
    private Date(int dd, int mm, int yy) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
        
        leapYear = isLeap(yy);
    }

    // Factoria
    public static Date generateDate(int dd, int mm, int yyyy) {
        if (isCorrect(dd, mm, yyyy)) {
            return new Date(dd, mm, yyyy);
        } else {
            return null;
        }
    }

    // Sumar/Restar dias
    void sumaDias(int diasASumar) {
        int[] localMonthDays = monthDays.clone();
        
        if (isLeap(this.yy)) {
            localMonthDays[1] = 29;
        }

        while (diasASumar > 0) {
            diasASumar--;
            this.dd++;

            // Comprobaciones (final de mes y año)
            if (this.dd > localMonthDays[this.mm - 1]) {
                this.dd = 1;
                this.mm++;

                if (this.mm > 12) {
                    this.dd = 1;
                    this.mm = 1;
                    this.yy++;

                    if (isLeap(this.yy)) {
                        localMonthDays[1] = 29;
                    } else {
                        localMonthDays[1] = 28;
                    }
                }
            }
        }
        
        leapYear = isLeap(yy);
    }
    
    void alterSumaDias(int dd){
        int[] localMonthDays = monthDays.clone();
        this.dd += dd;
        if (isLeap(this.yy)){
            localMonthDays[1] = 29;
        }
        
        while(this.dd > localMonthDays[this.mm-1]) {

            this.dd -= localMonthDays[this.mm-1];
            this.mm++;
            if (this.mm > 12){
                this.mm = 1;
                this.yy++;
                
                if (isLeap(this.yy)){
                    localMonthDays[1] = 29;
                } else {
                    localMonthDays[1] = 28;
                }
            }
        }
        
        leapYear = isLeap(yy);
    }
    
    void restaDias(int dd) {
        int[] localMonthDays = monthDays.clone();
        if (isLeap(this.yy)) {
            localMonthDays[1] = 29;
        }

        int daysElapsed = 0;
        while (daysElapsed < dd) {
            daysElapsed++;
            this.dd--;

            // Comprobaciones (final de mes y año)
            if (this.dd < 1) {

                this.mm--;
                this.dd = localMonthDays[this.mm];

                if (this.mm < 1) {

                    this.mm = 12;
                    this.dd = 31;
                    this.yy--;

                    if (isLeap(this.yy)) {
                        localMonthDays[1] = 29;
                    } else {
                        localMonthDays[1] = 28;
                    }
                }
            }
        }
        
        
        leapYear = isLeap(yy);
    }

    @Override
    public String toString() {
        String s = " no ";
        if (leapYear) s = " ";
        return dd + " " + mm + " " + yy + s + "es bisiesto";
    }

    // Static methods
    static boolean isCorrect(int dd, int mm, int yy) {
        return (mm >= 1 && mm <= 12 && yy >= 400) && (dd <= monthDays[mm - 1] && dd > 0) || (dd == 29 && mm == 2 && isLeap(yy));
    }

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
//    
//    static boolean dateIsCorrect(Date d) {
//        int[] localMonthDays = monthDays.clone();
//        
//        if (d.mm < 1 || d.mm > 12 || d.yy < 400) return false;
//        if (isLeap(d.yy)) localMonthDays[1]++;
//        int maxDay = localMonthDays[d.mm-1];
//        return (d.dd <= maxDay && d.dd > 0);
//    }
//    static boolean dateIsCorrect(int dd, int mm, int yyyy){
//        return dateIsCorrect(new Date(dd,mm,yyyy));
//    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) throws WrongDayException {
        if (isCorrect(yy,dd,mm)){
            this.dd = dd;
        } else {
            throw new WrongDayException();
        }
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) throws WrongMonthException {
        if (isCorrect(yy,dd,mm)){
            this.mm = mm;
        } else {
            throw new WrongMonthException();
        }
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) throws WrongYearException {
        if (isCorrect(yy,dd,mm)){
            this.yy = yy;
        } else {
            throw new WrongYearException();
        }
    }
}
