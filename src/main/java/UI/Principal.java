/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Modelo.Curso;
import Modelo.dobleL;
import UI.btnTable.TableActionCellEditor;
import UI.btnTable.TableActionCellEditor2;
import UI.btnTable.buttonToTable;
import javax.swing.table.DefaultTableModel;
import UI.btnTable.TableActionEvent;
import UI.btnTable.TableActionEvent2;
import UI.btnTable.buttonToTable2;
// hmtl to pdf
import java.io.*;
import com.itextpdf.html2pdf.HtmlConverter;

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
		model.addColumn("Horas");
		model.addColumn("Créditos");
		model.addColumn("?");

		d1.add(new Curso("Math1", 2, 2));
		d1.add(new Curso("Math2", 3, 3));
		d1.add(new Curso("Math3", 3, 3));
		d1.add(new Curso("Math4", 5, 3));
		Curso cursosArr[] = d1.toArray();

		for (Curso curso : cursosArr) {
			Object[] row = new Object[]{
				curso.getName(),
				curso.getHours(),
				curso.getCredits(),};
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

		TableActionEvent2 event2 = new TableActionEvent2() {
			@Override
			public void openUI(int row) {
				if (tbSelCourses.isEditing()) {
					tbSelCourses.getCellEditor().stopCellEditing();
				}
				NewJFrame n = new NewJFrame();
				n.setVisible(true);
				n.setDefaultCloseOperation(NewJFrame.DISPOSE_ON_CLOSE);
			}
		};

		tbCourses.getColumnModel().getColumn(3).setCellRenderer(new buttonToTable2());
		tbCourses.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor2(event2));

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
                jButton1 = new javax.swing.JButton();
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
                tbCourses.setRowHeight(30);
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

                jButton1.setText("reporte");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

                javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
                jDesktopPane1.setLayout(jDesktopPane1Layout);
                jDesktopPane1Layout.setHorizontalGroup(
                        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2)))
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(jButton1)))
                                .addContainerGap(17, Short.MAX_VALUE))
                );
                jDesktopPane1Layout.setVerticalGroup(
                        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(10, Short.MAX_VALUE))
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

	// create pdf
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		DefaultTableModel model = (DefaultTableModel) tbSelCourses.getModel();

		StringBuilder tb = new StringBuilder();
		tb.append("<html><head>");
		tb.append("<style>");
		tb.append("table { width:100%; border-collapse: collapse; }");
		tb.append("th, td { border: 1px solid #000; padding: 8px; text-align: center; }");
		tb.append("th { background-color: #f2f2f2; }");
		tb.append("</style>");
		tb.append("</head><body>");
		tb.append("<h2 style='text-align:center;'>Cursos Matriculados</h2>");
		tb.append("<table>");
		tb.append("<tr>");

		// Encabezados
		for (int col = 0; col < model.getColumnCount(); col++) {
			tb.append("<th>").append(model.getColumnName(col)).append("</th>");
		}
		tb.append("</tr>");

		// Filas
		for (int fila = 0; fila < model.getRowCount(); fila++) {
			tb.append("<tr>");
			for (int col = 0; col < model.getColumnCount(); col++) {
				Object valor = model.getValueAt(fila, col);
				tb.append("<td>").append(valor != null ? valor.toString() : "").append("</td>");
			}
			tb.append("</tr>");
		}
		tb.append("</table>");
		tb.append("</body></html>");

		try {
			HtmlConverter.convertToPdf(tb.toString(), new FileOutputStream("o.pdf"));
		} catch (FileNotFoundException ex) {
			System.getLogger(Principal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
		}
        }//GEN-LAST:event_jButton1ActionPerformed

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
        private javax.swing.JButton jButton1;
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
