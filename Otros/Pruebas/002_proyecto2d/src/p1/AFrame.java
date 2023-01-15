package p1;

import java.awt.*;
import javax.swing.*;

public class AFrame extends JFrame {
    
    APanel panel;
    
    public AFrame() {
        panel = new APanel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.add(panel);
        this.pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AFrame().setVisible(true); 
            }
        });
    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);  //
//        g.setColor(Color.blue);
//        g.drawLine(10, 60, 30, 400);
//        
//        int[] vectorX = {70, 130, 70, 23};
//        int[] vectorY = {70, 130, 130, 23};
//        g.drawPolygon(vectorX, vectorY, 3);
//    }

}

class APanel extends JPanel {

    APanel() {
        this.setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hola mundo", 10, 10);
        g.drawLine(0, 0, 500, 500);
    }
}
