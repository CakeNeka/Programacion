/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progoles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Neka
 */
public class MainWindow extends javax.swing.JFrame {

    List<Team> teams;
    List<Player> players;
    int season = 0;
    
    public MainWindow() {
        initComponents();
        this.setTitle("Darigong");

        teams = new ArrayList<>();
        players = new ArrayList<>();
        populateArrayList();
        for (Player player : players) {
            System.out.println(player);
        }
        updatePlayerList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PlayersTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList<>();
        teamComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        playerNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        seasonGoalsLabel = new javax.swing.JLabel();
        playerNameLabel2 = new javax.swing.JLabel();
        playerNameLabel3 = new javax.swing.JLabel();
        totalGoalsLabel = new javax.swing.JLabel();
        playerNicknameLabel = new javax.swing.JLabel();
        addGoalButton = new javax.swing.JButton();
        subGoalButton = new javax.swing.JButton();
        plusSeasonButton = new javax.swing.JButton();
        minusSeasonButton = new javax.swing.JButton();
        seasonLabel = new javax.swing.JLabel();
        teamsTab = new javax.swing.JPanel();
        statsTab = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        playerList.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        playerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playerListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(playerList);

        teamComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        teamComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        teamComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Equipo");

        playerNameLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        playerNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNameLabel.setText("PlayerName");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Temporada");

        seasonGoalsLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        seasonGoalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seasonGoalsLabel.setText("0");

        playerNameLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        playerNameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNameLabel2.setText("Temporada:");

        playerNameLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        playerNameLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNameLabel3.setText("Totales:");

        totalGoalsLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        totalGoalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalGoalsLabel.setText("0");

        playerNicknameLabel.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        playerNicknameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNicknameLabel.setText("PlayerNickName");

        addGoalButton.setText("+");
        addGoalButton.setFocusable(false);
        addGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGoalButtonActionPerformed(evt);
            }
        });

        subGoalButton.setText("-");
        subGoalButton.setFocusable(false);
        subGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subGoalButtonActionPerformed(evt);
            }
        });

        plusSeasonButton.setText(">");
        plusSeasonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusSeasonButtonActionPerformed(evt);
            }
        });

        minusSeasonButton.setText("<");
        minusSeasonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusSeasonButtonActionPerformed(evt);
            }
        });

        seasonLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        seasonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seasonLabel.setText("Temporada");

        javax.swing.GroupLayout PlayersTabLayout = new javax.swing.GroupLayout(PlayersTab);
        PlayersTab.setLayout(PlayersTabLayout);
        PlayersTabLayout.setHorizontalGroup(
            PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlayersTabLayout.createSequentialGroup()
                .addGroup(PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PlayersTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerNameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalGoalsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seasonGoalsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerNameLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerNicknameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PlayersTabLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(subGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(addGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(teamComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PlayersTabLayout.createSequentialGroup()
                            .addComponent(minusSeasonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(seasonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(plusSeasonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        PlayersTabLayout.setVerticalGroup(
            PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlayersTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(teamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PlayersTabLayout.createSequentialGroup()
                        .addComponent(playerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerNicknameLabel)
                        .addGap(24, 24, 24)
                        .addComponent(playerNameLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seasonGoalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerNameLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalGoalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PlayersTabLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(PlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plusSeasonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minusSeasonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seasonLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );

        jTabbedPane1.addTab("Jugadores", PlayersTab);

        javax.swing.GroupLayout teamsTabLayout = new javax.swing.GroupLayout(teamsTab);
        teamsTab.setLayout(teamsTabLayout);
        teamsTabLayout.setHorizontalGroup(
            teamsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );
        teamsTabLayout.setVerticalGroup(
            teamsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Equipos", teamsTab);

        javax.swing.GroupLayout statsTabLayout = new javax.swing.GroupLayout(statsTab);
        statsTab.setLayout(statsTabLayout);
        statsTabLayout.setHorizontalGroup(
            statsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );
        statsTabLayout.setVerticalGroup(
            statsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Estadísticas", statsTab);

        jMenu1.setText("Exportar");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jMenuItem2.setText("Exportar a csv");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Añadir");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setText("Añadir Jugador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Añadir Equipo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGoalButtonActionPerformed
        Team selectedTeam = teams.get(teamComboBox.getSelectedIndex());
        int playerIndex = playerList.getSelectedIndex();
        Player currentPlayer = selectedTeam.getPlayer(playerIndex);

        currentPlayer.addGoalOnSeason(season);
        updatePlayerList();
        playerList.setSelectedIndex(playerIndex);
        updateFields();
        SerializingHelper.savePlayersToFile(players);
        SerializingHelper.saveTeamsToFile(teams);
    }//GEN-LAST:event_addGoalButtonActionPerformed

    private void subGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subGoalButtonActionPerformed
        Team selectedTeam = teams.get(teamComboBox.getSelectedIndex());
        int playerIndex = playerList.getSelectedIndex();
        Player currentPlayer = selectedTeam.getPlayer(playerIndex);

        currentPlayer.subtractGoalOnSeason(season);
        updatePlayerList();
        playerList.setSelectedIndex(playerIndex);
        updateFields();
        SerializingHelper.savePlayersToFile(players);
        SerializingHelper.saveTeamsToFile(teams);
    }//GEN-LAST:event_subGoalButtonActionPerformed

    private void playerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playerListValueChanged
        updateFields();
    }//GEN-LAST:event_playerListValueChanged

    private void teamComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamComboBoxActionPerformed
        updatePlayerList();
        updateFields();
    }//GEN-LAST:event_teamComboBoxActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new AddTeam(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AddPlayer(this).setVisible(true); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void plusSeasonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusSeasonButtonActionPerformed
        season++;
        int playerIndex = playerList.getSelectedIndex();
        updatePlayerList();
        playerList.setSelectedIndex(playerIndex);
        updateFields();
    }//GEN-LAST:event_plusSeasonButtonActionPerformed

    private void minusSeasonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusSeasonButtonActionPerformed
        season--;
        int playerIndex = playerList.getSelectedIndex();
        updatePlayerList();
        playerList.setSelectedIndex(playerIndex);
        updateFields();
    }//GEN-LAST:event_minusSeasonButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            SerializingHelper.exportDataToCsv(teams);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void updateFields() {
        int teamIndex = teamComboBox.getSelectedIndex();
        int playerIndex = playerList.getSelectedIndex();
        if (teamIndex < 0) {
            return;
        }
        Team selectedTeam = teams.get(teamIndex);
        if (selectedTeam.getPlayers().isEmpty()){
            return;
        }
        if (playerIndex < 0) {
            playerIndex = 0;
        }
        Player currentPlayer = selectedTeam.getPlayer(playerIndex);
        
        seasonLabel.setText(season + "");
        playerNameLabel.setText(currentPlayer.getName());
        playerNicknameLabel.setText("“" + currentPlayer.getNickName() + "”");
        seasonGoalsLabel.setText(currentPlayer.getGoalsOnSeason(season) + "");
        totalGoalsLabel.setText(currentPlayer.getTotalGoals() + "");
    }

    public void updatePlayerList() {
        if (teamComboBox.getSelectedIndex() < 0) {
            return;
        }
        
        Team selectedTeam = teams.get(teamComboBox.getSelectedIndex());

        playerList.removeAll();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Player player : selectedTeam.getPlayers()) {
            model.addElement(player.toString() + " (" + player.getGoalsOnSeason(season) + ")");
        }
        playerList.setModel(model);
        playerList.setSelectedIndex(0);
    }

    public void populateArrayList() {
        teams = SerializingHelper.loadTeams();
        players = SerializingHelper.loadPlayers();
        
        String[] teamsArr = new String[teams.size()];
        for (int i = 0; i < teamsArr.length; i++) {
            teamsArr[i] = teams.get(i).toString();
        }
        teamComboBox.setModel(new DefaultComboBoxModel<>(teamsArr));
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PlayersTab;
    private javax.swing.JButton addGoalButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton minusSeasonButton;
    private javax.swing.JList<String> playerList;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JLabel playerNameLabel2;
    private javax.swing.JLabel playerNameLabel3;
    private javax.swing.JLabel playerNicknameLabel;
    private javax.swing.JButton plusSeasonButton;
    private javax.swing.JLabel seasonGoalsLabel;
    private javax.swing.JLabel seasonLabel;
    private javax.swing.JPanel statsTab;
    private javax.swing.JButton subGoalButton;
    private javax.swing.JComboBox<String> teamComboBox;
    private javax.swing.JPanel teamsTab;
    private javax.swing.JLabel totalGoalsLabel;
    // End of variables declaration//GEN-END:variables

}
