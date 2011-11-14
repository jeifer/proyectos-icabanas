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
	private Integer id;
	
	@Column(name="NOMBRE",length=250,nullable=false)
	@Basic(optional=false)
	private String nombre;

	public Biblioteca() {
	}

	public Biblioteca(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
