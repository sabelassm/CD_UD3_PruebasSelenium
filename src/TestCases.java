import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
	
	private WebDriver driver;
	

	@Before
	public void setUp() {
		/**
		 * para usar o chromedriver
		 */
		// System.setProperty("webdriver.chrome.driver", "/Users/simon/CD_UD3_PruebasSelenium/driver/chromedriver.exe");     
       // driver = new ChromeDriver();

		/**
		 * para usar o firefoxdriver
		 */
	   System.setProperty("webdriver.gecko.driver","/Users/simon/CD_UD3_PruebasSelenium/driver/geckodriver.exe");
	   DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette",true);
		driver = new FirefoxDriver();

	}
	
	@Test
	public void realizarBusqueda() throws InterruptedException {
		
		driver.get("https://www.ebay.es/"); //Abrimos la página objeto de prueba					

		String cadena = "*-**/";
						
			WebElement searchBox = driver.findElement(By.id("gh-ac"));
			WebElement searchButton = driver.findElement(By.id("gh-btn"));

			searchBox.sendKeys(cadena);//Escribimos el texto a buscar en la caja de texto
			
			searchButton.click();//Ejecutamos la accion de click para que realice la b�squeda
			Thread.sleep(2000);
			try{
			WebElement tituloPrimeraPagina = driver.findElement(By.className("x-motors-card-partial-token__message"));//Recuperamos el elemento que tiene el titulo en la p�gina abierta
		
			String titulo=tituloPrimeraPagina.getText();//Obtenemos el titulo de la pagina abierta

			assertEquals(cadena,titulo);//Comprobamos el titulo obtenido con el esperado
			}catch(NoSuchElementException e){
				assertEquals(1, 2);
				System.out.println("Error, no se encuentra el espacio de respuesta");
			}
			
	}//Fin
	
	@Test
	public void test_accesoSerccion() {
		/*******
		 * Vamos a acceder a la seccion electronica
		 *****/
		
			 String tituloHomeEsperado="Electrónica | Compra online en eBay";
			driver.get("https://www.ebay.es/"); //Abrimos la p�gina de la wikipedia 						
			WebElement randomPage = driver.findElement(By.linkText("Electrónica"));
			randomPage.click();//Ejecutamos la accion de click para que pinche en el enlace
			
			
			String titulo=driver.getTitle();//Obtenemos el titulo de la pagina abierta
			
			assertEquals(tituloHomeEsperado,titulo);//Comprobamos el titulo obtenido con el esperado
			
			
	}//Fin 

	@Test
	public void test_menu_busqueda() throws InterruptedException {
		/*******
		 *Realiza una busqueda rellenando distintos campos en un furmulario
		 
		 *****/
		
			 String tituloHomeEsperado="llave en venta - | eBay";
			driver.get("https://www.ebay.es/"); //Abrimos la p�gina de la wikipedia 						
			WebElement randomPage = driver.findElement(By.id("gh-as-a"));
			randomPage.click();//Ejecutamos la accion de click para que pinche en el enlace
			Thread.sleep(2000);
			//obtenemos varios elementos y los rellenamos
			WebElement serchbox = driver.findElement(By.id("_nkw"));
			serchbox.sendKeys("llave");
			WebElement check = driver.findElement(By.id("LH_TitleDesc"));
			check.click();
			WebElement radioLoc = driver.findElement(By.id("LH_LocatedInRadio"));
			radioLoc.click();
			Select distancia1 = new Select(driver.findElement(By.id("_salicSelect")));
			distancia1.selectByVisibleText("Andorra");
			
			
			WebElement botonBuscar = driver.findElement(By.id("searchBtnLowerLnk"));
			botonBuscar.click();
			Thread.sleep(2000);

			String titulo=driver.getTitle();//Obtenemos el titulo de la pagina abierta
			
			assertEquals(tituloHomeEsperado,titulo);//Comprobamos el titulo obtenido con el esperado
			
			
	}//Fin

	@Test
	public void test_añadir_cesta() throws InterruptedException {
		/*******
		 *añade un producto a cesta
		 *****/
		
			 String tituloHomeEsperado="Cesta de la compra (1 artículo)";
			 //entramos na paxina dun producto
			driver.get("https://www.ebay.es/itm/Silla-de-Oficina-Giratoria-Escritorio-de-Tela-de-Malla-Sillon-Ruedas-Despacho/363080295777?_trkparms=pageci%3A85da842b-67f9-11eb-8f92-1eed3905e9c1%7Cparentrq%3A741b80a51770ad33f85a94a5fffe9880%7Ciid%3A1"); //Abrimos la p�gina de la wikipedia 						
			//obtemos e clicamos o boton de añadir a cesta
			WebElement anhadir = driver.findElement(By.id("isCartBtn_btn"));
			anhadir.click();//Ejecutamos la accion de click para que pinche en el enlace

			WebElement titulo=driver.findElement(By.className("main-title"));//Obtenemos el titulo de la pagina abierta
			String vTitulo = titulo.getText();
			
			assertEquals(tituloHomeEsperado,vTitulo);//Comprobamos el titulo obtenido con el esperado
			
			
	}//Fin

	@After
	public void shutdown() {
		driver.quit();
	}
}
