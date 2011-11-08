package org.icabanas.ejemplos.jpa.pks.compuesta;

import java.io.Serializable;

public class ProyectoPK implements Serializable {

	private Integer idProyecto;
	
	private Integer idDepartamento;

	public ProyectoPK() {
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
}
