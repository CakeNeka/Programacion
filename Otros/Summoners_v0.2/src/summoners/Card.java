/*
 * You must gather your party before venturing forth
 */
package summoners;

/**
 *
 * @author Martina
 */
public abstract class Card implements Comparable<Card>{


    
    private String name;

    private boolean tapped;   //show if it has already been used in the current turn
    private boolean inBattlefield;
    
    //Getters & Setters:
    public boolean isInBattlefield(){ return inBattlefield; }
    public void setInBattlefield(boolean value){ this.inBattlefield = value;}
    
    public boolean isTapped() { return tapped; }
    public void tap() { this.tapped = true; }
    public void unTap() { this.tapped = false; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    

    public Card(String name) 
    {
        this.tapped = false;
        this.inBattlefield = false;
        this.name = name;
    }
    
    public void use()
    {
        System.out.println("Utilizas la carta");
    }
    
    public void play()
    {
        setInBattlefield(true);
    }

    @Override
    public int compareTo(Card card) 
    {
        String thisName = this.name;
        String cardName = card.name;
        
        return thisName.compareTo(cardName); //utiliza el comparador de Strings
    }

    
    public Card copy()
    {
        return this;
    }

    
    
}
