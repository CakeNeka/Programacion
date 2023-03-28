package org.cakeneka;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

/**
 * EJERCICIO 1
 * Introduce animal --> Text field --> borde rojo al entrar, salir borde verde.
 * --               --> Text Area  --> Drag cambiar texto a blanco sobre azul en el botón
 *                                     Doble click limpiar textField
 * BOTON            --> Añadir animal de la caja de texto al text area.
 * 
 * click derecho --> sobre el botón lanzar una nueva ventana con un saludo
 * @author Diurno
 */
public class MainWindow extends JFrame{

    Border hoverTextAreaBorder;
    Border textAreaBorder;
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 500;
    final int POSITION_X = 50;
    final int POSITION_Y = 50;
    
    private JPanel panel;
    private JLabel greet;
    private JTextField textField;
    private JButton button;
    private JTextArea textArea;
    
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hoverTextAreaBorder = BorderFactory.createLineBorder(Color.RED, 3);
        textAreaBorder = BorderFactory.createLineBorder(Color.GREEN, 3);
        setBounds(POSITION_X, POSITION_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        initComponents();
    }
    
    private void initComponents(){
        addPanel();
        addLabel();
        addTextField();
        addButton();
        addTextArea();
    }

    private void addPanel() {
        panel = new JPanel();  
        panel.setBackground(Color.white); 
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void addLabel() {
        JLabel etiqueta = new JLabel("Introduzca su nombre");
        etiqueta.setBounds(30, 10, 500, 30);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        panel.add(etiqueta);
    }
    
    private void addTextField(){
        textField = new JTextField();
        textField.setBounds(30, 50, 300, 30);
        textField.setBorder(textAreaBorder);
        
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {}

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {
               textField.setBorder(hoverTextAreaBorder);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                textField.setBorder(textAreaBorder);
            }
        });
        
        panel.add(textField);
    }
    
    private void addButton(){
        button = new JButton("¡Pulsa aquí!");
        button.setBounds(150, 100, 150, 40);
        button.setFont(new Font("arial", Font.PLAIN, 15));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textArea.append(textField.getText() + '\n');
                greet.setText("Hola " + textField.getText());
            }
        });
        button.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    new Saludo(textField.getText()).setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) { }

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {}
        });
        panel.add(button);
        greet = new JLabel();
        greet.setBounds(310, 110, 300, 40);
        button.setFont(new Font("arial", 1, 20));
        panel.add(greet);
        
    }
    
    private void addTextArea() {
        textArea = new JTextArea();
        textArea.setBounds(50, 180, 200, 200);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setForeground(Color.BLUE);
        textArea.setEditable(true);
        textArea.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                button.setForeground(Color.white);
                button.setBackground(Color.blue);
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                
            }
        });
        textArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    textField.setText("");
                }
            }

            @Override
            public void mousePressed(MouseEvent me) { }

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) { }

            @Override
            public void mouseExited(MouseEvent me) { }
        });
        panel.add(textArea);
        JScrollPane scroll = new JScrollPane(textArea, 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 180, 200, 200);
        panel.add(scroll);
    }
}
