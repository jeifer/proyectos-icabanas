package org.icabanas.ejemplos.jpa;

import static  org.junit.Assert.assertNotNull;
import static  org.junit.Assert.assertNull;
import static  org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class LectorTest extends BaseTest {

	@Test
	public void testQueCompruebaPersistenceXmlEsCorrecto(){
	}
	
	@Test
	public void deberiaCrearUnLector(){
		Lector lector = creaLectorPorDefecto();
		
		assertNull(lector.getId());
		
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		assertNotNull(lector.getId());
	}

	@Test
	public void deberiaRecuperarUnLectorPorClavePrimaria(){
		Lector lector = creaLectorPorDefecto();
		
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		Lector lectorTest = emConsultas.find(Lector.class, lector.getId());
		assertEquals(lector.getId(), lectorTest.getId());
	}

	@Test
	public void deberiaModificarUnLector(){
		Lector lector = creaLectorPorDefecto();
		
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		lector.getDatosPersonales().setNombre("Antonio");
		em.merge(lector);
		em.getTransaction().commit();
		
		Lector lectorTest = emConsultas.find(Lector.class, lector.getId());
		assertTrue(lector.getDatosPersonales().getNombre().equals(lectorTest.getDatosPersonales().getNombre()));
	}
	
	@Test
	public void deberiaEliminarUnLector(){
		Lector lector = creaLectorPorDefecto();
		
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		final Long idLector = lector.getId();
		
		em.getTransaction().begin();
		em.remove(lector);
		em.getTransaction().commit();
		
		Lector lectorTest = emConsultas.find(Lector.class, idLector);
		assertNull(lectorTest);
	}
	
	@Override
	public void inicializarDatosTest() {
		// TODO Auto-generated method stub
		
	}
	
	private Lector creaLectorPorDefecto() {
		Lector lector = new Lector("Ismael", "Cabañas García", "51942403P", "696980357", new Date(), Genero.HOMBRE);
		return lector;
	}
}
