package pe.visorweb.pagina.producto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pe.visorweb.helper.VisorHelper;
import pe.visorweb.menu.MenuPrincipal;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaRegistrarProducto extends PaginaBase {

	@FindBy(id="txtNombre")
	WebElement txtNombre;
	
	@FindBy(id="btnGuardar")
	WebElement btnGuardar;
	
	@FindBy(id="txtPrecio")
	WebElement txtPrecio;
	
	@FindBy(id="cboCategoria")
	WebElement cboCategoria;
	
	@FindBy(xpath="//span[@class='ui-messages-info-summary'] | //span[@class='ui-messages-error-summary']")
	WebElement lblMensaje;
		
	public PaginaRegistrarProducto(WebDriver driver) {
		super(driver); 
	}
	
	public void cargarPagina() {
		menuPrincipal
		.cargarPaginaMantenimientoProducto()
		.cargarPaginaRegistrarProducto();
	}
	
	public void guardar(String nombreproducto, String categoria, String precio) {
		escribir(txtNombre,nombreproducto);
		seleccionar(cboCategoria, categoria);
		escribir(txtPrecio,precio);
		click(btnGuardar);
	}
	
	public String getMensaje() {
		VisorHelper.pausar();
		return lblMensaje.getText();
	}
}
