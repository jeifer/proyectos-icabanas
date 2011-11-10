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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="ICG_PERSONA")
public class Persona implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="NOMBRE",length=25,nullable=false)
	private String nombre;
	
	@Column(name="APELLIDOS",length=100,nullable=true)
	private String apellidos;
	
	@Column(name="FECHA_NACIMIENTO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Embedded
	private Direccion direccion;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Transient
	private int edad;
	
	@Basic(fetch=FetchType.LAZY,optional=true)
	@Column(name="FOTOGRAFIA")
	@Lob
	private byte[] foto;
	
	public Persona(){}

	public Persona(String nombre, String apellidos, Date fechaNacimiento,
			Direccion direccion, Genero genero) {
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	
	
}