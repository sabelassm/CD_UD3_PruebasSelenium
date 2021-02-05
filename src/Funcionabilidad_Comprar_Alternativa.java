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

public class Funcionabilidad_Comprar_Alternativa {
    public static void main(String[] args) throws Exception {
        	// CARGAR DRIVER FIREFOX
    	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

    	driver.get("https://www.rakayoclothing.com/");
    	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]")).click();  // Abrir catálogo
    	driver.findElement(By.className("product-card")).click();  // Abre el primer producto de la lista
    	Thread.sleep(1500); 
    	
    		// Hacer Scroll Abajo
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        
    	driver.findElement(By.id("AddToCartText-product-template")).click();
    	js.executeScript("window.scrollBy(0,-350)", "");
    	Thread.sleep(1500); 
    	driver.findElement(By.xpath("//a[@class='site-header__link site-header__cart']")).click();  // Abrir carrito
    	Thread.sleep(1500); 
    	
		// Hacer Scroll Abajo
    	js.executeScript("window.scrollBy(0,350)", "");
    	Thread.sleep(1000); 
    	driver.findElement(By.xpath("//button[@class='btn'][@name='checkout']")).click();  // Comprar
    	Thread.sleep(1500); 
    	
    	System.out.println(driver.getTitle());  // Página Resultante
        driver.quit();
    }
}