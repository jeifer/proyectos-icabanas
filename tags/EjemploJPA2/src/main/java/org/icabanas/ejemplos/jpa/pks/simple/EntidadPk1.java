package org.icabanas.ejemplos.jpa.pks.simple;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que posee una clave primaria que se debe generar manualmente.
 * 
 * @author pajarokillo
 *
 */
@Entity
@Table(name="ENTIDADPK1")
public class EntidadPk1 {

	@Id
	@Column(name="ID",unique=true)
	private Integer id;
	
	@Basic(optional=false)
	@Column(name="CODIGO")
	private String codigo;

	public EntidadPk1() {		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
