import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:/Cosas/FP/git/tarea3ed/CD_UD3_PruebasSelenium/driver/chromedriver.exe");     

        WebDriver driver = new ChromeDriver();
        
        
        driver.get("https://www.totemvertigo.com/"); //Abrimos la página de la tienda en el navegador que acabamos de abrir
        Thread.sleep(2000); 
        
        WebElement searchBox = driver.findElement(By.id("busqueda")); //seleccionamos la caja de búsqueda
        
        Thread.sleep(2000);
        searchBox.sendKeys("sistémá"); //introducimos una palabra acentuada que no debería llevarlos, con el fin de ver si es capaz de encontrar los productos con la palabra "sistema" de igual modo
        searchBox.sendKeys(Keys.ENTER); //ejecuta la búsqueda
        Thread.sleep(2000);
        
        String titulo=driver.getTitle();
        System.out.println(titulo); 
        

        driver.quit();

    }
}
