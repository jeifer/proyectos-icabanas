package org.icabanas.blog.testunitariostruts2.dtos;

public class ProductoDto {

	private String nombre;
	private Long id;

	public ProductoDto(String nombre) {
		this.nombre = nombre;
	}

	public ProductoDto(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoDto other = (ProductoDto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
}
