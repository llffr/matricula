/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Curso {

	private int ID;
	private String NAME;
	private int hours;
	private int credits;
	private String profesor;

	public Curso() {
	}

	public Curso(int ID, String NAME, int hours, int credits, String profesor) {
		this.ID = ID;
		this.NAME = NAME;
		this.hours = hours;
		this.credits = credits;
		this.profesor = profesor;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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
