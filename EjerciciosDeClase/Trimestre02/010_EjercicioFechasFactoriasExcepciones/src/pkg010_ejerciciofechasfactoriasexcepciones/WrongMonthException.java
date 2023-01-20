package pkg010_ejerciciofechasfactoriasexcepciones;

public class WrongMonthException extends Exception{

    public WrongMonthException() {
        super("Invalid value for month");
    }
    
}
