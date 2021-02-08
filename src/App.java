import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        String username = "testejercicio@hotmail.com";
        String pass = "ejercicio11";

        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.pccomponentes.com/");

        // ! Imprimir título de la página
        String titulo = driver.getTitle();
        System.out.println(titulo);
        System.out.println("====================================================");

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
        
        // ! ===============  SELECCIONAR ELEMENTO Y AÑADIR AL CARRITO  =============== ! //
        WebElement itemButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[4]/div[4]/div[1]/div/div/div[2]/a"));
        itemButton.click();
        Thread.sleep(3000);

        WebElement addToCartButton = driver.findElement(By.id("add-cart"));
        addToCartButton.click();
        Thread.sleep(3000);

        // ! ===============  LOGOUT Y LOGIN  =============== ! //
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

        driver.quit();
    }
}