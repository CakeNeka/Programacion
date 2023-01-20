package pkg010_ejerciciofechasfactoriasexcepciones;

public class WrongYearException extends Exception {

    public WrongYearException() {
        super("Invalid value for year");
    }
    
    
}
