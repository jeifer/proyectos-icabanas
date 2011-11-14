package org.icabanas.ejemplos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class LibroTest extends BaseTest {
	
	@Test
	public void deberiaDarDeAltaLibrosParaBibliotecaYConsultarlos(){
		
		// inicializamos los datos del test
		inicializarDatosTest();
		
		// recuperamos el objeto
		final List<Libro> list = emConsultas.createQuery("select p from Libro p").getResultList();
		 
		assertEquals(2, list.size());
        for (Libro actual : list) {
            final String isbn = actual.getIsbn();
            assertTrue(isbn.equals("978-84-7902-464-2") || isbn.equals("978-84-7902-464-1"));
            final String nombreBiblioteca = actual.getBiblioteca().getNombre();
            assertTrue(nombreBiblioteca.equals("Biblioteca Nacional de Madrid"));
        }
	}
	
	@Test
	public void deberiaDarDeAltaLibrosParaBibliotecaYSusCopias(){
		
		// inicializamos los datos del test
		inicializarDatosTest();
		
		// recuperamos el objeto
		final List<Libro> list = emConsultas.createQuery("select p from Libro p").getResultList();
		 
		assertEquals(2, list.size());
        for (Libro actual : list) {
            final String isbn = actual.getIsbn();
            assertTrue(isbn.equals("978-84-7902-464-2") || isbn.equals("978-84-7902-464-1"));
            final String nombreBiblioteca = actual.getBiblioteca().getNombre();
            assertTrue(nombreBiblioteca.equals("Biblioteca Nacional de Madrid"));
            final int numeroCopiasLibro = actual.getCopiasDeLibro().size();
            assertTrue((numeroCopiasLibro == 2) || (numeroCopiasLibro == 1));
        }
	}

	private Libro creaLibro(String isbn, String titulo, String editorial) {
		Libro libro = new Libro(isbn, titulo, editorial);
		
		return libro;
	}

	private Biblioteca creaBiblioteca(String nombre) {
		Biblioteca b = new Biblioteca(nombre);
		
		return b;
	}
	
	private Copia creaCopia(boolean esPrestado){
		Copia copia = new Copia(esPrestado);
		return copia;
	}
	
	private void anadeCopiaLibro(Libro libro, Copia copia) {
		libro.addCopiaDeLibro(copia);
	}
	
	public void inicializarDatosTest(){
		Biblioteca bm = creaBiblioteca("Biblioteca Nacional de Madrid");
		
		Libro l1 = creaLibro("978-84-7902-464-2","Iniciarse en Triatlón","Tutor");
		Libro l2 = creaLibro("978-84-7902-464-1","El Quijote","Anaya");
		
		Copia c11 = creaCopia(false);
		Copia c12 = creaCopia(false);
		Copia c21 = creaCopia(false);
		
		// añadimos copias del libro 1
		anadeCopiaLibro(l1,c11);
		anadeCopiaLibro(l1,c12);
		anadeCopiaLibro(l2,c21);
		
		// lo insertamos en la BD
		em.getTransaction().begin();
		em.persist(bm);
		em.persist(c11);
		em.persist(c12);
		em.persist(c21);
		l1.setBiblioteca(bm);
		l2.setBiblioteca(bm);
		em.persist(l1);
		em.persist(l2);
		em.getTransaction().commit();
	}
}
