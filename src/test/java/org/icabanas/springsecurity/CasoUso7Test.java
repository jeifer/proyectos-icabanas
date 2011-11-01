package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Contiene tests de aceptación del requisito 7 para la aplicación.
 *
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 *
 * Por lo geneal, las páginas tendrán una barra de navegación
 * común con links a la home, a la administración y de logout.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso7Test extends BaseTest{    

    @Test
    public void deberianExistirLinksDeNavegacionComunCuandoNavegoALaPaginaDeAdministracion(){        
        // el usuario intenta acceder a un recurso seguro
        driver.get("http://localhost:9080/spring-security/admin.htm");

        // como el usuario no está autenticado, el sistema le redirige a la página de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // el usuario se autentica correctamente
        autenticarUsuarioValido();

        // después de autenticarse el usuario, el sistema le redirige a la página de administración
        assertThat(driver.getTitle(), is("Admin: Spring Security Web Application"));

        // verifico que existen los links
        assertNotNull(driver.findElement(By.linkText("Home")));
        assertNotNull(driver.findElement(By.linkText("Admin")));
        assertNotNull(driver.findElement(By.linkText("Logout")));
    }

    @Test
    public void deberianExistirLinksDeNavegacionComunCuandoNavegoALaPaginaHome(){        
        // el usuario intenta acceder a un recurso seguro
        driver.get("http://localhost:9080/spring-security/home.htm");

        // como el usuario no está autenticado, el sistema le redirige a la página de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // el usuario se autentica correctamente
        autenticarUsuarioValido();

        // después de autenticarse el usuario, el sistema le redirige a la página de administración
        assertThat(driver.getTitle(), is("Home: Spring Security Web Application"));

        // verifico que existen los links
        assertNotNull(driver.findElement(By.linkText("Home")));
        assertNotNull(driver.findElement(By.linkText("Admin")));
        assertNotNull(driver.findElement(By.linkText("Logout")));
    }

}
