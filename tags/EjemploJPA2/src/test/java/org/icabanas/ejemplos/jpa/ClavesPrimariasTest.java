package org.icabanas.ejemplos.jpa;

import static org.junit.Assert.assertEquals;

import javax.persistence.PersistenceException;

import org.icabanas.ejemplos.jpa.pks.simple.EntidadPk1;
import org.icabanas.ejemplos.jpa.pks.simple.EntidadPk2;
import org.icabanas.ejemplos.jpa.pks.simple.EntidadPk3;
import org.junit.Assert;
import org.junit.Test;

public class ClavesPrimariasTest extends BaseTest{

	@Test(expected=PersistenceException.class)
	public void deberiaLanzarPersistenceExceptionAlCrearUnaEntidadTipo1SiNoProporcionoUnaPkALaEntidad(){
		EntidadPk1 e1 = creaEntidadPk1();
		
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
	}

	
	@Test
	public void deberiaCrearUnaEntidadTipo1(){
		EntidadPk1 e1 = creaEntidadPk1();
		
		em.getTransaction().begin();
		e1.setId(Integer.valueOf(1));
		em.persist(e1);
		em.getTransaction().commit();
	}
	
	@Test
	public void deberiaCrearUnaEntidadTipo2(){
		EntidadPk2 e = creaEntidadPk2();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	@Test
	public void deberiaCrearUnaEntidadTipo3(){
		EntidadPk3 e = creaEntidadPk3();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		assertEquals(Integer.valueOf(1), e.getId());
		
		e = creaEntidadPk3();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		assertEquals(Integer.valueOf(2), e.getId());
	}
	
	private EntidadPk3 creaEntidadPk3() {
		EntidadPk3 e = new EntidadPk3();
		e.setCodigo("codigo");
		return e;
	}


	private EntidadPk2 creaEntidadPk2() {
		EntidadPk2 e = new EntidadPk2();
		e.setCodigo("codigo");
		return e;
	}


	private EntidadPk1 creaEntidadPk1() {
		EntidadPk1 e = new EntidadPk1();
		e.setCodigo("codigo");
		return e;
	}
}
