import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quinta {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.goat.com"); 
        Thread.sleep(5000);
        
        WebElement cookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        WebElement cancelButton = driver.findElement(By.cssSelector(".fpAmCQ"));
        Thread.sleep(2000);
        cookiesButton.click();
        Thread.sleep(2000);
        cancelButton.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//body")).sendKeys(Keys.END);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);

        Thread.sleep(500);
        driver.get("https://goat.zendesk.com/hc/en-us/requests/new"); 
        driver.findElement(By.id("request_anonymous_requester_email")).click();
        Thread.sleep(500);
        driver.findElement(By.id("request_anonymous_requester_email")).sendKeys("estoesuncorreofalso@yopmail.com");
        Thread.sleep(500);
        driver.findElement(By.id("request_subject")).sendKeys("No dejen enviar");
        Thread.sleep(500);
        driver.findElement(By.linkText("Shoes")).click();
        Thread.sleep(500);
        driver.findElement(By.id("product_type_shoes")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("-")).click();
        Thread.sleep(500);
        driver.findElement(By.id("user_type_buyer")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("-")).click();
        Thread.sleep(500);
        driver.findElement(By.id("black_friday_buyer")).click();
        Thread.sleep(500);
        driver.findElement(By.id("request_description")).click();
        Thread.sleep(500);
        driver.findElement(By.id("request_description")).sendKeys("piriririr");
        Thread.sleep(500);
        driver.findElement(By.name("commit")).click();
        Thread.sleep(5000);

        driver.quit();

    }
}