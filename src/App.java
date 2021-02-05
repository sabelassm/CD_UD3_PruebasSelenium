  

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
    WebElement resultado = driver.findElement(By.id("AddToCartText-product-template"));
    resultado.click();
    Thread.sleep(5000);
    driver.close();
    

   
    }
}