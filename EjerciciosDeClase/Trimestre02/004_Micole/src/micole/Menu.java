/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micole;

/**
 *
 * @author Neka
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addStudentBtn = new javax.swing.JMenuItem();
        addClassroomBtn = new javax.swing.JMenuItem();
        addGroupBtn = new javax.swing.JMenuItem();
        addSchoolBtn = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        edtiStudentBtn = new javax.swing.JMenuItem();
        editClassRoomBtn = new javax.swing.JMenuItem();
        editGroupBtn = new javax.swing.JMenuItem();
        editSchoolBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Age_of_Empires_HD_logo.png"))); // NOI18N

        jMenu1.setText("File");

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Add");

        addStudentBtn.setText("Student");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });
        jMenu2.add(addStudentBtn);

        addClassroomBtn.setText("Classroom");
        addClassroomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassroomBtnActionPerformed(evt);
            }
        });
        jMenu2.add(addClassroomBtn);

        addGroupBtn.setText("Group");
        addGroupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupBtnActionPerformed(evt);
            }
        });
        jMenu2.add(addGroupBtn);

        addSchoolBtn.setText("School");
        addSchoolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSchoolBtnActionPerformed(evt);
            }
        });
        jMenu2.add(addSchoolBtn);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");

        edtiStudentBtn.setText("Student");
        edtiStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtiStudentBtnActionPerformed(evt);
            }
        });
        jMenu3.add(edtiStudentBtn);

        editClassRoomBtn.setText("Classroom");
        editClassRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClassRoomBtnActionPerformed(evt);
            }
        });
        jMenu3.add(editClassRoomBtn);

        editGroupBtn.setText("Group");
        editGroupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGroupBtnActionPerformed(evt);
            }
        });
        jMenu3.add(editGroupBtn);

        editSchoolBtn.setText("School");
        editSchoolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSchoolBtnActionPerformed(evt);
            }
        });
        jMenu3.add(editSchoolBtn);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel2)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        new AddStudentForm().setVisible(true);
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void addClassroomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassroomBtnActionPerformed
        new AddClassroomForm().setVisible(true);
    }//GEN-LAST:event_addClassroomBtnActionPerformed

    private void addGroupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupBtnActionPerformed
        new AddGroupForm().setVisible(true);
    }//GEN-LAST:event_addGroupBtnActionPerformed

    private void addSchoolBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSchoolBtnActionPerformed
        new AddSchoolForm().setVisible(true);
    }//GEN-LAST:event_addSchoolBtnActionPerformed

    private void editSchoolBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSchoolBtnActionPerformed
        new EditSchoolForm().setVisible(true);
    }//GEN-LAST:event_editSchoolBtnActionPerformed

    private void editClassRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClassRoomBtnActionPerformed
        new EditClassroomForm().setVisible(true);
    }//GEN-LAST:event_editClassRoomBtnActionPerformed

    private void editGroupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGroupBtnActionPerformed
        new EditGroupForm().setVisible(true);
    }//GEN-LAST:event_editGroupBtnActionPerformed

    private void edtiStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtiStudentBtnActionPerformed
        new EditStudentForm().setVisible(true);
    }//GEN-LAST:event_edtiStudentBtnActionPerformed
    
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
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addClassroomBtn;
    private javax.swing.JMenuItem addGroupBtn;
    private javax.swing.JMenuItem addSchoolBtn;
    private javax.swing.JMenuItem addStudentBtn;
    private javax.swing.JMenuItem editClassRoomBtn;
    private javax.swing.JMenuItem editGroupBtn;
    private javax.swing.JMenuItem editSchoolBtn;
    private javax.swing.JMenuItem edtiStudentBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
