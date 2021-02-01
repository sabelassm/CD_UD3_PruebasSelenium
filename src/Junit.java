import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit {
    private WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/VSC_Selenium/JUnit/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void TestCarrito() throws InterruptedException {

        //Pruebas CP006 & CP007 Comprobar que se pueden añadir productos al carrito y eliminarlos
        driver.get("https://ordenadoreskm0.com/");
        Thread.sleep(2000); //detenemos el hilo 5 segundos
        String titulo = driver.getTitle(); //obtenemos el título de la web
        System.out.println(titulo); // Comprobamos que el título es correcto
        Thread.sleep(2000);

        //Accedemos a un artículo
        WebElement articulo = driver.findElement(By.xpath("//*[@id='content']/section/div/div[1]/article/div/a")); 
        articulo.click();
        Thread.sleep(2000);

        //Clicamos sobre el botón comprar para añadir el producto al carrito
        WebElement BotonComprar = driver.findElement(By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]/button"));
        BotonComprar.click();
        Thread.sleep(2000);

        //Clicamos para acceder al carrito y comprobar que el producto se ha añadido correctamente
        WebElement BotonIrCarrito = driver.findElement(By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a"));
        BotonIrCarrito.click();
        Thread.sleep(2000);

        //Comprobamos que se puede eliminar el artículo del carrito
        WebElement BotonEliminar = driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div[1]/div[2]/ul/li/div/div[3]/div/div[3]/div/a"));
        BotonEliminar.click();
        Thread.sleep(2000);
    }

    @After
    public void fin(){
        driver.quit();
    }
}
