package org.icabanas.blog.testunitariostruts2;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.icabanas.blog.testunitariostruts2.actions.ProductoAction;
import org.icabanas.blog.testunitariostruts2.dtos.ProductoDto;
import org.icabanas.blog.testunitariostruts2.exceptions.RegistrarProductoException;
import org.icabanas.blog.testunitariostruts2.services.ProductoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * Test unitario
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductoActionTest extends BaseStrutsTestCase{

	private static final String ACTION = "guardar";
	private static final String NAMESPACE = "/catalogos/producto";
	
	@Mock
	ProductoService _mockProductoService;
	
	private ProductoDto producto;
	
	private ProductoAction action;
	
	@Before
	public void prepara_test() throws Exception{
		action = createAction(ProductoAction.class, NAMESPACE, ACTION);
		producto = new ProductoDto("Leche");
		action.setProducto(producto);		
		action.setProductoService(_mockProductoService);						
	}
	
	@Test
	public void deberia_devolver_success_si_guarda_un_producto_correcto() throws RegistrarProductoException{
		// preparación
		try {
			when(_mockProductoService.validar(producto)).thenReturn(true);
			when(_mockProductoService.guardar(producto)).thenReturn(new ProductoDto(1L,"Leche"));
		} catch (RegistrarProductoException e) {
			fail("No debe fallar el test.");
		}				
		
		// ejecución
		String resultado = action.guardar();
		
		// verificación
		verify(_mockProductoService, VerificationModeFactory.times(1)).validar(producto);
		verify(_mockProductoService, VerificationModeFactory.times(1)).guardar(producto);
		assertThat(resultado, equalTo("success"));		
	}
	
	@Test
	public void deberia_devolver_input_si_no_se_valida_el_producto() throws RegistrarProductoException{
		// preparación
		when(_mockProductoService.validar(producto)).thenReturn(Boolean.FALSE);
				
		// ejecución
		String resultado = action.guardar();
		
		// verificación
		assertThat(resultado, equalTo("input"));
		verify(_mockProductoService, VerificationModeFactory.times(1)).validar(producto);
		verify(_mockProductoService, VerificationModeFactory.times(0)).guardar(producto);
	}
	
	@Test
	public void deberia_devolver_error_si_se_produce_error_al_guardar_un_producto() throws RegistrarProductoException{
		// preparación
		when(_mockProductoService.validar(producto)).thenReturn(Boolean.TRUE);
		when(_mockProductoService.guardar(producto)).thenThrow(new RegistrarProductoException());
		
		// ejecución
		String resultado = action.guardar();
		
		// verificación
		assertThat(resultado, equalTo("error"));
		verify(_mockProductoService, VerificationModeFactory.times(1)).validar(producto);
		verify(_mockProductoService, VerificationModeFactory.times(1)).guardar(producto);
	}
}
