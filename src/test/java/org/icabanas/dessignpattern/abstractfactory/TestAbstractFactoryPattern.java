package org.icabanas.dessignpattern.abstractfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestAbstractFactoryPattern {

	@Test
	public void deberiaSerUnBotonLinux(){
		Client cliente = new Client(creaGUILinux());
		assertEquals("Soy un botón de Linux.", cliente.paint());
	}

	private GUIFactory creaGUILinux() {
		return new LinuxFactory();
	}
}
