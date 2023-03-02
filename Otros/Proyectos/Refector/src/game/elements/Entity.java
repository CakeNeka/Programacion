package game.elements;

public abstract class Entity {
    
    private Tile parent;
    private String name;
    
    public Entity() { }
    public Entity(Tile parent) {
        this.parent = parent;
        name = "Entity";
    }
    public Entity(Tile parent, String name) {
        this.parent = parent;
        this.name = name;
    }
    
    
    public abstract String getSymbol();
    
    public void setParent(Tile parent){
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
