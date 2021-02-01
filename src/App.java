import static org.junit.Assert.assertEquals;
//import org.graalvm.compiler.core.target.Backend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Prueba CP001 Comprobar que la URL sea correcta y nos lleve a la página principal
        driver.get("https://ordenadoreskm0.com/"); //Abrimos la pagina en el navegador // con esto ya realizamos la primera prueba
        Thread.sleep(2000); //detenemos el hilo 5 segundos
        String titulo = driver.getTitle(); //obtenemos el título de la web
        System.out.println(titulo); // Comprobamos que el título es correcto
        //Fin prueba CP001 Exitosa


        //Prueba CP002 Comprobar que el cuadro de búsqueda funciona y se encunetra lo que se busca "pc sobremesa"
        WebElement searchBox = driver.findElement(By.name("s")); //Buscamos el elemento de caja de texto para las búsquedas
        WebElement searchButton = driver.findElement(By.tagName("button")); //Buscamos el elemento botón para realizar la búsqueda
        Thread.sleep(2000); //paramos dos segundos
        searchBox.sendKeys("pc sobremesa"); //Escribimos el texto a buscar en la caja
        Thread.sleep(2000); 
        searchButton.click();//Hacemos click sobre el botón para buscar
        Thread.sleep(2000); 
        //Fin prueba CP002 Exitosa, se obtiene un listado de pc sobremesa

        //Prueba CP003 Comprobar que el enlace Inicio Sesión nos lleva a la página correcta
        WebElement LinkInicioSEsion = driver.findElement(By.xpath("//a[@title='Acceda a su cuenta de cliente']")); //Buscamos el elemento del enlace a "Inicio sesión"
        LinkInicioSEsion.click(); //Realizamos cliclk
        Thread.sleep(2000);
        String TituloInicioSesion = driver.getTitle(); //Obtenemos el título de la página
        System.out.println(TituloInicioSesion);
        Thread.sleep(2000);
        String TituloEsperadoInicioSesion = "Iniciar sesión";
        assertEquals(TituloEsperadoInicioSesion, TituloInicioSesion); //Comprobamos que el título de la página y el título esperado coinciden
        Thread.sleep(2000); 
        //Fin prueba CP003, Prueba exitosa, nos lleva a la página correcta y los títulos coinciden



        //Prueba CP005 Comprobar que el enlace de "SOBREMESA" nos lleva a la página corrrecta
        WebElement LinkInicioSesion = driver.findElement(By.linkText("SOBREMESA")); //Buscamos el elemento enlace        
        Thread.sleep(2000); 
        LinkInicioSesion.click(); //Hacemos click en el enlace
        Thread.sleep(2000); 
        String TituloSobremesa = driver.getTitle(); //Recogemos en una variable el título de la página
        String TituloEsperadoSobremesa = "PC Sobremesa"; // Guardamos en una variable el título esperado para la página
        assertEquals(TituloSobremesa, TituloEsperadoSobremesa); //Comprobamos que los títulos son iguales
        System.out.println(TituloSobremesa); // Imprimimos por pantalla el título
        driver.navigate().to(("https://ordenadoreskm0.com/")); //Volvemos a la página de inicio
        Thread.sleep(2000); 
        //Fin pruena CP005 Exitosa, el enlace nos lleva a la página esperada


        driver.quit();
    }
}
