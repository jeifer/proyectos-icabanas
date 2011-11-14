package org.icabanas.ejemplos.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ICG_LECTOR")
public class Lector implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID_LECTOR")
	private Long id;
	
	@Column(name="NOMBRE",length=25,nullable=false)
	private String nombre;

	@Column(name="APELLIDOS",length=100,nullable=true)
	private String apellidos;

	@Column(name="NIF",length=9,nullable=false)
	private String nif;
	
	@Column(name="TELEFONO",length=9,nullable=true)
	private String telefono;
	
	public Lector(){}

	public Lector(String nombre, String apellidos, String nif, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}