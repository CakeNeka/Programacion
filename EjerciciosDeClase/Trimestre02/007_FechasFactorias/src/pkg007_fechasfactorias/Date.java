package pkg007_fechasfactorias;

/**
 *
 * @author Diurno 
 * Fecha: 11/01/2023  -- 13/01/2023
 * La fecha mínima será 1/1/400
 */
public class Date {

    // Atributos estáticos
    static int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Atributos
    private int dd;
    private int mm;
    private int yy;

    // Constructor
    private Date(int dd, int mm, int yy) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
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
    }

    void restaDias(int dd) {
        int[] localMonthDays = monthDays.clone();
        if (isLeap(this.yy)) {
            localMonthDays[1] = 29;
        }

        int daysElapsed = 0;
        while (daysElapsed <= dd) {
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
    }

    @Override
    public String toString() {
        return dd + " " + mm + " " + yy;
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
}
