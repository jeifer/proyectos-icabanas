package org.icabanas.ejemplos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class BaseTest {
	protected EntityManagerFactory emf;
	
	// EntityManager que se encarga de crear los registros necesarios para la ejecución del test
	protected EntityManager em;
	
	// EntityManager que se encarga de realizar consultas
	protected EntityManager emConsultas;
	
	@Before
	public void antesDeCadaTest(){
		emf = Persistence.createEntityManagerFactory("ejemploJPAPersistenceUnit");
		em = emf.createEntityManager();
		emConsultas = emf.createEntityManager();
	}
	
	@After
	public void despuesDeCadaTest(){
		emConsultas.close();
		em.close();
		emf.close();
	}

	public abstract void inicializarDatosTest();
}
