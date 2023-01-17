package p1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AFrame extends JFrame {
    
    PaintingPanel panel;
    Timer timer;
    
    double counter = 1;
    int rectHeight;
    
    public AFrame() {
        timer = new Timer(1 , (ActionEvent ae) -> {
            update();
        });
        timer.start();
        panel = new PaintingPanel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Aeterna Era");
        this.add(panel);
        this.pack();
    }
    
    void update(){
        System.out.println("Update");
        counter += 0.03;
        double var = Math.sin(counter) * 100;
        
        panel.varHeight = var;
        if (true) { // Delta puede ser /2 o *2 
            var /= 2;
        }
        panel.varTopHeight = var;
        panel.repaint();
    }
}