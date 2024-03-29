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
    final String DB_URL = "jdbc:mysql://localhost/trivago";
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
        initData();
        debugDataMap();
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
    
    private void initData() {
        try {
            addProvinces();
            addHotels();
        } catch (SQLException ex) {
            Logger.getLogger(HotelsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addProvinces() throws SQLException {
        Connection connection = connect();
        String query = "Select nombreProv from provincias";
        PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = preparedStatement.executeQuery();
        String[][] provinciasTable = getSqlTable(rs);
        for (String[] strings : provinciasTable) {
            citiesHotels.put(strings[0], new ArrayList<>());
        }
        connection.close();
    }

    private void addHotels() throws SQLException {
        Connection connection = connect();
        for (String provincia : citiesHotels.keySet()) {
            String query = "Select nombreHotel, nombreExtra, pvpExtra "
                    + "from hoteles inner join provincias on hoteles.idProv = provincias.idProvincia"
                    + " left join extras on extras.idHotel = hoteles.codHotel" 
                    + " where nombreProv like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1, provincia);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            String[][] hotelesTable = getSqlTable(rs);
            for (String[] hotel : hotelesTable) {
                addHotel(provincia, hotel);
            }
        }
        connection.close();
    }
    
    private void addHotel(String provincia, String[] hotelData) {
        List<Hotel> ls = citiesHotels.get(provincia);
        String hotelName = hotelData[0];
        String extraName = hotelData[1];
        String extraCost = hotelData[2];
        
        Hotel existing = getHotelByName(ls, hotelName);
        
        if (existing == null){
            if (extraName.equals("null") || extraCost.equals("null"))
                ls.add(new Hotel(hotelName));
            else 
                ls.add(new Hotel(hotelName, extraName, Float.parseFloat(extraCost)));
        } else if (!extraName.equals("null") && !extraCost.equals("null")){
            existing.addExtra(extraName, Float.parseFloat(extraCost));
        }
    }
    
    private Hotel getHotelByName(List<Hotel> ls, String hotelName) {
        for (Hotel h : ls) {
            if (h.getName().equals(hotelName)) 
                return h;
        }
        return null;
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
        Hotel[] hotels = citiesHotels.get(selectedCity).toArray(new Hotel[0]);
        DefaultComboBoxModel model = new DefaultComboBoxModel(hotels);
        hotelsCb.setModel(model);
        if (hotels.length > 0)
            hotelsCb.setSelectedIndex(0);
        updateInfo();
    }

    private void updateInfo() {
        Hotel selectedHotel = (Hotel) hotelsCb.getSelectedItem();
        if (selectedHotel != null) {
            hotelNameLabel.setText(hotelsCb.getSelectedItem().toString());
            hotelDescriptionLabel.setText(selectedHotel.getHtmlDescription());
            System.out.println(selectedHotel.getHtmlDescription());
        } else {
            hotelNameLabel.setText("");
            hotelDescriptionLabel.setText("");
        }
    }

    private void debugDataMap(){
        for (Map.Entry<String, List<Hotel>> keyValue : citiesHotels.entrySet()) {
            System.out.println("PROVINCIA: " + keyValue.getKey());
            for (Hotel hotel : keyValue.getValue()) {
                System.out.println("    HOTEL: " + hotel.getName() + ", extras: ");
                for (Map.Entry<String, Float> entry : hotel.getExtras().entrySet()) {
                    System.out.println("        -" + entry.getKey() + " " + entry.getValue());
                }
            }
        }
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
                if ("Windows".equals(info.getName())) {
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
