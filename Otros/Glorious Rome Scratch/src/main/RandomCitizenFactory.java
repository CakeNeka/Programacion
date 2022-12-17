package main;

import java.util.Random;

public class RandomCitizenFactory implements CitizenFactory {

    @Override
    public Citizen createCitizen() {
        Random random = new Random();
        int rand = random.nextInt(3);
        String name = NameGenerator.createName();
        String surname = NameGenerator.createSurname();

        if (rand == 0) {     // Create worker
            return new Worker(name, surname, random.nextInt(20), random.nextInt(20), random.nextInt(20));
        } else if (rand == 1) {// Create slave

        } else {               //create soldier

        }

        // todo cambiar esto:
        return new Worker(name, surname, random.nextInt(20), random.nextInt(20), random.nextInt(20));
    }

    @Override
    public Citizen createCitizen(String type) {
        Random random = new Random();
        String name = NameGenerator.createName();
        String surname = NameGenerator.createSurname();

        if (type.equals("Worker")) {
            return new Worker(name, surname, random.nextInt(20), random.nextInt(20), random.nextInt(20));
        } else if (type.equals("Slave")) {
            return new Slave(name, random.nextInt(15), random.nextInt(15), random.nextInt(15));
        } else if (type.equals("Soldier")) {
            return new Soldier(name, surname, Profession.SOLDIER, random.nextInt(20) + 5, random.nextInt(20), random.nextInt(10));
        } else {
            return null;
        }
    }

}
