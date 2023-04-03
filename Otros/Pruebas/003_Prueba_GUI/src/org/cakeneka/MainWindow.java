package org.cakeneka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.*;

public class MainWindow extends JFrame {

    final int WINDOW_WIDTH = 550;
    final int WINDOW_HEIGHT = 700;
    
    JPanel panel;
    
    public MainWindow() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);   
        setTitle("Bastión de los Valientes");            
        setResizable(false); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
    }

    private void initComponents() {
        initPanel();
    }
    
    private void initPanel() {
        panel = new JPanel();
        panel.setBackground(new Color(13,13,13));
        panel.setLayout(null);          // Desactivamos el layout por defecto del panel
        this.getContentPane().add(panel); // Añado el panel a la ventana
    }
}
