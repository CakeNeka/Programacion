package main;

import javax.swing.JOptionPane;

public class Main {

    public static Menu menu;
    public static String cityName;
    
    public static void main(String[] args) {
        setCityName();
        
        menu = new Menu();
        menu.setVisible(true);
    }
    
    private static void setCityName(){
        cityName = JOptionPane.showInputDialog(null,"Type the name of your city",
                "Salve", JOptionPane.PLAIN_MESSAGE);
        if (cityName == null){
            cityName = "Rome";
        }
        else if (cityName.trim().isEmpty()){
            cityName = "Rome";
        }
        else if (cityName.length() == 1){
            cityName = cityName.toUpperCase();
        }
        else {
            cityName = cityName.substring(0, 1).toUpperCase() + cityName.substring(1);
        }
    }
}
