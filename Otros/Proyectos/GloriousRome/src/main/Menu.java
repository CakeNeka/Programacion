package main;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class Menu extends javax.swing.JFrame {

    City city = City.getInstance();

    public Menu() {
        
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        initComponents();
        this.setLocationRelativeTo(null);
        start();
    }

    void start() {
        Image image = null;
        try {
            ClassLoader classLoader = Menu.class.getClassLoader();
            image = ImageIO.read(classLoader.getResourceAsStream("res/icon1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//      Initialize labels
        moneyLabel.setText(city.getMoney() + "");
        workersLabel.setText(city.getWorkersNum() + "");
//      ImageIcon img = new ImageIcon("src/res/icon1.png");
        this.setIconImage(image);
        professionList.setCellRenderer(new ColorListCellRenderer());
        this.setTitle("Glorious " + city.getName());

        updateSociety();
        displayCitizen();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        citizenList = new javax.swing.JList<>();
        saveButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        wisdomLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dexterityLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        strengthLabel = new javax.swing.JLabel();
        buySlaveButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        citizenNameLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        professionLabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        killCitizenButton = new javax.swing.JButton();
        salaryLabel = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        productionLabel = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        professionList = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        slavePriceLabel = new javax.swing.JLabel();
        soldierPriceLabel = new javax.swing.JLabel();
        killCitizenPriceLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        allyList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        enemyList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        beginBattleBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        allyForcesLabel = new javax.swing.JLabel();
        enemyForcesLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        allyStrengthLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        enemyStrengthLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        endTurnButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        workersLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        soldiersLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        slavesLabel = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        incomeLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        expendsLabel = new javax.swing.JLabel();
        profitLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Glorious Rome");
        setResizable(false);
        setState(30);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setName(""); // NOI18N

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        citizenList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ciudadano 1", "ciudadano 2", "ciudadano 3", "ciudadano 4", "ciudadano 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        citizenList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        citizenList.setName(""); // NOI18N
        citizenList.setSelectedIndex(0);
        citizenList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                citizenListMouseClicked(evt);
            }
        });
        citizenList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                citizenListKeyTyped(evt);
            }
        });
        citizenList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                citizenListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(citizenList);

        saveButton.setText("Save Changes");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("WISDOM");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        wisdomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wisdomLabel.setText("0");

        jLabel12.setText("DEXTERITY");

        dexterityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dexterityLabel.setText("0");

        jLabel14.setText("STRENGTH");
        jLabel14.setToolTipText("");

        strengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        strengthLabel.setText("0");

        buySlaveButton.setText("Buy Slave");
        buySlaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySlaveButtonActionPerformed(evt);
            }
        });

        nameTextField.setText("jTextField1");

        citizenNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citizenNameLabel.setText("NAME");

        jLabel23.setText("PROFFESSION");

        professionLabel.setText("none");

        jLabel25.setText("NAME:");

        jLabel26.setText("PROFFESSION:");

        killCitizenButton.setText("Kill Citizen");
        killCitizenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                killCitizenButtonActionPerformed(evt);
            }
        });

        salaryLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        salaryLabel.setText("0");

        jLabel28.setText("SALARY");

        productionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productionLabel.setText("0");

        jLabel29.setText("PRODUCTION");

        jButton6.setText("Buy Soldier");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(professionList);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Professions");

        slavePriceLabel.setText("(0)");

        soldierPriceLabel.setText("(0)");

        killCitizenPriceLabel.setText("(0)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTextField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(citizenNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel14))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dexterityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(strengthLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(wisdomLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(professionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(salaryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(109, 109, 109))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buySlaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(killCitizenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slavePriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(soldierPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(killCitizenPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(citizenNameLabel)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(strengthLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(dexterityLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(wisdomLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(professionLabel)
                                .addComponent(jLabel23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(salaryLabel)
                                    .addComponent(jLabel28))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productionLabel)
                                    .addComponent(jLabel29))))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(30, 30, 30)
                        .addComponent(saveButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buySlaveButton)
                            .addComponent(slavePriceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(soldierPriceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(killCitizenButton)
                            .addComponent(killCitizenPriceLabel))))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Society", jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Buildings", jPanel4);

        allyList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(allyList);

        enemyList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(enemyList);

        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("96%");

        jButton4.setText("Negotiate");
        jButton4.setPreferredSize(new java.awt.Dimension(32, 32));

        jButton5.setText("Flee");
        jButton5.setPreferredSize(new java.awt.Dimension(32, 32));

        beginBattleBtn.setText("Begin Battle");
        beginBattleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginBattleBtnActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Size");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Size");

        allyForcesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allyForcesLabel.setText("12");

        enemyForcesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemyForcesLabel.setText("12");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Strength");

        allyStrengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allyStrengthLabel.setText("12");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Strength");

        enemyStrengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemyStrengthLabel.setText("12");

        jLabel4.setText("Round");

        jLabel5.setText("1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(allyForcesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(allyStrengthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enemyStrengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(enemyForcesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(beginBattleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(allyForcesLabel)
                                    .addComponent(enemyForcesLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(allyStrengthLabel))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(enemyStrengthLabel)))
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(beginBattleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Combat", jPanel2);

        endTurnButton.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        endTurnButton.setText("0");
        endTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 233, 184));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MONEY");

        moneyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneyLabel.setText("0");

        workersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workersLabel.setText("0");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("WORKERS");

        soldiersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soldiersLabel.setText("0");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("SOLDIERS");

        slavesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slavesLabel.setText("0");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("SLAVES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soldiersLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(workersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(slavesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(moneyLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(workersLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(soldiersLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(slavesLabel)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("INCOME");

        incomeLabel.setForeground(new java.awt.Color(0, 153, 0));
        incomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        incomeLabel.setText("0");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EXPENDS");

        expendsLabel.setForeground(new java.awt.Color(255, 0, 0));
        expendsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expendsLabel.setText("1");

        profitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profitLabel.setText("1");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PROFIT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endTurnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(incomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expendsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incomeLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expendsLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profitLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(endTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void endTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnButtonActionPerformed
        endTurn();
    }//GEN-LAST:event_endTurnButtonActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown

    }//GEN-LAST:event_jPanel1ComponentShown

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        buySoldier();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void killCitizenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_killCitizenButtonActionPerformed
        killCitizen(citizenList.getSelectedIndex());
    }//GEN-LAST:event_killCitizenButtonActionPerformed

    private void buySlaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySlaveButtonActionPerformed
        buySlave();
    }//GEN-LAST:event_buySlaveButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        updateCitizen();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void citizenListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_citizenListValueChanged
        displayCitizen();
    }//GEN-LAST:event_citizenListValueChanged

    private void citizenListKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_citizenListKeyTyped

    }//GEN-LAST:event_citizenListKeyTyped

    private void citizenListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citizenListMouseClicked
        displayCitizen();
    }//GEN-LAST:event_citizenListMouseClicked

    private void beginBattleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginBattleBtnActionPerformed
        city.getEncounterManager().manageCombat();

        updateCombatView();
    }//GEN-LAST:event_beginBattleBtnActionPerformed


    /*
    int getTotalExpenses() {
        return armySlider.getValue() + navySlider.getValue() + developmentSlider.getValue();
    }

    void setState(JSlider slider, int value) {

        if (getTotalExpenses() <= city.getCurrentIncome()) {
            slider.setValue(value);
        } else {
            int difference = getTotalExpenses() - city.getCurrentIncome();
            int newValue = value - difference;
            slider.setValue(newValue);
        }
    }

    void changeIncome(int newMaxSum) {
        city.setCurrentIncome(newMaxSum);

        setState(armySlider, armySlider.getValue());
        armyLabel.setText(armySlider.getValue() + "");
        setState(navySlider, navySlider.getValue());
        navyLabel.setText(navySlider.getValue() + "");
        setState(developmentSlider, developmentSlider.getValue());
        developmentJLabel.setText(developmentSlider.getValue() + "");
    }
     */
    void buySlave() {
        city.buySlave();
        int index = citizenList.getSelectedIndex();
        updateSociety();
        citizenList.setSelectedIndex(index);
    }

    void buySoldier() {
        city.buySoldier();
        int index = citizenList.getSelectedIndex();
        updateSociety();
        citizenList.setSelectedIndex(index);
    }

    private void updateSociety() {
//      Updating labels
        moneyLabel.setText(String.format("%.0f", city.getMoney()));
        workersLabel.setText(city.getWorkersNum() + "");
        soldiersLabel.setText(city.getSoldiersNum() + "");
        slavesLabel.setText(city.getSlavesNum() + "");
        slavePriceLabel.setText("(" + city.getSlavePrice() + ")");
        soldierPriceLabel.setText("(" + city.getSoldierPrice() + ")");
        killCitizenPriceLabel.setText("(" + city.getKillCitizenPrice() + ")");
        incomeLabel.setText(String.format("%.2f", city.getTotalIncome()));
        expendsLabel.setText(String.format("%.2f", city.getTotalExpenses()));
        profitLabel.setText(city.getProfit() + "");
        if (city.getProfit() > 0) {
            profitLabel.setForeground(new Color(0, 153, 0));
        } else {
            profitLabel.setForeground(Color.RED);
        }

//      Updating citizen list:
        citizenList.removeAll();
        city.orderPopulation();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Citizen citizen : city.getPopulation()) {
            model.addElement(citizen.toString());
        }
        citizenList.setModel(model);
        citizenList.setSelectedIndex(0);

//      Updating professions:
        professionList.removeAll();
        model = new DefaultListModel<>();
        model.addElement(Profession.SOLDIER.getName() + " " + city.getAmountOf(Profession.SOLDIER));
        for (Profession profession : Profession.getProfessions()) {
            model.addElement(profession.getName() + " " + city.getAmountOf(profession));
        }
        professionList.setModel(model);

    }

    private void displayCitizen() {
        int index = citizenList.getSelectedIndex();
        if (index < 0) {
            index = 0;
        }

        Citizen citizenToDisplay = city.getPopulation(index);

        // Common fields:
        nameTextField.setText(citizenToDisplay.getFirstName());
        citizenNameLabel.setText(citizenToDisplay.getFullName());
        strengthLabel.setText(citizenToDisplay.getStrength() + "");
        wisdomLabel.setText(citizenToDisplay.getWisdom() + "");
        dexterityLabel.setText(citizenToDisplay.getDexterity() + "");
        professionLabel.setText(citizenToDisplay.getProfession().getName());
        salaryLabel.setText(String.format("%.0f", citizenToDisplay.getSalary()));
        productionLabel.setText(String.format("%.0f", citizenToDisplay.getProduction()));

        initializeComboBox();
        jComboBox1.setSelectedItem(citizenToDisplay.getProfession().toString());

        if (citizenToDisplay.getType().equals("Soldier")) {
            jComboBox1.setEnabled(false);
        }
    }

    private void initializeComboBox() {
        jComboBox1.setEnabled(true);
        String[] cbValues = new String[Profession.getProfessions().size()];
        for (int i = 0; i < Profession.getProfessions().size(); i++) {
            cbValues[i] = Profession.getProfessions().get(i).toString();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(cbValues);
        jComboBox1.setModel(model);
    }

    private void updateCitizen() {
        int index = citizenList.getSelectedIndex();

        city.getPopulation(index).setFirstName(nameTextField.getText());
        if (!city.getPopulation(index).getType().equals("Soldier")) {
            city.getPopulation(index).setProfession(Profession.getProfessions().get(jComboBox1.getSelectedIndex()));
        }

        updateSociety();
        citizenList.setSelectedIndex(index);
    }

    private void killCitizen(int i) {
        if (city.getPopulation().size() > 1) {
            city.orderKillCitizen(i);
            updateSociety();
            if (i > 0 && city.getMoney() + city.getKillCitizenPrice() > city.getKillCitizenPrice()) {
                citizenList.setSelectedIndex(i - 1);
            } else {
                citizenList.setSelectedIndex(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puedes eliminar al último ciudadano", "CUIDAO! ", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateCombatView() {
        EncounterManager cityEM = city.getEncounterManager();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Soldier s : cityEM.getAllies()) {
            model.addElement(s.toString());
        }
        allyList.setModel(model);

        model = new DefaultListModel<>();
        for (Soldier s : city.getEncounterManager().getEnemies()) {
            model.addElement(s.toString());
        }
        enemyList.setModel(model);

        allyForcesLabel.setText(cityEM.getAllySize() + "");
        allyStrengthLabel.setText(cityEM.getAllyStrength() + "");

        enemyForcesLabel.setText(cityEM.getEnemySize() + "");
        enemyStrengthLabel.setText(cityEM.getEnemyStrength() + "");

        if (!city.isAtWar())
            endTurnButton.setForeground(Color.black);
    }

    private void endTurn() {
        if (city.isAtWar()) {
            JOptionPane.showMessageDialog(this, "You must handle combat before ending turn",
                    "CUIDAO! ", JOptionPane.WARNING_MESSAGE);
        } else {
            city.endTurn();

            endTurnButton.setText(city.getTurn() + "");
            int index = citizenList.getSelectedIndex();
            updateSociety();
            citizenList.setSelectedIndex(index);

            if (city.isAtWar()) {
                endTurnButton.setForeground(Color.red);
                updateCombatView();
            } else {
                endTurnButton.setForeground(Color.black);
            }
        }
    }

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel allyForcesLabel;
    public javax.swing.JList<String> allyList;
    public javax.swing.JLabel allyStrengthLabel;
    public javax.swing.JButton beginBattleBtn;
    public javax.swing.JButton buySlaveButton;
    public javax.swing.JList<String> citizenList;
    public javax.swing.JLabel citizenNameLabel;
    public javax.swing.JLabel dexterityLabel;
    public javax.swing.JButton endTurnButton;
    public javax.swing.JLabel enemyForcesLabel;
    public javax.swing.JList<String> enemyList;
    public javax.swing.JLabel enemyStrengthLabel;
    public javax.swing.JLabel expendsLabel;
    public javax.swing.JLabel incomeLabel;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel28;
    public javax.swing.JLabel jLabel29;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JButton killCitizenButton;
    public javax.swing.JLabel killCitizenPriceLabel;
    public javax.swing.JLabel moneyLabel;
    public javax.swing.JTextField nameTextField;
    public javax.swing.JLabel productionLabel;
    public javax.swing.JLabel professionLabel;
    public javax.swing.JList<String> professionList;
    public javax.swing.JLabel profitLabel;
    public javax.swing.JLabel salaryLabel;
    public javax.swing.JButton saveButton;
    public javax.swing.JLabel slavePriceLabel;
    public javax.swing.JLabel slavesLabel;
    public javax.swing.JLabel soldierPriceLabel;
    public javax.swing.JLabel soldiersLabel;
    public javax.swing.JLabel strengthLabel;
    public javax.swing.JLabel wisdomLabel;
    public javax.swing.JLabel workersLabel;
    // End of variables declaration//GEN-END:variables

}
