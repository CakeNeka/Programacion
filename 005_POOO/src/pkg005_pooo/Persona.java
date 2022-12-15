package pkg005_pooo;

import java.util.ArrayList;
import java.util.List;


public class Persona {
    enum Nacionalidad {ESPAÑOLA, INGLESA, ALEMANA, CUBANA, JAPONESA, INDIO, APÁTRIDA}
    enum Sexo {HOMBRE, MUJER, FLUIDO}
    List<Persona> hijos;
    
    // Atributos
    String nombre;
    float altura;
    float peso;
    Nacionalidad nacionalidad;
    boolean europea ;
    String dni;
    byte edad;
    Sexo sexo;

    public String getSexo() {
        if (sexo != null)
            return sexo.toString();
        return "HOMBRE";
    }

    public void setSexo(String sexo) {
        try{
            this.sexo = Sexo.valueOf(sexo);
        } catch (IllegalArgumentException e){
            this.sexo = Sexo.valueOf("HOMBRE");
        }
    }
    
    // Métodos
    // CONSTRUCTOR
    public Persona(String unNombre, float altura, float miPeso, String nacionalidad,
                    String miDni, byte edad, String sexo){
        nombre = unNombre;
        this.altura = altura;
        peso = miPeso;
        setNacionalidad(nacionalidad);
        dni = miDni;
        this.edad = edad;
        setSexo(sexo);
        
        hijos = new ArrayList<Persona>();
    }
    
    //SOBRECARGA DE MÉTODOS
    public Persona(){
        nombre="";
        altura = 0;
        peso = 0;
        setNacionalidad("");
        dni="";
        edad=0;
        
        hijos = new ArrayList<Persona>();
    }
    
    // toString
    public void mostrarPersona(){
        System.out.printf("%s mide %.2f m, pesa %.2f kgs, tiene %d años y es "
                + "de nacionalidad %s.\nSu DNI es %s\n", nombre, altura, peso, 
                        edad, nacionalidad,dni );
    }
    
    // SETTERS
    // Métodos para cambiar los valores de los atributos

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setAltura(float altura){
        this.altura = altura;
    }
    
    public void setPeso(float unPeso){
        peso = unPeso;
    }   
    
    public void setNacionalidad(String nacion){
//        Nacionalidad pais= null;
        nacion = nacion.toUpperCase();
        try{
            nacionalidad = Nacionalidad.valueOf(nacion); 
        } catch (IllegalArgumentException error){
            nacionalidad = Nacionalidad.APÁTRIDA;
        }
        setEuropeo();
       
    }
    public void setEuropeo(){
        switch(nacionalidad){
            case ESPAÑOLA :
            case INGLESA :              
            case ALEMANA :
                 europea = true;
                 break;
          
            default:
                europea = false;
            
        }
    }
    
    
    public void setDni(String miDni){
        dni = miDni;
    }
    
    public void setEdad(byte edad){
        if (edad<=120 && edad >=0) this.edad = edad;
        else this.edad = -1;
    }  
    
    //GETTERS
    public String getNombre(){
        return nombre;
    }
    
    public float getAltura(){
        return altura;
    }
    
    public float getPeso(){
        return peso;
    }   
    
    public String getNacionalidad(){
        return nacionalidad.toString();
    }
    
    public String getDni(){
        return dni;
    }
    
    public byte getEdad(){
        return edad;
    }  
    
    public boolean getEuropeo(){
        return europea;
    }
    
    @Override
    public String toString(){
        
        StringBuilder result = new StringBuilder();
        result.append(nombre);
        String s = getSexo();
        
        if (s != null){
            switch(s){
                case "HOMBRE":
                    result.append(" es un hombre");
                    break;
                case "MUJER": 
                    result.append(" es una mujer");
                    break;
                case "FLUIDO":
                    result.append(" es un fluido");
                    break;
                default:
                    result.append(" no es identificado");
            }
        } else {
            result.append(", no es identificado");
        }
        
        
        result.append(String.format(". %s mide %.02f m , pesa %.02f kgs, tiene %d "
                + "años y es de nacionalidad %s",nombre,altura,peso,edad, getNacionalidad()));
             
        return result.toString();
    }
    
    
    public void saludar(){
        System.out.println(nombre + "dice 'Hola!'");
    }
    
    public void comer(String comida){
        // La comida puede ser pasteles, verdura, carne, pasta, pescado.
        switch (comida){
            case "Pasteles": peso += 5; 
                             break;
            case "Pasta": peso += 3; 
                             break;
            case "Carne": peso += 1; 
                             break;
            case "Pescado": peso += 0.5; 
                             break;
            case "Verdura": peso += 0.1; 
                             break;
        }
    }
    
    public void correr(){
        peso -= 2;
    }
    
    public void cumplirAños(){
        edad += 1;
    }
    
}
