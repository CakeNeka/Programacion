package main;

import javax.swing.JOptionPane;

public class Main {

    public static Menu menu;
    public static String cityName;
    
    public static void main(String[] args) {
        cityName = JOptionPane.showInputDialog("Type the name of your city");
        if (cityName.isEmpty()){
            cityName = "Rome";
        }
        menu = new Menu();
        menu.setVisible(true);
    }
    
}
