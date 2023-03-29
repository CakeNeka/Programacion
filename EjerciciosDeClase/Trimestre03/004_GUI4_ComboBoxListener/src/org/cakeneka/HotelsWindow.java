package org.cakeneka;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
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

    final int WINDOW_WIDTH = 600;
    final int WINDOW_HEIGHT = 400;
    private IOHelper io;
    
    private Map<String, List<Hotel>> cities;
    private Set<Hotel> setHoteles;
    
    private JPanel panel;
    private JComboBox citiesCb;
    private JComboBox hotelsCb;

    private JPanel extrasPanel;
    private JLabel extrasTitle;
    private JLabel hotelNameLabel;
    private JLabel hotelDescLabel;
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
        initExtrasPanel();
        initCombobox();
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
        hotelsCb.addItemListener(this);

        panel.add(citiesCb);
        panel.add(hotelsCb);
        
        updateHotelCb();
        updateHotelDescription();
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
        
        hotelNameLabel = new JLabel();
        hotelNameLabel.setBounds(0, 50, 300, 50);
        hotelNameLabel.setHorizontalAlignment(JLabel.CENTER);
        hotelNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        hotelNameLabel.setText("Titulo hotel");
        
        hotelDescLabel = new JLabel();
        hotelDescLabel.setBounds(0, 90, 300, 50);
        hotelDescLabel.setHorizontalAlignment(JLabel.CENTER);
        
        extrasLabel = new JLabel();
        extrasLabel.setBounds(0, 150, 300, 200);
        extrasLabel.setHorizontalAlignment(JLabel.CENTER);
        extrasLabel.setVerticalAlignment(JLabel.TOP);
        
        extrasPanel.add(extrasLabel);
        extrasPanel.add(extrasTitle);
        extrasPanel.add(hotelDescLabel);
        extrasPanel.add(hotelNameLabel);
        panel.add(extrasPanel);
    }
    
    private void readHotelsFromFile(){
        String[] lines = io.readAllLines();
        for (String line : lines) {
            String[] fields = line.split("/");
            String currentCity = fields[0];
            Hotel currentHotel = new Hotel(fields[0], fields[1], fields[2], fields[3]);
            
            cities.putIfAbsent(currentCity, new ArrayList<>());
            cities.get(currentCity).add(currentHotel);
        }
        
        io.setPath("ExtrasHoteles.txt");
        lines = io.readAllLines();
        for (String line : lines) {
            String[] lineSplit = line.split("/");
            String hotelCode = lineSplit[0];
            String fields = lineSplit[1];
            List<Extra> extras = stringToExtras(fields);
            
            assignExtrasToHotel(hotelCode, extras);
        }
    }
    
    private List<Extra> stringToExtras(String fields) {
        List<Extra> extrasList = new ArrayList<>();
        String[] extras = fields.split(",");
        for (String extra : extras) {
            String[] namePrice = extra.split(":");
            extrasList.add(new Extra(namePrice[0],namePrice[1]));
        }
        
        return extrasList;
    }

    private void assignExtrasToHotel(String hotelCode, List<Extra> extras) {
        for (List<Hotel> value : cities.values()) {
            for (Hotel hotel : value) {
                if (hotelCode.equals(hotel.getCode())){
                    hotel.addExtras(extras);
                }
            }
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == citiesCb){
            updateHotelCb();
            updateHotelDescription();
        } else if (ie.getSource() == hotelsCb) {
            updateHotelDescription();
        }
    }
    
    private void updateHotelCb() {
        hotelsCb.removeItemListener(this);
        String selectedCity = (String)citiesCb.getSelectedItem();
        DefaultComboBoxModel model = new DefaultComboBoxModel(cities.get(selectedCity).toArray(new Hotel[0]));
        hotelsCb.setModel(model);
        hotelsCb.addItemListener(this);
    }

    private void updateHotelDescription() {
        Hotel selectedHotel = (Hotel)hotelsCb.getSelectedItem();
        hotelNameLabel.setText(selectedHotel.toString());
        extrasLabel.setText(selectedHotel.getStringExtras());
        hotelDescLabel.setText(selectedHotel.getDescription());
    }
}
