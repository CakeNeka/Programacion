package pkg019_figurasgeometricas;

public class FiguraCerrada extends FiguraGeometrica{
    
    private int nlados;

    public FiguraCerrada(int nlados, double tamano) {
        super(tamano);
        this.nlados = nlados;
    }
    
    public void dibujar() {
        String s = " ------- \n" +
                   "|       |\n" +
                   "|       |\n" +
                   "|       |\n" +
                   "|       |\n" +
                   "|       |\n" +
                   "|       |\n" +
                   "|       |\n" +
                   "|       |\n" +
                   " ------- \n";
        System.out.print(s);
    }

    @Override
    public String toString() {
        return "FiguraCerrada{" + "" + ",nlados=" + nlados + '}';
    }

    
    
    
    
}
