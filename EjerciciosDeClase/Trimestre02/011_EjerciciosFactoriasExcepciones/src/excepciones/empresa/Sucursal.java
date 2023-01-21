package excepciones.empresa;

public class Sucursal {
    
    int numEmpleados;
    String responsable;
    String direccion;

    private Sucursal(int numEmpleados, String responsable, String direccion) {
        this.numEmpleados = numEmpleados;
        this.responsable = responsable;
        this.direccion = direccion;
    }
    
    public Sucursal generaSucursal(int numEmpleados, String responsable, String direccion) throws NegativeEmployeesException {
        
        if (!compruebaEmpleados(numEmpleados)) {
            throw new NegativeEmployeesException();
        } else {
            return new Sucursal(numEmpleados, responsable, direccion);
        }
        
    }
    
    boolean compruebaEmpleados(int empleados) {
        return empleados >= 0;
    }
}
