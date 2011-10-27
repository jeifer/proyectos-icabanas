package org.icabanas.dessignpattern.abstractfactory;

public class Client {
	
	private GUIFactory guiFactory;
	
	public Client(GUIFactory guiFactory){
		this.guiFactory = guiFactory;
	}
	
	public String paint(){
		Button button = guiFactory.createButton();
		return button.paint();
	}
}
