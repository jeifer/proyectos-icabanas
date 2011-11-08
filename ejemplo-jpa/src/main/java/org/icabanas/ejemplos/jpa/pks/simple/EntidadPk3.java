package org.icabanas.ejemplos.jpa.pks.simple;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Entidad cuya clave primaria vendrá dada por una secuencia de la base de datos
 * @author pajarokillo
 *
 */
@Entity
@Table(name="ENTIDADPK3")
@SequenceGenerator(sequenceName="ENTIDAD_SEQ",name="ENTIDAD_SEQ_GEN",initialValue=1)
public class EntidadPk3 {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ENTIDAD_SEQ_GEN")
	@Column(name="ID",unique=true)
	private Integer id;
	
	@Basic(optional=false)
	@Column(name="CODIGO")
	private String codigo;

	public EntidadPk3() {		
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
