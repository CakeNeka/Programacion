package porcentajeanio;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PorcentajeAnio extends JFrame {

    double porcentajeAnio;
    int anioActual;

    public PorcentajeAnio() {
        Calendar fechaActual = Calendar.getInstance();
        anioActual = fechaActual.get(Calendar.YEAR);
        int mesActual = fechaActual.get(Calendar.MONTH);
        int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);

        Calendar inicioAnio = Calendar.getInstance();
        inicioAnio.set(anioActual, 0, 1);

        long milisegundosTranscurridos = System.currentTimeMillis() - inicioAnio.getTimeInMillis();
        double diasTranscurridos = milisegundosTranscurridos / 1000 / 60 / 60 / 24;

        porcentajeAnio = diasTranscurridos / 365 * 100;

        setTitle("Porcentaje transcurrido del año " + anioActual);

        String text = String.format("Ha transcurrido el %.04f %% del año %d", porcentajeAnio, anioActual);

        JLabel jlabel1 = new JLabel(text);
        jlabel1.setFont(new Font(null, Font.ROMAN_BASELINE, 35));

        jlabel1.setBounds(0, 0, 700, 200);

        add(jlabel1);

        setSize(700, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        PorcentajeAnio ventana = new PorcentajeAnio();

        if (SystemTray.isSupported()) {
            Image image = null;
            try {
                // Obtenemos una instancia de ClassLoader
                ClassLoader classLoader = PorcentajeAnio.class.getClassLoader();

                // Cargamos la imagen del archivo "miImagen.png" que se encuentra en el paquete "imagenes"
                image = ImageIO.read(classLoader.getResourceAsStream("res/icono.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Añadimos el tray icon a la barra de tareas
            TrayIcon trayIcon = new TrayIcon(image, String.format("Ha transcurrido el %.04f del año %d", ventana.porcentajeAnio, ventana.anioActual));
            try {
                SystemTray.getSystemTray().add(trayIcon);
            } catch (AWTException ex) {
                Logger.getLogger(PorcentajeAnio.class.getName()).log(Level.SEVERE, null, ex);
            }
            ventana.setIconImage(image);
        }

    }

}
