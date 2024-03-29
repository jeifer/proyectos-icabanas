package org.icabanas.ejemplos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class BaseTest {
	protected EntityManagerFactory emf;
	
	// EntityManager que se encarga de crear los registros necesarios para la ejecución del test
	private List<EntityManager> ems;	
	
	@Before
	public void antesDeCadaTest(){
		emf = Persistence.createEntityManagerFactory("ejemploJPAPersistenceUnit");	
		ems = new ArrayList<EntityManager>();
	}
	
	@After
	public void despuesDeCadaTest(){
		cerrarEntitiesManager();
		emf.close();
	}

	private void cerrarEntitiesManager() {
		for (EntityManager em : ems) {
			if(em.isOpen())
				em.close();
		}
		
	}

	protected EntityManager getEntityManager(){
		EntityManager em = emf.createEntityManager();
		ems.add(em);
		return em;
	}
	
	public abstract void inicializarDatosTest();
}
