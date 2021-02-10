import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Segundo {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.goat.com"); 
        Thread.sleep(5000);


        WebElement cookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        WebElement cancelButton = driver.findElement(By.cssSelector(".fpAmCQ"));
        Thread.sleep(2000);
        cookiesButton.click();
        Thread.sleep(2000);
        cancelButton.click();
        Thread.sleep(2000);
        
        do
        {
            driver.navigate().refresh();
            Thread.sleep(500); //El sleep es para darle tiempo a la página a cargar. Habría que cambiarle los parámetros si nuestra conexión fuera muy lenta.
        } while (driver.findElements(By.className("content-wrapper")).size() < 1); 


    }

}
