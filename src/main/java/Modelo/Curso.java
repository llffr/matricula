/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Curso {

	public String name;
	public int hours;
	public int credits;
	public String profesor;
	public String horario;

	public Curso(String name, int hours, int credits, String profesor, String horario) {
		this.name = name;
		this.hours = hours;
		this.credits = credits;
		this.profesor = profesor; 
		this.horario = horario;
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

	@Override
	public String toString() {
		return name + " (" + credits + " credits, " + hours + "h)" + profesor + " " + horario;
	}

}
