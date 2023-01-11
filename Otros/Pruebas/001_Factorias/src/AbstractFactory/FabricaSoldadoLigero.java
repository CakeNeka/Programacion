package AbstractFactory;

class FabricaSoldadoLigero implements FabricaSoldado{

    @Override
    public Infanteria creaInfanteria() {
        return new Legionario();
    }

    @Override
    public Caballeria creaCaballeria() {
        return new Equite();
    }
    
}
