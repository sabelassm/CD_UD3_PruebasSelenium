import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Seguridad_Login_Inyeccion_SQL {
    public static void main(String[] args) throws Exception {
    	// CARGAR DRIVER FIREFOX
	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    
    	// PRUEBA
    // DESPLAZARSE A LA PÁGINA DE INTERÉS
    driver.get("https://www.rakayoclothing.com/");  // Iniciar instancia del navegador (página Inicio)
    driver.findElement(By.id("customer_login_link")).click();  // Abrir catálogo
    Thread.sleep(1500);
    
    // INTRODUCIR CAMPOS Y REALIZAR LOGIN
    	// Buscar los campos para el email y la contraseña
    WebElement emailBox = driver.findElement(By.id("CustomerEmail"));
	WebElement passBox = driver.findElement(By.id("CustomerPassword"));  

	// MODIFICACIONES HTML
		/* La configuración HTML del cuadro de correo no permite introducir elementos que no tengan un formato de correo electrónico.
		 * Parte de la vulnerabilidad que se desea detectar (y con una modificación sencilla  del documento HTML podría realizarse.
		 * Esta linea está adaptado: NO es propio, pero es necesaria para realizar la prueba. 
		 * 
		 * Reemplaza la etiqueta HTML original por otra igual sin el type=email*/
	((JavascriptExecutor)driver).executeScript("var ele=arguments[0]; ele.outerHTML = '<input name=\"customer[email]\" id=\"CustomerEmail\" class=\"\" placeholder=\"Correo electrónico\" autocorrect=\"off\" autocapitalize=\"none\" autofocus=\"\">';", emailBox);
	emailBox = driver.findElement(By.id("CustomerEmail"));  // Se actualiza el elemento que estamos buscando
	
		// Inyectar SQL (resultado TRUE)
	emailBox.sendKeys("'or '1'='1'");
	passBox.sendKeys("'or '1'='1'");
		// Pulsar el botón de login
    driver.findElement(By.xpath("//input[@class='btn'][@value='Registrarse']")).click();
    Thread.sleep(1500);
    System.out.println(driver.findElement(By.className("errors")));  // Muestra si se han producido errores
    driver.quit();
    }
}