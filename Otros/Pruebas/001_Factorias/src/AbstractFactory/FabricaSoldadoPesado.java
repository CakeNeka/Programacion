package AbstractFactory;

class FabricaSoldadoPesado implements FabricaSoldado {

    @Override
    public Infanteria creaInfanteria() {
        return new Pretoriano();
    }

    @Override
    public Caballeria creaCaballeria() {
        return new Catafracto();
    }
    
}
