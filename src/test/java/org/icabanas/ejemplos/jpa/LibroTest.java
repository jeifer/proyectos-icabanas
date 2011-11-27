package org.icabanas.ejemplos.jpa;

import static  org.junit.Assert.assertNotNull;
import static  org.junit.Assert.assertNull;
import static  org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.hibernate.LazyInitializationException;
import org.junit.Test;

public class LibroTest extends BaseTest {

	@Override
	public void inicializarDatosTest() {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void deberiaPersistirLibro(){
		Biblioteca biblioteca = creaBibliotecaPorDefecto();
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(biblioteca);
		em.getTransaction().commit();
		
		Libro libro = creaLibroPorDefecto(biblioteca);
		
		EntityManager em1 = getEntityManager();
		em1.getTransaction().begin();
		em1.persist(libro);
		em1.getTransaction().commit();
		
		assertNotNull(libro.getId());		
	}

	@Test(expected=LazyInitializationException.class)
	public void deberiaLanzarExcepcionAlConsultarPropiedadesBiblioteca(){
		Biblioteca biblioteca = creaBibliotecaPorDefecto();
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(biblioteca);
		em.getTransaction().commit();
		
		Libro libro = creaLibroPorDefecto(biblioteca);
		
		EntityManager em1 = getEntityManager();
		em1.getTransaction().begin();
		em1.persist(libro);
		em1.getTransaction().commit();
		
		EntityManager emConsulta = getEntityManager();
		Libro libroTest = emConsulta.find(Libro.class, libro.getId());
		emConsulta.close();
		libroTest.getBiblioteca().getNombre();
	}
	
	private Libro creaLibroPorDefecto(Biblioteca biblioteca) {
		Libro libro = new Libro();
		
		libro.setTitulo("Harry Potter y la piedra filosofal");
		libro.setIsbn("123456789");
		libro.setBiblioteca(biblioteca);
		
		return libro;
	}

	private Biblioteca creaBibliotecaPorDefecto() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setNombre("Biblioteca Municipal de Madrid");
		
		return biblioteca;
	}

}
