package buscamenos;

abstract class Item 
{

    String name;
    private char character;
    
    public Item(String name, char ch) {
        this.name = name;
        this.character = ch;
    }

    public String getName() {
        return name;
    }
    
    public char getCharacter() { return this.character; }
    
}
