package defector;

abstract class Entity {
    
    // Position:
    protected int row;
    protected int col;
    private boolean traversable;
    protected GamePanel parent;
    
    // Look.
    private char ch;

    // Constructor
    public Entity(int row, int col, char ch, boolean traversable, GamePanel parent) {
        this.row = row;
        this.col = col;
        this.ch = ch;
        this.traversable = traversable;
        this.parent = parent;
    }

    // Getters / Setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    boolean isTraversable() {
        return traversable;
    }
    
    
}
