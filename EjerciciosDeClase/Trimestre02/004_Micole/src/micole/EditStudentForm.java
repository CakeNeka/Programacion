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
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Neka
 */
public class EditStudentForm extends javax.swing.JFrame {
    
    ArrayList<Student> students;
    ArrayList<Group> groups;
    
    double[][] tempGradesQuarter = new double[3][3];
    double[] tempAverages = new double[3]; 
    
    /**
     * Creates new form EditStudentForm
     */
    public EditStudentForm() {
        initComponents();
        
        students = new ArrayList<>();
        groups = new ArrayList<>();
        populateArrayList();
        String[] studentsArr = new String[students.size()];
        for (int i = 0; i < students.size(); i++) {
            studentsArr[i] = students.get(i).toString();
        }
        studentCb.setModel(new DefaultComboBoxModel<>(studentsArr));
        
        String[] groupsArr = new String[groups.size()+1];
        groupsArr[0] = "none";
        for (int i = 0; i < groups.size(); i++) {
            groupsArr[i+1] = groups.get(i).toString();
        }
        groupCb.setModel(new DefaultComboBoxModel<>(groupsArr));
        
        updateTextFields();
    }
    
    private void saveStudentsToFile() {
        try {
            FileOutputStream file = new FileOutputStream("Students.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            for (int i = 0; i < students.size(); i++) {
                outputFile.writeObject(students.get(i)); //guardamos los objetos en el archivo .dat
            }

            outputFile.close();

            JOptionPane.showMessageDialog(this, "Succesfuly saved");
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void populateArrayList(){
        try {
            FileInputStream file = new FileInputStream("Students.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    students.add((Student) inputFile.readObject());
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

    private void updateTextFields(){
        int studentIndex = studentCb.getSelectedIndex();
        if (studentIndex != -1) {
            Student cur = students.get(studentIndex);
            studentNameTf.setText(cur.getName());
            studentSurnameTf.setText(cur.getSurname());
            dniTf.setText(cur.getDni());
            daySpinner.setValue(cur.getBirthDay().getDayOfMonth());
            monthSpinner.setValue(cur.getBirthDay().getMonthValue());
            yearSpinner.setValue(cur.getBirthDay().getYear());
            if (cur.getGrupo() != null){
                int i = 0;
                while (!cur.getGrupo().equals(groups.get(i)))
                    i++;
                groupCb.setSelectedIndex(i+1);
            }
            else{
                groupCb.setSelectedIndex(0);
            }
        }
    }
    
    private void updateAverages(){
        tempGradesQuarter[0][0] = (int) notas00.getValue();
        tempGradesQuarter[0][1] = (int) notas01.getValue();
        tempGradesQuarter[0][2] = (int) notas02.getValue();
        
        tempGradesQuarter[1][0] = (int) notas10.getValue();
        tempGradesQuarter[1][1] = (int) notas11.getValue();
        tempGradesQuarter[1][2] = (int) notas12.getValue();
        
        tempGradesQuarter[2][0] = (int) notas20.getValue();
        tempGradesQuarter[2][1] = (int) notas21.getValue();
        tempGradesQuarter[2][2] = (int) notas22.getValue();
        
        for (int i = 0; i < 3; i++) {
            tempAverages[i] = 0;
            for (int j = 0; j < 3; j++) {
                tempAverages[i] += tempGradesQuarter[i][j];
            }
            tempAverages[i] /= 3.0;
        }
        
        avgs0.setText(String.format("%.2f" ,tempAverages[0]));
        avgs1.setText(String.format("%.2f" ,tempAverages[1]));
        avgs2.setText(String.format("%.2f" ,tempAverages[2]));
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentSurnameTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        monthSpinner = new javax.swing.JSpinner();
        daySpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        yearSpinner = new javax.swing.JSpinner();
        studentNameTf = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dniTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        studentCb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        groupCb = new javax.swing.JComboBox<>();
        notas01 = new javax.swing.JSpinner();
        notas00 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        notas02 = new javax.swing.JSpinner();
        notas12 = new javax.swing.JSpinner();
        notas11 = new javax.swing.JSpinner();
        notas10 = new javax.swing.JSpinner();
        notas20 = new javax.swing.JSpinner();
        notas21 = new javax.swing.JSpinner();
        notas22 = new javax.swing.JSpinner();
        avgs0 = new javax.swing.JLabel();
        avgs1 = new javax.swing.JLabel();
        avgs2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        studentSurnameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSurnameTfActionPerformed(evt);
            }
        });

        jLabel4.setText("Birth date: ");

        monthSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        daySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel1.setText("Create a student by entering the details below:");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        yearSpinner.setModel(new javax.swing.SpinnerNumberModel(2000, 1900, 2022, 1));

        studentNameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTfActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Name: ");

        jLabel5.setText("DNI: ");

        jLabel3.setText("Surname: ");

        dniTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniTfActionPerformed(evt);
            }
        });

        jLabel6.setText("Student:");

        studentCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studentCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentCbActionPerformed(evt);
            }
        });

        jLabel7.setText("Group: ");

        groupCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        notas01.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        notas00.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("1");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("2");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("3");

        notas02.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        notas12.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        notas11.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        notas10.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        notas20.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        notas21.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        notas22.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));

        avgs0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avgs0.setText("0");

        avgs1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avgs1.setText("0");

        avgs2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avgs2.setText("0");

        jLabel14.setText("Programación");

        jLabel15.setText("Bases de Datos");

        jLabel16.setText("Sistemas");

        jLabel17.setText("Media");

        jLabel18.setText("Trimestre");

        jButton1.setText("Calculate Averages");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dniTf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentNameTf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentSurnameTf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(studentCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(groupCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(notas00)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notas10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(notas20))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(notas01)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notas11)
                            .addComponent(notas21))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(notas12)
                                    .addComponent(notas02)
                                    .addComponent(notas22)))))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(avgs0, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avgs1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(avgs2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(0, 440, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(studentCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(studentNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentSurnameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dniTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(groupCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(notas00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notas01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notas02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(avgs0))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(notas12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notas11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notas10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(avgs1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(notas20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notas21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notas22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(avgs2))
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentSurnameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSurnameTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentSurnameTfActionPerformed

    private void studentNameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameTfActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        Group grupo = null;
        if (groupCb.getSelectedIndex() != 0){
           grupo = groups.get(groupCb.getSelectedIndex() -1);
        }
        
        int day = (int) daySpinner.getValue();
        int month = (int) monthSpinner.getValue();
        int year = (int) yearSpinner.getValue();

        String name = studentNameTf.getText().trim();
        String surname = studentSurnameTf.getText().trim();
        String dni = dniTf.getText().trim();
        if (name.isEmpty() || surname.isEmpty() || studentCb.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please enter all fields");
        } else if (!DNIValidator.validate(dni)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid DNI");
        } else {
            try {
                LocalDate bDay = LocalDate.of(year, month, day);
                Student cur = students.get(studentCb.getSelectedIndex());
                cur.setBirthDay(bDay);
                cur.setName(name);
                cur.setSurname(surname);
                cur.setDni(dni);
                cur.setGradesQuarter(tempGradesQuarter);
                
                cur.setGrupo(grupo);
                if (grupo != null) grupo.addStudent(cur);
                saveStudentsToFile();
            } catch (DateTimeException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date");
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void dniTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniTfActionPerformed

    private void studentCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentCbActionPerformed
        updateTextFields();
    }//GEN-LAST:event_studentCbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateAverages();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avgs0;
    private javax.swing.JLabel avgs1;
    private javax.swing.JLabel avgs2;
    private javax.swing.JSpinner daySpinner;
    private javax.swing.JTextField dniTf;
    private javax.swing.JComboBox<String> groupCb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner monthSpinner;
    private javax.swing.JSpinner notas00;
    private javax.swing.JSpinner notas01;
    private javax.swing.JSpinner notas02;
    private javax.swing.JSpinner notas10;
    private javax.swing.JSpinner notas11;
    private javax.swing.JSpinner notas12;
    private javax.swing.JSpinner notas20;
    private javax.swing.JSpinner notas21;
    private javax.swing.JSpinner notas22;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> studentCb;
    private javax.swing.JTextField studentNameTf;
    private javax.swing.JTextField studentSurnameTf;
    private javax.swing.JSpinner yearSpinner;
    // End of variables declaration//GEN-END:variables
}
