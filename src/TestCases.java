import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {

	private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/silvi/OneDrive/Documentos/VisualStudioCode/UnpackedTest/driver/chromedriver.exe");

        driver = new ChromeDriver();
    }


    @Test
    public void añadirProductoAgotado() throws InterruptedException {

        driver.get("https://www.unpackedshop.es");
        Thread.sleep(7000);
        WebElement popUp = driver.findElement(By.className("popup_close"));
        popUp.click();
        WebElement avisoCookies = driver.findElement(By.className("cerrar_aviso_cookies"));
        avisoCookies.click();

        WebElement desplegable = driver.findElement(By.linkText("DÍA A DÍA"));
        Actions mover = new Actions(driver);
        mover.moveToElement(desplegable).perform();
        WebElement cocina = driver.findElement(By.linkText("Cocina"));
        cocina.click();
        WebElement siguiente = driver.findElement(By.linkText("Siguiente"));
        siguiente.click();
        WebElement producto = driver.findElement(By.linkText("PAÑOS REUTILIZABLES"));
        producto.click();
        WebElement añadir = driver.findElement(By.className("btn_comprar"));
        añadir.click();

        // comprobamos el número de elementos del carrito
	String elemCarritoEsperado = "0";
	WebElement elemCarrito = driver.findElement(By.className("nProductosCarrito"));
	String carrito = elemCarrito.getText();
	assertEquals(elemCarritoEsperado, carrito);

    }// Fin AñadirProductoAgotado CPF1


    @Test
    public void añadirMuchaCantidadProducto() throws InterruptedException {

        driver.get("https://www.unpackedshop.es");
        Thread.sleep(7000);
        WebElement popUp = driver.findElement(By.className("popup_close"));
        popUp.click();
        WebElement avisoCookies = driver.findElement(By.className("cerrar_aviso_cookies"));
        avisoCookies.click();

        WebElement desplegable = driver.findElement(By.linkText("CUIDADO PERSONAL"));
        Actions mover = new Actions(driver);
        mover.moveToElement(desplegable).perform();

        WebElement facial = driver.findElement(By.linkText("Facial"));
        facial.click();

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

        driver.findElement(By.className("btn_comprar")).click();

        String avisoEsperado = "There was an error processing the request.";
        WebElement avisoError = driver.findElement(By.id("Apoyo_Mensaje_div_texto"));
        String error = avisoError.getText();
        assertEquals(avisoEsperado, error);

    }// Fin añadirMuchaCantidadProducto CPF2


    @Test
    public void aplicarCuponFalso() throws InterruptedException {

        driver.get("https://www.unpackedshop.es");
        Thread.sleep(7000);
        WebElement popUp = driver.findElement(By.className("popup_close"));
        popUp.click();
        WebElement avisoCookies = driver.findElement(By.className("cerrar_aviso_cookies"));
        avisoCookies.click();

        WebElement carroCompra = driver.findElement(By.className("carrito_li"));
        carroCompra.click();

        Thread.sleep(2000); // pongo tiempo de espera porque sino falla, como si no le diese tiempo de
                            // acceder al siguiente paso

        WebElement irCesta = driver
                .findElement(By.xpath("//div[@class='desp_cesta-int']//a//div[@class='desp_cesta-pagar']"));
        irCesta.click();

        // INTRODUCIMOS Y APLICAMOS CUPON
        WebElement cajaCupon = driver.findElement(By.id("txb_codDesc"));
        cajaCupon.sendKeys("1234abcd");
        cajaCupon.sendKeys(Keys.TAB);
        cajaCupon.sendKeys(Keys.ENTER);

        Thread.sleep(2000); // pongo tiempo de espera porque sino falla, como si no le diese tiempo de leer
                            // el mensaje

        String avisoEsperado = "El código del cupón no existe o ha expirado";
        WebElement avisoError = driver.findElement(By.id("Apoyo_Mensaje_div_texto"));
        String error = avisoError.getText();
        assertEquals(avisoEsperado, error);

    }// Fin aplicarCuponFalso CPF3


    @Test
    public void listaCorrecta() throws InterruptedException {

        driver.get("https://www.unpackedshop.es");
        Thread.sleep(7000);
        WebElement popUp = driver.findElement(By.className("popup_close"));
        popUp.click();
        WebElement avisoCookies = driver.findElement(By.className("cerrar_aviso_cookies"));
        avisoCookies.click();

        WebElement cuidadoPersonal = driver.findElement(By.linkText("CUIDADO PERSONAL"));
        cuidadoPersonal.click();

        String elementoEsperado1 = "FACIAL";
        String elementoEsperado2 = "CUERPO";
        String elementoEsperado3 = "HIGIENE BUCAL";
        String elementoEsperado4 = "MENSTRUAL";
        String elementoEsperado5 = "PELO";

        WebElement elemento1 = driver.findElement(By.linkText("FACIAL"));
        WebElement elemento2 = driver.findElement(By.linkText("CUERPO"));
        WebElement elemento3 = driver.findElement(By.linkText("HIGIENE BUCAL"));
        WebElement elemento4 = driver.findElement(By.linkText("MENSTRUAL"));
        WebElement elemento5 = driver.findElement(By.linkText("PELO"));

        String contenido1 = elemento1.getText();
        String contenido2 = elemento2.getText();
        String contenido3 = elemento3.getText();
        String contenido4 = elemento4.getText();
        String contenido5 = elemento5.getText();

        assertEquals(elementoEsperado1, contenido1);
        assertEquals(elementoEsperado2, contenido2);
        assertEquals(elementoEsperado3, contenido3);
        assertEquals(elementoEsperado4, contenido4);
        assertEquals(elementoEsperado5, contenido5);

    }// Fin listaCorrecta CPF4


    @Test
    public void suscripcionNewsletterFalsa() throws InterruptedException {

        driver.get("https://www.unpackedshop.es");
        Thread.sleep(7000);
        WebElement popUp = driver.findElement(By.className("popup_close"));
        popUp.click();
        WebElement avisoCookies = driver.findElement(By.className("cerrar_aviso_cookies"));
        avisoCookies.click();

        WebElement introduceEmail = driver.findElement(By.id("txb_newsletter_email"));
        introduceEmail.sendKeys("nnn@nn.nn");
        introduceEmail.sendKeys(Keys.TAB);
        introduceEmail.sendKeys(Keys.ENTER);

        String mensajeEsperado = "eMail no valido";
        WebElement mensajeError = driver.findElement(By.id("Apoyo_Mensaje_div_texto"));
        String mensaje = mensajeError.getText();
        assertEquals(mensajeEsperado, mensaje);

    }// Fin suscripcionNewsletterFalsa CPF5


    @Test
    public void registroExistente() throws InterruptedException {

        driver.get("https://www.unpackedshop.es");
        Thread.sleep(7000);
        WebElement popUp = driver.findElement(By.className("popup_close"));
        popUp.click();
        WebElement avisoCookies = driver.findElement(By.className("cerrar_aviso_cookies"));
        avisoCookies.click();

        WebElement logIn = driver.findElement(By.linkText("Login"));
        logIn.click();
        WebElement registrarse = driver.findElement(By.linkText("Registrarse"));
        registrarse.click();

        // FORMULARIO DE DATOS
        WebElement cajaEmail = driver.findElement(By.id("txb_email"));
        cajaEmail.sendKeys("silvia_lpez@hotmail.com");
        cajaEmail.sendKeys(Keys.TAB);
        WebElement confirmaEmail = driver.findElement(By.id("txb_email1"));
        confirmaEmail.sendKeys("silvia_lpez@hotmail.com");

        confirmaEmail.sendKeys(Keys.TAB);
        WebElement cajaNombre = driver.findElement(By.id("txb_nombre"));
        cajaNombre.sendKeys("Nnnn");

        cajaNombre.sendKeys(Keys.TAB);
        WebElement cajaApellidos = driver.findElement(By.id("txb_apellidos"));
        cajaApellidos.sendKeys("NNN NNN");

        cajaApellidos.sendKeys(Keys.TAB);
        WebElement cajaDNI = driver.findElement(By.className("CSS_KO"));
        cajaDNI.sendKeys("88888888N");

        cajaDNI.sendKeys(Keys.TAB);
        Select eligePais = new Select(driver.findElement(By.id("drop_pais")));
        eligePais.selectByIndex(65);

        WebElement pais = driver.findElement(By.id("drop_pais"));
        pais.sendKeys(Keys.TAB);
        Select eligeProvincia = new Select(driver.findElement(By.id("drop_provincia")));
        eligeProvincia.selectByIndex(13);

        WebElement provincia = driver.findElement(By.id("drop_provincia"));
        provincia.sendKeys(Keys.TAB);

        WebElement cajaPoblacion = driver.findElement(By.id("txb_poblacion"));
        cajaPoblacion.sendKeys("ddd");
        cajaPoblacion.sendKeys(Keys.TAB);

        WebElement cajaCP = driver.findElement(By.id("txb_codigoPostal"));
        cajaCP.sendKeys("ddd");
        cajaCP.sendKeys(Keys.TAB);

        WebElement cajaDireccion = driver.findElement(By.id("txb_direccion"));
        cajaDireccion.sendKeys("dddddd");
        cajaDireccion.sendKeys(Keys.TAB);

        WebElement cajaTlfn = driver.findElement(By.id("txb_tfn"));
        cajaTlfn.sendKeys("111222333");
        cajaTlfn.sendKeys(Keys.TAB);

        WebElement aceptaSuscripcion = driver.findElement(By.id("chkbx_newsletter"));
        aceptaSuscripcion.sendKeys(Keys.SPACE);
        aceptaSuscripcion.sendKeys(Keys.TAB);

        WebElement cajaPss = driver.findElement(By.id("txb_p1"));
        cajaPss.sendKeys("fff222");
        cajaPss.sendKeys(Keys.TAB);

        WebElement cajaPssR = driver.findElement(By.id("txb_p2"));
        cajaPssR.sendKeys("fff222");

        WebElement aceptaPrivacidad = driver
                .findElement(By.id("ckedit_usuario.legal_altausuario_1||/imagenes/lang/usuario.legal_altausuario_"));
        aceptaPrivacidad.click();

        WebElement guardainfo = driver.findElement(By.id("ckedit_envio.guardar_1||/imagenes/lang/envio.guardar_"));
        guardainfo.click();
        Thread.sleep(5000); // pongo tiempo de espera porque sino falla, como si no le diese tiempo de leer
                            // el mensaje

        String mensajeEsperado = "Ya existe una cuenta con el eMail \"silvia_lpez@hotmail.com\"";
        WebElement mensajeError = driver.findElement(By.id("Apoyo_Mensaje_div_texto"));
        String mensaje = mensajeError.getText();
        assertEquals(mensajeEsperado, mensaje);

    }// Fin registroExistente CPF6


    @After
    public void shutdown() {
        driver.quit();
    }
}
