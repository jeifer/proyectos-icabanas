package org.icabanas.ejemplos.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ICG_LIBRO")
public class Libro implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID_LIBRO")
	private Integer id;
	
	@Column(name="ISBN",nullable=false)
	@Basic(optional=false)
	private String isbn;
	
	@Column(name="TITULO",nullable=false,length=250)
	@Basic(optional=false)
	private String titulo;
	
	@Column(name="EDITORIAL",nullable=false,length=250)
	@Basic(optional=false)
	private String editorial;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	private Biblioteca biblioteca;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="libro")
	private List<Copia> copiasDeLibro = new ArrayList<Copia>();

	public Libro() {}

	public Libro(String isbn, String titulo, String editorial) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public List<Copia> getCopiasDeLibro() {
		return copiasDeLibro;
	}

	public void setCopiasDeLibro(List<Copia> copiasDeLibro) {
		this.copiasDeLibro = copiasDeLibro;
	}
	
	public void addCopiaDeLibro(Copia copia){
		this.copiasDeLibro.add(copia);
		if(copia.getLibro() != this)
			copia.setLibro(this);
	}
	
	
}
