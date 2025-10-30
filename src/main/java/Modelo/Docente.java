/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fernd
 */
public class Docente {

	private String idDocente, nombre, especialidad, correo;

	public Docente(String idDocente, String nombre, String especialidad, String correo) {
		this.idDocente = idDocente;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.correo = correo;
	}

	public String toString() {
		return idDocente + " - " + nombre;
	}
}
