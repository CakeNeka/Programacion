package defector;

abstract class Entity {
    
    // Position:
    private int row;
    private int col;
    private boolean traversable;
    
    // Look.
    private char ch;

    // Constructor
    public Entity(int row, int col, char ch, boolean traversable) {
        this.row = row;
        this.col = col;
        this.ch = ch;
        this.traversable = traversable;
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
    
    
}
