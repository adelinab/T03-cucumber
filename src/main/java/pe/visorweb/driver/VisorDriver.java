package pe.visorweb.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VisorDriver {

	public enum Navegador { CHROME, FIREFOX, EDGE }
	
	private VisorDriver() {
		//un constructor siempre existe. Si lo eliminas se cree uno implícito pero que no es visible. 
		//Entonces es mejor crearlo y dejarlo vacío como si no existiera
	}
	
	public static WebDriver getDriver(Navegador navegador) {
		if (navegador == Navegador.FIREFOX) {
			return getFirefoxDriver();
		} else if (navegador == Navegador.EDGE) {
			return getEdgeDriver();
		}
		return getChromeDriver();
	}

	private static WebDriver getEdgeDriver() {
		return aplicarConfiguracionComun(new EdgeDriver());
	}

	private static WebDriver getChromeDriver() {
		return aplicarConfiguracionComun(new ChromeDriver());
	}

	private static WebDriver getFirefoxDriver() {
		return aplicarConfiguracionComun(new FirefoxDriver());
	}
	
	private static WebDriver aplicarConfiguracionComun(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
}
