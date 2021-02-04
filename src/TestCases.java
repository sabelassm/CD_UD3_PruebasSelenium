import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
	
	private WebDriver driver;
	

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        driver = new ChromeDriver();

	}
	
	@Test
	public void realizarBusquedaWiki() {
		
		driver.get("https://www.wikipedia.es"); //Abrimos la p�gina de la wikipedia 						

						
			WebElement searchBox = driver.findElement(By.id("searchInput"));
			WebElement searchButton = driver.findElement(By.id("searchButton"));
			 String tituloSeleniumEsperado = "Selenium";

			searchBox.sendKeys("Selenium");//Escribimos el texto a buscar en la caja de texto
			
			searchButton.click();//Ejecutamos la accion de click para que realice la b�squeda
			
			WebElement tituloPrimeraPagina = driver.findElement(By.id("firstHeading"));//Recuperamos el elemento que tiene el titulo en la p�gina abierta
		
			String titulo=tituloPrimeraPagina.getText();//Obtenemos el titulo de la pagina abierta

			assertEquals(tituloSeleniumEsperado,titulo);//Comprobamos el titulo obtenido con el esperado
			
			
	}//Fin realizarBusquedawiki
	
	@Test
	public void test_WikiRandomAndBack() {
		/*******
		 * Vamos abrir una página de la wikipedia, pulsaremos en el enlace Pagina Aleatoria y a continuaci�n,
		 * pulsaremos sobre Go Back del navegador
		 *****/
		
			 String tituloHomeEsperado="Wikipedia, la enciclopedia libre";
			driver.get("https://www.wikipedia.es"); //Abrimos la p�gina de la wikipedia 						
			WebElement randomPage = driver.findElement(By.linkText("Página aleatoria"));
			randomPage.click();//Ejecutamos la accion de click para que pinche en el enlace
			
			driver.navigate().back();//Ejecutamos el Atrás del navegador para cargar de nuevo la p�gina inicial
			
			String titulo=driver.getTitle();//Obtenemos el titulo de la pagina abierta
			
			assertEquals(tituloHomeEsperado,titulo);//Comprobamos el titulo obtenido con el esperado
			
			
	}//Fin test_WikiRandomAndBack
	
	@Test
	public void test_busquedas(){
	int i;
	
    for (i=0;i<1000;i++){
    WebElement searchBox = driver.findElement(By.id("SiteNavSearch"));
    
    searchBox.sendKeys("sudadera");
   
    searchBox.submit();
        }
    driver.close();
	}
	@Test
	public void test_Busquedasinresultado(){
		String busqueda = "RESULTADOS DE LA BÚSQUEDA 0 resultaos para 1E3" ; 
		WebElement searchBox = driver.findElement(By.id("SiteNavSearch"));
		
		searchBox.sendKeys("1E3");   
		searchBox.submit();
		WebElement resultado = driver.findElement(By.id("MainContent"));
		System.out.println(resultado.getText());
		assertEquals(busqueda,resultado.getText());    
		driver.close();
		

	}
	@After
	public void shutdown() {
		driver.quit();
	}
}
