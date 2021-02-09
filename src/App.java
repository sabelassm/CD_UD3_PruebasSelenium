
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    WebDriver driver  = new ChromeDriver(); 
    driver.get("https://www.rakayoclothing.com/");   

    
    String titulo = driver.getTitle();
    System.out.println("*********************");
    System.out.println(titulo);
    System.out.println("*********************");
    WebElement searchBox = driver.findElement(By.id("SiteNavSearch"));
    searchBox.sendKeys("SUDADERA");   
    searchBox.submit();
    Thread.sleep(2000);
    WebElement resultado = driver.findElement(By.className("product-card__image-wrapper"));
    resultado.click();
    Thread.sleep(2000);
    WebElement añadircesta = driver.findElement(By.id("AddToCart-product-template"));
    añadircesta.click();
    Thread.sleep(2000);
    WebElement cesta = driver.findElement(By.className("icon-cart"));
    cesta.click();
    Thread.sleep(2000);
    WebElement finalizarcompra = driver.findElement(By.className("btn"));
    finalizarcompra.click();
    Thread.sleep(2000); 
    WebElement continuarenvios = driver.findElement(By.id("continue_button"));
    continuarenvios.click();
    Thread.sleep(2000);
    String titulofallo = "Error - Informacion -Rakayo Clothing - Pantalla de pago";
    String tituloerror = driver.getTitle();
    System.out.println(tituloerror);    
    assertEquals(tituloerror, titulofallo);
    driver.close();
   
    }
}