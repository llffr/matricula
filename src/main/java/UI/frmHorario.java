/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Modelo.Curso;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmHorario extends javax.swing.JFrame {

	private Curso cursoAConfirmar;
	private JTable tablaDestino;

	public frmHorario(Curso curso, JTable tabla) {
		this.cursoAConfirmar = curso;
		this.tablaDestino = tabla;

		initComponents();
		setLocationRelativeTo(null);
		mostrarDetallesCurso(); // Rellena los campos con los datos del curso
	}

	/**
	 * Rellena las etiquetas con los detalles del curso.
	 */
	private void mostrarDetallesCurso() {
		if (cursoAConfirmar != null) {
			lblCursoNombre.setText(cursoAConfirmar.getName());
			lblHorario.setText(cursoAConfirmar.getHorario());
			lblProfesor.setText(cursoAConfirmar.getProfesor());
		}
	}

	/**
	 * Agrega el curso a la tabla de cursos seleccionados.
	 */
	private void agregarCursoAMatricula() {
		DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();

		Object[] row = new Object[]{
			cursoAConfirmar.getName(),
			cursoAConfirmar.getHours(),
			cursoAConfirmar.getCredits(),
			cursoAConfirmar.getProfesor(),
			cursoAConfirmar.getHorario(),
			null // Espacio para el botón de acción (eliminar)
		};

		model.addRow(row);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		lblCursoNombre = new javax.swing.JLabel();
		lblProfesor = new javax.swing.JLabel();
		lblHorario = new javax.swing.JLabel();
		lblCreditos = new javax.swing.JLabel();
		lblHoras = new javax.swing.JLabel();
		btnConfirmar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Confirmar Matrícula");
		setResizable(false);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Curso"));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel1.setText("Curso:");

		jLabel2.setText("Profesor:");

		jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jLabel3.setText("Horario:");

		jLabel4.setText("Créditos:");

		jLabel5.setText("Horas:");

		lblCursoNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lblCursoNombre.setForeground(new java.awt.Color(0, 0, 204));
		lblCursoNombre.setText("NOMBRE DEL CURSO");

		lblProfesor.setText("Profesor Asignado");

		lblHorario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblHorario.setForeground(new java.awt.Color(204, 0, 0));
		lblHorario.setText("L-M-V 18:00 - 20:00");

		lblCreditos.setText("X");

		lblHoras.setText("Y");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(20, 20, 20)
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel1)
						.addComponent(jLabel2)
						.addComponent(jLabel3)
						.addComponent(jLabel4)
						.addComponent(jLabel5))
					.addGap(30, 30, 30)
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblHoras)
						.addComponent(lblCreditos)
						.addComponent(lblHorario)
						.addComponent(lblProfesor)
						.addComponent(lblCursoNombre))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(lblCursoNombre))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(lblProfesor))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel3)
						.addComponent(lblHorario))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(lblCreditos))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel5)
						.addComponent(lblHoras))
					.addContainerGap(15, Short.MAX_VALUE))
		);

		btnConfirmar.setText("Confirmar Matrícula");
		btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConfirmarActionPerformed(evt);
			}
		});

		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addGap(50, 50, 50)
					.addComponent(btnConfirmar)
					.addGap(30, 30, 30)
					.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnCancelar))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}// </editor-fold>                        

	private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
		agregarCursoAMatricula();
		JOptionPane.showMessageDialog(this, "Curso '" + cursoAConfirmar.getName() + "' matriculado con éxito.", "Matrícula Exitosa", JOptionPane.INFORMATION_MESSAGE);
		this.dispose(); // Cerrar la ventana de confirmación
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose(); // Simplemente cerrar la ventana
	}

	// Las aplicaciones GUI que usan NetBeans Design no suelen tener main()
	// en los formularios secundarios, pero lo incluyo por si necesitas probarlo
	/*
	   public static void main(String args[]) {
	   java.awt.EventQueue.invokeLater(new Runnable() {
	   public void run() {
	// Ejemplo de uso (asumiendo que Curso existe)
	// new frmHorario(new Curso("Test", 3, 5, "Dr. Ejemplo", "M-J 10:00"), new JTable()).setVisible(true);
	   }
	   });
	   }
	 */
	// Variables declaration - do not modify                     
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnConfirmar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblCreditos;
	private javax.swing.JLabel lblCursoNombre;
	private javax.swing.JLabel lblHorario;
	private javax.swing.JLabel lblHoras;
	private javax.swing.JLabel lblProfesor;
	// End of variables declaration                   
}
