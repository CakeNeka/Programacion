package AbstractFactory;

public class GeneradorFabricaSoldado {
    
    public static FabricaSoldado generaFabrica(String type) {
        type = type.toLowerCase();
        if (type.equals("pesada"))
            return new FabricaSoldadoPesado();
        else if (type.equals("ligera"))
            return new FabricaSoldadoLigero();
        
        return null;
    }
}
