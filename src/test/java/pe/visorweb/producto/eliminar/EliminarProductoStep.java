package pe.visorweb.producto.eliminar;

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
import pe.visorweb.pagina.producto.PaginaActualizarProducto;
import pe.visorweb.pagina.producto.PaginaMantenimientoProducto;

public class EliminarProductoStep {

	@Managed
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaActualizarProducto paginaActualizarProducto;
	PaginaMantenimientoProducto paginaMantenimientoProducto;
	
	
	@Before
	public void configurarDriver() {
		paginaLogin = new PaginaLogin(driver);
		paginaActualizarProducto = new PaginaActualizarProducto(driver);
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


	@And("hago click en el botón filtrar") 	
	public void clickBotonFiltrar() {
		paginaMantenimientoProducto.clickbtnFiltrar();
	}
	
	@And("selecciono el producto que quiero editar de la tabla de resultados") 	
	public void seleccionarProductoDeTablaDeResultados() {
		paginaMantenimientoProducto.seleccionarProducto();
	}
	
	@And("hago click en el botón eliminar") 	
	public void clickBotonEditar() {
		paginaMantenimientoProducto.clickbtnEliminar();
	}
	
	@And("hago click en el botón sí") 	
	public void clickbtnSi() {
		paginaMantenimientoProducto.clickbtnSi();
	}
	
	@Then("el aplicativo muestra el mensaje {string}")
	public void validarMensaje(String mensaje) {
		Assertions
		.assertThat(paginaMantenimientoProducto.getMensaje())
		.isEqualTo(mensaje);
	}
}
