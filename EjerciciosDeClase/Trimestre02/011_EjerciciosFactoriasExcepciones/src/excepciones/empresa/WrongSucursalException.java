package excepciones.empresa;

public class WrongSucursalException extends Exception {

    public WrongSucursalException() {
        super("Invalid value for field 'Sucursal'");
    }
    
}
