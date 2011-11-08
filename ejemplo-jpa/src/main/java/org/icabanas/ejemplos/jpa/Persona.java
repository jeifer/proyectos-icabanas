package org.icabanas.ejemplos.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PERSONA")
public class Persona implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID", nullable=false, unique=true)
	private Integer id;
	
	@Column(name="NOMBRE",length=25,nullable=false)
	@Basic(optional=false)
	private String nombre;
	
	@Column(name="APELLIDOS",length=50,nullable=false)
	@Basic(optional=false)
	private String apellidos;
	
	@Column(name="FECHA_NACIMIENTO",nullable=false)
	@Basic(optional=false)
	private Date fechaNacimiento;
	
	@Transient
	private int edad;
	
	@Embedded
	@Basic(optional=true)
	private Direccion direccion;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENERO")
	@Basic(optional=false)
	private Genero genero;
	
	public Persona(){}

	public Persona(String nombre, String apellidos, Date fechaNacimiento, Direccion direccion, Genero genero) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.genero = genero;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	
	
	
}
