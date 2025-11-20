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
			System.out.println("ADVERTENCIA: Los datos simulados ya fueron cargados. Saltando inicialización.");
			return;
		}
		// Docentes de prueba: (nombre, codigo, pwd)
		listaDocentes.agregarAlFinal(new Docente("Maria Lopez","123"));
		listaDocentes.agregarAlFinal(new Docente("Juan Perez", "456"));

		// Alumnos de prueba: (CODIGO, PASSWD)
		listaAlumnos.agregarAlFinal(new Alumno("U1", "1"));
		listaAlumnos.agregarAlFinal(new Alumno("U2", "2"));

		// Curso de prueba
		listaCursos.agregarAlFinal(new Curso("Algoritmos", 4, 6, "Maria Lopez", "L-M 08:00-10:00 am"));
		listaCursos.agregarAlFinal(new Curso("Math1", 4, 6, "Juan Perez", "L-M 08:00-10:00 am"));
		listaCursos.agregarAlFinal(new Curso("Fisica1", 4, 6, "Juan Perez", "L-M 06:00-08:00 pm"));

		// no duplicate
		datosInicializados= true;
	}
}
