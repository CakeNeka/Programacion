package summoners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Martina
 */



public class MagicGame 
{
    
    static Random random = ThreadLocalRandom.current();
    static Scanner scan = new Scanner(System.in);
    
    public static ArrayList<Warrior> creatureDeck = new ArrayList<>();
    static String[] phases = {"main", "combat"};
    static int currentPhase = 0;
    
    public static int turn = 1;
    
    static int attacksPerTurn;
    static int mergesPerTurn;
    static int changesPerTurn; 
    static int manaGeneration;
    
    static Mage player1 = new Mage("Blasting Cohete");
    static Mage player2 = new Mage("Nes Mágico");
    static Mage curPlayer;
    static Mage curEnemy;
                                                
    public static void main(String[] args) 
    {          
        clearConsole();
        setUpCardList();

        for (int i = 0; i < 3; i++) 
        {
            player1.addCard((Warrior) creatureDeck.get(random.nextInt(creatureDeck.size())).copy());
            player2.addCard((Warrior) creatureDeck.get(random.nextInt(creatureDeck.size())).copy());
        }
       
        mainLoop();
    }
    
    static void mainLoop()
    {
        boolean gameOver = false;
        curPlayer = player1;
        curEnemy = player2;
        String input;
        manaGeneration = 2;
        
        while(player1.getHitPoints() > 0 && player2.getHitPoints() > 0)
        {
            input = "";
            currentPhase = 0;
            attacksPerTurn = 1;
            mergesPerTurn = 1;
            changesPerTurn = 2;
            curPlayer.untapAll();
            
            while(!input.equals("R") && !input.equals("G") && !input.equals("B"))
            {
                displayInfo();
                System.out.printf("Asign value %d to (R)ed, (G)reen, or (B)lue"
                                    + " Mana Generation\n", manaGeneration);
                System.out.print(">>");
                input = scan.nextLine();
                input = input.toUpperCase();
                
                clearConsole();
            }
            curPlayer.addGenMana(input.charAt(0), manaGeneration);
            
            curPlayer.generateMana();
                 
            if(turn > 2)
            {
                curPlayer.addCard((Warrior)creatureDeck.get(random.nextInt(creatureDeck.size())).copy());
            }
            
            //primera fase (begin)
            while(!input.equals("yo paso"))
            {
                displayInfo();
                System.out.print(">>");
                input = scan.nextLine();
                clearConsole();
                input = input.trim().toLowerCase();
                manageInput(input);
            }
       
            input = "";
            currentPhase++;

            while(!input.equals("yo paso") && !input.equals("attack"))
            {
                displayInfo();
                System.out.print(">>");
                input = scan.nextLine();
                clearConsole();
                input = input.trim().toLowerCase();
                manageInput(input);
            }
            
            //TURN END: swap player positions.
            curPlayer = curEnemy;
            curEnemy = curEnemy == player1 ? player2 : player1;
            turn++;
            manaGeneration *= 2;
        }
        
        System.out.println(curEnemy.getName() + " stands victoriously over " 
                + curPlayer.getName());
    }
    
    static void manageInput(String input)
    {        
        if(input.contains("use"))
        {
            try
            {
                use(Integer.parseInt(input.substring(3).trim()) - 1);
            } 
            catch(Exception e) //NumberFormatException StringIndexOutOfBoundsException
            {
                System.out.println("Debes introducir un número");
            }
        }
        else if(input.contains("play"))
        {   
            try
            {
                play(Integer.parseInt(input.substring(5).trim()) - 1);
            }
            catch(Exception e) //NumberFormatException StringIndexOutOfBoundsException
            {
                System.out.println("Debes introducir un número" + e.getMessage());
            }
        }   
        else if(input.contains("attack"))
        {
            if (currentPhase == 1 && attacksPerTurn > 0)
            {
                curEnemy.getAttacked(curPlayer);
                attacksPerTurn--;
            }
            else if (attacksPerTurn == 0)
                System.out.println("Solo puedes atacar una vez por turno");
            else
                System.out.println("No puedes atacar en esta fase");
        }
        else if(input.contains("merge"))
        {
            if (mergesPerTurn > 0)
            {
                String nums = input.substring(6).trim();
                String[] wIndex = {"",""};

                int i = 0;
                for (char c : nums.toCharArray()) 
                {
                    if(Character.isDigit(c))
                    {
                        wIndex[i] += c;
                    }
                    if(c == ' ')
                        i = 1;
                }
                try
                {
                    merge(Integer.parseInt(wIndex[0])-1, Integer.parseInt(wIndex[1])-1);
                } 
                catch (NumberFormatException e)
                {
                    System.out.println("Incorrect Numbers" + e.getMessage());
                }
            }
            else
            {
                System.out.println("No merges left");
            }
        }
        else if(input.contains("change")) //cambiar por input.substring(0,5)
        {
            if(changesPerTurn > 0)
            {
                try
                {
                    curPlayer.change(Integer.parseInt(input.substring(7).trim()) - 1);
                    changesPerTurn--;
                }
                catch(Exception e)
                {
                    System.out.println("You must use a number");
                }
            }
            else
            {
                System.out.println("No changes left");
            }
        }
    }
        
    static void merge(int i1, int i2)
    {
        if(i1 != i2 && i1 < curPlayer.getBattlefield().size() && i1 >= 0 
                && i2 < curPlayer.getBattlefield().size() && i2 >= 0)
            curPlayer.mergeWarriors(i1, i2);
        else
            System.out.println("incorrect numbers");
    }
    
    static void use(int i) 
    {
        if (i >= curPlayer.getBattlefield().size() || i < 0)
        {
            System.out.println("Incorrect number");
        }
        else if (currentPhase == 0) 
        {
            System.out.println("No puedes usar cartas en esta fase");
        }
        else if (currentPhase == 1)
        {
            curPlayer.getBattlefield(i).use(); 
        }
    }
    
    static void play(int i)
    {
        if (i >= curPlayer.getHand().size() || i < 0)
        {
            System.out.println("El número introducido no es válido");
        }
        else if (currentPhase == 0 )
        {
            if (curPlayer.getHand(i).getClass() == Warrior.class) 
            {
                curPlayer.getHand(i).play();
            }

            else
            {
                System.out.println("Solo puedes jugar dos carta de tierra este turno");
            }
        }
    }

    static void displayInfo()
    {
        System.out.println("\nTURNO (" + turn + "º) DE: "
                + curPlayer.getName() + " (" + phases[currentPhase] + " phase)");
        System.out.println("\n" + player1.getName().toUpperCase());
        player1.displayCards();
        System.out.println("\n------\n" + player2.getName().toUpperCase());
        player2.displayCards();
    }
    
    static void setUpCardList()
    {
        
        //Creatures:
        creatureDeck.add(new Warrior("Skeleton",2,2,false,0,0,0,1));
        creatureDeck.add(new Warrior("Barbarian",3,2,false,1,0,1,0));
        creatureDeck.add(new Warrior("Orc",4,2,false,0,2,0,1));
        creatureDeck.add(new Warrior("Demon",2,2,false,3,0,0,1));
        creatureDeck.add(new Warrior("Mermaid",5,3,false,0,0,4,1));
        creatureDeck.add(new Warrior("Troll",4,7,false,1,4,0,1));
        creatureDeck.add(new Warrior("Undead",4,5,false,0,0,0,6));
        creatureDeck.add(new Warrior("Dragon",7,13,false,2,2,2,9));
    }                                                   //7|8|7| 20
    
    static void clearConsole()
    {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}
