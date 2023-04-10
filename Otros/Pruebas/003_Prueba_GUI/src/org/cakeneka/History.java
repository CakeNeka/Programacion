
package org.cakeneka;

import javax.swing.JTextArea;
import javax.swing.JTextField;

class History extends JTextArea{

    public History() {
        setEditable(false);
    }
    
    @Override
    public void append(String s) {
        super.append(s);
        setCaretPosition(getDocument().getLength());
    }
}
