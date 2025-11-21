/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structure;

public class pilaEstatica {
	private int[] pila;
	private int tope;
	private int capacidad;

	public pilaEstatica(int capacidad) {
		this.capacidad = capacidad;
		pila = new int[capacidad];
		tope = -1;
	}

	public void push(int valor) {
		if (tope < capacidad - 1) {
			pila[++tope] = valor;
		} else {
			System.out.println("Pila llena.");
		}
	}

	public int pop() {
		if (tope >= 0) {
			return pila[tope--];
		} else {
			System.out.println("Pila vacía.");
			return -1;
		}
	}

	public int peek() {
		return (tope >= 0) ? pila[tope] : -1;
	}

	public boolean isEmpty() {
		return tope == -1;
	}

	public void imprimir() {
		pilaEstatica x = new pilaEstatica(capacidad);
		while (!isEmpty()) {
			int d = pop();
			System.out.print(" " + d);
			x.push(d);
		}
		while (!x.isEmpty()) {
			int d = x.pop();
			push(d);
		}
	}

	public void invertir() {
		pilaEstatica x = new pilaEstatica(capacidad);
		pilaEstatica y = new pilaEstatica(capacidad);
		while (!isEmpty()) {
			int d = pop();
			x.push(d);
		}
		while (!x.isEmpty()) {
			int d = x.pop();
			y.push(d);
		}
		while (!y.isEmpty()) {
			int d = y.pop();
			push(d);
		}
	}

	public int mayor() {
		pilaEstatica x = new pilaEstatica(capacidad);
		int m = pop();
		x.push(m);
		while (!isEmpty()) {
			int d = pop();
			if (d > m) {
				d = m;
			}
			x.push(d);
		}
		while (!x.isEmpty()) {
			int d = x.pop();
			push(d);
		}
		return m;
	}

	/*public static void main(String[] args) {
		pilaEstatica p1= new pilaEstatica(10);
		p1.push(2);
		p1.push(3);
		p1.push(23);
		p1.imprimir();
	}*/
}
