package org.icabanas.springsecurity;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.icabanas.springsecurity.selenium.NavigatorEnum;
import org.icabanas.springsecurity.selenium.WebDriverCliente;
import org.icabanas.springsecurity.selenium.WebDriverParaFireFoxFactory;
import org.icabanas.springsecurity.selenium.WebDriverParaIEFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Clase que contiene mï¿½todos de utilidad para la ejecuciï¿½n de tests.
 * 
 * @author icabanas.ext
 *
 */
public abstract class BaseTest {

	protected WebDriver driver = null;
	
	@Before
	public void antesDeCadaTest(){
		driver = getDriver();
	}
	
	/**
	 * Método que devuelve la propiedad <code>property</code> del fichero de propiedades test.properties
	 * @param string
	 * @return
	 */
	private String getProperty(String property) {
		String valueProperty = null;
		Properties props = new Properties();
		URL url = ClassLoader.getSystemResource("test.properties");
		try{
			props.load(url.openStream());
			valueProperty = props.getProperty(property);
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		return valueProperty;
	}

	@After
	public void despuesDeCadaTest(){
		// cierra el navegador firefox que se abriï¿½ despuï¿½s de cada test.
		driver.close();
	}
	
	/**
	 * 
	 */
	protected void autenticarUsuarioValido() {
		driver.get("http://localhost:9080/spring-security/login.jsp");
		
		// compruebo que estamos en la pï¿½gina de login de Spring
		assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
		
		autenticarUsuario("username", "password");
	}
	
	protected void autenticarUsuarioConPasswordIncorrecta() {
		driver.get("http://localhost:9080/spring-security/login.jsp");
		
		// compruebo que estamos en la pï¿½gina de login de Spring
		assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
		
		autenticarUsuario("username", "passwordErronea");
	}
	
	protected void autenticarUsuarioConUsuarioIncorrecto() {
		driver.get("http://localhost:9080/spring-security/login.jsp");
		
		// compruebo que estamos en la pï¿½gina de login de Spring
		assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
		
		autenticarUsuario("usernameIncorrecto", "password");
	}
	
	/**
	 * @param usuario
	 * @param password
	 */
	protected void autenticarUsuario(String usuario,String password){
		if(driver != null){
			// obtengo los campos username y password del formulario
			final WebElement usernameField = driver.findElement(By.name("j_username"));
			final WebElement passwordField = driver.findElement(By.name("j_password"));
			
			// introduzco valores en los campos
			usernameField.sendKeys(usuario);
			passwordField.sendKeys(password);
			
			// envio el formulario
			passwordField.submit();
		}
	}
	
	protected WebDriver getDriver(){
		WebDriver driver = null;
		NavigatorEnum testNavigator = NavigatorEnum.getEnumByCodigo(getProperty("test.navigator"));
		switch (testNavigator) {
		case INTERNET_EXPLORER:
			driver = WebDriverCliente.obtenerWebDriver(new WebDriverParaIEFactory());
			break;
		case FIREFOX:
			driver = WebDriverCliente.obtenerWebDriver(new WebDriverParaFireFoxFactory());
		default:
			break;
		}
		return driver;
	}
}
