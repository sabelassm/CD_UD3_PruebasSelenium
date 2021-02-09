import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
	
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;


	@Before
	public void setUp() {

		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Irene/SeleniumTest/driver/chromedriver.exe");  

		driver = new ChromeDriver();
		driver.manage().window().maximize();				
	}
	
	
	@Test 
	public void testPF1_FormularioContacto() throws InterruptedException {
	
		String errorEsperado="Este campo es obligatorio."; //Texto que debemos obtener 
		driver.get("https://www.pccomponentes.com"); //Abrimos la página
		Thread.sleep(1000); 
		WebElement contacto = driver.findElement(By.linkText("Contacto")); //Seleccionamos Contacto	
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contacto); //Nos desplazamos hasta el elemento
		contacto.click(); //Hacemos click
		Thread.sleep(1000);

		
		WebElement opciones= driver.findElement(By.id("mostrarconsulta")); //Marcamos la zona para elegir el tipo de contacto
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opciones); //Nos desplazamos a ella
		WebElement ticket= driver.findElement(By.xpath("//span[text()='Ticket']"));	// Seleccionamos la opción Ticket
		ticket.click(); //Hacemos click en ella
		Thread.sleep(1000);

		WebElement enviarFormulario = driver.findElement(By.id("supportTicket_send")); //Seleccionamos enviar el formulario
		enviarFormulario.click(); 	//Enviamos el formulario vacío
		Thread.sleep(1000);
		String error = driver.findElement(By.id("supportTicket_name-error")).getText(); //Sacamos el tecto que devuelve 
		assertEquals(errorEsperado, error); //Lo comparamos con el que esperábamos

	}
	

	@Test 
	public void testPF3_CajaBuscarTexto() throws InterruptedException {
		
		driver.get("https://www.pccomponentes.com"); //Abrimos la página de pccomponentes
		
		Thread.sleep(1000); //Para ver la ejecución, detenemos el hilo 2 segundos
		String busqueda= "Monitores"; // Guardamos el texto que queremos buscar
		
        WebElement searchBox = driver.findElement(By.id("ais-autocomplete-selectized"));  //Seleccionamos la caja de búsqueda  
		Thread.sleep(1000);
		
        searchBox.sendKeys(busqueda); //Escribimos el texto guardado anteriormente
		Thread.sleep(1000);
		
        searchBox.sendKeys(Keys.ENTER); //Pulsamos Enter para enviar
        Thread.sleep(500);

        String titulo= driver.findElement(By.xpath("//span[@class='naranja']//strong[1]")).getText();  //Sacamos el texto de cabecera de la búsqueda realizada
        assertEquals("\"" + busqueda + "\"" , titulo); //Lo comparamos con el buscado      
	}


	@Test
	public void testPF4_CarritoVariasPestañas() throws InterruptedException {

				
		driver.get("https://www.pccomponentes.com"); //Abrimos la página de pccomponentes
		Thread.sleep(1000); //Para ver la ejecución, detenemos el hilo 2 segundos
		
		WebElement objeto1 = driver.findElement(By.xpath("//div[@id='producto-interesa']")); //Seleccionamos con el xpath uno de los productos recomendados
		objeto1.click(); //Abrimos la página de ese producto
		Thread.sleep(1000);

		WebElement añadir = driver.findElement(By.id("add-cart")); //Seleccionamos el carrito con el id
		añadir.click(); 
		Thread.sleep(1000);

		((JavascriptExecutor)driver).executeScript("window.open()"); //Abrimos una nueva pestaña en el navegador con la dirección de la tienda
   		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
   		driver.switchTo().window(tabs.get(1));
    	driver.get("https://www.pccomponentes.com");
		Thread.sleep(1000);
	
				
		WebElement objeto2 = driver.findElement(By.xpath("(//div[@id='producto-interesa'])[3]")); //Seleccionamos otro producto de la lista de recomendaciones
		objeto2.click();
		Thread.sleep(1000);
		WebElement añadir2 = driver.findElement(By.id("add-cart")); //La añadimos al carrito
		añadir2.click();
		Thread.sleep(2000);
        
		String numeroEsperado="2";

		String numeroObtenido = driver.findElement(By.xpath("(//span[text()='2'])[2]")).getText();
		assertEquals(numeroEsperado, numeroObtenido);	//Comprobamos que el numero de objetos en el carrito es 2, que son los que hemos añadido
	}


@Test
	public void testPF5_MenuFiltros() throws InterruptedException {
		
		Actions builder =new Actions(driver);
		driver.get("https://www.pccomponentes.com"); //Abrimos la página de pccomponentes
		Thread.sleep(2000); //Para ver la ejecución, detenemos el hilo 2 segundos
		
		WebElement categorias = driver.findElement(By.className("c-main-menu__name")); //Seleccionamos el menú con la clase
		categorias.click(); //Abrimos el menú
		Thread.sleep(500);

		WebElement ordenadores = driver.findElement(By.linkText("Ordenadores")); //Seleccionamos la categoría ordenadores
		builder.moveToElement(ordenadores).perform(); //Nos desplazamos hasta ordenadores para que se desplieguen las categorías
		Thread.sleep(500);

		WebElement verPortatiles = driver.findElement(By.linkText("Ver todos los portátiles")); //Seleccionamos los portátiles
		builder.moveToElement(verPortatiles).perform();
		verPortatiles.click(); 
		Thread.sleep(500);


		WebElement marca = driver.findElement(By.linkText("Acer")); //Seleccionamos el menú con la clase
		marca.click();

		WebElement tipo = driver.findElement(By.linkText("Gaming")); //Seleccionamos el menú con la clase
		tipo.click();
		Thread.sleep(1000);

		String portatilesFiltros = driver.findElement(By.tagName("h1")).getText();

		String esperado="Portátiles Acer Gaming";

		assertEquals(esperado, portatilesFiltros);		
	}
	
	
	@Test 
	public void testPF6_CuentaNueva() throws InterruptedException {
		driver.get("https://www.pccomponentes.com"); //Abrimos la página de pccomponentes
		Thread.sleep(1000); //Para ver la ejecución, detenemos el hilo 2 segundos

		WebElement miCuenta = driver.findElement(By.linkText("Mi cuenta")); //Seleccionamos con el xpath uno de los productos recomendados
		miCuenta.click(); //Abrimos la página de ese producto
		Thread.sleep(1000);

		WebElement crearCuenta = driver.findElement(By.xpath("//div[text()='Crear cuenta']")); //Seleccionamos con el xpath uno de los productos recomendados
		crearCuenta.click(); //Abrimos la página de ese producto
		Thread.sleep(1000);

		String tituloEsperado = "Crear cuenta";
		String tituloRecibido = driver.findElement(By.tagName("h1")).getText();
		assertEquals(tituloEsperado, tituloRecibido);		
	}

	@After
	public void shutdown() {
		driver.quit();
	}

}
