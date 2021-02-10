import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class Primero {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.opera.driver", "./driver/operadriver.exe");

        WebDriver driver = new OperaDriver();
        driver.get("https://www.goat.com"); 
        Thread.sleep(5000);
        
        WebElement cookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        WebElement cancelButton = driver.findElement(By.cssSelector(".fpAmCQ"));
        Thread.sleep(2000);
        cookiesButton.click();
        Thread.sleep(2000);
        cancelButton.click();
        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.id("Layer_1"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.cssSelector(".InstantSearchBox__Input-wfzp5c-1")); 
        searchBox.sendKeys("Dior x Air Jordan 1 high");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        Thread.sleep(20000);
        



        driver.quit();

    }
}