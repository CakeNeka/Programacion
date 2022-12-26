/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micole;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Neka
 */
public class EditGroupForm extends javax.swing.JFrame {

    ArrayList<Classroom> classrooms;
    ArrayList<Group> groups;

    /**
     * Creates new form EditGroupForm
     */
    public EditGroupForm() {
        initComponents();
        
        classrooms = new ArrayList<>();
        groups = new ArrayList<>();
        populateArrayList();
        
        String[] classroomsArr = new String[classrooms.size()];
        for (int i = 0; i < classrooms.size(); i++) {
            classroomsArr[i] = classrooms.get(i).toString();
        }
        classroomsCb.setModel(new DefaultComboBoxModel<>(classroomsArr));
        
        String[] groupsArr = new String[groups.size()];
        for (int i = 0; i < groups.size(); i++) {
            groupsArr[i] = groups.get(i).toString();
        }
        groupCb.setModel(new DefaultComboBoxModel<>(groupsArr));
        
        updateTextFields();
    }
    
    private void saveGroupsToFile() {
        try {
            FileOutputStream file = new FileOutputStream("Groups.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            for (int i = 0; i < groups.size(); i++) {
                outputFile.writeObject(groups.get(i));
            }

            outputFile.close();
            JOptionPane.showMessageDialog(this, "Succesfully saved");
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void populateArrayList() {
        try {
            FileInputStream file = new FileInputStream("Classrooms.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    classrooms.add((Classroom) inputFile.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(this, f.getMessage());
                }
            }
            inputFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            FileInputStream file = new FileInputStream("Groups.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    groups.add((Group) inputFile.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(this, f.getMessage());
                }
            }
            inputFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void updateTextFields() {
        int groupIndex = groupCb.getSelectedIndex();
        int classIndex = -1;
        if (groupIndex != -1){
            Group selectedGroup = groups.get(groupCb.getSelectedIndex());
            groupNameTf.setText(selectedGroup.getName());
            idLabel.setText(selectedGroup.GROUP_ID + "");
            
            classIndex = 0;
            while (!classrooms.get(classIndex).equals(selectedGroup.getClassroom())){
                classIndex++;
            }
            classroomsCb.setSelectedIndex(classIndex);
        }
        
        updateClassroomsFields();
    }
    
    private void updateClassroomsFields(){
        int classIndex = classroomsCb.getSelectedIndex();
        
        if (classIndex != -1) {
            Classroom chosen = classrooms.get(classIndex);
            schoolLabel.setText(chosen.getSchool().toString());
            capacityLabel.setText(chosen.getCapacity() + "");
            if (classroomIsOccupied(chosen)) {
                classOccupiedLabel.setText("Class Occupied");
                saveBtn.setEnabled(false);
            } else {
                classOccupiedLabel.setText("");
                saveBtn.setEnabled(true);
            }
        }
    }
    
    private boolean classroomIsOccupied(Classroom chosen) {
        Group selectedGroup = groups.get(groupCb.getSelectedIndex());
        for (Group group : groups) {
            if (group.getClassroom().equals(chosen) && !group.equals(selectedGroup)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        classOccupiedLabel = new javax.swing.JLabel();
        capacityLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        groupNameTf = new javax.swing.JTextField();
        classroomsCb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        schoolLabel = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        groupCb = new javax.swing.JComboBox<>();
        idLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        classOccupiedLabel.setForeground(new java.awt.Color(255, 0, 0));
        classOccupiedLabel.setText("Class occupied");

        capacityLabel.setText("capacity");

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel1.setText("Edit a group by entering the details below:");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Name: ");

        groupNameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupNameTfActionPerformed(evt);
            }
        });

        classroomsCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        classroomsCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classroomsCbActionPerformed(evt);
            }
        });

        jLabel3.setText("Classroom: ");

        jLabel4.setText("School: ");

        schoolLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolLabel.setText(" ");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        groupCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        groupCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupCbActionPerformed(evt);
            }
        });

        idLabel.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 215, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(classOccupiedLabel))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(classroomsCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(groupNameTf)
                                    .addComponent(schoolLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(groupCb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(capacityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idLabel))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(groupNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classroomsCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(capacityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(schoolLabel))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classOccupiedLabel))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void groupNameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupNameTfActionPerformed
        
    }//GEN-LAST:event_groupNameTfActionPerformed

    private void classroomsCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classroomsCbActionPerformed
        updateClassroomsFields();
    }//GEN-LAST:event_classroomsCbActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String name = groupNameTf.getText().trim();
        int classroomIndex = classroomsCb.getSelectedIndex();
        int groupIndex = groupCb.getSelectedIndex();
        if (name.isEmpty() || classroomIndex == -1 || groupIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please enter all fields");
        } else {
            Classroom selectedClass = classrooms.get(classroomIndex);
            groups.get(groupIndex).setName(name);
            groups.get(groupIndex).setClassroom(selectedClass);
            saveGroupsToFile();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void groupCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupCbActionPerformed
        updateTextFields();
    }//GEN-LAST:event_groupCbActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EditGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditGroupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel capacityLabel;
    private javax.swing.JLabel classOccupiedLabel;
    private javax.swing.JComboBox<String> classroomsCb;
    private javax.swing.JComboBox<String> groupCb;
    private javax.swing.JTextField groupNameTf;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel schoolLabel;
    // End of variables declaration//GEN-END:variables
}
