package org.icabanas.springsecurity.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverParaFireFoxFactory implements AbstractWebDriverFactory {

	@Override
	public WebDriver crearWebDriver() {
		return new FirefoxDriver();
	}

}
