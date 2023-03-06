/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progoles;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class SerializingHelper {

    public static List<Team> loadTeams() {
        List<Team> loadedTeams = new ArrayList<>();
        try {
            FileInputStream file2 = new FileInputStream("Teams.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    loadedTeams.add((Team) inputFile2.readObject());
                } catch (EOFException e) { //END OF FILE exception
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile2.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return loadedTeams;
    }

    static List<Player> loadPlayers() {
        List<Player> loadedPlayers = new ArrayList<>();
        try {
            FileInputStream file2 = new FileInputStream("Players.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    loadedPlayers.add((Player) inputFile2.readObject());
                } catch (EOFException e) { //END OF FILE exception
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile2.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return loadedPlayers;
    }
    
    public static void saveTeamsToFile(List<Team> teams) {
        try {
            FileOutputStream file = new FileOutputStream("Teams.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            for (int i = 0; i < teams.size(); i++) {
                outputFile.writeObject(teams.get(i));
            }
            
            outputFile.close();
            System.out.println("Succesfully saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
        public static void savePlayersToFile(List<Player> players) {
        try {
            FileOutputStream file = new FileOutputStream("Players.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            for (int i = 0; i < players.size(); i++) {
                outputFile.writeObject(players.get(i));
            }
            
            outputFile.close();
            System.out.println("Succesfully saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    static void exportDataToCsv(List<Team> teams) throws IOException {
        int counter = 0;
        String name = "export";
        File archivo = new File(name + counter + ".csv");
        boolean fileExists = archivo.exists();
        while (fileExists) {
            counter++;
            archivo = new File(name + counter + ".csv");
            fileExists = archivo.exists();
        }
        
        archivo.createNewFile();
        FileWriter writer = new FileWriter(archivo,false);
        writer.append(toCsv(teams));
        
        writer.close();
    }

    private static String toCsv(List<Team> teams){
        StringBuilder csv = new StringBuilder();
        for (Team team : teams) {
            List<Player> players = team.getPlayers();
            for (Player player : players) {
                csv.append(player.getName());
                csv.append(',');
                csv.append(player.getNickName());
                csv.append(',');
                csv.append(player.getTotalGoals());
                csv.append(',');
                csv.append(',');
                csv.append(',');
                
                csv.append('\n');
            }
        }
        return "";
    }
    /*
    
    }
    */
}
