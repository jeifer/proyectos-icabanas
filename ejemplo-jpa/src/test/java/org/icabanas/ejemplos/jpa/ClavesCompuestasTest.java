package org.icabanas.ejemplos.jpa;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.icabanas.ejemplos.jpa.pks.compuesta.Contacto;
import org.icabanas.ejemplos.jpa.pks.compuesta.ContactoPK;
import org.icabanas.ejemplos.jpa.pks.compuesta.Proyecto;
import org.icabanas.ejemplos.jpa.pks.compuesta.ProyectoPK;
import org.junit.Test;

public class ClavesCompuestasTest extends BaseTest {

	@Test
	public void deberiaCrearEntidadClavePrimariaCompuestaEmbebida(){
		Contacto e = crearContacto();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		// recuperamos el objeto
		final List<Contacto> list = em.createQuery("select p from Contacto p").getResultList();
 
        assertEquals(1, list.size());
        for (Contacto actual : list) {
            final String nombre = actual.getContactoPK().getNombre();
            assertEquals("Isma", nombre);
            final Integer posicion = actual.getContactoPK().getPosicion();
            assertEquals(Integer.valueOf(1), posicion);
        }
	}

	@Test
	public void deberiaCrearEntidadClavePrimariaCompuestaNoEmbebida(){
		Proyecto e = crearProyecto();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		// recuperamos el objeto
		final List<Proyecto> list = em.createQuery("select p from Proyecto p").getResultList();
 
        assertEquals(1, list.size());
        for (Proyecto actual : list) {
            final String nombre = actual.getNombre();
            assertEquals("Nombre proyecto", nombre);            
        }
	}
	private Proyecto crearProyecto() {
		ProyectoPK pk = new ProyectoPK();
		pk.setIdDepartamento(Integer.valueOf(1));
		pk.setIdProyecto(Integer.valueOf(1));
		
		Proyecto e = new Proyecto();
		e.setNombre("Nombre proyecto");
		
		return e;
	}

	private Contacto crearContacto() {
		ContactoPK pk = new ContactoPK();
		pk.setNombre("Isma");
		pk.setPosicion(1);
		
		Contacto e = new Contacto();
		e.setContactoPK(pk);
		
		return e;
	}
}
