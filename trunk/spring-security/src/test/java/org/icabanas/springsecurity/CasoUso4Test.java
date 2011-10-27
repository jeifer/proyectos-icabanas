package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Contiene tests de aceptación del requisito 4 para la aplicación.
 * 
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 * 
 * Los usuarios autenticados que acceder a la url raíz 
 * deberían ser dirigidos a la página home
 *
 * @author icabanas.ext
 *
 */
public class CasoUso4Test extends BaseTest{
        
        
    @Test
    public void deberiaAccederALaPaginaHomeSiElUsuarioEstaAutenticadoEIntentaAccederALaRaizDeLaAplicacion(){
            
            // autenticamos al usuario
            autenticarUsuarioValido();
            
            // accedemos a la raíz
            driver.get("http://localhost:9080/spring-security");
            
            // verifico el test
            assertThat(driver.getTitle(), is("Home: Spring Security Web Application"));
    }

    @Test
    public void deberiaIrAlLoginSiUsuarioIntentaAccederALaRaizYNoEstaAutenticado(){
            // accedemos a la raíz
            driver.get("http://localhost:9080/spring-security");
            
            // verifico el test
            assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
    }
                
}

