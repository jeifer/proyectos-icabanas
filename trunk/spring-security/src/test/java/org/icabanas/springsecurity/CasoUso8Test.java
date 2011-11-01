package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Contiene tests de aceptación del requisito 8 para la aplicación.
 *
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 *
 * Un usuario puede realizar logout de la parte segura
 * de la aplicación y el sistema debería redirigirle a la página de
 * login y mostrarle un mensaje informativo de que realizó logout
 * correctamente.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso8Test extends BaseTest{    

    @Test
    public void deberiaSerCapazDeRealizarLogoutDeLaAplicacionYVerMensajeQueConfirmeEsto(){        
        // el usuario accede a la home
        driver.get("http://localhost:9080/spring-security/home.htm");

        // como el usuario no está autenticado, el sistema le redirige a la página de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // el usuario se autentica correctamente
        autenticarUsuarioValido();

        // después de autenticarse el usuario, el sistema le redirige a la página que solicitó
        assertThat(driver.getTitle(), is("Home: Spring Security Web Application"));

        // el usuario pincha el enlace de logout
        final WebElement linkLogout = driver.findElement(By.linkText("Logout"));
        linkLogout.click();

        // verifico que el usuario es redirigido a la página de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // verifico que se le presenta al usuario el mensaje informativo
        final WebElement mensajeInformativo = driver.findElement(By.id("infomessage"));
        assertThat(mensajeInformativo.getText(), containsString("Se ha desconectado del sistema correctamente."));
    }    

}