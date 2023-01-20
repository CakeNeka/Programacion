package pkg010_ejerciciofechasfactoriasexcepciones;

public class WrongDayException extends Exception {

    public WrongDayException() {
        super("Invalid value for day");
    }
    
}
