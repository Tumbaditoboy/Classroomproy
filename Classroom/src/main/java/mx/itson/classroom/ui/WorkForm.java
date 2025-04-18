/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mx.itson.classroom.ui;

import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.classroom.entities.Assignment;
import mx.itson.classroom.entities.Student;
import mx.itson.classroom.entities.Work;
import mx.itson.classroom.persistence.AssignmentDAO;
import mx.itson.classroom.persistence.StudentDAO;
import mx.itson.classroom.persistence.WorkDAO;

/**
 *
 * @author dzlan
 */
public class WorkForm extends javax.swing.JDialog {
    
    private Work workToEdit;
            
    public WorkForm(java.awt.Frame parent, boolean modal) {
    this(parent, modal, null);}
    
    public WorkForm(java.awt.Frame parent, boolean modal, Work work) {
    super(parent, modal);
    initComponents();
    
    this.workToEdit = work;
    fillForm();
     
    cmbAssignment.setModel(new javax.swing.DefaultComboBoxModel());
    cmbStudent.setModel(new javax.swing.DefaultComboBoxModel());

    // Llenar los JComboBox con cadenas en formato "ID - Texto"
    try {
        List assignments = AssignmentDAO.getAll();
        cmbAssignment.removeAllItems();
        for (int i = 0; i < assignments.size(); i++) {
            Assignment assignment = (Assignment) assignments.get(i);
            // Agregamos el String con ID y título, por ejemplo: "1 - Matemáticas"
            cmbAssignment.addItem(assignment.getId() + " - " + assignment.getTitle());
        }

        List students = StudentDAO.getAll();
        cmbStudent.removeAllItems();
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student) students.get(i);
            // Agregamos el String con ID y nombre
            cmbStudent.addItem(student.getId() + " - " + student.getName());
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    /*Codigo para llenar el form con los valores que tiene un elemento en caso de querer editar */
    private void fillForm() {
    if (workToEdit != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        txtDate.setText(sdf.format(workToEdit.getDate()));
        txtFile.setText(workToEdit.getFile_Name());

        // Selecciona el item correcto en cmbAssignment
        String assignmentIdStr = String.valueOf(workToEdit.getAssignment().getId());
        for (int i = 0; i < cmbAssignment.getItemCount(); i++) {
            String item = cmbAssignment.getItemAt(i).toString();
            if (item.startsWith(assignmentIdStr + " -")) {
                cmbAssignment.setSelectedIndex(i);
                break;
            }
        }

        // Selecciona el item correcto en cmbStudent
        String studentIdStr = String.valueOf(workToEdit.getStudent().getId());
        for (int i = 0; i < cmbStudent.getItemCount(); i++) {
            String item = cmbStudent.getItemAt(i).toString();
            if (item.startsWith(studentIdStr + " -")) {
                cmbStudent.setSelectedIndex(i);
                break;
            }
        }
    }
}
    
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbAssignment = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbStudent = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();
        fkjds = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel5.setText("Student");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("Work");

        cmbAssignment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAssignmentActionPerformed(evt);
            }
        });

        jLabel2.setText("date");

        cmbStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        fkjds.setText("File name");

        jLabel4.setText("Assignment");

        btnSave.setBackground(new java.awt.Color(204, 204, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(cmbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fkjds)
                        .addComponent(jLabel2)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cmbAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cmbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(fkjds)
                    .addGap(18, 18, 18)
                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(198, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    String dueDateStr = txtDate.getText().trim();
    String fileName = txtFile.getText().trim();

    if (dueDateStr.equals("") || fileName.equals("")) {
        JOptionPane.showMessageDialog(this, "All fields are required.", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!dueDateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
        JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date dueDate = sdf.parse(dueDateStr);

    // Obtener IDs
    String selectedAssignmentStr = cmbAssignment.getSelectedItem().toString();
    int assignmentId = Integer.parseInt(selectedAssignmentStr.split(" - ")[0]);

    String selectedStudentStr = cmbStudent.getSelectedItem().toString();
    int studentId = Integer.parseInt(selectedStudentStr.split(" - ")[0]);

    // Obtener objetos desde la BD
    Assignment assignment = AssignmentDAO.getById(assignmentId);
    Student student = StudentDAO.getById(studentId);
    
    // Verificar si la fecha de entrega es posterior a la fecha límite de la asignación
    if (dueDate.after(assignment.getDue_Date())) {
        JOptionPane.showMessageDialog(this, "The work cannot be submitted after the due date.", 
                "Late Submission Error", JOptionPane.ERROR_MESSAGE);
        return; // No guardar el trabajo si es una entrega tardía
    }

    // Crear o actualizar
    Work work = (workToEdit != null) ? workToEdit : new Work();
    work.setDate(dueDate);
    work.setFile_Name(fileName);
    work.setAssignment(assignment);
    work.setStudent(student);
    

    if (WorkDAO.save(work)) {
        String message = (workToEdit != null)
                ? "The work was updated successfully."
                : "The work was added successfully.";
        JOptionPane.showMessageDialog(this, message, "Work Saved", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Cierra el formulario
    } else {
        JOptionPane.showMessageDialog(this, "Failed to save the work.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.",
                "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "An error occurred while saving the work: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }



    


    

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void cmbAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAssignmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAssignmentActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(WorkForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WorkForm dialog = new WorkForm(null, true); // Usar 'null' como el Frame padre si no hay uno
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbAssignment;
    private javax.swing.JComboBox<String> cmbStudent;
    private javax.swing.JLabel fkjds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFile;
    // End of variables declaration//GEN-END:variables

}
