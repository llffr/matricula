/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Modelo.Curso;
import Structure.genericListaDoble;
import Structure.genericNode;
import Structure.globalVariables;
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
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

	/**
	 * Creates new form Principal
	 */
	public Principal() {
		initComponents();
		setLocationRelativeTo(null); // center jframe
		addCourses();
		copyFromTables();
		backToLogin();
	}

	public void backToLogin() {
		// When the user closes the window, show login again
		this.setDefaultCloseOperation(Principal.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				// Show the login form again
				frmLogin login = new frmLogin();
				login.setVisible(true);
				// Close the menu
				dispose();
			}
		});
	}

	public void addCourses() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5;
			}
		};

		model.addColumn("Curso");
		model.addColumn("Profesor");
		model.addColumn("Horario");
		model.addColumn("Horas");
		model.addColumn("Créditos");
		model.addColumn("Action");

		tbCourses.setModel(model);

		genericListaDoble<Curso> listaCursos = globalVariables.getListaCursos();
		genericNode<Curso> actual = listaCursos.getCabeza();

		int index = 0;
		while (actual != null) {
			Curso curso = actual.getDato();
			Object[] rowData = new Object[]{
				curso.getName(),
				curso.getProfesor(),
				curso.getHorario(),
				curso.getHours(),
				curso.getCredits(),
				"Seleccionar"
			};
			model.addRow(rowData);
			actual = actual.getSiguiente();
			index++;
		}

		TableActionEvent2 event2 = new TableActionEvent2() {
			@Override
			public void openUI(int row) {
				// obtener los datos de fila seleccionada
				String nombre = (String) tbCourses.getValueAt(row, 0);
				String profesor = (String) tbCourses.getValueAt(row, 1);
				String horario = (String) tbCourses.getValueAt(row, 2);
				int horas = (int) tbCourses.getValueAt(row, 3);
				int creditos = (int) tbCourses.getValueAt(row, 4);

				// buscar el objeto usando sus atributos
				Curso cursoSeleccionado = buscarCursoExacto(nombre, profesor, horario, horas, creditos);

				if (cursoSeleccionado != null) {
					frmHorario n = new frmHorario(cursoSeleccionado, tbSelCourses);
					n.setVisible(true);
					n.setDefaultCloseOperation(frmHorario.DISPOSE_ON_CLOSE);
				} else {
					JOptionPane.showMessageDialog(null, "Error: Curso no encontrado en la lista");
				}
			}
		};

		tbCourses.getColumnModel().getColumn(5).setCellRenderer(new buttonToTable2());
		tbCourses.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor2(event2));

	}

	public void copyFromTables() {
		DefaultTableModel modelSel = new DefaultTableModel();
		tbSelCourses.setModel(modelSel);

		modelSel.addColumn("Curso");
		modelSel.addColumn("Horas");
		modelSel.addColumn("Créditos");
		modelSel.addColumn("Profesor");
		modelSel.addColumn("Horario");
		modelSel.addColumn("Action");

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
				// obtener los datos de la fila seleccionada
				String nombre = (String) tbCourses.getValueAt(row, 0);
				String profesor = (String) tbCourses.getValueAt(row, 1);
				String horario = (String) tbCourses.getValueAt(row, 2);
				int horas = (int) tbCourses.getValueAt(row, 3);
				int creditos = (int) tbCourses.getValueAt(row, 4);

				// buscar el objeto exacto usando sus atributos
				Curso cursoSeleccionado = buscarCursoExacto(nombre, profesor, horario, horas, creditos);

				if (cursoSeleccionado != null) {
					frmHorario n = new frmHorario(cursoSeleccionado, tbSelCourses);
					n.setVisible(true);
					n.setDefaultCloseOperation(frmHorario.DISPOSE_ON_CLOSE);
				} else {
					JOptionPane.showMessageDialog(null, "Error: Curso no encontrado en la lista global.");
				}
			}
		};

		//tbCourses.getColumnModel().getColumn(3).setCellRenderer(new buttonToTable2());
		//tbCourses.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor2(event2));

		tbSelCourses.getColumnModel().getColumn(5).setCellRenderer(new buttonToTable());
		tbSelCourses.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
	}

	private Curso buscarCursoExacto(String name, String profesor, String horario, int hours, int credits) {
		genericListaDoble<Curso> lista = globalVariables.getListaCursos();
		genericNode<Curso> actual = lista.getCabeza();

		while (actual != null) {
			Curso curso = actual.getDato();
			// Compara todos los campos para asegurar que es la variante correcta
			if (curso.getName().equals(name)
				&& curso.getProfesor().equals(profesor)
				&& curso.getHorario().equals(horario)
				&& curso.getHours() == hours
				&& curso.getCredits() == credits) {
				return curso;
			}
			actual = actual.getSiguiente();
		}
		return null;
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
	               txtUser = new javax.swing.JLabel();
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
	               jDesktopPane1.setLayer(txtUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

	               javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
	               jDesktopPane1.setLayout(jDesktopPane1Layout);
	               jDesktopPane1Layout.setHorizontalGroup(
	                       jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                       .addGroup(jDesktopPane1Layout.createSequentialGroup()
	                               .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                       .addGroup(jDesktopPane1Layout.createSequentialGroup()
	                                               .addGap(51, 51, 51)
	                                               .addComponent(jButton1))
	                                       .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
	                                                       .addGap(34, 34, 34)
	                                                       .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                                               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                               .addGroup(jDesktopPane1Layout.createSequentialGroup()
	                                                                       .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                                                       .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                                               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
	                                                       .addGap(15, 15, 15)
	                                                       .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                                               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
	                                                               .addComponent(jScrollPane2)))))
	                               .addContainerGap(17, Short.MAX_VALUE))
	               );
	               jDesktopPane1Layout.setVerticalGroup(
	                       jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                       .addGroup(jDesktopPane1Layout.createSequentialGroup()
	                               .addContainerGap()
	                               .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                       .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                       .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
	                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                               .addComponent(jLabel2)
	                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
	                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                               .addComponent(jButton1)
	                               .addGap(10, 10, 10))
	               );

	               menuAsistencia.setText("Cursos");
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

		       tb.append("<img src='file:./img/utp.jpg' alt='Logo' style='width:100px;height:auto;'/>");
		       tb.append("<h2 style='text-align:center;'>Cursos Matriculados</h2>");
		       tb.append("<h3 style='text-align:left;'>User: ").append(frmLogin.txtUsuario.getText()).append("</23>");
		       tb.append("<table>");
		       tb.append("<tr>");

		       // Encabezados
		       for (int col = 0; col < model.getColumnCount() - 1; col++) {
			       tb.append("<th>").append(model.getColumnName(col)).append("</th>");
		       }
		       tb.append("</tr>");

		       // Filas
		       for (int fila = 0; fila < model.getRowCount(); fila++) {
			       tb.append("<tr>");
			       for (int col = 0; col < model.getColumnCount() - 1; col++) {
				       Object valor = model.getValueAt(fila, col);
				       tb.append("<td>").append(valor != null ? valor.toString() : "").append("</td>");
			       }
			       tb.append("</tr>");
		       }
		       tb.append("</table>");
		       tb.append("</body></html>");

		       try {
			       //genera archivo pdf
			       HtmlConverter.convertToPdf(tb.toString(), new FileOutputStream("o.pdf"));
			       JOptionPane.showMessageDialog(null, "Reporte Generado");
		       } catch (FileNotFoundException ex) {
			       System.getLogger(Principal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
		       }
	       }//GEN-LAST:event_jButton1ActionPerformed

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
	       private javax.swing.JLabel txtUser;
	       // End of variables declaration//GEN-END:variables
}
