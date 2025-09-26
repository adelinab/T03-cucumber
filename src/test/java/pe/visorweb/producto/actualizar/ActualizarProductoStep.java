package pe.visorweb.producto.actualizar;

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

public class ActualizarProductoStep {
	
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
	
	@And("hago click en el botón editar") 	
	public void clickBotonEditar() {
		paginaMantenimientoProducto.clickBotonEditar();
	}
	
	@And("ingreso el nombre {string}") 	
	public void ingresarNombreProducto(String nombreproducto) {
		paginaActualizarProducto.ingresarNombreProducto(nombreproducto);
	}
	
	@And("selecciono la categoría {string}") 	
	public void seleccionarCategoria(String categoria) {
		paginaActualizarProducto.seleccionarCategoria(categoria);
	}
	
	
	@And("ingreso el precio {string}") 	
	public void ingresarPrecio(String precio) {
		paginaActualizarProducto.ingresarPrecio(precio);
	}
	
	@And("hago click en el botón guardar") 	
	public void clickBotonGuardar() {
		paginaActualizarProducto.clickBotonGuardar();
	}
	
	@Then("el aplicativo muestra el mensaje {string}")
	public void verificarRegistro(String mensaje) {
		Assertions
			.assertThat(paginaActualizarProducto.getMensaje())
			.isEqualTo(mensaje);
	}
}
