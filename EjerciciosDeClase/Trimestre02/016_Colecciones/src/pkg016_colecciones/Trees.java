package pkg016_colecciones;

import java.util.Objects;

    
enum Leaves {
    FALLEN,
    EVERGREEN,
    OTHER
}

public class Trees implements Comparable{
    
    private String name;
    private String scientificName;
    private Leaves leaves;
    private int year;

    public Trees(String name, String scientificName, Leaves leaves, int year) {
        this.name = name;
        this.scientificName = scientificName;
        this.leaves = leaves;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Trees{" + "name=" + name + ", scientificName=" + scientificName + ", leaves=" + leaves + ", year=" + year + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trees other = (Trees) obj;
        return Objects.equals(this.name, other.name);
    }
    
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the scientificName
     */
    public String getScientificName() {
        return scientificName;
    }

    /**
     * @param scientificName the scientificName to set
     */
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    /**
     * @return the leaves
     */
    public Leaves getLeaves() {
        return leaves;
    }

    /**
     * @param leaves the leaves to set
     */
    public void setLeaves(Leaves leaves) {
        this.leaves = leaves;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Object t) {
        Trees other = (Trees) t;
        return this.name.compareTo(other.name);
    }
    
    
    
}
