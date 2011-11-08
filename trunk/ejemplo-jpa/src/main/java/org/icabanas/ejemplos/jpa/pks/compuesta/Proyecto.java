package org.icabanas.ejemplos.jpa.pks.compuesta;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="PROYECTO")
@IdClass(ProyectoPK.class)
public class Proyecto implements Serializable {

	@Id
	private Integer idProyecto;
	
	@Id
	private Integer idDepartamento;
	
	private String nombre;

	public Proyecto() {
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
