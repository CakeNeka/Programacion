package pkg026_ejerciciopaises;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Country implements Serializable{

    private String name;
    private int area;
    private int population;
    private Map<String, Integer> citiesArea;
    private Set<Country> borderCountries;

    public Country(String name, int area, int inhabitants) {
        this.name = name;
        this.area = area;
        this.population = inhabitants;
        this.citiesArea = new HashMap<>();
        this.borderCountries = new HashSet<>();
    }

    public void addCity(String city, int extension) {
        if (city != null && extension > 0) {
            citiesArea.put(city, extension);
        }
    }

    public void addBorderCountry(Country country) throws InvalidCountryException {
        if (this.equals(country)){
            throw new InvalidCountryException();
        }
        if (country != null && !borderCountries.contains(country)) {
            borderCountries.add(country);
            country.borderCountries.add(this);
        }
    }

    public void removeBorderCountry(Country country) throws InvalidCountryException {
        if (this.equals(country)){
            throw new InvalidCountryException();
        }
        if (country != null && !this.equals(country)) {
            borderCountries.remove(country);
            country.borderCountries.remove(this);
        }
    }

    public void printCities() {
        for (Map.Entry<String, Integer> entry : citiesArea.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public Set<String> getCitiesWithExtension(int extension) {
        Set<String> cities = new HashSet<>();
        for (Map.Entry<String, Integer> entry : citiesArea.entrySet()) {
            if (entry.getValue() == extension) {
                cities.add(entry.getKey());
            }
        }
        if (cities.isEmpty())
            return null;
        return cities;
    }

    public int getExtensionOfCity(String cityName) {
        return citiesArea.get(cityName);
    }

    public void printBorders() {
        for (Country borderCountry : borderCountries) {
            System.out.println(borderCountry);
        }
    }

    public String toCsv() {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append(name);
        csvBuilder.append(',');
        csvBuilder.append(area);
        csvBuilder.append(',');
        csvBuilder.append(population);
        csvBuilder.append(',');
        csvBuilder.append(citiesArea.size());
        
        return csvBuilder.toString();
    }
    
    public boolean isFrontierOf(Country country) {
        return borderCountries.contains(country);
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Map<String, Integer> getCitiesArea() {
        return citiesArea;
    }

    
    
    
}
