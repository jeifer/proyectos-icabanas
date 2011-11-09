package org.icabanas.ejemplos.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Date fechaNacimiento;

	@Column(name="DIRECCION",length=250,nullable=false)
	private String direccion;
	
	@Column(name="LOCALIDAD",length=50,nullable=false)
	private String localidad;
	
	@Column(name="POBLACION",length=150,nullable=false)
	private String poblacion;
	
	@Column(name="PROVINCIA",length=150,nullable=false)
	private String provincia;
	
	@Column(name="CODIGO_POSTAL",length=5,nullable=false)
	private String codigoPostal;
	
	public Persona(){}

	public Persona(String nombre, String apellidos, Date fechaNacimiento,
			String direccion, String localidad, String poblacion,
			String provincia, String codigoPostal) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}	
}