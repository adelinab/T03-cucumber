package pe.visorweb.pagina.producto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pe.visorweb.helper.VisorHelper;
import pe.visorweb.pagina.base.PaginaBase;

public class PaginaMantenimientoProducto extends PaginaBase{

	@FindBy(id = "btnNuevo")
	WebElement btnNuevo;
		
	@FindBy(id = "btnFiltrar")
	WebElement btnFiltrar;
	
	@FindBy(id = "btnActualizar")
	WebElement btnActualizar;
	
	@FindBy(id = "btnEliminar")
	WebElement btnEliminar;
	
	@FindBy(id = "btnSi")
	WebElement btnSi;
	
	@FindBy(xpath="//tbody[@id='tablaProductos_data']/tr[2]")
	WebElement productoSeleccionado;
	
	@FindBy(xpath="//span[@class='ui-messages-warn-summary'] | //span[@class='ui-messages-info-summary']")
	WebElement lblMensaje;
		
	@FindBy(id = "txtFiltro")
	WebElement txtFiltro;
	
	@FindBy(xpath = "//tbody[@id='tablaProductos_data']/tr/td[2]")
	List<WebElement> resultadosFiltro;
	
	@FindBy(xpath="//tr[@class='ui-widget-content ui-datatable-empty-message']")
	WebElement lblNoRegistros;
	
	
	public PaginaMantenimientoProducto(WebDriver driver) {
		super(driver);
	}
	
	public void cargarPaginaMntProducto() {
		menuPrincipal
		.cargarPaginaMantenimientoProducto();
	}
	
	public PaginaRegistrarProducto cargarPaginaRegistrarProducto() {
		click(btnNuevo);
		return new PaginaRegistrarProducto(driver);
	}
	
	
	public PaginaActualizarProducto cargarPaginaActualizarProducto() {
		
		btnFiltrar.click();
		productoSeleccionado.click();
		btnActualizar.click();
		return new PaginaActualizarProducto(driver);
	}

	public void clickBotonEditar() {
		click(btnActualizar);
	}
	

	public void seleccionarProducto() {
		click(productoSeleccionado);
	}
	
	public void clickbtnFiltrar() {
		click(btnFiltrar);
		
	}
	
	public void clickbtnActualizar() {
				
		click(btnActualizar);
	}
	
	public void clickbtnEliminar() {
		
		click(btnEliminar);
	}
	
	public void clickbtnSi() {
		
		click(btnSi);
	}
	
	
	public void escribirNombreProductoAFiltrar(String nombreproducto) {
		
		escribir(txtFiltro,nombreproducto);		
	}
	
	public boolean validarNumerodeFilas() {		
		
		 if(resultadosFiltro.size()>0) 
		 {		
			return true;
		 }
		 else 
		 {
			 return false;
		 }
		 		 
	}
	
	public String getMensajeNoRegistros() {
		VisorHelper.pausar();
		return lblNoRegistros.getText();
	}
	
	public String getMensaje() {
		VisorHelper.pausar();
		return lblMensaje.getText();
	}
	
	
}
