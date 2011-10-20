package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Contiene tests de aceptación para la aplicación.
 * 
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 * 
 *  Todo usuario que no esté autenticado y que quiera acceder a una zona segura 
 *	deberá autenticarse a través de un formulario de login.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso1Test extends BaseTest{
		
	@Test
	public void deberiaIrALaPaginaDeLoginDeSpringSiElUsuarioIntentaIrAUnRecursoSeguroYNoEstaAutenticado(){
		driver.get("http://localhost:9080/spring-security/home.htm");

        assertThat(driver.getTitle(),
                is(not("Home: Spring Security Web Application")));
        assertThat(driver.getTitle(),
        		is("Login: Spring Security Web Application"));
	}
}
