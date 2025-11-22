/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Curso {

	private String name, profesor, horario;
	private int hours, credits;
	
	//limitar vacantes
	private int maxVacantes;
	private int vacantesDisponibles;

	public Curso(String name, int hours, int credits, String profesor, String horario, int maxVacantes) {
		this.name = name;
		this.hours = hours;
		this.credits = credits;
		this.profesor = profesor;
		this.horario = horario;
		this.vacantesDisponibles = maxVacantes;
	}

	public Curso(String name, int hours, int credits) {
		this.name = name;
		this.hours = hours;
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor= profesor;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	// vacantes
	public int getMaxVacantes() {
		return maxVacantes;
	}

	public void setMaxVacantes(int maxVacantes) {
		this.maxVacantes = maxVacantes;
	}

	public int getVacantesDisponibles() {
		return vacantesDisponibles;
	}

	private void setVacantesDisponibles(int vacantesDisponibles) {
		this.vacantesDisponibles = vacantesDisponibles;
	}

	public boolean matricularAlumno() {
		if (vacantesDisponibles > 0) {
			// reduce el numero de vacantes
			vacantesDisponibles--; 
			return true;
		}
		return false;
	}

	// libera una vacante (cuando se elimina un curso de la matrícula).
	public void liberarVacante() {
		if (vacantesDisponibles < maxVacantes) {
			vacantesDisponibles++; // aumenta el contador de vacantes
		}
	}

	@Override
	public String toString() {
		return name + ", credits: " + credits + ", hours: " + hours + ", profesor: " + profesor + ", horario: " + horario + ", vacantes: "  + vacantesDisponibles;
	}

}
