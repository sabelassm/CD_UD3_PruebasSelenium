import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class tercero {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.goat.com"); 
        Thread.sleep(5000);
        
        WebElement cookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        WebElement cancelButton = driver.findElement(By.cssSelector(".fpAmCQ"));
        Thread.sleep(2000);
        cookiesButton.click();
        Thread.sleep(2000);
        cancelButton.click();
        Thread.sleep(2000);

        WebElement menuButton = driver.findElement(By.cssSelector(".Nav__Hamburger-sc-4qndhy-1"));
        menuButton.click();
        Thread.sleep(1000);

        WebElement signUpButton = driver.findElement(By.linkText("Sign Up"));
        signUpButton.click();
        Thread.sleep(1000);

        WebElement nameBox = driver.findElement(By.id("full-name"));
        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passBox = driver.findElement(By.id("password"));
        WebElement passCBox = driver.findElement(By.id("confirm-password"));
        nameBox.sendKeys("Yago Álvarez Enríquez");
        nameBox.sendKeys(Keys.TAB);
        Thread.sleep(500);
        emailBox.sendKeys("yagopruebaseleniuasdfm@yopmail.com");
        emailBox.sendKeys(Keys.TAB);
        Thread.sleep(500);
        passBox.sendKeys("Sanclemente2021");
        passBox.sendKeys(Keys.TAB);
        Thread.sleep(500);
        passCBox.sendKeys("Sanclemente2021");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".bSipoS")).click();

        Thread.sleep(20000);
        



        driver.quit();

    }
}