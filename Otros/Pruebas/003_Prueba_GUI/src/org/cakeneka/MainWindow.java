package org.cakeneka;

import java.awt.Color;
import javax.swing.*;

public class MainWindow extends JFrame {

    final int WINDOW_WIDTH = 550;
    final int WINDOW_HEIGHT = 700;
    
    JPanel panel;
    JTextArea historyTf;
    
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
        initTextField();
    }
    
    private void initPanel() {
        panel = new JPanel();
        panel.setBackground(new Color(13,13,13));
        panel.setLayout(null);          
        add(panel);
    }
    
    private void initTextField() {
        historyTf = new JTextArea();
        historyTf.setBounds(25,200,500,100);
        JScrollPane scroll = new JScrollPane(historyTf,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(25,200,500,150);
        historyTf.setEditable(false);
        panel.add(scroll);
        
        for (int i = 0; i < 19; i++) {
            historyTf.append(i + "\n");
            historyTf.setCaretPosition(historyTf.getDocument().getLength());
        }
    }
    
    
}
