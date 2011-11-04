package org.icabanas.ejemplos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaTest {

	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Before
	public void antesDeCadaTest(){
		emf = Persistence.createEntityManagerFactory("ejemploJPAPersistenceUnit");
		em = emf.createEntityManager();
	}
	
	@After
	public void despuesDeCadaTest(){
		em.close();
		emf.close();
	}
	
	@Test
	public void deberiaInsertarPersonaYRecuperarla(){
		// Creamos el objeto Persona
		Persona personaA = creaPersonaPorDefecto();	
		assertEquals(null,personaA.getId());
		
		// lo insertamos en la BD
		em.getTransaction().begin();
		em.persist(personaA);
		em.getTransaction().commit();
		assertNotNull(personaA.getId());
		
		// recuperamos el objeto
		final List<Persona> list = em.createQuery("select p from Persona p").getResultList();
 
        assertEquals(1, list.size());
        for (Persona actual : list) {
            final String nombre = actual.getNombre();
            assertEquals("Ismael", actual.getNombre());
        }
		
	}
	
	@Test
	public void deberiaActualizarPersonaYRecuperarla(){
		// Creamos el objeto Persona
		Persona personaA = creaPersonaPorDefecto();	
		assertEquals(null,personaA.getId());
		
		// lo insertamos en la BD
		em.getTransaction().begin();
		em.persist(personaA);
		// actualizamos la persona
		personaA.setNombre("Antonio");
		em.persist(personaA);
		em.getTransaction().commit();
		assertNotNull(personaA.getId());
		
		// recuperamos el objeto
		final List<Persona> list = em.createQuery("select p from Persona p").getResultList();
 
        assertEquals(1, list.size());
        for (Persona actual : list) {
            final String nombre = actual.getNombre();
            assertEquals("Antonio", actual.getNombre());
        }
		
	}
	
	@Test
	public void deberiaRecuperarPersona(){
		// Creamos el objeto Persona
		Persona personaA = creaPersonaPorDefecto();	
		assertEquals(null,personaA.getId());
		
		// lo insertamos en la BD
		em.getTransaction().begin();
		em.persist(personaA);
		em.getTransaction().commit();
		assertNotNull(personaA.getId());
		
		// recuperamos el objeto
		Persona persontaTest = em.find(Persona.class, personaA.getId());
		assertEquals(personaA.getNombre(), persontaTest.getNombre());		
	}
	
	@Test
	public void deberiaEliminarPersona(){
		// Creamos el objeto Persona
		Persona personaA = creaPersonaPorDefecto();	
		assertEquals(null,personaA.getId());
		
		// lo insertamos en la BD
		em.getTransaction().begin();
		em.persist(personaA);
		// eliminamos la persona
		em.remove(personaA);
		em.getTransaction().commit();
		assertNotNull(personaA.getId());
		
		// recuperamos el objeto
		final List<Persona> list = em.createQuery("select p from Persona p").getResultList();
 
        assertEquals(0, list.size());		
	}

	
	private Persona creaPersonaPorDefecto(){
		return creaPersona("Ismael", "Cabañas García", new Date(), 
				"C/ Antonio Van de Pere, 81, 2ºA", "28342", "Valdemoro", "Madrid");
	}

	private Persona creaPersona(String nombre, String apellidos, Date fechaNacimiento,
			String direccion, String codigoPostal, String poblacion, String provincia) {
		return new Persona(nombre,apellidos,fechaNacimiento,direccion,codigoPostal,poblacion,provincia);
	}
}
