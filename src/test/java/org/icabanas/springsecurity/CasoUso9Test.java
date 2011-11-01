package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CasoUso9Test extends BaseTest {
	
	@Test
    public void deberiaPermitirUnaSolaSesionConcurrentePorUsuario() throws Exception {

        driver.get("http://localhost:9080/spring-security/login.jsp");

        // nos logamos sobre la página de login
        autenticarUsuario("test", "test");

        // cerramos la sesión del navegador
        driver.close();

        driver = getDriver();
        // nos logamos otra vez
        driver.get("http://localhost:9080/spring-security/login.jsp");

        // nos logamos sobre la página de login
        autenticarUsuario("test", "test");

        assertThat(driver.getTitle(),
                is("Login: Spring Security Web Application"));

        final WebElement informationMessageSection = driver.findElement(By
                .id("infomessage"));
        assertThat(
                informationMessageSection.getText(),
                containsString("Login fallido debido a: Maximum sessions of 1 for this principal exceeded."));
	}
}

