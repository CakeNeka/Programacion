package pkg019_figurasgeometricas;

public class FiguraGeometrica {
    
    private double tamano;

    public FiguraGeometrica(double tamano) {
        this.tamano = tamano;
    }
    

    @Override
    public String toString() {
        return "FiguraGeometrica{" + "tamano=" + tamano + '}';
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    
}
