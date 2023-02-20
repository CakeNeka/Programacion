package game.elements;

/**
 *
 * @author Neka
 */
abstract class Entity {
    
    private Tile parent;

    public Entity() { }
    public Entity(Tile parent) {
        this.parent = parent;
    }
    
    
    
    
    public abstract String getSymbol();
    
    public void setParent(Tile parent){
        this.parent = parent;
    }
}
