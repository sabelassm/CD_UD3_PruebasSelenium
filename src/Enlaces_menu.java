import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Enlaces_menu {
    public static void main(String[] args) throws Exception {
        	// CARGAR DRIVER FIREFOX
    	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
      
        	// MENUS Y URLS
        // String[] menu = {"'Inicio'", "'Catálogo'", "'¿Quiénes somos?'"};  
        String [] url = {"https://www.rakayoclothing.com/", "https://www.rakayoclothing.com/collections/all", "https://www.rakayoclothing.com/pages/quienes-somos"};

    	// SAVEDATA
        File outFile = new File("resultados.txt");

        // PRUEBAS
        FileWriter outResultado = new FileWriter("resultados.txt");
        for(int i=0; i<3; i++) { 
        	// Para cada página en el menú, comprobar que todas tienen las rutas correctas
        		// Menú Inicio
        	driver.get(url[i]);
        	outResultado.write("Prueba " + (i+1) + " : Iniciar en " + driver.getTitle()+ "\n");
        	Thread.sleep(1000); 
        	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Inicio')]")).click();  // Selecciona el botón
        	outResultado.write("\t Botón inicio: Resultado " + driver.getTitle() + "\n");  // Resultado
        	Thread.sleep(1000); 
        		// Menú Catálogo
        	driver.get(url[i]);
        	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]")).click();  // Selecciona el botón
        	outResultado.write("\t Botón Catálogo: Resultado " + driver.getTitle() + "\n");  // Resultado
        	Thread.sleep(1000);
        	
        		//Menú Quienes Somos
        	driver.get(url[i]);
        	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), '¿Quiénes somos?')]")).click();  // Selecciona el botón
        	outResultado.write("\t Botón Quienes Somos: Resultado " + driver.getTitle() + "\n");  // Resultado
        	Thread.sleep(1000);
        }
        // Cerrar instancias
        outResultado.close();
        driver.quit();
    }
}