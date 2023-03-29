package org.cakeneka;

import java.util.ArrayList;
import java.util.List;

public class Hotel implements Comparable<Hotel> {

    private String city;
    private String name;
    private String code;
    private String description;

    private List<Extra> extras;

    public Hotel(String city, String code, String name) {
        this.city = city;
        this.name = name;
        this.code = code;

        extras = new ArrayList<>();
    }

    public Hotel(String city, String code, String name, String description) {
        this.city = city;
        this.name = name;
        this.code = code;
        this.description = description;
        
        extras = new ArrayList<>();
    }
    
    

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void addExtra(Extra extra) {
        extras.add(extra);
    }
    
    public void addExtras(List<Extra> extra) {
        extras.addAll(extra);
    }

    @Override
    public int compareTo(Hotel other) {
        return name.compareToIgnoreCase(other.getName());
    }

    @Override
    public String toString() {
        return name;
    }

    String getStringExtras() {
        String result = "<html>";
        for (Extra extra : extras) {
            result += extra.getName() + ": " + extra.getCost() + "<br>";
        }
        result += "<html/>";
        return result;
    }

}
