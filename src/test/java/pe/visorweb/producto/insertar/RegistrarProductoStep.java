package pe.visorweb.producto.insertar;

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
import pe.visorweb.pagina.producto.PaginaRegistrarProducto;

public class RegistrarProductoStep {

	@Managed
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaRegistrarProducto paginaRegistrarProducto;
	
	
	@Before
	public void configurarDriver() {
		paginaLogin = new PaginaLogin(driver);
		paginaRegistrarProducto = new PaginaRegistrarProducto(driver);
		
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
	
	@When("cargo la página registrar producto")
	public void cargarPaginaRegistrarProducto() {
		paginaRegistrarProducto.cargarPagina();
	}
	
	
	@And("registro el producto {string} con la categoria {string} y con precio {string}")
	public void registrarProducto(String nombreproducto, String categoria, String precio) {
		paginaRegistrarProducto.guardar(nombreproducto, categoria, precio);
	}
	
	@Then("el aplicativo muestra el mensaje {string}")
	public void verificarRegistro(String mensaje) {
		Assertions
			.assertThat(paginaRegistrarProducto.getMensaje())
			.isEqualTo(mensaje);
	}
}
