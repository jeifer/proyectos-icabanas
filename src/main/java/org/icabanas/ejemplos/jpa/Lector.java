package org.icabanas.ejemplos.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ICG_LECTOR")
public class Lector implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID_LECTOR")
	private Long id;
	
	@Embedded
	private DatosPersonales datosPersonales;
	
	@Basic(fetch=FetchType.LAZY,optional=true)
	@Column(name="FOTOGRAFIA")
	@Lob
	private byte[] fotografia;
	
	@OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true,optional=true)
	private Direccion direccion;
	
	public Lector(){}

	public Lector(String nombre, String apellidos, String nif, String telefono, Date fechaNacimiento, Genero genero) {
		super();
		this.datosPersonales = new DatosPersonales(nombre, apellidos, nif, telefono, fechaNacimiento, genero);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}