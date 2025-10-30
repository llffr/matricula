/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fernd
 */
public class dobleNode {
	Curso data;
	Alumno dataAl;
	dobleNode next;
	dobleNode prev;

	public dobleNode(Curso data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	public dobleNode(Alumno dataAl) {
		this.dataAl = dataAl;
		this.next = null;
		this.prev = null;
	}
}