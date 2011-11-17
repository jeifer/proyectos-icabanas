package org.icabanas.ejemplos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;

public class DireccionTest extends BaseTest {

	@Test
	public void deberiaPersistirDireccionAsociandoleUnLectorExistente(){
		Lector lector = creaLectorPorDefecto();
		Direccion direccion = creaDireccionPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(lector);
		em.getTransaction().commit();
		
		EntityManager em2 = getEntityManager();
		em2.getTransaction().begin();
		Lector lectorPersistido = em2.find(Lector.class, lector.getId());
		direccion.setLector(lectorPersistido);
		em2.persist(direccion);
		em2.getTransaction().commit();

		Long idDireccion = direccion.getId();
		
		assertNotNull(idDireccion);
	}
	
	/**
	 * Para este test, es necesario tener la relación establecida en el propietario, es decir, la entidad 
	 * propieteria en esta relación es Lector y debe tener previamente asociada la dirección, entonces, de 
	 * esta forma podemos consultar desde la entidad Direccion qué Lector tiene asociado.
	 */
	@Test
	public void deberiaConsultarElNombreDelLectorParaUnaDireccionDeterminadaSiEstamosEnLaTransaccionDebidoAlLazy(){
		Lector lector = creaLectorPorDefecto();
		Direccion direccion = creaDireccionPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		lector.setDireccion(direccion);
		em.persist(lector);
		em.getTransaction().commit();
		
		Long idDireccion = lector.getDireccion().getId();
		
		EntityManager em3 = getEntityManager();
		em3.getTransaction().begin();
		Direccion direccionTest = em3.find(Direccion.class, idDireccion);
		String nombreLector = direccionTest.getLector().getDatosPersonales().getNombre();
		em3.getTransaction().commit();
		
		assertEquals("Ismael", nombreLector);				
	}
	
	@Test
	public void deberiaConsultarElNombreDelLectorParaUnaDireccionDeterminadaSiEstamosFueraDeLaTransaccionDebidoAPesarDelLazy(){
		Lector lector = creaLectorPorDefecto();
		Direccion direccion = creaDireccionPorDefecto();
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		lector.setDireccion(direccion);
		em.persist(lector);
		em.getTransaction().commit();
		
		Long idDireccion = lector.getDireccion().getId();
		
		EntityManager em3 = getEntityManager();
		em3.getTransaction().begin();
		Direccion direccionTest = em3.find(Direccion.class, idDireccion);
		em3.getTransaction().commit();
		
		String nombreLector = direccionTest.getLector().getDatosPersonales().getNombre();	
		assertEquals("Ismael", nombreLector);
	}
	
	@Override
	public void inicializarDatosTest() {
		// TODO Auto-generated method stub

	}

}
