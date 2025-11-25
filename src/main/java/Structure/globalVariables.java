/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structure;

import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Docente;

public class globalVariables {

	private static genericListaDoble<Docente> listaDocentes = new genericListaDoble<>();
	private static genericListaDoble<Alumno> listaAlumnos = new genericListaDoble<>();
	private static genericListaDoble<Curso> listaCursos = new genericListaDoble<>();
	public static Object usuarioActual;

	private static boolean datosInicializados = false;

	public static genericListaDoble<Docente> getListaDocentes() {
		return listaDocentes;
	}

	public static genericListaDoble<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public static genericListaDoble<Curso> getListaCursos() {
		return listaCursos;
	}

	public static void initVariables() {
		if (datosInicializados) {
			System.out.println("datos ya creados");
			return;
		}
		listaDocentes.agregarAlFinal(new Docente("Maria Lopez","123"));
		listaDocentes.agregarAlFinal(new Docente("Juan Perez", "456"));
		listaDocentes.agregarAlFinal(new Docente("Leo Perez", "456"));
		listaDocentes.agregarAlFinal(new Docente("Mia Perez", "456"));

		for(int i=1; i<=100000; i++) {
			String al= "U" + i;
			String al_pwd= Integer.toString(i);
			listaAlumnos.agregarAlFinal(new Alumno(al, al_pwd));
		}

		listaCursos.agregarAlFinal(new Curso("Algoritmos", 4, 6, "Maria Lopez", "Lunes-Miercoles 8:30-10:00", 20));
		listaCursos.agregarAlFinal(new Curso("Math1", 2, 6, "Juan Perez", "Lunes-Miercoles 10-13:00", 10));
		listaCursos.agregarAlFinal(new Curso("Math2", 4, 6, "Leo Perez", "Martes-Miercoles 10-13:00", 10));
		listaCursos.agregarAlFinal(new Curso("Math3", 4, 6, "Mia Perez", "Lunes-Miercoles 10-13:00", 15));
		listaCursos.agregarAlFinal(new Curso("Fisica1", 4, 6, "Juan Perez", "Martes-Jueves 18-20:30", 15));
		listaCursos.agregarAlFinal(new Curso("Fisica1", 4, 6, "Mia Perez", "Martes-Jueves 18-20:30", 20));

		// no duplicate
		datosInicializados= true;
	}
}
