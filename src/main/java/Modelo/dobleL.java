/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fernd
 */
public class dobleL {

	private dobleNode init;
	private dobleNode end;
	int size = 0;

	public void add(Curso data) {
		dobleNode aux = new dobleNode(data);
		if (init == null) {
			init = end = aux;
			size++;
			return;
		}
		end.next = aux;
		aux.prev = end;
		end = aux;
		size++;
	}

	public void add(Alumno dataAl) {
		dobleNode aux = new dobleNode(dataAl);
		if (init == null) {
			init = end = aux;
			size++;
			return;
		}
		end.next = aux;
		aux.prev = end;
		end = aux;
		size++;
	}

	public void printInit() {
		dobleNode current = init;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void printInitAl() {
		dobleNode current = init;
		while (current != null) {
			System.out.print(current.dataAl + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void printEnd() {
		dobleNode current = end;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.prev;
		}
		System.out.println("null");
	}

	public boolean containsValue(String dni, String pwd) {
		dobleNode current = init;

		while (current != null) {
			if (current.dataAl.getCODIGO().equals(dni) && current.dataAl.getPASSWD().equals(pwd)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public Curso[] toArray() {
		Curso[] arr = new Curso[size];
		dobleNode aux = init;
		int i = 0;
		while (aux != null) {
			arr[i++] = aux.data;
			aux = aux.next;
		}
		return arr;
	}

	/*public static void main(String[] args) {
		dobleL d1 = new dobleL();
		d1.add(new Alumno("imi", "imdie"));
		d1.add(new Alumno("imi", "imdie"));
		d1.add(new Alumno("imi", "imdie"));
		d1.add(new Alumno("imi", "imdie"));
		d1.add(new Alumno("imi", "imdie"));
		d1.add(new Alumno("imi", "imdie"));
		d1.add(new Alumno("imi", "imdie"));
		d1.printInitAl();
		System.out.println("im");
	}*/
}
