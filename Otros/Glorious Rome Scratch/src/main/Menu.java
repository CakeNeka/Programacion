package main;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class Menu extends javax.swing.JFrame {

    int turn = 0;
    int maxSum = 80;
    City city = City.getInstance();

    public Menu() {
        initComponents();
        start();
    }

    void start() {
        // Initialize labels
        moneyLabel.setText(city.getMoney() + "");
        workersLabel.setText(city.getWorkersNum() + "");

        
        
        this.setTitle("Glorious " + city.getName());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        navyLabel = new javax.swing.JLabel();
        armySlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        savingsLabel = new javax.swing.JLabel();
        developmentJLabel = new javax.swing.JLabel();
        taxSlider = new javax.swing.JSlider();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        taxLabel = new javax.swing.JLabel();
        navySlider = new javax.swing.JSlider();
        developmentSlider = new javax.swing.JSlider();
        armyLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
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

        navyLabel.setText("0");

        armySlider.setValue(0);
        armySlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                armySliderMouseReleased(evt);
            }
        });

        jLabel1.setText("Total: ");

        jLabel2.setText("Gastos");

        totalLabel.setText("0");

        jLabel3.setText("Ahorro: ");

        savingsLabel.setText("0");

        developmentJLabel.setText("0");

        taxSlider.setValue(0);
        taxSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                taxSliderMouseReleased(evt);
            }
        });

        jLabel4.setText("Ingresos:");

        taxLabel.setText("0");

        navySlider.setValue(0);
        navySlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                navySliderMouseReleased(evt);
            }
        });

        developmentSlider.setValue(0);
        developmentSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                developmentSliderMouseReleased(evt);
            }
        });

        armyLabel.setText("0");

        jLabel5.setText("Ejercito");

        jLabel6.setText("Armada");

        jLabel9.setText("Desarrollo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(340, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(taxSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(taxLabel)
                                .addGap(48, 48, 48))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(armySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(navySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(developmentSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(armyLabel)
                                            .addComponent(navyLabel)
                                            .addComponent(developmentJLabel)
                                            .addComponent(totalLabel)
                                            .addComponent(savingsLabel))
                                        .addGap(17, 17, 17)))
                                .addGap(21, 21, 21))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(taxSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(developmentSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(armySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(navySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(armyLabel)
                        .addGap(18, 18, 18)
                        .addComponent(navyLabel)
                        .addGap(18, 18, 18)
                        .addComponent(developmentJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(totalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savingsLabel)))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Economía", jPanel1);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTextField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(citizenNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel14))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dexterityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(strengthLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(wisdomLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(professionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(salaryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(109, 109, 109))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buySlaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(killCitizenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(slavePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soldierPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(killCitizenPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(citizenNameLabel)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(strengthLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(dexterityLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(wisdomLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(professionLabel)
                                .addComponent(jLabel23))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(salaryLabel)
                                    .addComponent(jLabel28))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productionLabel)
                                    .addComponent(jLabel29))))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(30, 30, 30)
                        .addComponent(saveButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buySlaveButton)
                            .addComponent(slavePriceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(soldierPriceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(killCitizenButton)
                            .addComponent(killCitizenPriceLabel))
                        .addContainerGap(177, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        jTabbedPane1.addTab("Sociedad", jPanel2);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endTurnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(endTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void armySliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_armySliderMouseReleased
        setState(armySlider, armySlider.getValue());
        armyLabel.setText(armySlider.getValue() + "");
    }//GEN-LAST:event_armySliderMouseReleased

    private void navySliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navySliderMouseReleased
        setState(navySlider, navySlider.getValue());
        navyLabel.setText(navySlider.getValue() + "");
    }//GEN-LAST:event_navySliderMouseReleased

    private void developmentSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developmentSliderMouseReleased
        setState(developmentSlider, developmentSlider.getValue());
        developmentJLabel.setText(developmentSlider.getValue() + "");
    }//GEN-LAST:event_developmentSliderMouseReleased

    private void taxSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxSliderMouseReleased
        taxLabel.setText(taxSlider.getValue() + "");
        changeIncome(taxSlider.getValue());
    }//GEN-LAST:event_taxSliderMouseReleased

    private void endTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnButtonActionPerformed
        endTurn();
    }//GEN-LAST:event_endTurnButtonActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        updateSociety();
        displayCitizen();
    }//GEN-LAST:event_jPanel2ComponentShown

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

    private void killCitizenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_killCitizenButtonActionPerformed
        killCitizen(citizenList.getSelectedIndex());
    }//GEN-LAST:event_killCitizenButtonActionPerformed

    private void buySlaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySlaveButtonActionPerformed
        buySlave();
    }//GEN-LAST:event_buySlaveButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        buySoldier();
    }//GEN-LAST:event_jButton6ActionPerformed



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
        moneyLabel.setText(city.getMoney() + "");
        workersLabel.setText(city.getWorkersNum() + "");
        soldiersLabel.setText(city.getSoldiersNum() + "");
        slavesLabel.setText(city.getSlavesNum() + "");
        slavePriceLabel.setText("("+ city.getSlavePrice() + ")");
        soldierPriceLabel.setText("(" + city.getSoldierPrice() + ")");
        killCitizenPriceLabel.setText("(" + city.getKillCitizenPrice() + ")");

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
        salaryLabel.setText(citizenToDisplay.getSalary() + "");
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
            city.killCitizen(i);
            updateSociety();
            if (i > 0 && city.getMoney()+city.getKillCitizenPrice() > city.getKillCitizenPrice()) {
                citizenList.setSelectedIndex(i - 1);
            } else {
                citizenList.setSelectedIndex(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puedes eliminar al último ciudadano", "CUIDAO! ", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void endTurn() {
        city.endTurn();
        turn++;
        endTurnButton.setText(turn + "");

        int index = citizenList.getSelectedIndex();
        updateSociety();
        citizenList.setSelectedIndex(index);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel armyLabel;
    public javax.swing.JSlider armySlider;
    public javax.swing.JButton buySlaveButton;
    public javax.swing.JList<String> citizenList;
    public javax.swing.JLabel citizenNameLabel;
    public javax.swing.JLabel developmentJLabel;
    public javax.swing.JSlider developmentSlider;
    public javax.swing.JLabel dexterityLabel;
    public javax.swing.JButton endTurnButton;
    public javax.swing.JButton jButton6;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel14;
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
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JButton killCitizenButton;
    public javax.swing.JLabel killCitizenPriceLabel;
    public javax.swing.JLabel moneyLabel;
    public javax.swing.JTextField nameTextField;
    public javax.swing.JLabel navyLabel;
    public javax.swing.JSlider navySlider;
    public javax.swing.JLabel productionLabel;
    public javax.swing.JLabel professionLabel;
    public javax.swing.JList<String> professionList;
    public javax.swing.JLabel salaryLabel;
    public javax.swing.JButton saveButton;
    public javax.swing.JLabel savingsLabel;
    public javax.swing.JLabel slavePriceLabel;
    public javax.swing.JLabel slavesLabel;
    public javax.swing.JLabel soldierPriceLabel;
    public javax.swing.JLabel soldiersLabel;
    public javax.swing.JLabel strengthLabel;
    public javax.swing.JLabel taxLabel;
    public javax.swing.JSlider taxSlider;
    public javax.swing.JLabel totalLabel;
    public javax.swing.JLabel wisdomLabel;
    public javax.swing.JLabel workersLabel;
    // End of variables declaration//GEN-END:variables

}
