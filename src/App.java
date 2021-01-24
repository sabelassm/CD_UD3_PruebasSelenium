import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");     

        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/sabelasobrinosanmartin/seleniumTest/pagina_web/index.html"); //Abrimos el fichero de pruebas combobox
        Thread.sleep(3000);

        /* BUSQUEDA TEXTO */
        driver.get("https://www.wikipedia.es"); //Abrimos la p�gina de la wikipedia en el navegador que acabamos de abrir
        Thread.sleep(2000); //Para ver la ejecuci�n, detenemos el hilo 2 segundos
        
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        
        Thread.sleep(2000);
        searchBox.sendKeys("Selenium");
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(2000);
        
        String titulo=driver.getTitle();
        System.out.println(titulo); //Visualizamos en consola el t�tulo de la p�gina que se abre como resultado de la b�squeda
        

        /* PÁGINA ALEATORIA */
        driver.findElement(By.id("n-randompage")).click();//Hacemos click en el enlace de p�gina aleatoria que hay en el men� izquierdo de wikipedia
       // driver.findElement(By.linkText("Pagina aleatoria")).click();//Hacemos click en el enlace de p�gina aleatoria que hay en el men� izquierdo de wikipedia
        
        Thread.sleep(2000);
        titulo = driver.getTitle();//Obtenemos el t�tulo de la p�gina web aleatoria que nos abri� wikipedia
        System.out.println(titulo); //Visualizamos en consola el t�tulo de la p�gina que se abri�

            
        /* COMBO BOX SIMPLE */
        Select comboboxSimple = new Select(driver.findElement(By.id("combobox1")));
        comboboxSimple.selectByIndex(2);//0 es el primer elemento

        Thread.sleep(2000);
        
        //OJO: no se puede deseleccionar en un combo Simple
        driver.findElement(By.id("enviaComboboxes")).click();//hacemos click sobre el bot�n enviar
        Thread.sleep(2000);
        /* COMBO BOX MULTIPLE */
         Select comboboxMultiple = new Select(driver.findElement(By.id("combobox2")));
        comboboxMultiple.selectByIndex(0);//0 es el primer elemento del combo
        comboboxMultiple.selectByValue("pera");//seleccionamos por el texto del atributo value de las opciones
        comboboxMultiple.selectByVisibleText("Plátano");//seleccionamos por el texto visible de las opciones

        Thread.sleep(2000);//esperamos 2 segundos para poder visualizar las acciones ejecutadas
        
        comboboxMultiple.deselectByIndex(1); //Deseleccionamos la segunda opci�n del combo m�ltiple que previamente habiamos seleccionado
        //OJO: no se puede deseleccionar en un combo Simple
        
        driver.findElement(By.id("enviaComboboxes")).click();;//hacemos click sobre el bot�n enviar
        

        /*RADIO*/

        
        WebElement aguaBoton = driver.findElement(By.cssSelector("[name='bebida'][value='agua']"));
        aguaBoton.click();
        Thread.sleep(2000);		
        
        //Usamos xpath para localizar el radioButton comida cuyo valor sea dorada
        WebElement doradaBoton = driver.findElement(By.xpath("//input[@name='comida' and @value='dorada']"));
        doradaBoton.click();
        Thread.sleep(2000);						
        
        WebElement botonRadioButton = driver.findElement(By.id("enviaRadiobutton"));//hacemos click sobre el bot�n enviar
        botonRadioButton.click();
        

        /*CALENDARIO*/

        
        WebElement calendario = driver.findElement(By.name("fecha"));
        calendario.sendKeys("15012021");//Introducimos la fecha 15/01/2021
        calendario.sendKeys(Keys.TAB);//Introduce la tecla Tabulador para poder cambiar a escribir la hora en el campo
        calendario.sendKeys("1030");//Escribimos la hora 10:30 en el campo
        

        Thread.sleep(5000);
        driver.quit();

    }
}
