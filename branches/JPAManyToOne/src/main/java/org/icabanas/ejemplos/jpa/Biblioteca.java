package org.icabanas.ejemplos.jpa;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ICG_BIBLIOTECA")
public class Biblioteca implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID_BIBLIOTECA")
	private Long id;
	
	@Basic(optional=false)
	@Column(name="NOMBRE",length=50,nullable=false)
	private String nombre;

	public Biblioteca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
