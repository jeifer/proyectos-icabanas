package org.icabanas.dessignpattern.abstractfactory;

public class LinuxFactory implements GUIFactory {

	public Button createButton() {
		return new LinuxButton();
	}

}
