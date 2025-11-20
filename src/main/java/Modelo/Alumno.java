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

	private String CODIGO, PASSWD;

	public Alumno(String CODIGO, String PASSWD) {
		this.CODIGO = CODIGO;
		this.PASSWD = PASSWD;
	}

	public String getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(String CODIGO) {
		this.CODIGO = CODIGO;
	}

	public String getPASSWD() {
		return PASSWD;
	}

	public void setPASSWD(String PASSWD) {
		this.PASSWD = PASSWD;
	}
	@Override
	public String toString() {
		return CODIGO + " " + PASSWD; 
	}

}
