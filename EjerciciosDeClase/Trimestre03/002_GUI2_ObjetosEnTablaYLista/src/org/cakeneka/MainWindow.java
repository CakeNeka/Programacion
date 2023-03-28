package org.cakeneka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 * Mostrar una clase en lista desplegable, lista y tabla.
 * @author Diurno
 */
public class MainWindow extends JFrame {
    
    static List<Enemy> enemies;
    
    public JPanel panel;
        
    public MainWindow() {
        initEnemyList();
        
        final int ancho = 550;
        final int alto = 700;
        setSize(ancho, alto);
//      setLocation(110,200);           //Determina la posición de la ventana
//      setBounds(110,200,ancho,alto);  // Determina posición y dimensiones

        setLocationRelativeTo(null);    // Centramos la ventana
        setTitle("Prueba2");            // Ponemos un título
        setResizable(false);      // Deshabilitar la redimensión
        setMinimumSize (new Dimension(200,200)); // Establecer tamaño mínimo
        this.getContentPane().setBackground(Color.yellow);  //Cambiar el color 
        
        initComponents();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
        
    private void initComponents() {
        placePanel();
        placeTitle();
        addComboBox();
        addTable();
        addList();
    }

    private void placePanel() {
        panel = new JPanel();
        panel.setBackground(new Color(13,13,13));
        panel.setLayout(null);          // Desactivamos el layout por defecto del panel
        this.getContentPane().add(panel); // Añado el panel a la ventana
    }
    
    private void placeTitle() {
        Font trajan = null;
        try {
            trajan = Font.createFont(Font.TRUETYPE_FONT, new File("TrajanPro-Regular.otf"));
        } catch (FontFormatException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JLabel etiqueta = new JLabel();
        
        etiqueta.setText("Enemigos");
        etiqueta.setBounds(0, 30, 550, 30);  
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); 
        etiqueta.setForeground (Color.MAGENTA);
        etiqueta.setOpaque(true);     
        etiqueta.setBackground(Color.black); 
        // Establecemos la fuente de la letra
        etiqueta.setFont(trajan.deriveFont(Font.PLAIN, 27));
        panel.add(etiqueta);
    }

    private void addComboBox() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(enemies.toArray());
        JComboBox listaPersonas = new JComboBox(modelo);
        listaPersonas.setBounds(30, 140, 490, 30);
        panel.add(listaPersonas);
    }

    private void addTable() {
        // Usamos un modelo de datos para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);
        
        // Añadimos las columnas AL MODELO
        modelo.addColumn("Nombre");
        modelo.addColumn("Arma");
        modelo.addColumn("Daño por Segundo");
        
        // Añadimos las filas
        for (Enemy enemy : enemies) {
            String[] row = new String[3];
            row[0] = enemy.getName();
            row[1] = enemy.getWeapon();
            row[2] = enemy.getFormattedDps();
            modelo.addRow(row);
        }
        
        panel.add(tabla);
        
        //Como estas columnas no se ven en la tabla, hay que añadirle una barra 
        // de desplazamiento
        JScrollPane scroll = new JScrollPane(tabla, 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(30, 230, 490, 200);
        panel.add(scroll);
    }

    private void initEnemyList() {
        enemies = new ArrayList<>();
        enemies.add(new Enemy("Questlord of Inverness", "Garrote Divino +4", 7f));
        enemies.add(new Enemy("Gran Maestre Optimus Megaslayer", "Zweihander", 14f));
        enemies.add(new Enemy("Proletio, El Santo Barón", "Uchigatana", 9f));
        enemies.add(new Enemy("Gwyn, Señor de la Ceniza", "Espadón del Gran Señor +5", 15.523423f));
    }

    private void addList() {
        DefaultListModel modelo = new DefaultListModel();
        for (Enemy enemy : enemies) {
            modelo.addElement(enemy);
        }
        JList list = new JList(modelo);
        panel.add(list);
        
        JScrollPane scroll = new JScrollPane (list, 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(30, 450, 490, 200);
        panel.add(scroll);
    }
    
    
}
