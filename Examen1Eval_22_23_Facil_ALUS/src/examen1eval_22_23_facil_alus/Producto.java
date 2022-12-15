/*
 * Clase Producto
Campos: - nombre del producto
        - fecha de compra, fecha en la que se compró este producto
        - número de Albarán, donde figura la compra de este producto
        - pvp, precio por unidad
        - unidades de este producto, comprado en la fecha indicada con nº albarán indicado
        - preciototal --> saco el precio total, según el pvp, el nº de unidades 
                y el dto de la tienda y el mes indicado en la fecha
        - Un array bidimensional llamado descuentos que me dice, según el nº de tienda (de 5)
        y el nº de mes, qué descuento se aplica (aleatorio entre 0%, 10%, 20%, 35%, 50%)
 */
package examen1eval_22_23_facil_alus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Date;
import java.util.Random;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Rut
 */
public class Producto {
    final byte numTiendas = 15;
    
    private String nombre;
    private LocalDate fecha;
    private String albaran;
    private double pvp;
    private int unidades;
    private double precioTotal;
    private int tienda;
    private int[][] descuentos;

    public Producto(String nombre, String fecha, double pvp, int unidades, int tienda) {
        this.nombre = nombre;
        this.pvp = pvp;
        this.unidades = unidades;
        this.tienda = tienda;
        setFecha(fecha);
        setAlbaran2();
        setDescuentos();
        setPrecioTotal();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // 1 pto  (setFecha)
    public void setFecha(String fecha){
        try{
            this.fecha = LocalDate.parse(fecha);
        } catch (DateTimeParseException e){ 
            this.fecha = null;
        }
    }
    
    // 1 pto (getFecha)
    public String getFecha(){
        if (this.fecha == null) return null;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd-MM-yyyy");  
        return formatter.format(this.fecha);
    }

    public String getAlbaran() {
        return albaran;
    }

    
    // 2 ptos
    public void setAlbaran() {
        // El albarán será un String con la fecha + 3 primeros caracteres nombre 
        // + número de la tienda con dos dígitos
        StringBuilder albaranSb = new StringBuilder();
        if (getFecha() != null){
            char[] fechaChars = getFecha().toCharArray();
            for (char ch : fechaChars) {
                if (Character.isDigit(ch))
                    albaranSb.append(ch);
            }
        }
        else{
            albaranSb.append("DDMMYYYY");
        }
        
        // En caso de que el nombre tenga menos de 3 letras
        if (nombre.length() < 4){
            albaranSb.append(nombre.toUpperCase());
        }else{
            albaranSb.append(nombre.substring(0, 3).toUpperCase());
        }
        
        albaranSb.append(String.format("%02d",tienda)); 
        this.albaran = albaranSb.toString();
    }
    
    void setAlbaran2(){
        if (fecha != null)
            this.albaran = DateTimeFormatter.ofPattern("ddMMyyyy").format(fecha) 
                    + nombre.substring(0,3).toUpperCase() + String.format("%02d",tienda);
        else
             this.albaran = "DDMMYYYY" + nombre.substring(0,3).toUpperCase() + String.format("%02d",tienda);
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getTienda() {
        return tienda;
    }

    public void setTienda(int tienda) {
        this.tienda = tienda;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    // 2,5 ptos
    public void setPrecioTotal() {
        int mes = obtenerMes();
        if (mes == -1) 
            mes = 0;
        
        double precioSinDesc = pvp * unidades;
        double descuento = precioSinDesc * ((double)descuentos[tienda][mes] / 100);
        precioTotal = (precioSinDesc - descuento);
    }
    
    int obtenerMes(){
            if (fecha == null) return -1;
        return fecha.getMonthValue()-1;
    }

    // 2 ptos
    public void setDescuentos() {
        descuentos = new int[15][12];
        for (int i = 0; i < descuentos.length; i++) {
            for (int j = 0; j < descuentos[i].length; j++) {
                descuentos[i][j] = generaDescuento();
            }
        }
    }
           
    private int generaDescuento(){
        Random random = new Random();
        int generador = random.nextInt(60);
        int descuento = 50;
        
        if (generador < 10)
            descuento = 0;
        else if(generador >= 10 && generador < 20 )
            descuento = 10;
        else if(generador >= 20 && generador < 35)
            descuento = 20;
        else if(generador >= 35 && generador < 50)
            descuento = 35;
        
        return descuento;
    }

    
    public void muestraDescuentos() {
        final int numMeses = 12;
        for (int i = 0; i < numTiendas; i++) {
            System.out.println("Tienda " + i + ": ");
            for (int j = 0; j < numMeses; j++) {
                System.out.print(descuentos[i][j] + " ");
            }
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "Producto{Nombre=" + nombre + ", fecha=" + fecha + ", albaran=" 
                + albaran + ", pvp=" + pvp + ", unidades=" + unidades +", "
                + "tienda =" + tienda + ", precioTotal=" + precioTotal + '}';
    }

    
}
