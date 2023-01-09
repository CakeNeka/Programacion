
package main;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.JLabel;

public class ColorListCellRenderer implements ListCellRenderer<String> {

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel(value);
        if (index % 2 == 0) {
            label.setBackground(Color.LIGHT_GRAY);
            label.setOpaque(true);
        }
        if (index == 6 && !City.getInstance().enoughFarmers()) {
            label.setBackground(Color.RED);
        }
        return label;
    }

}
