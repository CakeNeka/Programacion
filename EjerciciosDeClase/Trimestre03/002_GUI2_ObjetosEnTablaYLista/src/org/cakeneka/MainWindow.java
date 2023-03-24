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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
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
        
        etiqueta.setText("Enemies");
        etiqueta.setBounds(0, 30, 550, 30);  //Establecemos el tamaño
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Alineamos al centro
        etiqueta.setForeground (Color.MAGENTA); // Color de la letra
        etiqueta.setOpaque(true);               // Cambiar color de fondo
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
        tabla.setBounds(60, 230, 300, 200);
        
        //Añadimos las columnas AL MODELO
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Nacionalidad");
        
        // Añadimos las filas
        String[] persona1 = {"Rut", "22", "Española"};
        String[] persona2 = {"Pepe", "22", "Española"};
        String[] persona3 = {"Isabel", "22", "Española"};
        String[] persona4 = {"Leo", "22", "Española"};
        String[] persona5 = {"Rut", "22", "Española"};
        modelo.addRow(persona1);
        modelo.addRow(persona2);
        modelo.addRow(persona3);
        modelo.addRow(persona4);
        modelo.addRow(persona5);
        
        panel.add(tabla);
        
        //Como estas columnas no se ven en la tabla, hay que añadirle una barra 
        // de desplazamiento
        JScrollPane scroll = new JScrollPane(tabla, 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(60, 230, 300, 200);
        panel.add(scroll);
    }

    private void initEnemyList() {
        enemies = new ArrayList<>();
        enemies.add(new Enemy("Questlord of Inverness"));
        enemies.add(new Enemy("Gran Maestre Optimus Megaslayer"));
        enemies.add(new Enemy("Proletio, El Santo Barón"));
    }
    
    
}
