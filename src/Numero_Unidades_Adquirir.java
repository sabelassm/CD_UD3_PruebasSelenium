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
import java.util.List;

public class Numero_Unidades_Adquirir {
    public static void main(String[] args) throws Exception {
        	// CARGAR DRIVER FIREFOX
    	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        	
        	// PRECARGAR VALORES QUE VAN A SER UTILIZADOS
        String [] unitValue = {"0", "-1","10000"};
        
        	// PRUEBA
        for(int i=0; i<unitValue.length; i++) {  // El bucle permite probar con el valor 0 y con el valor negativo
        	// DESPLAZARSE A LA PÁGINA DE INTERÉS
        	driver.get("https://www.rakayoclothing.com/");  // Iniciar instancia del navegador (página Inicio)
        	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]")).click();  // Abrir catálogo
        	driver.findElement(By.className("product-card")).click();  // Abrir primer producto de la lista
        	Thread.sleep(1500);
        	
        	// MODIFICAR NÚMERO DE UNIDADES Y ACCEDER AL CARRITO
    			// Hacer Scroll Abajo
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("window.scrollBy(0,350)", "");
        
        		// Modificar cantidad
        	WebElement unitBox = driver.findElement(By.id("Quantity"));  // Caja de selección de cantidad
        	unitBox.clear();
        	unitBox.sendKeys(unitValue[i]);  // Modificar el valor a 0
        	driver.findElement(By.id("AddToCartText-product-template")).click();  // Añadir al carrito
        	
        		// Acceder a la página del carrito
        	js.executeScript("window.scrollBy(0,-350)", "");  // Scroll arriba
        	Thread.sleep(1500); 
        	driver.findElement(By.xpath("//a[@class='site-header__link site-header__cart']")).click();  // Abrir carrito
        	Thread.sleep(1500); 
        	
        	// COMPROBAR QUE SE PUEDE ACCEDER A LA PÁGINA DE COMPRA
        	js.executeScript("window.scrollBy(0,-350)", "");  // Scroll abajo
        	
        		// Generamos un objeto que almacena los elementos que coinciden con la búsuqueda (botón de comprar)
        	List<WebElement> elems = driver.findElements(By.xpath("//button[@class='btn'][@name='checkout']"));

        	
        	if (elems.size() > 0) { // Si hay elementos en la lista, es posible comprar 
        		System.out.println("Algo ha salido mal, es posible realizar la compra.");  //Resultado
        		driver.findElement(By.xpath("//button[@class='btn'][@name='checkout']")).click();  // Moverse a la página de compra
        		Thread.sleep(1500);
        		System.out.println(driver.getTitle());  // Mostrar la página final 
        	}
        	else {
        		System.out.println("No hay elementos en el carrito, no se puede comprar.");
        		System.out.println(driver.getTitle());  // Página Resultante
        	}
        }
        driver.quit();
    }
}