import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
    private WebDriver driver;
    private String driverRoute = "E:/CICLO/Entornos de desarrollo/Pruebas Salva/SeleniumPCComponentes/TestCompleto/driver/chromedriver.exe";
    private String siteUrl = "https://www.pccomponentes.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverRoute);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("=================== TESTING SETUP ===================");
    }

    @Test // ! -----------------------> F2
    // * La cantidad de elementos en carrito al cerrar e iniciar sesión debe ser 0
    public void testCarritoSesion() throws InterruptedException {
        String username = "testejercicio@hotmail.com";
        String pass = "ejercicio11";
        driver.get(siteUrl);

        // * ===============  LOGIN  =============== * //
        WebElement goToLoginButton = driver.findElement(By.className("qa-user-login-button"));
        goToLoginButton.click();

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/form/button[2]"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(pass);
        loginButton.click();
        Thread.sleep(3000);

        // * ===============  COOKIE  =============== * //
        WebElement cookieButton = driver.findElement(By.className("accept-cookie"));
        cookieButton.click();
        Thread.sleep(3000);
        
        // * ===============  SELECCIONAR ELEMENTO Y AÑADIR AL CARRITO  =============== * //
        WebElement itemButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[4]/div[4]/div[1]/div/div/div[2]/a"));
        itemButton.click();
        Thread.sleep(3000);

        WebElement addToCartButton = driver.findElement(By.id("add-cart"));
        addToCartButton.click();
        Thread.sleep(3000);

        // * ===============  LOGOUT Y LOGIN  =============== * //
        WebElement menuButton = driver.findElement(By.id("user-menu-panel"));
        menuButton.click();
        Thread.sleep(3000);
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/header/div[3]/ul/li[2]/ul/li[6]/a"));
        logoutButton.click();
        Thread.sleep(3000);

        // * Hay que volver a establecer las variables de los elementos por cambio de página
        goToLoginButton = driver.findElement(By.className("qa-user-login-button"));
        goToLoginButton.click();
        usernameInput = driver.findElement(By.name("username"));
        passwordInput = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/form/button[2]"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(pass);
        loginButton.click();
        Thread.sleep(3000);

        // * OBTENER NÚMERO DE ELEMENTOS EN CARRITO ! //
        WebElement cartLabel = driver.findElement(By.className("js-units"));
        assertEquals("0", cartLabel.getText());
    }

    @Test // ! -----------------------> F3
    // * Comprobación de mail válido
    public void comprobacionValidedMail() throws InterruptedException {
        driver.get(siteUrl);
        driver.manage().window().maximize();

        // * =============== LOGIN =============== * //
        WebElement goToLoginButton = driver.findElement(By.className("qa-user-login-button"));
        String createmail = "estemailnoexisteporquelodigoyo892hotmail.com";
        goToLoginButton.click();
        Thread.sleep(3000);

        // * =============== Pulsar Boton Crear =============== * //
        WebElement clickCreateButton = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/form/a"));
        clickCreateButton.click();
        Thread.sleep(3000);

        // * =============== Introducir E-mail =============== * //
        WebElement createMailInput = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/form/div[4]/div/input"));
        createMailInput.sendKeys(createmail);
        Thread.sleep(3000);
        
        // * OBTENER MENSAJE ! //
        WebElement messageLabel = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/form/div[4]/span"));
        assertEquals("¡Ey! Tu e-mail debe contener @ y dominio", messageLabel.getText());
    }

    @Test // ! -----------------------> F5
    public void comprobacionNumeroTelefono() throws InterruptedException {
        String username = "testejercicio@hotmail.com";
        String pass = "ejercicio11";
        String badNumber = "98874541A";
        driver.get(siteUrl);

        // ! ===============  LOGIN  =============== ! //
        WebElement goToLoginButton = driver.findElement(By.className("qa-user-login-button"));
        goToLoginButton.click();

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/form/button[2]"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(pass);
        loginButton.click();
        Thread.sleep(3000);

        // ! ===============  COOKIE  =============== ! //
        WebElement cookieButton = driver.findElement(By.className("accept-cookie"));
        cookieButton.click();
        Thread.sleep(3000);
        
        // ! ===============  IR A MI CUENTA =============== ! //
        WebElement menuButton = driver.findElement(By.id("user-menu-panel"));
        menuButton.click();
        Thread.sleep(3000);
        WebElement miCuentaButton = driver.findElement(By.className("qa-user-login-sub-4"));
        miCuentaButton.click();
        Thread.sleep(3000);
        
        // ! ===============  IR A AÑADIR DIRECCION =============== ! //
        WebElement anadirDirecButton = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div[2]/div[9]/button"));
        anadirDirecButton.click();
        Thread.sleep(3000);
        
        // ! ===============  IR A AÑADIR TELEFONO INCORRECTO =============== ! //
        WebElement phoneInput = driver.findElement(By.id("userNewShippingAddress_cellPhone"));
        phoneInput.sendKeys(badNumber);
        phoneInput.sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        // * OBTENER MENSAJE ! //
        WebElement messageLabel = driver.findElement(By.id("userNewShippingAddress_cellPhone-error"));
        assertEquals("Por favor, escribe sólo dígitos.", messageLabel.getText());
        // assertTrue(messageLabel.getText().length() == 0);
    }

    @Test // ! -----------------------> F7
    public void testAvisoStock() throws InterruptedException {
        String mail = "estamailnoexisteporquelodigoyo389@gmail.com";
        driver.get("https://www.pccomponentes.com/amd-ryzen-threadripper-3960x");

        // * =============== Pulsar Avisame =============== * //
        WebElement goToAvisameButton = driver.findElement(By.id("notify-me"));
        goToAvisameButton.click();

        // * =============== <Escribir> Notificacion. =============== * //
        WebElement goToNotifyInput = driver.findElement(By.id("Notify_email"));
        goToNotifyInput.sendKeys(mail);

        // * =============== <Pulsar Boton Check =============== * //
        WebElement condiciones = driver.findElement(By.className("c-indicator"));
        condiciones.click();

        // * =============== <Pulsar Boton Enviar =============== * //
        WebElement buttonSend = driver.findElement(
                By.xpath("/html/body/div[3]/div[2]/div/div[4]/div[1]/div[6]/div[2]/div/form/div[1]/div[3]/button"));
        buttonSend.click();
        
        // * OBTENER MENSAJE ! //
        WebElement messageLabel = driver.findElement(By.id("alerta-00"));
        assertEquals("El aviso se ha registrado correctamente", messageLabel.getText());
        // assertTrue(messageLabel.getText().length() == 0);
        
    }

    @Test // ! -----------------------> F8
    public void testBusquedaErronea() throws InterruptedException {
        driver.get(siteUrl);
 String textoPrueba = "@@@ºº!!";
        WebElement searchInput = driver.findElement(By.id("ais-autocomplete-selectized"));
        searchInput.sendKeys(textoPrueba);
        searchInput.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        // * OBTENER MENSAJE ! //
        WebElement messageLabel = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/div/div/h1/span[2]"));
        assertEquals("\"" + textoPrueba + "\"", messageLabel.getText());
    } 

    @After
    public void shutdown() {
        driver.quit();
    }

}