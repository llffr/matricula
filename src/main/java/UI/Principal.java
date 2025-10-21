/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Modelo.Curso;
import Modelo.dobleL;
import UI.btnTable.TableActionCellEditor;
import UI.btnTable.buttonToTable;
import javax.swing.table.DefaultTableModel;
import UI.btnTable.TableActionEvent;

public class Principal extends javax.swing.JFrame {

	dobleL d1 = new dobleL();

	/**
	 * Creates new form Principal
	 */
	public Principal() {
		initComponents();
		setLocationRelativeTo(null); // center jframe
		addCourses();
		copyFromTables();
	}

	public void addCourses() {
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Curso");
		model.addColumn("Créditos");
		model.addColumn("H");
		model.addColumn("?");

		d1.add(new Curso("Math1", 2, 2, "a1"));
		d1.add(new Curso("Math2", 3, 3, "a2"));
		d1.add(new Curso("Math3", 3, 3, "a3"));
		d1.add(new Curso("Math4", 5, 3, "a4"));
		Curso cursosArr[] = d1.toArray();
		for (Curso curso : cursosArr) {
			Object[] row = new Object[]{
				curso.getName(),
				curso.getCredits(),
				curso.getHours(),
				curso.getProfesor()
			};
			model.addRow(row);
		}
		tbCourses.setModel(model);
	}

	public void copyFromTables() {
		// Inicializar modelo de tbSelCourses con mismas columnas que tbCourses
		DefaultTableModel modelSel = new DefaultTableModel();
		tbSelCourses.setModel(modelSel);
		for (int i = 0; i < tbCourses.getColumnCount(); i++) {
			modelSel.addColumn(tbCourses.getColumnName(i));
		}
		//
		TableActionEvent event = new TableActionEvent() {
			@Override
			public void onDelete(int row) {
				if (tbSelCourses.isEditing()) {
					tbSelCourses.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel) tbSelCourses.getModel();
				model.removeRow(row);
			}
		};

		tbSelCourses.getColumnModel().getColumn(3).setCellRenderer(new buttonToTable());
		tbSelCourses.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jMenuItem3 = new javax.swing.JMenuItem();
                jMenuItem5 = new javax.swing.JMenuItem();
                jDesktopPane1 = new javax.swing.JDesktopPane();
                jScrollPane1 = new javax.swing.JScrollPane();
                tbCourses = new javax.swing.JTable();
                jScrollPane2 = new javax.swing.JScrollPane();
                tbSelCourses = new javax.swing.JTable();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jMenuBar1 = new javax.swing.JMenuBar();
                menuAsistencia = new javax.swing.JMenu();

                jMenuItem3.setText("jMenuItem3");

                jMenuItem5.setText("jMenuItem5");

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                tbCourses.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {

                        }
                ));
                tbCourses.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tbCoursesMouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(tbCourses);

                tbSelCourses.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {

                        }
                ));
                tbSelCourses.setRowHeight(30);
                jScrollPane2.setViewportView(tbSelCourses);

                jLabel1.setText("Cursos disponibles");

                jLabel2.setText("Cursos matriculados");

                jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

                javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
                jDesktopPane1.setLayout(jDesktopPane1Layout);
                jDesktopPane1Layout.setHorizontalGroup(
                        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(32, Short.MAX_VALUE))
                );
                jDesktopPane1Layout.setVerticalGroup(
                        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(57, Short.MAX_VALUE))
                );

                menuAsistencia.setText("Cursos");
                menuAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                menuAsistenciaMouseClicked(evt);
                        }
                });
                jMenuBar1.add(menuAsistencia);

                setJMenuBar(jMenuBar1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

	private void menuAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuAsistenciaMouseClicked
	}// GEN-LAST:event_menuAsistenciaMouseClicked

	private void tbCoursesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbCoursesMouseClicked
		// tbCourses.getValueAt(), tbCourses.getColumnCount()
		int selectedRow = tbCourses.getSelectedRow();

		if (selectedRow != -1) {
			DefaultTableModel modelCourses = (DefaultTableModel) tbCourses.getModel();
			DefaultTableModel modelSel = (DefaultTableModel) tbSelCourses.getModel();
			Object[] rowData = new Object[modelCourses.getColumnCount()];
			for (int i = 0; i < modelCourses.getColumnCount(); i++) {
				rowData[i] = modelCourses.getValueAt(selectedRow, i);
			}
			// no duplicado
			boolean exists = false;
			for (int i = 0; i < modelSel.getRowCount(); i++) {
				if (modelSel.getValueAt(i, 0).equals(rowData[0])) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				modelSel.addRow(rowData);
			}
		}
	}// GEN-LAST:event_tbCoursesMouseClicked

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
				.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName())
				.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JDesktopPane jDesktopPane1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JMenuBar jMenuBar1;
        private javax.swing.JMenuItem jMenuItem3;
        private javax.swing.JMenuItem jMenuItem5;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JMenu menuAsistencia;
        public static javax.swing.JTable tbCourses;
        public static javax.swing.JTable tbSelCourses;
        // End of variables declaration//GEN-END:variables
}
