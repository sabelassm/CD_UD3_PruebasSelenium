import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

       

        //PRUEBA CON LA PÁGINA DE ELPAIS.COM

        
       

        /*HACER CLICKS EN LA SECCIÓN DE METEREOLOGÍA
        A VECES FALLA DEPENDIENDO LA VELOCIDAD CON LA QUE SE
        CARGA LA PÁGINA(solo se prueba con dos clicks)*/

        int i;
        for (i = 1; i <= 2; i++) {
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.elpais.com");

            Thread.sleep(3000);

            WebElement agree = driver.findElement(By.id("didomi-notice-agree-button"));
            agree.click();
            

            WebElement repeticion = driver.findElement(By.className("icon_services_weather"));

            repeticion.click();

            driver.quit();
            Thread.sleep(1000);
        }

        /* Introducir caracteres no latinos en el apartado "suscribirse" */

        Thread.sleep(2000);

        

        WebDriver driver1 = new ChromeDriver();

        driver1.get("https://www.elpais.com");

        WebElement agree = driver1.findElement(By.id("didomi-notice-agree-button"));
        agree.click();

        Thread.sleep(3000);
        WebElement suscripcion = driver1.findElement(By.className("user_login"));
        suscripcion.click();

        WebElement nuevacuenta = driver1.findElement(By.className("linkSocial"));
        nuevacuenta.click();

        WebElement correo = driver1.findElement(By.id("subsEmail"));
        correo.sendKeys("\u0412\u0415\u0420\u0422\u041E\u041D@gmail.com");

        WebElement contraseña = driver1.findElement(By.id("subsPassword"));
        contraseña.sendKeys("12345678");

        Thread.sleep(3000);

        driver1.quit();

        // probar si existe la politica de protección de datos


        WebDriver driver2 = new ChromeDriver();

        driver2.get("https://www.elpais.com");

        WebElement agree1 = driver2.findElement(By.id("didomi-notice-agree-button"));
        agree1.click();

        Thread.sleep(3000);
        WebElement suscripcion1 = driver2.findElement(By.className("user_login"));
        suscripcion1.click();

        WebElement nuevacuenta1 = driver2.findElement(By.className("linkSocial"));
        nuevacuenta1.click();
        Thread.sleep(1000);

        WebElement prot_datos = driver2.findElement(By.partialLinkText("Condiciones"));
        prot_datos.click();
        Thread.sleep(3000);
        driver2.quit();
    

    //introducir numeros en el buscador de noticias
    

    WebDriver driver3 = new ChromeDriver();

    driver3.get("https://www.elpais.com/buscador");

    WebElement agree2 = driver3.findElement(By.id("didomi-notice-agree-button"));
        agree2.click();
        
        
        Thread.sleep(1000);

        WebElement buscador1 = driver3.findElement(By.xpath("//input[@type='text']"));

        buscador1.click();

        double a = Math.random()*100000+1;  //genero un número aleatorio
        String b = String.valueOf(a);

        buscador1.sendKeys(b);

        WebElement buscador2 = driver3.findElement(By.xpath("//input[@type='submit']"));

        buscador2.click();

        Thread.sleep(3000);

        

        driver3.quit();


        //introducir un correo con numeros cuando se abre una cuenta
        

        

        WebDriver driver4 = new ChromeDriver();

        driver4.get("https://www.elpais.com");

        WebElement agree3 = driver4.findElement(By.id("didomi-notice-agree-button"));
        agree3.click();

        Thread.sleep(3000);
        WebElement suscripcion2 = driver4.findElement(By.className("user_login"));
        suscripcion2.click();

        WebElement nuevacuenta2 = driver4.findElement(By.className("linkSocial"));
        nuevacuenta2.click();

        double corr = Math.random()*1000+1;
        String cad = String.valueOf(corr);

        WebElement correo1 = driver4.findElement(By.id("subsEmail"));
        correo1.sendKeys(cad+"@gmail.com");

        WebElement contraseña2 = driver4.findElement(By.id("subsPassword"));
        contraseña2.sendKeys("12345678");

        Thread.sleep(3000);

        driver4.quit();


    }
}
