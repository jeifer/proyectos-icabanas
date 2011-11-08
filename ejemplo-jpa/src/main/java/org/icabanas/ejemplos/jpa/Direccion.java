package org.icabanas.ejemplos.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Direccion implements Serializable{

	@Column(name="DIRECCION",length=250)
	private String direccion;
	
	@Column(name="CODIGO_POSTAL",length=5)
	private String codigoPostal;
	
	@Column(name="POBLACION",length=250)
	private String poblacion;
	
	@Column(name="PROVINCIA",length=25)
	private String provincia;

	public Direccion() {
	}

	public Direccion(String direccion, String codigoPostal, String poblacion,
			String provincia) {
		super();
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.provincia = provincia;
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
