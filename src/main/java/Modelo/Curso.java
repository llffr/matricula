/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Curso {

	public String NAME;
	public int hours;
	public int credits;
	public String profesor;

	public Curso() {
	}

	public Curso(String NAME, int hours, int credits, String profesor) {
		this.NAME = NAME;
		this.hours = hours;
		this.credits = credits;
		this.profesor = profesor;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
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
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return NAME + " (" + credits + " créditos, " + hours + "h) - " + profesor;
	}

}
