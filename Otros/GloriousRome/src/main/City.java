package main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class City {

    private static City city;
    
    private final int KILL_CITIZEN_PRICE;
    private String name;
    private float money;
    private int currentIncome;

    CitizenFactory citizenFactory = new RandomCitizenFactory();
    
    private List<Citizen> population = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void changeMoney(float money) {
        this.money += money;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public List<Citizen> getPopulation() {
        return population;
    }
    
    public Citizen getPopulation(int i) {
        if (i<0) i = 0;
        return population.get(i);
    }
    
    public int getWorkersNum(){
        return getAmountOf("Worker");
    }
    public int getSoldiersNum() {
        return getAmountOf("Soldier");
    }
    public int getSlavesNum() {
        return getAmountOf("Slave");
    }
    
    int getAmountOf(String type){
        int i = 0;
        for (Citizen citizen : population) {
            if (citizen.getType().equals(type))
                i++;
        }
        return i;
    }
    
    public int getAmountOf(Profession job){
        int i = 0;
        for (Citizen citizen : population) {
            if (citizen.getProfession().equals(job))
                i++;
        }
        return i;
    }
    
    // El precio de matar a un ciudadano escala con la cantidad de ciudadanos matados
    public int getKillCitizenPrice(){
        return KILL_CITIZEN_PRICE;
    }
    
    // El precio de un esclavo escala con la cantidad de esclavos vivos
    public int getSlavePrice(){
        return Slave.PRICE;
    }
    
    // El precio de un soldado escala con la cantidad de soldados vivos
    public int getSoldierPrice(){
        return Soldier.PRICE;
    }
    
    
    public float getTotalIncome() {
        float i = 0;
        for (Citizen citizen : population) {
            i += citizen.getProduction();
        }
        return i;
    }

    public float getTotalExpenses() {
        float i = 0; 
        for (Citizen citizen : population) {
            i += citizen.getSalary();
        }
        return i;
    }
    
    public float getProfit() {
        return getTotalIncome() - getTotalExpenses();
    }
    
    public void addCitizen(Citizen citizen) {
        this.population.add(citizen);
    }
    
    public void endTurn(){
        // Spend money

        changeMoney(getTotalIncome() - getTotalExpenses());
        
        // Each turn theres a little chance to obtain a new worker:
        double rand = Math.random();
        if (rand < 0.07 && this.money > 10 && enoughFarmers()){
            Citizen newWorker = citizenFactory.createCitizen("Worker");
            addCitizen(newWorker);
            JOptionPane.showMessageDialog(Main.menu, "Worker " + newWorker.getFullName()
                    + " arrived.", "A New Citizen" , JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Each turn there's a little chance miners can die
        int i = 0;
        killerLoop(0.04, Profession.MINER);
        
        if (!enoughFarmers()){
            System.out.println("farmers are less than 20%");
            killerLoop(0.04);
        }
        
        // Each turn we check for game over conditions (bankrupt --> money < -1000) 
        if (money < -1000)
            GameOver.gameOver(GameOver.BANKRUPT);
        if (population.isEmpty())
            GameOver.gameOver(GameOver.DEPOPULATION);
    }

    private void killerLoop(double dieChance, Profession prof) {
        int i = 0;
        double rand;
        while (i < population.size()){
            if (population.get(i).getProfession().equals(prof)){
                rand = Math.random();
                if (rand <= dieChance)
                    killCitizen(i);
            }
            i++;
        }
    }
    
    private void killerLoop(double dieChance) {
        int i = 0;
        double rand;
        while (i < population.size()){
            rand = Math.random();
            if (rand <= dieChance)
                killCitizen(i);
            i++;
        }
    }
    
    boolean enoughFarmers() {
        // Each turn we need at least 20% of citizens to be farmers else
        // citizens may starve
        
        double j = 0;
        for (Citizen citizen : population) {
            if (citizen.getProfession().equals(Profession.FARMER))
                j++;
        }
        return j/(double)population.size() >= 0.2;
    }
    
    public void orderPopulation() {
        // First Soldiers
        // Second Workers
        // Third Slaves
        
        List<Citizen> soldiers = new ArrayList<>();
        List<Citizen> workers = new ArrayList<>();
        List<Citizen> slaves = new ArrayList<>();
        
        for (int i = 0; i < population.size(); i++) {
            if (population.get(i).getType().equals("Soldier"))
                soldiers.add(population.get(i));
            else if (population.get(i).getType().equals("Worker"))
                workers.add(population.get(i));
            else
                slaves.add(population.get(i));
        }
        population.clear();
        population.addAll(soldiers);
        population.addAll(workers);
        population.addAll(slaves);
    }
    
    public void buySlave(){
        if (money >= getSlavePrice()){
            money -= getSlavePrice();
            addCitizen(citizenFactory.createCitizen("Slave"));
        } else {
            System.out.println("NO MONEY");
        }
    }
        
    public void buySoldier() {
        if (money >= getSoldierPrice()){
            money -= getSoldierPrice();
            addCitizen(citizenFactory.createCitizen("Soldier"));
        } else {
            System.out.println("NO MONEY");
        }
    }
    
    public void orderKillCitizen(int index){
        if (money >= getKillCitizenPrice()){
            money -= getKillCitizenPrice();
            killCitizen(index);
        } else {
            System.out.println("NO MONEY! :( ");
        }
    }
    
    public void killCitizen(int index){
        population.get(index).die();
        population.remove(index);
    }
    
    public static City getInstance() {
        
        if (city == null) {
            city = new City(Main.cityName);
        }
        return city;
    }

    private City(String name) {
        this.name = name;
        this.money = 200;
        for (int i = 0; i < 40; i++) {
            addCitizen(citizenFactory.createCitizen("Worker"));
        }
        KILL_CITIZEN_PRICE = 15;
    }
}
