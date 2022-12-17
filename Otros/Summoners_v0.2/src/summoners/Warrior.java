package summoners;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Martina
 */
public class Warrior extends Card {
    
    public Mage owner;
    
    private int toughness;
    private int pow;
    private boolean canFly;
    private int turnEntered;
    
    //mana requirements:
    private Map<Character, Integer> manaRq = new HashMap<Character, Integer>();
    
    //Getters & Setters
    public boolean getCanFly() { return canFly; }

    public void setCanFly( boolean canFly) { this.canFly = canFly; }

    public int getToughness() { return toughness; }

    public void changeToughness(int value) { this.toughness = toughness + value; }

    public int getPow() { return pow; }
    
    public void setPow(int pow) { this.pow = pow; }
    
    public int getTurnsInBtf() { return MagicGame.turn - this.turnEntered; }
    
    public void setOwner(Mage owner){ this.owner = owner; }
    
    public int getManaRq(Character c) {return this.manaRq.get(c);}
    //

    public int getTurnEntered() { return turnEntered; }

    public void setTurnEntered(int turnEntered) { this.turnEntered = turnEntered; }
    

    
    
    
    public Warrior(String name,int pow, int hp) 
    {
        super(name);
        this.canFly = false;
        this.toughness = hp;
        this.pow = pow;
        
    }
    
    public Warrior(String name, int pow, int toughness, boolean canFly,
             int redMana, int greenMana, int blueMana, int anyMana) 
    {
        super(name);
        this.toughness = toughness;
        this.pow = pow;
        this.canFly = canFly;
        
        this.manaRq.put('R', redMana);
        this.manaRq.put('G', greenMana);
        this.manaRq.put('B', blueMana);
        this.manaRq.put('A', anyMana);
    }
    
    @Override
    public void play()
    {
        boolean conditionsMet = manaRq.get('R') <= owner.getCurMana('R')
                && manaRq.get('G') <= owner.getCurMana('G')
                && manaRq.get('B') <= owner.getCurMana('B')
                && manaRq.get('A') <= owner.getCurMana() - manaRq.get('R')
                 - manaRq.get('G')- manaRq.get('B'); 
                
        if (conditionsMet) 
        {
            super.play();
            this.tap();
            turnEntered = MagicGame.turn;
            int i = manaRq.get('A');
            
            for (Map.Entry<Character, Integer> entry  : manaRq.entrySet()) 
            {
                if (entry.getKey() != 'A')
                {
                    owner.addCurMana(entry.getKey(),-entry.getValue());
                }
            }
            
            for (char ch : owner.getCurManaMap().keySet()) 
            {
                if(owner.getCurMana(ch) >= i)
                {
                    owner.addCurMana(ch, -i); 
                    i = 0;
                }
                else if(owner.getCurMana(ch) > 0)
                {
                    i -= owner.getCurMana(ch);
                    owner.addCurMana(ch, -owner.getCurMana(ch));
                }
            }
        }
        else
        {
            System.out.println("No tienes suficiente mana");
        }
    }
    
    @Override
    public void use()
    {
        if (getTurnsInBtf() == 0)
        {
            System.out.println(getName() + " suffers from summoning sickness!");
        }
        else
        {
            tap();
        }
    }

    @Override
    public String toString() 
    {
        //display mana values here
        String mana = "{" + manaRq.get('R') + "," + manaRq.get('G') + "," + 
                manaRq.get('B') + "," + manaRq.get('A') + "}";
        
        String tap = isTapped() ? "tapped":"untapped";
        String fly = getCanFly() ? "flying":"ground";
        return "Creature{" + getName() + ", " + tap
                + ", [" + pow + "/" + toughness + "], " + fly + '}' + mana;
    }
    
    @Override
    public Card copy()
    {
        return new Warrior(this.getName(),pow, toughness,canFly,
                manaRq.get('R'),manaRq.get('G'),manaRq.get('B'),manaRq.get('A'));
    }
    
}
