/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author frd
 */
public class Alumno {
	private int ID;
	private String DNI;
	private String PASSWD;

	public Alumno() {
	}

	public Alumno(int ID, String DNI, String PASSWD) {
		this.ID = ID;
		this.DNI = DNI;
		this.PASSWD = PASSWD;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getPASSWD() {
		return PASSWD;
	}

	public void setPASSWD(String PASSWD) {
		this.PASSWD = PASSWD;
	}
	
}
