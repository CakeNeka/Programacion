package main;

public interface CitizenFactory {
    Citizen createCitizen();
    Citizen createCitizen(String type);
}
