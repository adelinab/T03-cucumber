package pe.visorweb.pagina.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pe.visorweb.pagina.base.PaginaBase;

public class PaginaLogin extends PaginaBase{

	@FindBy(id = "txtUsuario") //a esto se le llama anotacion
	WebElement txtUsuario;
	
	@FindBy(id = "txtClave")
	WebElement txtClave;
	
	@FindBy(id = "btnIniciarSesion")
	WebElement btnIniciarSesion;
	
	@FindBy(xpath = "//div[@class='title-main']")
	WebElement lblMensaje;
	
	
	
	public PaginaLogin(WebDriver driver) {
		super(driver);
	}
	
	public void iniciarSesion(String usuario, String clave) {
		txtUsuario.clear();
		txtUsuario.sendKeys(usuario);
		
		txtClave.clear();
		txtClave.sendKeys(clave);
		
		btnIniciarSesion.click();
	}
	
	public String getMensaje() {
		return lblMensaje.getText();
	}
	
	public void cargarPagina() {
		driver.get("http://localhost:8080/VisorWeb/index.xhtml");
	}
}
