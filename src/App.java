import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.worten.es/"); // Abrimos la pagina de Worten
        Thread.sleep(2000); // Para ver la ejecuciÃ³n, detenemos el hilo 2 segundos

        WebElement searchBox = driver.findElement(By.id("search-input")); // Pruebo el buscador con la palabra "Playa"
        searchBox.sendKeys("playa");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.RETURN);
        Thread.sleep(4000);
        Select galletas = new Select(driver.findElement(By.id("order_by"))); // Compruebo que ordena correctamente los
                                                                             // productos segun el filtro
        galletas.selectByIndex(2);
        Thread.sleep(6000);
        WebElement carro = driver.findElement(By.xpath(
                "//a[@class='w-shop-cart-icon-mobile qa-header__shop-cart iss-cart-button']//*[local-name()='svg']")); // Veo
                                                                                                                       // que
                                                                                                                       // la
                                                                                                                       // opcion
                                                                                                                       // de
                                                                                                                       // acceso
                                                                                                                       // al
                                                                                                                       // carro
                                                                                                                       // funciona
                                                                                                                       // aun
                                                                                                                       // sin
                                                                                                                       // cuenta
        carro.click();
        Thread.sleep(4000);
        WebElement islas = driver.findElement(By.xpath("//a[normalize-space()='CANARIAS']")); // Comprobacion de la
                                                                                              // version canaria de la
                                                                                              // web
        islas.click();
        Thread.sleep(4000);
        WebElement tienda = driver.findElement(By.xpath("//a[normalize-space()='INICIAR SESIÃ“N']")); // Intento acceso
                                                                                                      // a
                                                                                                      // cuenta
        tienda.click();
        Thread.sleep(4000);
        WebElement mail = driver.findElement(By.xpath("//input[@id='email']")); // Introduzco un mail falso , no deberia
                                                                                // darme acceso
        mail.sendKeys("falsemail@nomail.com");
        Thread.sleep(4000);
        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));// La contraseÃ±a es falsa tambien
        pass.sendKeys("123456");
        Thread.sleep(4000);
        WebElement pulsar = driver.findElement(By.xpath("//button[normalize-space()='Iniciar SesiÃ³n']")); // No deja
                                                                                                           // iniciar
                                                                                                           // sesion
        pulsar.click();
        Thread.sleep(4000);
        WebElement otra = driver.findElement(By.xpath("//span[@ng-bind='secondaryText']"));//
        otra.click();
        Thread.sleep(4000);
        driver.quit();

    }
}