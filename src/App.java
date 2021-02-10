import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/rani/Documentos/2 - Apuntes/1A - DAW 1/Entornos de programacion/UD3/Tarea 3.2/CD_UD3_PruebasSelenium/driver/chromedriver");
        //Declaramos la instancia del navegador
        WebDriver driver = new ChromeDriver();
    //Para ver la ejecución, detenemos el hilo 5 segundos
    try {
        driver.get("https://www.wikipedia.es"); //Abrimos la página de la wikipedia en el navegador que acabamos de abrir
        Thread.sleep(2000); //Para ver la ejecución, detenemos el hilo 5segundos
        String titulo = driver.getTitle();//Obtenemos el título de la página web
        System.out.println(titulo);


        WebElement searchBox=driver.findElement(By.id("searchInput"));
        WebElement searchButton=driver.findElement(By.id("searchButton"));

        Thread.sleep(2000);
        searchBox.sendKeys("flor de lis");
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(2000);

    } catch (InterruptedException e) {
    e.printStackTrace();
    }
    //Una vez esperados los 5 segundos, detenemos el driver
    driver.quit();
    }
}
