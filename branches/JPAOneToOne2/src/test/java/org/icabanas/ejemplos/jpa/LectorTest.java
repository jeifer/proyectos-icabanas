package org.icabanas.ejemplos.jpa;

import static  org.junit.Assert.assertNotNull;
import static  org.junit.Assert.assertNull;
import static  org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.LazyInitializationException;
import org.junit.Test;

public class LectorTest extends BaseTest {

	@Test
	public void testQueCompruebaPersistenceXmlEsCorrecto(){
	}
	
	@Test
	public void deberiaCrearUnLector(){
		Lector lector = creaLectorPorDefecto();
		
		assertNull(lector.getId());
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		assertNotNull(lector.getId());
	}

	@Test
	public void deberiaRecuperarUnLectorPorClavePrimaria(){
		Lector lector = creaLectorPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		EntityManager emConsultas = getEntityManager();
		Lector lectorTest = emConsultas.find(Lector.class, lector.getId());
		assertEquals(lector.getId(), lectorTest.getId());
	}

	@Test
	public void deberiaModificarUnLector(){
		Lector lector = creaLectorPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		lector.getDatosPersonales().setNombre("Antonio");
		em.merge(lector);
		em.getTransaction().commit();
		
		EntityManager emConsultas = getEntityManager();
		Lector lectorTest = emConsultas.find(Lector.class, lector.getId());
		assertTrue(lector.getDatosPersonales().getNombre().equals(lectorTest.getDatosPersonales().getNombre()));
	}
	
	@Test
	public void deberiaEliminarUnLector(){
		Lector lector = creaLectorPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		final Long idLector = lector.getId();
		
		em.getTransaction().begin();
		em.remove(lector);
		em.getTransaction().commit();
		
		EntityManager emConsultas = getEntityManager();
		Lector lectorTest = emConsultas.find(Lector.class, idLector);
		assertNull(lectorTest);
	}
	
	/**
	 * Test que comprueba cascade=PERSIST
	 */
	@Test
	public void siCreamosUnaInstanciaDeLectorAsociadaNuevaInstanciaDireccionDeberiaPersistirAmbas(){
		Lector lector = creaLectorPorDefecto();
		Direccion direccion = creaDireccionPorDefecto();
		lector.setDireccion(direccion);
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		Long idLector = lector.getId();
		Long idDireccion = lector.getDireccion().getId();
		
		assertNotNull(idLector);
		assertNotNull(idDireccion);
	}
	
	/**
	 * Test que comprueba cascade=PERSIST
	 */
	@Test
	public void siCreamosUnaInstanciaDeLectorAsociadaAInstanciaDireccionExistenteDeberiaPersistirLector(){
		Lector lector = creaLectorPorDefecto();
		Direccion direccion = creaDireccionPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(direccion);
		em.getTransaction().commit();
		
		Long idDireccion = direccion.getId();
		assertNotNull(idDireccion);
		
		EntityManager em2 = getEntityManager();
		Direccion direccion2 = em2.find(Direccion.class, direccion.getId());
		em2.getTransaction().begin();
		lector.setDireccion(direccion2);
		em2.persist(lector);
		em2.getTransaction().commit();
		
		Long idLector = lector.getId();	
		idDireccion = lector.getDireccion().getId();
		assertNotNull(idLector);		
		assertNotNull(idDireccion);
	}
	
	/**
	 * Test que comprueba fetch=LAZY
	 */
	@Test(expected=LazyInitializationException.class)
	public void cuandoRecuperoUnaInstanciaDeLectorSeProcudeErrorAlRecuperarPropiedadDeDireccionSiConexionCerrada(){
		Lector lector = creaLectorPorDefecto();
		Direccion direccion = creaDireccionPorDefecto();
		lector.setDireccion(direccion);
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		EntityManager emConsultas = getEntityManager();
		Lector lectorTest = emConsultas.find(Lector.class, lector.getId());
		emConsultas.close();
		
		String calleDireccion = lectorTest.getDireccion().getDireccion();
	}
	
	/**
	 * Test que comprueba cascade=REMOVE
	 */
	@Test
	public void deberiaEliminarInstanciaDireccionSiEliminoElLectorAsociado(){
		Lector lector = creaLectorPorDefecto();
		Direccion direccion = creaDireccionPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(direccion);
		em.getTransaction().commit();
		
		Long idDireccion = direccion.getId();
		assertNotNull(idDireccion);
		
		EntityManager em2 = getEntityManager();
		Direccion direccion2 = em2.find(Direccion.class, direccion.getId());
		em2.getTransaction().begin();
		lector.setDireccion(direccion2);
		em2.persist(lector);
		em2.getTransaction().commit();
		
		Long idLector = lector.getId();
		
		EntityManager em3 = getEntityManager();
		em3.getTransaction().begin();
		Lector lectorRemove = em3.find(Lector.class, idLector);
		em3.remove(lectorRemove);
		em3.getTransaction().commit();
		
		EntityManager em4 = getEntityManager();
		Lector lectorTest = em4.find(Lector.class, idLector);
		assertNull(lectorTest);
		Direccion direccionTest = em4.find(Direccion.class, idDireccion);
		assertNull(direccionTest);
	}
	
	@Override
	public void inicializarDatosTest() {
		// TODO Auto-generated method stub
		
	}	
}
