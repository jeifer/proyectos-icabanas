package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Contiene tests de aceptación del requisito 6 para la aplicación.
 *
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 *
 * Cuando un usuario intenta acceder a un recurso seguro y no está aunteticado,
 * cuando éste se valide correctamente será redirigido automáticamente al recurso que solicitó.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso6Test extends BaseTest{    

    @Test
    public void deberiaRedirigirALaPaginaQueUsuarioIntentoAccederDespuesDeAutenticarse(){        
        // el usuario intenta acceder a un recurso seguro
        driver.get("http://localhost:9080/spring-security/admin.htm");

        // como el usuario no está autenticado, el sistema le redirige a la página de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // el usuario se autentica correctamente
        autenticarUsuarioValido();

        // verifico que no estamos en la página home
        assertThat(driver.getTitle(), is(not("Home: Spring Security Web Application")));

        // verifico que estamos en la página que usuario quiso acceder
        assertThat(driver.getTitle(), is("Admin: Spring Security Web Application"));        
    }

}
