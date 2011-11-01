package org.icabanas.springsecurity.selenium;

public enum NavigatorEnum {
	INTERNET_EXPLORER("IE"), FIREFOX("FF"), CHROME("CH");

	private String codigo;
	
	private NavigatorEnum(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
	
	public static NavigatorEnum getEnumByCodigo(String codigo){
		if(codigo.toUpperCase().equals("IE"))
			return INTERNET_EXPLORER;
		else if(codigo.toUpperCase().equals("FF"))
			return FIREFOX;
		else if(codigo.toUpperCase().equals("CH"))
			return CHROME;
		else return INTERNET_EXPLORER;
	}
}
