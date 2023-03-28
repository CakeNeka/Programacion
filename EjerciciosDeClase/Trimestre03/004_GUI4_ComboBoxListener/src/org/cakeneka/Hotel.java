package org.cakeneka;

public class Hotel implements Comparable<Hotel> {

    private String city;
    private String name;
    private String code;

    private double[] extras;

    public Hotel(String city, String code, String name) {
        this.city = city;
        this.name = name;
        this.code = code;

        extras = new double[4];
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

    public double[] getExtras() {
        return extras;
    }

    public void setExtras(double[] extras) {
        this.extras = extras;
    }

    @Override
    public int compareTo(Hotel other) {
        return name.compareToIgnoreCase(other.getName());
    }

    @Override
    public String toString() {
        return name;
    }

}
