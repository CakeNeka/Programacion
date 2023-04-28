package pkg008_ej3;

class Hotel {
    private String city;
    private String name;
    private String description;

    public Hotel(String city, String name, String description) {
        this.city = city;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
