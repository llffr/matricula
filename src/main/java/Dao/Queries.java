/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Alumno;
import Modelo.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vista.Principal;

public class Queries {

	clsConexion cn = new clsConexion();
	Connection con = cn.sqlite();
	ResultSet rs;

	// login
	public boolean login(Alumno al) {
		PreparedStatement ps = null;
		String sql = "select email, passwd from alumnos where email=? and passwd=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, al.getDNI());
			ps.setString(2, al.getPASSWD());
			rs = ps.executeQuery();

			if (rs.next()) {
				if (al.getDNI().equals(rs.getString(1)) && al.getPASSWD().equals(rs.getString(2))) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return false;
	}

	public void showCourses() {
		DefaultTableModel tabla = new DefaultTableModel();
		String[] titulo = {"Course", "Hours", "Credits", "Profesor"};
		tabla = new DefaultTableModel(null, titulo);

		String sql = "SELECT c.nombre, c.hours, c.creditos, concat(p.nombre, ' ', p.apellido) as Profesor FROM cursos c inner JOIN profesores p ON c.id_profesor = p.id_profesor";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Object[] dato = new Object[4];
				dato[0] = rs.getString("nombre");
				dato[1] = rs.getInt("hours");
				dato[2] = rs.getInt("creditos");
				dato[3] = rs.getString("Profesor");
				tabla.addRow(dato);
			}
			Principal.tbCourses.setModel(tabla);
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void saveSelectedCourses() {
//		int[] selectedRows = Principal.tbCourses.getSelectedRows();
//		ArrayList<Curso> selectedCourses = new ArrayList<>();
//
//		for (int row : selectedRows) {
//			String course = Principal.tbCourses.getValueAt(row, 0).toString();
//			int hours = Integer.parseInt(Principal.tbCourses.getValueAt(row, 1).toString());
//			int credits = Integer.parseInt(Principal.tbCourses.getValueAt(row, 2).toString());
//			String profesor = Principal.tbCourses.getValueAt(row, 3).toString();
//
//			selectedCourses.add(new Course(course, hours, credits, profesor));
//		}
//
//		// Construir el texto para el JLabel
//		StringBuilder texto = new StringBuilder("<html>");
//		for (Curso c : selectedCourses) {
//			texto.append(c.toString()).append("<br>");
//		}
//		texto.append("</html>");
//
//		// Mostrar en el JLabel
//		Principal.lblSelectedCourses.setText(texto.toString());
//	}

}
