/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Modelo.Docente;
import Modelo.Alumno;
import Modelo.Curso;
import Structure.genericListaDoble;
import Structure.genericNode;
import Structure.globalVariables;

import javax.swing.*;
import java.awt.*;

public class frmAdd extends JFrame {

	private CardLayout cardLayout;
	private JPanel mainPanel;

	private genericListaDoble<Docente> docentes = globalVariables.getListaDocentes();
	private genericListaDoble<Alumno> alumnos = globalVariables.getListaAlumnos();
	private genericListaDoble<Curso> cursos = globalVariables.getListaCursos();

	public frmAdd() {
		super("Gestión de Datos Universitarios (Lista Doble)");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 550); 

		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Creación de paneles
		JPanel panelDocente = crearPanelDocente();
		JPanel panelAlumno = crearPanelAlumno();
		JPanel panelCurso = crearPanelCurso();
		JPanel panelInicio = crearPanelInicio(); // Método corregido

		// Añadir los paneles al CardLayout
		mainPanel.add(panelInicio, "Inicio");
		mainPanel.add(panelDocente, "Docente");
		mainPanel.add(panelAlumno, "Alumno");
		mainPanel.add(panelCurso, "Curso");

		// Configurar la barra de menú
		JMenuBar menuBar = crearMenuBar();
		setJMenuBar(menuBar);

		add(mainPanel);

		cardLayout.show(mainPanel, "Inicio");
		setLocationRelativeTo(null);
		setVisible(true);
		backToLogin();
	}

	// go to frmLogin
	public void backToLogin() {
		// When the user closes the window, show login again
		this.setDefaultCloseOperation(frmAdd.DO_NOTHING_ON_CLOSE);
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

	// --- MÉTODOS DE MENÚ ---
	private JMenuBar crearMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuAgregar = new JMenu("Agregar");
		JMenu menuVer = new JMenu("Ver Datos");

		JMenuItem itemDocente = new JMenuItem("Docente");
		JMenuItem itemAlumno = new JMenuItem("Alumno");
		JMenuItem itemCurso = new JMenuItem("Curso");

		JMenuItem verDocentes = new JMenuItem("Docentes");
		JMenuItem verAlumnos = new JMenuItem("Alumnos");
		JMenuItem verCursos = new JMenuItem("Cursos");

		// Acciones Agregar
		itemDocente.addActionListener(e -> cardLayout.show(mainPanel, "Docente"));
		itemAlumno.addActionListener(e -> cardLayout.show(mainPanel, "Alumno"));
		itemCurso.addActionListener(e -> cardLayout.show(mainPanel, "Curso"));

		menuAgregar.add(itemDocente);
		menuAgregar.add(itemAlumno);
		menuAgregar.add(itemCurso);

		// Acciones Ver
		verDocentes.addActionListener(e -> mostrarDatos(docentes, "Docentes Registrados"));
		verAlumnos.addActionListener(e -> mostrarDatos(alumnos, "Alumnos Registrados"));
		verCursos.addActionListener(e -> mostrarDatos(cursos, "Cursos Registrados"));

		menuVer.add(verDocentes);
		menuVer.add(verAlumnos);
		menuVer.add(verCursos);

		menuBar.add(menuAgregar);
		menuBar.add(menuVer);

		return menuBar;
	}

	// panel de inicio.
	private JPanel crearPanelInicio() {
		JPanel panel = new JPanel(new BorderLayout());
		return panel;
	}

	// forms
	private JPanel crearPanelDocente() {
		JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
		panel.setBorder(BorderFactory.createTitledBorder("Registro de Docente"));

		JTextField txtNombre = new JTextField(20);
		JPasswordField txtPwd = new JPasswordField(20);

		panel.add(new JLabel("Nombre:"));
		panel.add(txtNombre);
		panel.add(new JLabel("Contraseña:"));
		panel.add(txtPwd);

		JButton btnGuardar = new JButton("Guardar Docente");
		btnGuardar.addActionListener(e -> {
			String nombre = txtNombre.getText();
			String pwd = new String(txtPwd.getPassword());

			if (nombre.isEmpty() || pwd.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			Docente nuevoDocente = new Docente(nombre, pwd);
			// uso de listadoble
			docentes.agregarAlFinal(nuevoDocente);

			JOptionPane.showMessageDialog(this, "Docente registrado: " + nuevoDocente.getNombre());

			txtNombre.setText("");
			txtPwd.setText("");
		});

		panel.add(new JLabel());
		panel.add(btnGuardar);

		JPanel wrapper = new JPanel(new GridBagLayout());
		wrapper.add(panel);
		return wrapper;
	}

	private JPanel crearPanelAlumno() {
		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
		panel.setBorder(BorderFactory.createTitledBorder("Registro de Alumno"));

		JTextField txtCodigo = new JTextField(20);
		JPasswordField txtPasswd = new JPasswordField(20);

		panel.add(new JLabel("Código (CODIGO):"));
		panel.add(txtCodigo);
		panel.add(new JLabel("Contraseña (PASSWD):"));
		panel.add(txtPasswd);

		JButton btnGuardar = new JButton("Guardar Alumno");
		btnGuardar.addActionListener(e -> {
			String codigo = txtCodigo.getText();
			String passwd = new String(txtPasswd.getPassword());

			if (codigo.isEmpty() || passwd.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			Alumno nuevoAlumno = new Alumno(codigo, passwd);
			// USO DE LISTADOBLE
			alumnos.agregarAlFinal(nuevoAlumno);

			JOptionPane.showMessageDialog(this, "Alumno registrado con código: " + nuevoAlumno.getCODIGO());

			txtCodigo.setText("");
			txtPasswd.setText("");
		});

		panel.add(new JLabel());
		panel.add(btnGuardar);

		JPanel wrapper = new JPanel(new GridBagLayout());
		wrapper.add(panel);
		return wrapper;
	}

	private JPanel crearPanelCurso() {
		JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
		panel.setBorder(BorderFactory.createTitledBorder("Registro de Curso"));

		// horario clases
		String[] diasSemana= { "--", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

		// horarios +30min
		String[] horasDisponibles = new String[29];
		int count = 0;
		for (int h = 8; h <= 22; h++) {
			horasDisponibles[count++] = String.format("%02d:00", h);
			if (h < 22) { // No queremos 20:30
				horasDisponibles[count++] = String.format("%02d:30", h);
			}
		}
		// docentes registrados
		String[] nombresDocentes;
		if (docentes.getTamaño()> 0) {
			nombresDocentes = new String[docentes.getTamaño()]; 

			genericNode<Docente> actual = docentes.getCabeza();
			int i = 0;
			while (actual != null) {
				nombresDocentes[i++] = actual.getDato().getNombre();
				actual = actual.getSiguiente();
			}
		} else {
			nombresDocentes = new String[]{"-- No hay docentes registrados --"};
		}

		JComboBox<String> cmbDiaInicio = new JComboBox<>(diasSemana);
		JComboBox<String> cmbDiaFin = new JComboBox<>(diasSemana);
		JComboBox<String> cmbHoraInicio = new JComboBox<>(horasDisponibles);
		JComboBox<String> cmbHoraFin = new JComboBox<>(horasDisponibles);
		JComboBox<String> cmbProfesor = new JComboBox<>(nombresDocentes);

		JTextField txtName = new JTextField(20);
		JTextField txtHours = new JTextField(20);
		JTextField txtCredits = new JTextField(20);
		JTextField txtMaxVacantes = new JTextField(20);

		panel.add(new JLabel("Nombre:"));
		panel.add(txtName);
		panel.add(new JLabel("Horas (int):"));
		panel.add(txtHours);
		panel.add(new JLabel("Créditos (int):"));
		panel.add(txtCredits);

		panel.add(new JLabel("Profesor:"));
		panel.add(cmbProfesor);
		panel.add(new JLabel("Día de Inicio:"));
		panel.add(cmbDiaInicio);
		panel.add(new JLabel("Día de Fin:"));
		panel.add(cmbDiaFin);

		panel.add(new JLabel("Hora de Inicio:"));
		panel.add(cmbHoraInicio);
		panel.add(new JLabel("Hora de Fin:"));
		panel.add(cmbHoraFin);
		
		panel.add(new JLabel("Max. Vacantes (int):"));
		panel.add(txtMaxVacantes);

		JButton btnGuardar = new JButton("Guardar Curso");
		btnGuardar.addActionListener(e -> {
			try {
				String name = txtName.getText();
				int hours = Integer.parseInt(txtHours.getText());
				int credits = Integer.parseInt(txtCredits.getText());
				int maxVacantes = Integer.parseInt(txtMaxVacantes.getText());

				String profesor = (String) cmbProfesor.getSelectedItem();
				if (profesor.equals("-- No hay docentes registrados --")) {
					JOptionPane.showMessageDialog(this, "ERROR: Debe registrar docentes antes de crear un curso.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// horario combobox
				String diaInicio = (String) cmbDiaInicio.getSelectedItem();
				String diaFin = (String) cmbDiaFin.getSelectedItem();
				String horaInicio = (String) cmbHoraInicio.getSelectedItem();
				String horaFin = (String) cmbHoraFin.getSelectedItem();

				// Creación del string Horario: "Lunes-Martes 9:00 - 11:00"
				String horarioFinal = diaInicio + "-" + diaFin + " " + horaInicio + "-" + horaFin;

				if (name.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Los campos de texto son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// CHECK
				if (diaInicio.equals(diaFin)) {
					JOptionPane.showMessageDialog(this, "El curso debe tener al menos dos días diferentes.", "Error de Horario", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// hora inicio no sea igual o posterior a fin
				if (horaInicio.compareTo(horaFin) >= 0) {
					JOptionPane.showMessageDialog(this, "La Hora de Inicio debe ser anterior a la Hora de Fin.", "Error de Horario", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// unico dia
				if (diaFin.equals("--")) {
					horarioFinal = diaInicio +  " " + horaInicio + "-" + horaFin;
				}

				Curso nuevoCurso = new Curso(name, hours, credits, profesor, horarioFinal, maxVacantes);

				// uso de listadoble
				cursos.agregarAlFinal(nuevoCurso);

				JOptionPane.showMessageDialog(this, "Curso registrado: " + nuevoCurso.getName() + " horario: " + horarioFinal);

				txtName.setText("");
				txtHours.setText("");
				txtCredits.setText("");
				txtMaxVacantes.setText("");

				// los combobox regresan al primer elemento por defecto
				cmbProfesor.setSelectedIndex(0);
				cmbDiaInicio.setSelectedIndex(0); 
				cmbDiaFin.setSelectedIndex(0);
				cmbHoraInicio.setSelectedIndex(0);
				cmbHoraFin.setSelectedIndex(0);

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Las Horas, Créditos y Vacantes deben ser números enteros válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
			}
		});

		panel.add(new JLabel());
		panel.add(btnGuardar);

		JPanel wrapper = new JPanel(new GridBagLayout());
		wrapper.add(panel);
		return wrapper;
	}

	/**
	 * Muestra los datos recopilados desde la ListaDoble<T>
	 */
	private <T> void mostrarDatos(genericListaDoble<T> lista, String titulo) {

		// Obtiene el contenido HTML usando el método de ListaDoble
		String contenidoHtml = lista.obtenerDatosComoString();

		if (contenidoHtml.equals("No hay datos registrados.")) {
			JOptionPane.showMessageDialog(this, contenidoHtml, titulo, JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		StringBuilder sb = new StringBuilder("<html><h2>" + titulo + "</h2>");
		sb.append(contenidoHtml).append("</html>");

		// Usamos JScrollPane para manejar listas largas
		JLabel contentLabel = new JLabel(sb.toString());
		// Ajustamos la alineación vertical y horizontal para que se vea bien
		contentLabel.setVerticalAlignment(SwingConstants.TOP);
		contentLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JScrollPane scrollPane = new JScrollPane(contentLabel);
		scrollPane.setPreferredSize(new Dimension(500, 300));

		JOptionPane.showMessageDialog(this, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new frmAdd());
	}
}
