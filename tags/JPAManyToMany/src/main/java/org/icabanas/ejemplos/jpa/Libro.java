package org.icabanas.ejemplos.jpa;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ICG_LIBRO")
public class Libro implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID_LIBRO")
	private Long id;
	
	@Basic(optional=false)
	@Column(name="ISBN",length=25,nullable=false)
	private String isbn;
	
	@Basic(optional=false)
	@Column(name="TITULO",length=250,nullable=false)
	private String titulo;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="ID_BIBLIOTECA")
	private Biblioteca biblioteca;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	
}
