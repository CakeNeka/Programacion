package buscamenos;

public class Key extends Item
{
    
    private int keyId;

    public int getKeyId() {
        return keyId;
    }

    
    public Key(String name,int keyId) {
        super(name,'K');
        this.keyId = keyId;
    }
    
}
