/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structure;

import Modelo.Alumno;

public class genericListaDoble<T> {

	private genericNode<T> cabeza;
	private genericNode<T> cola;
	private int tamaño;

	public genericListaDoble() {
		this.cabeza = null;
		this.cola = null;
		this.tamaño = 0;
	}

	public boolean estaVacia() {
		return cabeza == null;
	}

	public int getTamaño() {
		return tamaño;
	}

	public genericNode<T> getCabeza() {
		return cabeza;
	}

	public void insertarAlInicio(T dato) {
		genericNode<T> nuevoNodo = new genericNode<>(dato);

		if (estaVacia()) {
			cabeza = nuevoNodo;
			cola = nuevoNodo;
		} else {
			nuevoNodo.setSiguiente(cabeza);
			cabeza.setPrevio(nuevoNodo);
			cabeza = nuevoNodo;
		}
		tamaño++;
	}

	public void agregarAlFinal(T dato) {
		genericNode<T> nuevoNodo = new genericNode<>(dato);

		if (estaVacia()) {
			cabeza = nuevoNodo;
			cola = nuevoNodo;
		} else {
			nuevoNodo.setPrevio(cola);
			cola.setSiguiente(nuevoNodo);
			cola = nuevoNodo;
		}
		tamaño++;
	}

	public boolean buscarStudent(String codigo, String passwd) {
		if (estaVacia()) {
			return false;
		}
		genericNode<T> actual = cabeza;
		while (actual != null) {
			Alumno alumno = (Alumno) actual.getDato();

			if (alumno.getCODIGO().equalsIgnoreCase(codigo) && alumno.getPASSWD().equals(passwd)) {
				return true;
			}

			actual = actual.getSiguiente();
		}

		return false;
	}

	public T eliminarAlInicio() {
		if (estaVacia()) {
			System.out.println("La lista está vacía. No se puede eliminar.");
			return null;
		}

		T datoEliminado = cabeza.getDato();

		if (cabeza == cola) { // Caso de un solo elemento
			cabeza = null;
			cola = null;
		} else {
			cabeza = cabeza.getSiguiente();
			cabeza.setPrevio(null);
		}
		tamaño--;
		return datoEliminado;
	}

	public T eliminarAlFinal() {
		if (estaVacia()) {
			System.out.println("La lista está vacía. No se puede eliminar.");
			return null;
		}

		T datoEliminado = cola.getDato();

		if (cabeza == cola) {
			cabeza = null;
			cola = null;
		} else {
			cola = cola.getPrevio();
			cola.setSiguiente(null);
		}
		tamaño--;
		return datoEliminado;
	}

	public void imprimirAdelante() {
		if (estaVacia()) {
			System.out.println("La lista está vacía.");
			return;
		}

		genericNode<T> actual = cabeza;
		System.out.print("Lista (Adelante): ");
		while (actual != null) {
			System.out.print(actual.toString() + " <-> ");
			actual = actual.getSiguiente();
		}
		System.out.println("FIN");
	}

	public void imprimirAtras() {
		if (estaVacia()) {
			System.out.println("La lista está vacía.");
			return;
		}

		genericNode<T> actual = cola;
		System.out.print("Lista (Atrás): ");
		while (actual != null) {
			System.out.print(actual.toString() + " <-> ");
			actual = actual.getPrevio();
		}
		System.out.println("INICIO");
	}

	// añadir los cursos que estan en la lista a una tabla
	public T[] toArray() {
		if (estaVacia()) {
			return (T[]) new Object[0];
		}

		T[] array = (T[]) new Object[tamaño];

		genericNode<T> actual = cabeza;
		int indice = 0;

		while (actual != null) {
			array[indice] = actual.getDato();

			actual = actual.getSiguiente();
			indice++;
		}

		return array;
	}

	public String obtenerDatosComoString() {
		if (estaVacia()) {
			return "No hay datos registrados.";
		}

		StringBuilder sb = new StringBuilder("<ul>");
		genericNode<T> actual = cabeza;
		while (actual != null) {
			sb.append("<li>").append(actual.getDato().toString()).append("</li>");
			actual = actual.getSiguiente();
		}
		sb.append("</ul>");
		return sb.toString();
	}

}
