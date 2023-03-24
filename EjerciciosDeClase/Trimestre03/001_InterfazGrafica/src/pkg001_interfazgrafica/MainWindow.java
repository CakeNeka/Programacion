package pkg001_interfazgrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class MainWindow extends JFrame {

    static final int WINDOW_HEIGHT = 500;       // Alto de la ventana
    static final int WINDOW_WIDTH = 500;        // Ancho de la ventana
    
    JPanel panel;
    JPanel menuPanel;
    JLabel label;
    
    public MainWindow() {
        this.setTitle("Me parece que me vas a dar la pelota");  // Establece el título de la ventana
//      this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);              // Establece el tamaño de la ventana
//      this.setLocation(120, 230);                             // Cambia ubicación de ventana. (0,0) está en la esquina superior
                                                                // izquierda de la pantalla.
        this.setBounds(120, 230, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);                       // Posiciona la ventana en el centro
//      this.setResizable(false);                               // Permite o no redimensionar
        this.setMinimumSize(new Dimension(200,200));            // Establece un tamaño mínimo a la ventana

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Define el comportamiento de la ventana al cerrarse (botón [x])
                                                                // EXIT_ON_CLOSE, DISPOSE ...
        this.getContentPane().setBackground(new Color(34,234,65));  // Cambia el color de fondo de la ventana.
        
        initComponents();
    }

    /**
     * Inicializa los componentes
     */
    private void initComponents() {
        /* Colocar Etiqueta */
        label = new JLabel("Graphic Design is my passion", SwingConstants.CENTER);
        label.setBounds(90, 10, 300, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.green);
        // Fuentes --> se pueden utilizar fuentes instaladas en el sistema
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        
        /* Colocar Panel */
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.magenta);
        // Layout es la forma de en la que una ventana distribuye sus componentes
        menuPanel.setLayout(null);              
        menuPanel.add(label);
        add(menuPanel);
        

        
        
        
//        Font font = Font.º;
//        label.setText();
        
    }
    
}
