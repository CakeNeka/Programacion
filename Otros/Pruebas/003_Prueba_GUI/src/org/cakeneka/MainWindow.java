package org.cakeneka;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class MainWindow extends JFrame {

    static final int WINDOW_WIDTH = 550;
    static final int WINDOW_HEIGHT = 700;

    private Adventure parent;

    private JPanel panel;
    private JTextPane history;
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
        initTextPane();
        initOptionList();
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setBackground(new Color(13, 13, 13));
        panel.setLayout(null);
        add(panel);
    }

    private void initTextPane() {
        history = new JTextPane();
        history.setEditable(false);
        JScrollPane scroll = new JScrollPane(history,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(25, 200, 500, 150);
        panel.add(scroll);
    }

    private void initOptionList() {
        DefaultListModel<String> model = new DefaultListModel();
        optionList = new JList(model);
        optionList.addMouseListener(new OptionListener());
        panel.add(optionList);

        JScrollPane scroll = new JScrollPane(optionList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(25, 400, 500, 150);
        panel.add(scroll);
    }
    
    public void writeText(String msg, Color c) {
        history.setEditable(true);
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = history.getDocument().getLength();
        history.setCaretPosition(len);
        history.setCharacterAttributes(aset, false);
        history.replaceSelection(msg + "\n");
        history.setEditable(false);
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
