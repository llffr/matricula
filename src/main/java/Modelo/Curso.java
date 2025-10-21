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

	public Curso() {
	}

	public Curso(String name, int hours, int credits, String profesor) {
		this.name = name;
		this.hours = hours;
		this.credits = credits;
		this.profesor = profesor;
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
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return name + " (" + credits + " credits, " + hours + "h) - " + profesor;
	}

}
