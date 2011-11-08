package org.icabanas.ejemplos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class BaseTest {
	protected EntityManagerFactory emf;
	
	protected EntityManager em;
	
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
}
