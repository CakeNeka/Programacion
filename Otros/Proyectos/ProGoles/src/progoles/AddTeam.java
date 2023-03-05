package progoles;

import java.util.ArrayList;
import java.util.List;


public class AddTeam extends javax.swing.JFrame {

    List<Team> teams;
    MainWindow mainWindow;
    
    public AddTeam(MainWindow parent) {
        initComponents();
        teams = new ArrayList<>();
        teams = SerializingHelper.loadTeams();
        mainWindow = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerNameLabel = new javax.swing.JLabel();
        teamNameTf = new javax.swing.JTextField();
        AddTeamButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        playerNameLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        playerNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNameLabel.setText("Añadir Equipo");

        teamNameTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        AddTeamButton.setText("Añadir");
        AddTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTeamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(teamNameTf)
                    .addComponent(AddTeamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(teamNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(AddTeamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTeamButtonActionPerformed
        String teamName = teamNameTf.getText().trim();
        if (!teamName.isEmpty()){
            teams.add(new Team(teamName));
        }
        SerializingHelper.saveTeamsToFile(teams);
        mainWindow.populateArrayList();
        mainWindow.updatePlayerList();
        mainWindow.updateFields();
    }//GEN-LAST:event_AddTeamButtonActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTeamButton;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JTextField teamNameTf;
    // End of variables declaration//GEN-END:variables
}
