import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.unpackedshop.es");

        Thread.sleep(5000);

        // CERRAR POPUP
        WebElement popUp = driver.findElement(By.className("popup_close"));
        popUp.click();

        Thread.sleep(1000);

        // CERRAR AVISO COOKIES
        WebElement avisoCookies = driver.findElement(By.className("cerrar_aviso_cookies"));
        avisoCookies.click();

        Thread.sleep(1000);

        // CPF1 AÑADIR A LA CESTA UN PRODUCTO AGOTADO
        WebElement desplegable = driver.findElement(By.linkText("DÍA A DÍA"));
        Actions mover = new Actions(driver);
        mover.moveToElement(desplegable).perform();

        Thread.sleep(1000);

        WebElement cocina = driver.findElement(By.linkText("Cocina"));
        cocina.click();

        Thread.sleep(1000);

        WebElement pagsiguiente = driver.findElement(By.linkText("Siguiente"));
        pagsiguiente.click();

        Thread.sleep(1000);

        WebElement producto = driver.findElement(By.linkText("PAÑOS REUTILIZABLES"));
        producto.click();

        Thread.sleep(1000);

        WebElement añadir = driver.findElement(By.className("btn_comprar"));
        añadir.click();

        Thread.sleep(1000);

        // CPF2 AÑADIR CANTIDADES INGENTES DE PRODUCTO
        desplegable = driver.findElement(By.linkText("CUIDADO PERSONAL"));
        mover.moveToElement(desplegable).perform();

        Thread.sleep(1000);

        WebElement facial = driver.findElement(By.linkText("Facial"));
        facial.click();

        Thread.sleep(1000);

        driver.findElement(By.linkText("LIMPIADOR FACIAL PARA PIEL MIXTA - GRASA")).click();

        WebElement aumentar = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();
        aumentar.click();

        Thread.sleep(1000);

        driver.findElement(By.className("btn_comprar")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("Apoyo_Mensaje_div_aceptar")).click();

        Thread.sleep(1000);

        // CPF3 IR A CESTA COMPRA CUPÓN DESCUENTO
        WebElement carroCompra = driver.findElement(By.className("carrito_li"));
        carroCompra.click();

        Thread.sleep(2000);

        WebElement irCesta = driver
                .findElement(By.xpath("//div[@class='desp_cesta-int']//a//div[@class='desp_cesta-pagar']"));
        irCesta.click();

        Thread.sleep(1000);

        // INTRODUCIMOS Y APLICAMOS CUPON
        WebElement cajaCupon = driver.findElement(By.id("txb_codDesc"));
        cajaCupon.sendKeys("1234abcd");

        Thread.sleep(1000);

        cajaCupon.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        cajaCupon.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.id("Apoyo_Mensaje_div_aceptar")).click();

        Thread.sleep(2000);

        // CPF4 ACCESO A CUIDADO PERSONAL
        WebElement cuidadoPersonal = driver.findElement(By.linkText("CUIDADO PERSONAL"));
        cuidadoPersonal.click();

        Thread.sleep(3000);

        // CPF5 NEWSLETTER
        // ACCEDER A LA PÁGINA PRINCIPAL
        WebElement paginaInicio = driver.findElement(By.linkText("Inicio"));
        paginaInicio.click();

        Thread.sleep(1000);

        WebElement introduceEmail = driver.findElement(By.id("txb_newsletter_email"));
        introduceEmail.sendKeys("nnn@nn.nn");

        Thread.sleep(1000);

        introduceEmail.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        introduceEmail.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.id("Apoyo_Mensaje_div_aceptar")).click();

        Thread.sleep(2000);

        // CPF6 REGISTRO USUARIO NUEVO
        WebElement logIn = driver.findElement(By.linkText("Login"));
        logIn.click();

        Thread.sleep(1000);

        WebElement registrarse = driver.findElement(By.linkText("Registrarse"));
        registrarse.click();

        Thread.sleep(1000);

        // FORMULARIO DE DATOS
        WebElement cajaEmail = driver.findElement(By.id("txb_email"));
        cajaEmail.sendKeys("silvia_lpez@hotmail.com");

        Thread.sleep(1000);

        cajaEmail.sendKeys(Keys.TAB);

        WebElement confirmaEmail = driver.findElement(By.id("txb_email1"));

        confirmaEmail.sendKeys("silvia_lpez@hotmail.com");

        Thread.sleep(1000);

        confirmaEmail.sendKeys(Keys.TAB);

        WebElement cajaNombre = driver.findElement(By.id("txb_nombre"));
        cajaNombre.sendKeys("Nnnn");

        Thread.sleep(1000);

        cajaNombre.sendKeys(Keys.TAB);

        WebElement cajaApellidos = driver.findElement(By.id("txb_apellidos"));
        cajaApellidos.sendKeys("NNN NNN");

        Thread.sleep(1000);

        cajaApellidos.sendKeys(Keys.TAB);

        WebElement cajaDNI = driver.findElement(By.className("CSS_KO"));
        cajaDNI.sendKeys("88888888N");

        Thread.sleep(1000);

        cajaDNI.sendKeys(Keys.TAB);

        Select eligePais = new Select(driver.findElement(By.id("drop_pais")));
        eligePais.selectByIndex(65);

        Thread.sleep(1000);

        WebElement pais = driver.findElement(By.id("drop_pais"));
        pais.sendKeys(Keys.TAB);

        Select eligeProvincia = new Select(driver.findElement(By.id("drop_provincia")));
        eligeProvincia.selectByIndex(0);

        Thread.sleep(1000);

        WebElement provincia = driver.findElement(By.id("drop_provincia"));
        provincia.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        WebElement cajaPoblacion = driver.findElement(By.id("txb_poblacion"));
        cajaPoblacion.sendKeys("ddd");
        cajaPoblacion.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        WebElement cajaCP = driver.findElement(By.id("txb_codigoPostal"));
        cajaCP.sendKeys("ddd");
        cajaCP.sendKeys(Keys.TAB);

        Thread.sleep(2000);

        WebElement cajaDireccion = driver.findElement(By.id("txb_direccion"));
        cajaDireccion.sendKeys("dddddd");
        cajaDireccion.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        WebElement cajaTlfn = driver.findElement(By.id("txb_tfn"));
        cajaTlfn.sendKeys("111222333");
        cajaTlfn.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        WebElement aceptaSuscripcion = driver.findElement(By.id("chkbx_newsletter"));
        aceptaSuscripcion.sendKeys(Keys.SPACE);
        aceptaSuscripcion.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        WebElement cajaPss = driver.findElement(By.id("txb_p1"));
        cajaPss.sendKeys("fff222");
        cajaPss.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        WebElement cajaPssR = driver.findElement(By.id("txb_p2"));
        cajaPssR.sendKeys("fff222");

        Thread.sleep(1000);

        WebElement aceptaPrivacidad = driver
                .findElement(By.id("ckedit_usuario.legal_altausuario_1||/imagenes/lang/usuario.legal_altausuario_"));
        aceptaPrivacidad.click();

        Thread.sleep(1000);

        WebElement guardainfo = driver.findElement(By.id("ckedit_envio.guardar_1||/imagenes/lang/envio.guardar_"));
        guardainfo.click();

        Thread.sleep(1000);

        driver.findElement(By.linkText("ACEPTAR")).click();

        Thread.sleep(2000);

        driver.quit();

    }
}
