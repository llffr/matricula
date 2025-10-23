/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Modelo.Curso;
import javax.swing.table.DefaultTableModel;

public class NewJFrame extends javax.swing.JFrame {

    private Curso curso;
    private javax.swing.JTable tbSelCourses;

    public NewJFrame(Curso curso, javax.swing.JTable tbSelCourses) {
        initComponents();
        this.curso = curso;
        this.tbSelCourses = tbSelCourses;
        setLocationRelativeTo(null);
        lblCurso.setText("Curso: " + curso.getName());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblCurso = new javax.swing.JLabel();
        lblProfesor = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        cbProfesor = new javax.swing.JComboBox<>();
        cbHorario = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Profesor y Horario");

        lblCurso.setText("Curso:");
        lblProfesor.setText("Profesor:");
        lblHorario.setText("Horario:");

        cbProfesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Prof. Smith", "Prof. Johnson", "Prof. Brown", "Prof. Lee"
        }));

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "08:00 - 09:00",
            "09:00 - 10:00",
            "10:00 - 11:00",
            "11:00 - 12:00",
            "13:00 - 14:00"
        }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(evt -> btnGuardarActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCurso)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProfesor)
                            .addComponent(lblHorario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbProfesor, 0, 200, Short.MAX_VALUE)
                            .addComponent(cbHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.CENTER))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCurso)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfesor)
                    .addComponent(cbProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorario)
                    .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnGuardar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        String profesor = cbProfesor.getSelectedItem().toString();
        String horario = cbHorario.getSelectedItem().toString();

        curso.setProfesor(profesor);
        curso.setHorario(horario);

        DefaultTableModel modelSel = (DefaultTableModel) tbSelCourses.getModel();

        boolean exists = false;
        for (int i = 0; i < modelSel.getRowCount(); i++) {
            if (modelSel.getValueAt(i, 0).equals(curso.getName())) {
                modelSel.setValueAt(profesor, i, 3);
                modelSel.setValueAt(horario, i, 4);
                exists = true;
                break;
            }
        }

        if (!exists) {
            modelSel.addRow(new Object[]{
                curso.getName(),
                curso.getHours(),
                curso.getCredits(),
                profesor,
                horario
            });
        }

        dispose(); // cerrar ventana
    }

    // Variables declaration
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbProfesor;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblProfesor;
    // End of variables declaration
}
