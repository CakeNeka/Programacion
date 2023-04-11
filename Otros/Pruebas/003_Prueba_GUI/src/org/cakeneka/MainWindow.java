package org.cakeneka;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.*;

public class MainWindow extends JFrame {

    static final int WINDOW_WIDTH = 550;
    static final int WINDOW_HEIGHT = 700;

    private Adventure parent;
    
    private JPanel panel;
    private JTextArea history;
    private JList optionList;
    
    public MainWindow(Adventure parent) {
        this.parent = parent;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Bastión Nefario");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        initPanel();
        initTextField();
        initOptionList();
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setBackground(new Color(13, 13, 13));
        panel.setLayout(null);
        add(panel);
    }

    private void initTextField() {
        history = new History();
        JScrollPane scroll = new JScrollPane(history,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(25, 200, 500, 150);
        panel.add(scroll);
    }

    private void initOptionList() {
        DefaultListModel<String> model = new DefaultListModel();
        model.add(0, "Def opt 0");
        model.add(1, "Def opt 1");
        model.add(2, "Def opt 2");
        optionList = new JList(model);
        optionList.addMouseListener(new OptionListener());
        panel.add(optionList);

        JScrollPane scroll = new JScrollPane(optionList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(25, 400, 500, 150);
        panel.add(scroll);
    }

    public void writeText(String text) {
        history.append(text + "\n");
    }

    public void writeText(String text, Color color) {

    }

    void updateOptions(String[] options) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String s : options) {
            listModel.addElement(s);
        }
        optionList.setModel(listModel);
    }

    private class OptionListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            int selectedIndex = optionList.getSelectedIndex();
            if (selectedIndex != -1) {
                parent.onOptionChosen(selectedIndex);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
}
