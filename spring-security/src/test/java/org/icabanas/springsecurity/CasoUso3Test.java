package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Contiene tests de aceptación del requisito 3 para la aplicación.
 * 
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 * 
 * Cuando al usuario se le muestre la página de Login, 
 * ésta debería ser una página de la aplicación personalizada.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso3Test extends BaseTest{
                
        
    @Test
    public void deberiaUsarUnaPaginaDeLoginPersonalizadaCuandoElUsuarioQuieraAutenticarse(){
            // accedemos a /home.htm
            driver.get("http://localhost:9080/spring-security/home.htm");
            
            // verifico el test
            assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
    }
}

