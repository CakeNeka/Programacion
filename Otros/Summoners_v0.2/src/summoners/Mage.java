package summoners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Martina
 */
public class Mage {
    
    static Random rand = ThreadLocalRandom.current();
    
    private int hitPoints = 20;
    private ArrayList<Warrior> hand;
    private ArrayList<Warrior> battlefield;
    private String name;
    private HashMap<Character, Integer> curMana;
    private HashMap<Character, Integer> genMana;

    public String getName() { return name + " (" + hitPoints + "/20)"; }
    
    public int getHitPoints() { return hitPoints; }
    public void receiveDamage(int hitPoints) { this.hitPoints -= hitPoints; }
    
    public ArrayList<Warrior> getHand(){ return hand; }
    public Card getHand(int i){ return hand.get(i); }
    
    public ArrayList<Warrior> getBattlefield() { return battlefield; }
    public Card getBattlefield(int i) {return battlefield.get(i); }
    
    
    public int getCurMana(char manaType) { return curMana.get(manaType); }
    public int getCurMana()
    {
        return curMana.get('R') + curMana.get('G') + curMana.get('B'); 
    }
    public void addCurMana(char manaType, int value)
    {
       curMana.put(manaType,curMana.get(manaType) + value);
    }
    public HashMap<Character, Integer> getCurManaMap(){return curMana;}
    
    public int getGenMana(char manaType){ return genMana.get(manaType); }
    public int getGenMana()
    {
        return genMana.get('R') + genMana.get('G') + genMana.get('B'); 
    }
    public void addGenMana(char manaType, int value)
    {
        genMana.put(manaType, genMana.get(manaType) + value);
    }
    
    public void addCard(Warrior newCard)
    {
        hand.add(newCard);
    }
    
    public void updateCards() 
    {
        orderCards(hand);
        orderCards(battlefield);

        for (int i = 0; i < hand.size(); i++) 
        {
            hand.get(i).setOwner(this);
            hand.get(i).unTap();
            if (hand.get(i).isInBattlefield()) 
            {
                battlefield.add(hand.remove(i));
            }
        }
        
        for (int i = 0; i < battlefield.size(); i++) 
        {
            if (battlefield.get(i).getToughness() <= 0)
            {
                System.out.println(battlefield.get(i).getName() + 
                        " ha muerto");
                battlefield.remove(battlefield.get(i));
            }
        }
    }
    
    public void generateMana()
    {
        curMana.put('R', curMana.get('R') + genMana.get('R'));
        curMana.put('G', curMana.get('G') + genMana.get('G'));
        curMana.put('B', curMana.get('B') + genMana.get('B'));
    }
    
    public void displayHand()
    {
        orderCards(hand);   
        System.out.println("In Hand: ");
        for (int i = 0; i < hand.size(); i++) 
            System.out.println((i+1) + "· " + hand.get(i).toString());        
    }
    
    public void displayBattlefield()
    {
        orderCards(battlefield);
        System.out.println("\nIn Battlefield: ");
        for (int i = 0; i < battlefield.size(); i++) 
            System.out.println((i+1) + "· " + battlefield.get(i).toString());
        
    }
    public void displayMana() 
    {
        System.out.printf("MANA GENERATION: Red: %02d, Green: %02d, Blue: %02d, Total: %02d\n",
                getGenMana('R'), getGenMana('G'), getGenMana('B'), getGenMana());
        System.out.printf("AVAILABLE MANA:  Red: %02d, Green: %02d, Blue: %02d, Total: %02d\n",
                getCurMana('R'), getCurMana('G'), getCurMana('B'), getCurMana());
        
    }
    
    public void displayCards()
    {
        updateCards();
        displayMana();
        displayHand();
        displayBattlefield();
    }
    
    private void orderCards(ArrayList<Warrior> cards)
    {
        Collections.sort(cards);
    }
    
    public void untapAll()
    {
        for (Card card : battlefield) 
            card.unTap();
    }
    
    public void getAttacked(Mage attacker)
    {
        ArrayList<Warrior> attackers = new ArrayList<>();
        ArrayList<Warrior> blockers = battlefield;
        int blPow = 0;
        int atPow = 0;
        
        for (Warrior blocker : blockers) 
            blPow += blocker.getPow();
        
        
        for (Warrior attackerC : attacker.getBattlefield()) 
        {
            if (attackerC.isTapped())
            {
                attackers.add((Warrior) attackerC);
                atPow += attackerC.getPow();
            }
        }
        
        for (Warrior blocker : blockers) //blockers receive attack damage
        {
            if (blocker.getToughness() >= atPow)
            {
                blocker.changeToughness(-atPow);
                atPow = 0;
            }
            else
            {
                atPow -= blocker.getToughness();
                blocker.changeToughness(-blocker.getToughness());
            }
        }
        
        if (atPow <= attacker.getHitPoints())   //attacked mage receives damage
            this.receiveDamage(atPow);
        else
            this.receiveDamage(attacker.getHitPoints());
        
        
        
        for (Warrior attackerCreature : attackers) //attackers receive damage   
        {
            if (attackerCreature.getToughness() >= blPow)
            {
                attackerCreature.changeToughness(-blPow);
                blPow = 0;
            }
            else
            {
                blPow -= attackerCreature.getToughness();
                attackerCreature.changeToughness(-attackerCreature.getToughness());
            }
        }
        
        //attacker mage does not receives damage
    }
    
    public void mergeWarriors(int ind1, int ind2)
    {
        Warrior w1 = (battlefield.get(ind1));
        Warrior w2 = (battlefield.get(ind2));
        battlefield.remove(w2);
        battlefield.remove(w1);
        MagicGame.mergesPerTurn--;
        
        Warrior mergedWr = new Warrior( w1.getName() + " " + w2.getName(),
                w1.getPow() + w2.getPow(),w1.getToughness() + w2.getToughness(),
                w1.getCanFly() && w2.getCanFly(),w1.getManaRq('R') + w2.getManaRq('R'),
                w1.getManaRq('G') + w2.getManaRq('G'), w1.getManaRq('B') + w2.getManaRq('B'),
                w1.getManaRq('A') + w2.getManaRq('A'));

        mergedWr.setOwner(this);
        mergedWr.setTurnEntered(MagicGame.turn);
        
        battlefield.add( mergedWr );

        System.out.println("Merged successfully. " +
                MagicGame.mergesPerTurn + " merges left");
    }
    
    public void change(int ind)
    {
        hand.set(ind,(Warrior)MagicGame.creatureDeck.get(rand.nextInt(MagicGame.creatureDeck.size())).copy());
    }
    
    public Mage(String name) 
    {
        System.out.println("building...");
        this.hand = new ArrayList<>();
        this.battlefield = new ArrayList<>();
        this.curMana = new HashMap<>();
        this.genMana = new HashMap<>();
        this.name = name;
        
        this.curMana.put('R', 0);
        this.curMana.put('G', 0);
        this.curMana.put('B', 0);

        this.genMana.put('R', 0);
        this.genMana.put('G', 0);
        this.genMana.put('B', 0);
    }
}
