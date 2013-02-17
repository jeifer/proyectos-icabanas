package org.icabanas.ejemplos.displaytag.web.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.icabanas.ejemplos.displaytag.modelo.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class EjemploCatalogoProductosAction {

	public String ejemplo1(){
		return _ejemplo();
	}
	
	public String ejemplo2(){
		return _ejemplo();
	}
	
	public String ordenacion(){
		return _ejemplo();
	}

	public String paginacion(){ 
		return _ejemplo(); 
	}
	
	public String links(){ 
        return _ejemplo(); 
	}
	
	private String _ejemplo() {
		List<Producto> productos = getProductos();
		
		ServletActionContext.getRequest().setAttribute("productos", productos);
		
		return ActionSupport.SUCCESS;
	}

	private List<Producto> getProductos() {
		List<Producto> resultado = new ArrayList<Producto>();
		
		 resultado.add(new Producto("1","producto1","descripcion1","http://www.google.es")); 
         resultado.add(new Producto("2","producto2","descripcion2","http://www.google.es")); 
         resultado.add(new Producto("3","producto3","descripcion3","http://www.google.es")); 
         resultado.add(new Producto("4","producto4","descripcion4","http://www.google.es")); 
         resultado.add(new Producto("5","producto5","descripcion5","http://www.google.es")); 
         resultado.add(new Producto("6","producto6","descripcion6","http://www.google.es")); 
         resultado.add(new Producto("7","producto7","descripcion7","http://www.google.es")); 
         
		return resultado;
	}
}
