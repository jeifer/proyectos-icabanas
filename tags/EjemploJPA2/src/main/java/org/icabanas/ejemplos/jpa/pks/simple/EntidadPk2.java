package org.icabanas.ejemplos.jpa.pks.simple;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que posee una clave primaria que se debe generar automáticamente (autonumérico).
 * 
 * @author pajarokillo
 *
 */
@Entity
@Table(name="ENTIDADPK2")
public class EntidadPk2 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",unique=true)
	private Integer id;
	
	@Basic(optional=false)
	@Column(name="CODIGO")
	private String codigo;

	public EntidadPk2() {		
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
