
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Eloy/visual/CD_Tarea3/driver/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void pruebaComprar() throws InterruptedException {

        driver.get("https://www.pccomponentes.com/seagate-barracuda-35-1tb-sata3?tmPid=111412&recToken=recs");
        driver.manage().window().maximize();
        
        WebElement botonCarrito = driver.findElement(By.id("add-cart"));
        
        botonCarrito.click();
        Thread.sleep(5000);
        
        WebElement numeroCarritoActual = driver.findElement(By.className("c-units"));
        String numeroCarritoEsperado = "1";
        String numeroCarrito = numeroCarritoActual.getText();

        assertEquals(numeroCarritoEsperado, numeroCarrito);

    }

    @Test
    public void pruebaBusqueda() throws InterruptedException {

        driver.get("https://www.pccomponentes.com/");
        driver.manage().window().maximize();

        WebElement botonBusqueda = driver.findElement(By.id("ais-autocomplete-selectized"));

        botonBusqueda.sendKeys("raspberry pi 4 modelo b 4gb");
        Thread.sleep(1000);
        botonBusqueda.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        
        WebElement producto = driver.findElement(By.cssSelector("[data-id='216504']"));

        producto.click();
        Thread.sleep(5000);

        WebElement nombreObjetoActual = driver.findElement(By.cssSelector("h1.h4 strong:first-child"));
        String nombreObjetoEsperado = "Raspberry Pi 4 Modelo B 4GB";
        String nombreObjeto = nombreObjetoActual.getText();

        assertEquals(nombreObjetoEsperado, nombreObjeto);

    }

    @Test
    public void filtradoProductos() throws InterruptedException {

        driver.get("https://www.pccomponentes.com/discos-duros");
        driver.manage().window().maximize();

        WebElement filtroTamaño = driver.findElement(By.cssSelector("[data-id='130']"));
        
        filtroTamaño.click();
        Thread.sleep(3000);
        
        WebElement filtroConexion = driver.findElement(By.linkText("M.2"));

        filtroConexion.click();
        Thread.sleep(3000);

        WebElement nombreSeleccion = driver.findElement(By.cssSelector("h1.white-card:nth-child(1)"));
        String nombreFiltroEsperado = "Discos Duros 1 TB M.2";
        String nombreActual = nombreSeleccion.getText();

        assertEquals(nombreFiltroEsperado, nombreActual);

    }

    @Test
    public void compraSinProducto() throws InterruptedException {

        driver.get("https://www.pccomponentes.com/cart/");
        driver.manage().window().maximize();
        
        WebElement numeroCarritoActual = driver.findElement(By.cssSelector("h1.h3 strong:first-child"));
        String numeroEsperado = "(0)";
        String numeroActual = numeroCarritoActual.getText();

        assertEquals(numeroEsperado, numeroActual);

        WebElement textoCestaActual = driver.findElement(By.cssSelector("div p:first-child"));
        String textoEsperado = "El carrito está vacío";
        String textoActual = textoCestaActual.getText();

        assertEquals(textoEsperado, textoActual);

        WebElement botonCompra = driver.findElement(By.id("GTM-carrito-realizarPedidoPaso1"));
        botonCompra.click();

        WebElement usuario = driver.findElement(By.name("username"));
        WebElement contraseña = driver.findElement(By.name("password"));
        WebElement botonInicio = driver.findElement(By.cssSelector("[data-cy='log-in']"));

        //cuenta y constraseña para prueba no contiene datos
        usuario.sendKeys("abc123@hotmail.com");
        contraseña.sendKeys("abc123");
        botonInicio.click();
        Thread.sleep(5000);

        WebElement alerta = driver.findElement(By.cssSelector("div.alertBox div#alerta-00 p"));
        String textoErrorEsperado = "El carrito está vacio";
        String textoAlertaActual = alerta.getText();

        assertEquals(textoErrorEsperado, textoAlertaActual);
    }

    @Test
    public void pruebaMenu() throws InterruptedException {

        driver.get("https://www.pccomponentes.com/");
        driver.manage().window().maximize();

        WebElement menu = driver.findElement(By.className("c-main-menu__top-bar"));
        menu.click();
        Thread.sleep(2000);

        WebElement opcion1 = driver.findElement(By.id("GTM-superfamilia-119"));
        opcion1.click();
        Thread.sleep(2000);
        
        WebElement tituloOpcionActual = driver.findElement(By.cssSelector("div.col-xs-12 h1"));
        String tituloEsperado = "Ordenadores PC y Portátiles";
        String tituloActual = tituloOpcionActual.getText();

        assertEquals(tituloEsperado, tituloActual);
        Thread.sleep(2000);

        WebElement menu2 = driver.findElement(By.className("c-main-menu__top-bar"));
        menu2.click();
        Thread.sleep(2000);

        WebElement opcion2 = driver.findElement(By.id("GTM-superfamilia-28"));
        opcion2.click();
        Thread.sleep(2000);

        WebElement tituloOpcionActual2 = driver.findElement(By.cssSelector("div.col-xs-12 h1"));
        String tituloEsperado2 = "Periféricos";
        String tituloActual2 = tituloOpcionActual2.getText();

        assertEquals(tituloEsperado2, tituloActual2);
    }
    

    @After
    public void shutdown() {
        driver.quit();
    }
}
