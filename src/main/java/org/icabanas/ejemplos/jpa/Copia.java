package org.icabanas.ejemplos.jpa;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ICG_COPIA")
public class Copia implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID_COPIA")
	private Integer id;
	
	@Column(name="PRESTADO",nullable=false)
	@Basic(optional=false)
	private Boolean esPrestado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Libro libro;

	public Copia() {
	}
	
	public Copia(Boolean esPrestado) {
		super();
		this.esPrestado = esPrestado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEsPrestado() {
		return esPrestado;
	}

	public void setEsPrestado(Boolean esPrestado) {
		this.esPrestado = esPrestado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
		if(!libro.getCopiasDeLibro().contains(this)){
			libro.addCopiaDeLibro(this);
		}
	}
	
	
}
