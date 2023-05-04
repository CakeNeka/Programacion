package pkg008_ej3;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String name;
    private Map<String, Float> extras;

    public Hotel(String name) {
        this.name = name;
        extras = new HashMap<>();
    }
    
    public Hotel(String name, String extraName, float cost) {
        this.name = name;
        extras = new HashMap<>();
        addExtra(extraName, cost);
    }
    
    public void addExtra(String extraName, float cost) {
        extras.put(extraName, cost);
    }

    public String getName() {   
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getExtras() {
        return extras;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getHtmlDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        for (Map.Entry<String, Float> entry : extras.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" --> ");
            sb.append(entry.getValue());
            sb.append('€');
            sb.append("<br>");
        }
        sb.append("</html>");
        return sb.toString();
    }
    
    
}
