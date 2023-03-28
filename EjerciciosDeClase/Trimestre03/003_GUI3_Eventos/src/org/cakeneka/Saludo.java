package org.cakeneka;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Saludo extends JFrame {
    private JPanel panel;
    private JLabel greeting;

    public Saludo(String animal) {
        
        setSize(250, 250);
        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        
        greeting = new JLabel("Te saludo " + animal);
        greeting.setHorizontalAlignment(SwingConstants.CENTER); 
        greeting.setSize(250, 70);
        greeting.setBackground(Color.green);
        greeting.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel.add(greeting);
    }
    
    
}
