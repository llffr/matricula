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

	class dobleNode {

		Curso data;
		dobleNode next;
		dobleNode prev;

		dobleNode(Curso data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

	}

	dobleNode init;
	dobleNode end;
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

	public void printInit() {
		dobleNode current = init;
		while (current != null) {
			System.out.print(current.data + " <-> ");
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

	public static void main(String[] args) {
		dobleL d1= new dobleL();
		d1.add(new Curso("a1", 1,2));
		
		Curso str[]= d1.toArray();
		
		System.out.println(str[0].getName());
	}
}
