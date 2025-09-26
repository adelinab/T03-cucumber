package pe.visorweb.producto.filtrar;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import pe.visorweb.pagina.login.PaginaLogin;
import pe.visorweb.pagina.producto.PaginaMantenimientoProducto;

public class FiltrarProductoStep {

	@Managed
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaMantenimientoProducto paginaMantenimientoProducto;
	
	
	@Before
	public void configurarDriver() {
		paginaLogin = new PaginaLogin(driver);
		paginaMantenimientoProducto = new PaginaMantenimientoProducto(driver);
		
	}
	
	
	@After
	public void cerrarDriver() {
		driver.quit();
	}
	
	@Given("cargo la página visor web")
	public void cargarPaginaVisor() {
		paginaLogin.cargarPagina();
	}
	
	@And("inicio sesión con el usuario {string} y clave {string}") 	
	public void iniciarSesion(String usuario, String clave) {
		paginaLogin.iniciarSesion(usuario, clave);
	}
	
	@When("navego a la página de mantenimiento de producto")
	public void cargarPaginaMantenimientoProducto() {
		paginaMantenimientoProducto.cargarPaginaMntProducto();
	}

	
	@And("ingreso el nombre de producto {string} en el filtro de búsqueda") 	
	public void ingresarNombreProductoAFiltrar(String nombreproducto) {
		paginaMantenimientoProducto.escribirNombreProductoAFiltrar(nombreproducto);
	}

	@And("hago click en el botón filtrar") 	
	public void clickBotonFiltrar() {
		paginaMantenimientoProducto.clickbtnFiltrar();
	}
	
	
	@Then("valido que la tabla de resultados devuelva mínimo un registro") 	
	public void validarNumerodeFilas() {
		assertTrue(paginaMantenimientoProducto.validarNumerodeFilas());
		
	}
	
	
	@Then("el aplicativo muestra el mensaje {string}") 	
	public void validarMensajeRespuesta(String mensaje) {
		Assertions
		.assertThat(paginaMantenimientoProducto.getMensajeNoRegistros())
		.isEqualTo(mensaje);
		
	}
}
