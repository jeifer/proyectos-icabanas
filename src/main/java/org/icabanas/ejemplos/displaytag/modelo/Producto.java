package org.icabanas.ejemplos.displaytag.modelo;

public class Producto { 

    private String codigo; 
    
    private String nombre; 
    
    private String descripcion; 
    
    private String url; 

    public Producto(String codigo, String nombre, String descripcion, String url) { 
            this.codigo = codigo; 
            this.nombre = nombre; 
            this.descripcion = descripcion; 
            this.url = url; 
    } 

    public String getCodigo() { 
            return codigo; 
    } 

    public void setCodigo(String codigo) { 
            this.codigo = codigo; 
    } 

    public String getNombre() { 
            return nombre; 
    } 

    public void setNombre(String nombre) { 
            this.nombre = nombre; 
    } 

    public String getDescripcion() { 
            return descripcion; 
    } 

    public void setDescripcion(String descripcion) { 
            this.descripcion = descripcion; 
    } 

    public String getUrl() { 
            return url; 
    } 

    public void setUrl(String url) { 
            this.url = url; 
    } 
    
    
} 
