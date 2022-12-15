package buscamenos;


public class Gate extends Cell {
    
    private int gateId;
    private boolean end;
    private int levelPointer;
    
    private int rowTeleport;
    private int colTeleport;

    public Gate(int row, int col, int id, boolean end, boolean isTraversable,
            int levelPointer, int rowTeleport, int colTeleport) 
    {
        super(isTraversable, row, col);
        this.gateId = id;
        this.end = end;
        this.levelPointer = levelPointer;
        
        this.rowTeleport = rowTeleport;
        this.colTeleport = colTeleport;
    }
    
    public Gate(int row, int col, int id) 
    {
        super(false, row, col);
        this.gateId = id;
        this.end = false;
    }

    public int getLevelPointer() { return levelPointer; }

    public int getGateId() { return gateId; }
    
    public boolean isEnd() { return end; }
    
    
    public int getRowTeleport() {
        return rowTeleport;
    }

    public int getColTeleport() {
        return colTeleport;
    }
    
    @Override
    public char getCellChar() 
    {
        if (this.isTraversable())
            return '_'; 
        return '|';
    }
    
    public void open(Key k)
    {
        if(k.getKeyId() == this.gateId)
        {
            this.setTraversable(true);
        }
    }
}
