import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe"); 

        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.asos.com/es/?hrd=1");  
        Thread.sleep(2000);

        /*Test 1*/

        driver.findElement(By.id("chrome-search")).sendKeys("amarillo"+ Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("a[data-testid='asoslogo']")).click();
        Thread.sleep(2000);

        driver.quit();

        /*Test 2*/  

        driver.findElement(By.id("chrome-search")).sendKeys("top"+ Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[data-auto-id='saveForLater']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("a[data-testid='savedItemsIcon']")).click();
        Thread.sleep(2000);

        driver.quit();

        /*Test 3*/
        
        driver.findElement(By.cssSelector("button[data-testid='country-selector-btn']")).click();
        Thread.sleep(2000);

        Select comboboxSimple = new Select(driver.findElement(By.id("country")));
        comboboxSimple.selectByIndex(0);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[data-testid='save-country-button']")).click();
        Thread.sleep(2000);

        driver.quit();

        /*Test 4*/ 

        driver.findElement(By.id("chrome-search")).sendKeys("pantalón rosa"+ Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();
        
        /*Test 5*/ 

        driver.findElement(By.id("myAccountDropdown")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[data-testid='signup-link']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("Email")).sendKeys("ejemplo@correo.com");
        Thread.sleep(2000);
        driver.findElement(By.id("FirstName")).sendKeys("Nombre");
        Thread.sleep(2000);
        driver.findElement(By.id("LastName")).sendKeys("Apellidos");
        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("Contraseña");
        Thread.sleep(2000);

        Select Calendario = new Select(driver.findElement(By.id("BirthDay")));
        Calendario.selectByIndex(29);
        Select Calendario2 = new Select(driver.findElement(By.id("BirthMonth")));
        Calendario2.selectByIndex(1);
        Select Calendario3 = new Select(driver.findElement(By.id("BirthYear")));
        Calendario3.selectByIndex(9);
        Thread.sleep(2000);

        WebElement radio = driver.findElement(By.id("female"));
        radio.click();
        WebElement checkbox = driver.findElement(By.id("promosLabel"));
        checkbox.click();
        driver.findElement(By.id("all-checkbox-button")).click();

        driver.findElement(By.id("register")).click();
        Thread.sleep(2000);

         driver.quit();
    }
        
}
