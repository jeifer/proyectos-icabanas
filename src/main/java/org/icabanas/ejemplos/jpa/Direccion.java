package org.icabanas.ejemplos.jpa;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.PROPERTY)
public class Direccion {
	private String direccion;
	
	private String localidad;
	
	private String poblacion;
	
	private String provincia;
	
	private String codigoPostal;

	public Direccion() {
	}

	public Direccion(String direccion, String localidad, String poblacion,
			String provincia, String codigoPostal) {
		super();
		this.direccion = direccion;
		this.localidad = localidad;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}

	@Column(name="DIRECCION",length=250,nullable=false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name="LOCALIDAD",length=50,nullable=false)
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Column(name="POBLACION",length=150,nullable=false)
	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	@Column(name="PROVINCIA",length=150,nullable=false)
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Column(name="CODIGO_POSTAL",length=5,nullable=false)
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
	
}
