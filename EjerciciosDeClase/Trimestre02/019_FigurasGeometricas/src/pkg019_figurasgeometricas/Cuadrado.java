package pkg019_figurasgeometricas;

class Cuadrado extends FiguraCerrada{
    
    private double area;

    public Cuadrado(double area, int nlados, double tamano) {
        super(nlados, tamano);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public void dibujar() {
        String s = " ------- \n" +
                   "|       |\n" +
                   "|       |\n" +
                   "|       |\n" +
                   " ------- \n";
        System.out.print(s);
    }
    
    
}
