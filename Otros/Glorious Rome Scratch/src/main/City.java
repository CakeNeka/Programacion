package main;

import java.util.ArrayList;
import java.util.List;


public class City {

    private static City city;
    
    private final int KILL_CITIZEN_PRICE;
    private String name;
    private int money;
    private int currentIncome;

    CitizenFactory citizenFactory = new RandomCitizenFactory();
    
    private List<Citizen> population = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void changeMoney(int money) {
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
    
    public void addCitizen(Citizen citizen) {
        this.population.add(citizen);
    }
    
    public void endTurn(){
        // Spend money
        int totalSalaries = 0;
        int totalProduction = 0;
        for (Citizen citizen : population) {
            totalSalaries += citizen.getSalary();
            totalProduction += citizen.getProduction();
        }
        changeMoney(totalProduction - totalSalaries);
        
        // Each turn theres a little chance to obtain a new worker:
        double rand = Math.random();
        if (rand < 0.07 && this.money > 10){
            addCitizen(citizenFactory.createCitizen("Worker"));
        }
        
        // Each turn there's a little chance miners can die
        int i = 0;
        double randMinerChance = 1;
        while (i < population.size()){
            if (population.get(i).getProfession().getName().equals("Miner")){
                randMinerChance = Math.random();
                if (randMinerChance < 0.03)
                    killCitizen(i);
            }
            i++;
        }
        // Each turn we need at least 1/3 of citizens to be farmers else
        // citizens may starve
        
        // Each turn we check for game over conditions (bankrupt --> money < -1000) 
        if (money < -1000)
            GameOver.gameOver(GameOver.BANKRUPT);
        if (population.isEmpty())
            GameOver.gameOver(GameOver.DEPOPULATION);
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
    
    public void killCitizen(int index){
        if (money >= getKillCitizenPrice()){
            money -= getKillCitizenPrice();
            population.get(index).die();
            population.remove(index);
        } else {
            System.out.println("NO MONEY! :( ");
        }
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
        for (int i = 0; i < 4; i++) {
            addCitizen(citizenFactory.createCitizen("Worker"));
        }
        KILL_CITIZEN_PRICE = 15;
    }







}
