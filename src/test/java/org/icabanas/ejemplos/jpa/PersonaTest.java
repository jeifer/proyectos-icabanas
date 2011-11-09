package org.icabanas.ejemplos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

public class PersonaTest extends BaseTest {

	@Test
	public void testQueCompruebaPersistenceXmlEsCorrecto(){
	}
	
	@Test
	public void deberiaInsertarRecuperarPersona(){
		// Creamos el objeto Persona
		Persona personaA = creaPersona("Ismael", "Cabañas García", new Date(), "C/Antonio Van de Pere, 81, 2ºA", "28342", "Madrid", "Valdemoro", "Madrid");
		Persona personaB = creaPersona("Beatríz", "Bernardino Nuño", new Date(), "C/Antonio Van de Pere, 81, 2ºA", "28342", "Madrid", "Valdemoro", "Madrid");
		
		assertEquals(null,personaA.getId());
		assertEquals(null,personaB.getId());
		
		// lo insertamos en la BD
		em.getTransaction().begin();
		em.persist(personaA);
		em.persist(personaB);
		em.getTransaction().commit();
		assertNotNull(personaA.getId());
		
		// recuperamos el objeto
		final List<Persona> list = em.createQuery("select p from Persona p").getResultList();
 
        assertEquals(2, list.size());
        for (Persona actual : list) {
            final String nombre = actual.getNombre();
            assertTrue(nombre.equals("Ismael") || nombre.equals("Beatríz"));
        }
		
	}
	

	private Persona creaPersona(String nombre, String apellidos, Date fechaNacimiento,
			String direccion, String codigoPostal, String poblacion, String localidad, String provincia) {
		
		return new Persona(nombre,apellidos,fechaNacimiento,direccion,localidad,poblacion,provincia,codigoPostal);
	}
}
