package buscamenos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class InputHandler extends JFrame implements KeyListener{
    
    public InputHandler()
    {    
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(50,50);
        this.setLayout(null);
        this.addKeyListener(this);
  
        this.setVisible(true);  
    }

    @Override
    public void keyTyped(KeyEvent ke){}

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        switch(ke.getKeyCode())
        {
            case 37:        // Left
                Main.move(0, -1);
                break;
            case 38:        // Up
                Main.move(-1, 0);
                break;
            case 39:        // Right
                Main.move(0, 1);
                break;
            case 40:        // Down
                Main.move(1, 0);
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}
}

