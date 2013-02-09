package org.icabanas.blog.testunitariostruts2.services;

import org.icabanas.blog.testunitariostruts2.dtos.ProductoDto;
import org.icabanas.blog.testunitariostruts2.exceptions.RegistrarProductoException;

public interface ProductoService {

	public ProductoDto guardar(ProductoDto producto) throws RegistrarProductoException;

	public boolean validar(ProductoDto producto);

}
