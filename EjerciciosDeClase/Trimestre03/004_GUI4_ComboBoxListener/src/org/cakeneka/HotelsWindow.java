package org.cakeneka;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * Quitar los listener, rellenar la lista y añadir los listener.
 * cb.removeItemListener(this) -->
 *
 * @author Diurno
 */
public class HotelsWindow extends JFrame implements ItemListener {

    Map<String, List<Hotel>> cities;
    
    final int WINDOW_WIDTH = 600;
    final int WINDOW_HEIGHT = 400;

    private IOHelper io;
    
    private JPanel panel;
    private JComboBox citiesCb;
    private JComboBox hotelsCb;

    private JPanel extrasPanel;
    private JLabel extrasTitle;
    private JLabel extrasLabel;

    public HotelsWindow() {
        io = new IOHelper("Hoteles.txt");
        cities = new TreeMap<>();
        readHotelsFromFile();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Hoteles");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        initComponents();
    }

    private void initComponents() {
        initPanel();
        initCombobox();
        initExtrasPanel();
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }

    private void initCombobox() {
        citiesCb = new JComboBox();
        DefaultComboBoxModel model = new DefaultComboBoxModel(cities.keySet().toArray(new String[0]));
        citiesCb.setBounds(40, 30, 200, 25);
        citiesCb.setModel(model);
        citiesCb.addItemListener(this);

        hotelsCb = new JComboBox();
        hotelsCb.setBounds(40, 60, 200, 25);

        panel.add(citiesCb);
        panel.add(hotelsCb);
    }

    private void initExtrasPanel() {
        extrasPanel = new JPanel();
        extrasPanel.setBackground(new Color(222, 222, 222));
        extrasPanel.setBounds(300, 5, 300, 350);
        extrasPanel.setLayout(null);
        
        extrasTitle = new JLabel();
        extrasTitle.setBounds(0, 0, 300, 40);
        extrasTitle.setVerticalAlignment(SwingConstants.CENTER);
        extrasTitle.setHorizontalAlignment(SwingConstants.CENTER);
        extrasTitle.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        extrasTitle.setText("Extras");

        extrasLabel = new JLabel();
        extrasLabel.setBounds(0, 50, 300, 50);
        extrasLabel.setHorizontalAlignment(JLabel.CENTER);
        
        extrasPanel.add(extrasLabel);
        extrasPanel.add(extrasTitle);
        panel.add(extrasPanel);
    }
    
    private void readHotelsFromFile(){
        String[] lines = io.readAllLines();
        for (String line : lines) {
            String[] fields = line.split("/");
            String currentCity = fields[0];
            Hotel currentHotel = new Hotel(fields[0], fields[1], fields[2]);
            
            cities.putIfAbsent(currentCity, new ArrayList<>());
            cities.get(currentCity).add(currentHotel);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        extrasLabel.setText("Ciudad " + ie.getItem() + " Seleccionada");
        DefaultComboBoxModel model = new DefaultComboBoxModel(cities.get((String)ie.getItem()).toArray(new Hotel[0]));
        hotelsCb.setModel(model);
    }

}
