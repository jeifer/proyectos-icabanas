package org.icabanas.ejemplos.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ICG_DIRECCION")
public class Direccion {
	
	@Id
	@GeneratedValue
	@Column(name="ID_DIRECCION")
	private Long id;
	
	@Column(name="DIRECCION",length=250,nullable=false)
	private String direccionVivienda;
	
	@Column(name="LOCALIDAD",length=50,nullable=false)
	private String localidad;
	
	@Column(name="PROVINCIA",length=150,nullable=false)
	private String provincia;
	
	@Column(name="CODIGO_POSTAL",length=5,nullable=false)
	private String codigoPostal;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="direccion")
	private Lector lector;
	
	public Direccion() {
	}

	public Direccion(String direccion, String localidad,
			String provincia, String codigoPostal) {
		super();
		this.direccionVivienda = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return direccionVivienda;
	}

	public void setDireccion(String direccion) {
		this.direccionVivienda = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}
	
	
}
