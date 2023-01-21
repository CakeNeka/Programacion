package excepciones.empresa;

public class Empresa {
    
    private String nombre;
    private String director;
    private String NIF;
    private int numEmpleados;
    private int numSucursales;

    private Empresa(String nombre, String director, String NIF, int numEmpleados, int numSucursales) {
        this.nombre = nombre;
        this.director = director;
        this.NIF = NIF;
        this.numEmpleados = numEmpleados;
        this.numSucursales = numSucursales;
    }
    
    public static Empresa generaEmpresa(String nombre, String director, String NIF, int numEmpleados, int numSucursales) throws WrongNIFException, NegativeEmployeesException, WrongSucursalException{
        if (!compruebaEmpleados(numEmpleados)) {
            throw new NegativeEmployeesException();
        } else if (!compruebaNif(NIF)) {
            throw new WrongNIFException();
        } else if (!compruebaSucursal(numSucursales)) {
            throw new WrongSucursalException();
        } else {
            return new Empresa(nombre, director, NIF, numEmpleados, numSucursales);
        }
    }
    
    static boolean compruebaEmpleados(int empleados) {
        return empleados > 0;
    }

    static private boolean compruebaNif(String NIF) {
        return NIF.length() == 8 && Character.isDigit(NIF.charAt(1));
    }

    static private boolean compruebaSucursal(int numSucursales) {
        return numSucursales > 0;
    }
    
}
