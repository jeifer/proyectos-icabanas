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
	public void deberiaInsertarPersonaConDireccionYRecuperarLaPersonaConSuDireccion(){
		// inicializamos los datos del test
		inicializarDatosTest();
		
		// recuperamos el objeto
		final List<Persona> list = emConsultas.createQuery("select p from Persona p").getResultList();
 
        assertEquals(2, list.size());
        for (Persona actual : list) {
            final String nombre = actual.getNombre();
            assertTrue(nombre.equals("Ismael") || nombre.equals("Beatríz"));
            final String calle = actual.getDireccion().getDireccion();
            assertTrue(calle.equals("C/Antonio Van de Pere, 81, 2ºA"));
        }
		
	}

	@Override
	public void inicializarDatosTest() {
		// Creamos el objeto Persona
		Date fechaNacimiento = new Date();
		Direccion direccionA = creaDireccion("C/Antonio Van de Pere, 81, 2ºA", "28342", "Madrid", "Valdemoro", "Madrid");
		Direccion direccionB = creaDireccion("C/Antonio Van de Pere, 81, 2ºA", "28342", "Madrid", "Valdemoro", "Madrid");
		Persona personaA = creaPersona("Ismael", "Cabañas García", fechaNacimiento, Genero.HOMBRE);
		Persona personaB = creaPersona("Beatríz", "Bernardino Nuño", fechaNacimiento, Genero.MUJER);
			
		// lo insertamos en la BD
		em.getTransaction().begin();
		em.persist(direccionA);
		em.persist(direccionB);
		personaA.setDireccion(direccionA);
		personaB.setDireccion(direccionB);
		em.persist(personaA);
		em.persist(personaB);
		em.getTransaction().commit();
	}

	private Persona creaPersona(String nombre, String apellidos, Date fechaNacimiento,Genero genero) {		
		Persona per = new Persona(nombre, apellidos, fechaNacimiento, genero);
		return per;
	}
	
	private Direccion creaDireccion(String direccion, String codigoPostal, String poblacion, String localidad, String provincia){
		Direccion dir = new Direccion(direccion, localidad, poblacion, provincia, codigoPostal);
		return dir;
	}
}
