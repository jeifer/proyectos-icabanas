package org.icabanas.ejemplos.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Embeddable
@Access(AccessType.PROPERTY)
public class DatosPersonales implements Serializable {

	private String nombre;

	private String apellidos;

	private String nif;
	
	private String telefono;
	
	private Date fechaNacimiento;
	
	private int edad;
	
	private Genero genero;

	public DatosPersonales() {
	}

	public DatosPersonales(String nombre, String apellidos, String nif,
			String telefono, Date fechaNacimiento, Genero genero) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	@Column(name="NOMBRE",length=25,nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="APELLIDOS",length=100,nullable=true)
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name="NIF",length=9,nullable=false)
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name="TELEFONO",length=9,nullable=true)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="FECHA_NACIMIENTO",nullable=false)
	@Temporal(TemporalType.DATE)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Transient
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="SEXO", nullable=false)
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
