package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Contiene tests de aceptación del requisito 2 para la aplicación.
 * 
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 * 
 * El usuario, una vez autenticado con un username/password válidos,
 * debería ser capaz de ver el recurso seguro solicitado.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso2Test extends BaseTest {    
        
    @Test
    public void deberiaAccederAlRecursoSeguroCuandoElUsuarioSeAutenticaCorrectamente(){
        // accedemos a /home.htm
        driver.get("http://localhost:9080/spring-security/home.htm");
        
        // compruebo que estamos en la página de login de Spring
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
        
        // obtengo los campos username y password del formulario
        final WebElement usernameField = driver.findElement(By.name("j_username"));
        final WebElement passwordField = driver.findElement(By.name("j_password"));
        
        // introduzco valores en los campos
        usernameField.sendKeys("username");
        passwordField.sendKeys("password");
        
        // envio el formulario
        passwordField.submit();
        
        // verifico el test
        assertThat(driver.getTitle(), is("Home: Spring Security Web Application"));
    }
}

