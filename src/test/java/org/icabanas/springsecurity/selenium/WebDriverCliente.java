package org.icabanas.springsecurity.selenium;

import org.openqa.selenium.WebDriver;

public class WebDriverCliente {
	public static WebDriver obtenerWebDriver(AbstractWebDriverFactory factory){
		return factory.crearWebDriver();
	}
}
