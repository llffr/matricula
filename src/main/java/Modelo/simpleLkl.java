/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class simpleLkl {

	// (head|data, next) -> (data, next) -> (data, null)
	class nodeSimple {

		Alumno data;
		nodeSimple next;

		nodeSimple(Alumno data) {
			this.data = data;
			this.next = null;
		}
	}

	nodeSimple head;

	public void add(Alumno data) {
		nodeSimple newNode = new nodeSimple(data);
		if (head == null) {
			head = newNode;
			return;
		}
		nodeSimple current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	public void print() {
		nodeSimple current = head;
		while (current != null) {
			String current_data = current.data.getDNI() + " " + current.data.getPASSWD();
			System.out.print(current_data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void rm(Alumno value) {
		if (head == null) {
			return;
		}

		// remove head
		if (head.data == value) {
			head = head.next;
			return;
		}

		nodeSimple current = head;
		while (current.next != null && current.next.data != value) {
			current = current.next;
		}

		if (current.next != null) {
			current.next = current.next.next;
		}
	}

	public boolean containsValue(String dni, String pwd) {
		nodeSimple current = head;

		while (current != null) {
			if (current.data.getDNI().equals(dni) && current.data.getPASSWD().equals(pwd)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		simpleLkl s1= new simpleLkl();
		s1.add(new Alumno("12", "12"));
		s1.print();
	}
}
