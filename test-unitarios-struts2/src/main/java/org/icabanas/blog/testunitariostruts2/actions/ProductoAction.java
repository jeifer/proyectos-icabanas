package org.icabanas.blog.testunitariostruts2.actions;

import org.icabanas.blog.testunitariostruts2.dtos.ProductoDto;
import org.icabanas.blog.testunitariostruts2.exceptions.RegistrarProductoException;
import org.icabanas.blog.testunitariostruts2.services.ProductoService;

public class ProductoAction {

	private static final String ERROR = "error";
	private static final String SUCCES = "success";
	private static final String INPUT = "input";
	
	private ProductoDto producto;
	private ProductoService productoService;

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public String guardar() {
		try{
			if(productoService.validar(producto)){
				productoService.guardar(producto);
			}
			else{
				return INPUT;
			}
		}
		catch(RegistrarProductoException e){
			return ERROR;
		}
		return SUCCES;
	}

}
