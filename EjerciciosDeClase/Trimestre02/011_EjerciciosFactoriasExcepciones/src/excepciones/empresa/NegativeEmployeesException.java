package excepciones.empresa;

public class NegativeEmployeesException extends Exception {

    public NegativeEmployeesException() {
        super("Field 'Employees does not accept negative values");
    }
    
}
