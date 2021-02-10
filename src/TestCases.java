import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
	
	private WebDriver driver;
	
	/* Conseguí programar las acciones pero, como verás,
	faltan la mayor parte de indicaciones de cuál debe ser el restultado...
	En algunos casos no supe cómo decirle qué es lo que se necesita comprobar exactamente y en otros está mal
	(por ejemplo, en "pruebacodigopostal" no sé decirle que si el resultado es que si nos permite
	realizar el resgistro es que hay un fallo, o en "pruebavariasunidades" no sé hacerle extraer el número
	existente después de pulsar las teclas + y -, he intentado varias formas pero no lo logré).

	Entrego lo que tengo hecho, pero seguiré practicando por mi cuenta de todos modos.

	*/

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:/Cosas/FP/git/tarea3ed/CD_UD3_PruebasSelenium/driver/chromedriver.exe");     

        driver = new ChromeDriver();

	}
	
	@Test
	public void realizarBusquedaAcentos() throws InterruptedException { // Nombre caso de prueba: CPF3
		
		driver.get("https://www.totemvertigo.com"); 					

						
			WebElement searchBox = driver.findElement(By.id("busqueda")); //identifica caja de búsqueda

			searchBox.sendKeys("sistémá");//Escribimos el texto a buscar en la caja de texto
			
			searchBox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			
			
			//Tiene que haber resultados en la búsqueda
			
			
	}//Fin
	
	@Test
	public void pruebacodigopostal() throws InterruptedException { //Nombre caso de prueba: CPF1
		
		driver.get("https://www.totemvertigo.com/registro.php"); //Abre la página de registro						

						
			WebElement registerBox = driver.findElement(By.id("Email"));
			registerBox.sendKeys("correoemail@gmail.com");//Escribe la dirección de e-mail	

			WebElement passBox = driver.findElement(By.id("login-pass"));
			passBox.sendKeys("unpasS1230");//Escribe contraseña

			WebElement passrepeatBox = driver.findElement(By.id("Password2"));
		   passrepeatBox.sendKeys("unpasS1230");//Repite la contraseña anterior

		   WebElement nameBox = driver.findElement(By.id("ContactoNombre"));
		   nameBox.sendKeys("Estoy");//Escribe el nombre del usuario

		   WebElement surnameBox = driver.findElement(By.id("ContactoApellidos"));
		   surnameBox.sendKeys("Probando Esto");//Escribe los apellidos del usuario
		   Thread.sleep(3000);
		   WebElement phoneBox = driver.findElement(By.id("Telefono"));
		   phoneBox.sendKeys("986515152");//Escribe un número de teléfono fijo

		   WebElement mobileBox = driver.findElement(By.id("TelefonoMovil"));
		   mobileBox.sendKeys("626277788");//Escribe un teléfono móvil

		   WebElement dniBox = driver.findElement(By.id("ContactoDNI"));
		   dniBox.sendKeys("35456789P");//Escribe el dni del usuario
		   Thread.sleep(3000);
		   WebElement adressBox = driver.findElement(By.id("ContactoDireccion"));
		   adressBox.sendKeys("Rúa do loureiro n12");//Escribe la dirección postal

		   WebElement cityBox = driver.findElement(By.id("ContactoPoblacion"));
		   cityBox.sendKeys("Boiro");//Escribe el municipio

		   WebElement postalcodeBox = driver.findElement(By.id("ContactoCodPostal"));
		   postalcodeBox.sendKeys("1567891023");//Escribe un código postal que excede la longitud de 5 caracteres
		   
		   WebElement privacycheckBox = driver.findElement(By.id("chk-billing-address"));
		   privacycheckBox.click();
		   Thread.sleep(3000);
		   

			WebElement finishButton = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/div/form[2]/div/div[17]/button"));
			finishButton.click();
			Thread.sleep(3000);


			
			
	}//Fin

		
	@Test
	public void pruebavariasunidades() throws InterruptedException { // Nombre caso de prueba CPF6
		
		driver.get("https://www.totemvertigo.com/precio/0602508538865/en-tus-planes.html"); //Abrimos la página de un producto en stock 						

		
						
			WebElement quantityBox = driver.findElement(By.id("cantidad"));
			String numerodeunidadesEsperado = "3"; //esperamos que al final del test el número de unidades sea 3

			quantityBox.sendKeys(Keys.BACK_SPACE); //eliminamos el valor 1 que viene marcado por defecto
			quantityBox.sendKeys("3");//Escribimos que queremos 3 unidades para a continuación probar los botones - y +
			Thread.sleep(3000);
						
			WebElement quitarArticulo = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/div/div[2]/div/div/form/div/div[1]/div/button[1]"));
			quitarArticulo.click(); //quitamos un artículo, debe marcar 2
			Thread.sleep(3000);	

			WebElement anadirArticulo = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/div/div[2]/div/div/form/div/div[1]/div/button[2]"));
			anadirArticulo.click(); //sumamos un artículo, debe marcar de nuevo 3
			Thread.sleep(3000);

			String unidades=quantityBox.getText();//Obtenemos texto de la casilla de cantidad
			assertEquals(numerodeunidadesEsperado,unidades);//Comprobamos que el número es el esperado (3)
			
			
	}//Fin
		
	@Test
	public void pruebacarrito() throws InterruptedException { // Nombre caso de prueba CPF2
		
		driver.get("https://www.totemvertigo.com/precio/0602508538865/en-tus-planes.html"); //Abrimos la página de un producto en stock 						

		

			WebElement anadirAlcarro = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/div/div[2]/div/div/form/div/div[2]/ul/li/button"));
			anadirAlcarro.click(); //añadimos producto al carro
			Thread.sleep(3000);	

			WebElement verCesta = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[4]/div[2]/a"));
			verCesta.click(); //pulsamos el botón ver cesta
			Thread.sleep(3000);

						
			WebElement elementoencesta = driver.findElement(By.xpath("/html/body/div[2]/section/div/div[1]/div/div/div/form/table/tbody/tr/td[2]/div/a"));
			String nombredisco = "EN TUS PLANES";
			String discoencesta=elementoencesta.getText();//Obtenemos texto de la casilla de cantidad, que debe corresponderse con el nombre del disco
			assertEquals(nombredisco,discoencesta);
			
	}//Fin


	@Test
	public void pruebapasscorto() throws InterruptedException { //Nombre caso de prueba CPNF2
		
		driver.get("https://www.totemvertigo.com/registro.php"); //Abre la página de registro						

						
			WebElement registerBox = driver.findElement(By.id("Email"));
			registerBox.sendKeys("correoemail@gmail.com");//Escribe la dirección de e-mail	

			WebElement passBox = driver.findElement(By.id("login-pass"));
			passBox.sendKeys("a12");//Escribe contraseña de menos de 5 caracteres

			WebElement passrepeatBox = driver.findElement(By.id("Password2"));
		   passrepeatBox.sendKeys("a12");//Repite la contraseña anterior

		   WebElement nameBox = driver.findElement(By.id("ContactoNombre"));
		   nameBox.sendKeys("Voy");//Escribe el nombre del usuario

		   WebElement surnameBox = driver.findElement(By.id("ContactoApellidos"));
		   surnameBox.sendKeys("A probar");//Escribe los apellidos del usuario
		   Thread.sleep(3000);
		   WebElement phoneBox = driver.findElement(By.id("Telefono"));
		   phoneBox.sendKeys("986516652");//Escribe un número de teléfono fijo

		   WebElement mobileBox = driver.findElement(By.id("TelefonoMovil"));
		   mobileBox.sendKeys("626288788");//Escribe un teléfono móvil

		   WebElement dniBox = driver.findElement(By.id("ContactoDNI"));
		   dniBox.sendKeys("35456789P");//Escribe el dni del usuario
		   Thread.sleep(3000);
		   WebElement adressBox = driver.findElement(By.id("ContactoDireccion"));
		   adressBox.sendKeys("Rúa da ameixa n18");//Escribe la dirección postal

		   WebElement cityBox = driver.findElement(By.id("ContactoPoblacion"));
		   cityBox.sendKeys("Vigo");//Escribe el municipio

		   WebElement postalcodeBox = driver.findElement(By.id("ContactoCodPostal"));
		   postalcodeBox.sendKeys("36666");//Escribe código postal
		   
		   WebElement privacycheckBox = driver.findElement(By.id("chk-billing-address"));
		   privacycheckBox.click();
		   Thread.sleep(3000);
		   

			WebElement finishButton = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/div/form[2]/div/div[17]/button"));
			finishButton.click();
			Thread.sleep(3000);



			//Debería devolver un mensaje de error por las características de la contraseña
			
			
	}//Fin

	
	@After
	public void shutdown() {
		driver.quit();
	}
}
