/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkg008_ej3;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

class HotelsWindow extends javax.swing.JFrame {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/hoteles";
    final String USER = "root";
    final String PASS = "";

    ItemListener citiesCbItemListener = (ItemEvent e) -> {
        updateHotelsCb();
    };
    
    ItemListener hotelsCbItemListener = (ItemEvent e) -> {
        updateInfo();
    };

    private Map<String, List<Hotel>> citiesHotels;

    public HotelsWindow() {
        initComponents();
        citiesHotels = new HashMap<>();
        fetchHotelsData();
        initCitiesCb();
        initHotelsCb();
    }
    
    private Connection connect() {
        Connection con = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    private void fetchHotelsData() {
        try {
            Connection connection = connect();

            String query = "Select * from hoteles";
            PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet = preparedStatement.executeQuery();
            String[][] sqlTable = getSqlTable(resultSet);
            fillHotelsMap(sqlTable);
        } catch (SQLException ex) {
            Logger.getLogger(HotelsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[][] getSqlTable(ResultSet resultSet) throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        int columns = meta.getColumnCount();
        resultSet.last();
        int rows = resultSet.getRow();
        String[][] table = new String[rows][columns];

        resultSet.beforeFirst();
        int i = 0;
        while (resultSet.next()) {
            for (int j = 0; j < table[i].length; j++) {
                Object cell = resultSet.getObject(j + 1);
                if (cell == null) {
                    table[i][j] = "null";
                } else {
                    table[i][j] = cell.toString();
                }
            }
            i++;
        }
        return table;
    }

    private void fillHotelsMap(String[][] sqlTable) {
        for (String[] columns : sqlTable) {
            citiesHotels.putIfAbsent(columns[0], new ArrayList<>());
            citiesHotels.get(columns[0]).add(new Hotel(columns[0], columns[1], columns[2]));
        }
    }

    private void initCitiesCb() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(citiesHotels.keySet().toArray());
        citiesCb.setModel(model);
        citiesCb.addItemListener(citiesCbItemListener);
        citiesCb.setSelectedIndex(0);
    }

    private void initHotelsCb() {
        hotelsCb.addItemListener(hotelsCbItemListener);
        updateHotelsCb();
    }

    private void updateHotelsCb() {
        String selectedCity = (String) citiesCb.getSelectedItem();
        DefaultComboBoxModel model = new DefaultComboBoxModel(citiesHotels.get(selectedCity).toArray(new Hotel[0]));
        hotelsCb.setModel(model);
        hotelsCb.setSelectedIndex(0);
        updateInfo();
    }

    private void updateInfo() {
        Hotel selectedHotel = (Hotel) hotelsCb.getSelectedItem();
        System.out.println(selectedHotel);
        hotelNameLabel.setText(selectedHotel.getName());
        hotelDescriptionLabel.setText("<html>"+selectedHotel.getDescription()+"</html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        hotelNameLabel = new javax.swing.JLabel();
        hotelDescriptionLabel = new javax.swing.JLabel();
        citiesCb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hotelsCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hoteles");
        setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        setResizable(false);

        infoPanel.setBackground(new java.awt.Color(228, 202, 248));
        infoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        hotelNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hotelNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelNameLabel.setText("Hotel");

        hotelDescriptionLabel.setText("H");
        hotelDescriptionLabel.setToolTipText("");
        hotelDescriptionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hotelNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(hotelDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hotelNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hotelDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ciudad");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hotel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(citiesCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hotelsCb, 0, 230, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(citiesCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hotelsCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HotelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HotelsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> citiesCb;
    private javax.swing.JLabel hotelDescriptionLabel;
    private javax.swing.JLabel hotelNameLabel;
    private javax.swing.JComboBox<String> hotelsCb;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
