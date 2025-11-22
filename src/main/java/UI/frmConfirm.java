/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Modelo.Curso;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmConfirm extends javax.swing.JFrame {

	private Curso cursoAConfirmar;
	private JTable tablaDestino;

	public frmConfirm(Curso curso, JTable tabla) {
		this.cursoAConfirmar = curso;
		this.tablaDestino = tabla;

		initComponents();
		setLocationRelativeTo(null);
		mostrarDetallesCurso(); // Rellena los campos con los datos del curso
	}

	/**
	 * Rellena las etiquetas con los detalles del curso, incluyendo vacantes.
	 */
	private void mostrarDetallesCurso() {
		if (cursoAConfirmar != null) {
			lblCursoNombre.setText(cursoAConfirmar.getName());
			lblHorario.setText(cursoAConfirmar.getHorario());
			lblProfesor.setText(cursoAConfirmar.getProfesor());

			// Se rellenan los campos de Horas y Créditos (corrección de la omisión inicial)
			lblCreditos.setText(String.valueOf(cursoAConfirmar.getCredits()));
			lblHoras.setText(String.valueOf(cursoAConfirmar.getHours()));

			// NUEVA LÍNEA: Mostrar Vacantes Disponibles/Máximas
			String vacantesStr = cursoAConfirmar.getVacantesDisponibles() + " / " + cursoAConfirmar.getMaxVacantes();
			lblVacantes.setText(vacantesStr); 
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
		// NUEVO: Etiqueta para Vacantes
		jLabel6 = new javax.swing.JLabel(); 
		
		lblCursoNombre = new javax.swing.JLabel();
		lblProfesor = new javax.swing.JLabel();
		lblHorario = new javax.swing.JLabel();
		lblCreditos = new javax.swing.JLabel();
		lblHoras = new javax.swing.JLabel();
		// NUEVO: Etiqueta de Valor de Vacantes
		lblVacantes = new javax.swing.JLabel(); 

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

		jLabel4.setText("Créditos:"); // Se reincorpora la etiqueta
		
		jLabel5.setText("Horas:"); // Se reincorpora la etiqueta

		jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NUEVA ETIQUETA
		jLabel6.setText("Vacantes:"); 

		lblCursoNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lblCursoNombre.setForeground(new java.awt.Color(0, 0, 204));
		lblCursoNombre.setText("NOMBRE DEL CURSO");

		lblProfesor.setText("Profesor Asignado");

		lblHorario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblHorario.setForeground(new java.awt.Color(204, 0, 0));
		lblHorario.setText("L-M-V 18:00 - 20:00");

		lblCreditos.setText("X");

		lblHoras.setText("Y");
		
		lblVacantes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NUEVO CAMPO
		lblVacantes.setForeground(new java.awt.Color(0, 153, 0));
		lblVacantes.setText("0/0");

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
						.addComponent(jLabel5)
						.addComponent(jLabel6)) // NUEVA ETIQUETA
					.addGap(30, 30, 30)
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblVacantes) // NUEVO CAMPO
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
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Espacio para el nuevo campo
					.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel6) // NUEVA ETIQUETA
						.addComponent(lblVacantes)) // NUEVO CAMPO
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
		
		// Lógica de control de vacantes ya implementada
		if (cursoAConfirmar.matricularAlumno()) {
			// La matrícula fue exitosa y la vacante se redujo en el objeto Curso
			agregarCursoAMatricula();
			JOptionPane.showMessageDialog(this, "Curso '" + cursoAConfirmar.getName() + 
					"' matriculado con éxito.\nVacantes restantes: " + cursoAConfirmar.getVacantesDisponibles(), 
					"Matrícula Exitosa", JOptionPane.INFORMATION_MESSAGE);
			this.dispose(); 
		} else {
			// No hay vacantes
			JOptionPane.showMessageDialog(this, "ERROR: No quedan vacantes disponibles para el curso '" + 
					cursoAConfirmar.getName() + "'.", 
					"Matrícula Fallida", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose(); // Simplemente cerrar la ventana
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnConfirmar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6; // NUEVA ETIQUETA
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblCreditos;
	private javax.swing.JLabel lblCursoNombre;
	private javax.swing.JLabel lblHorario;
	private javax.swing.JLabel lblHoras;
	private javax.swing.JLabel lblProfesor;
	private javax.swing.JLabel lblVacantes; // NUEVA VARIABLE
	// End of variables declaration                   
}
