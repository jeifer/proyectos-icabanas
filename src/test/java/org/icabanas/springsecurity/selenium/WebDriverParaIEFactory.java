package org.icabanas.springsecurity.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverParaIEFactory implements AbstractWebDriverFactory {

	@Override
	public WebDriver crearWebDriver() {
		return new InternetExplorerDriver();
	}

}
