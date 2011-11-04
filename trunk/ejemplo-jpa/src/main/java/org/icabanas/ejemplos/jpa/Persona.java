package org.icabanas.ejemplos.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String nombre;
	
	@Column(name="APELLIDOS",length=50,nullable=false)
	private String apellidos;
	
	@Column(name="FECHA_NACIMIENTO",nullable=false)
	private Date fechaNacimiento;
	
	@Transient
	private int edad;
	
	@Column(name="DIRECCION",length=250)
	private String direccion;
	
	@Column(name="CODIGO_POSTAL",length=5)
	private String codigoPostal;
	
	@Column(name="POBLACION",length=250)
	private String poblacion;
	
	@Column(name="PROVINCIA",length=25)
	private String provincia;
	
	public Persona(){}

	public Persona(String nombre, String apellidos, Date fechaNacimiento,
			String direccion, String codigoPostal, String poblacion,
			String provincia) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.provincia = provincia;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
}
