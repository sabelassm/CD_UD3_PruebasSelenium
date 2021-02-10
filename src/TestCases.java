import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
	
	private WebDriver driverff;
	

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:/blass/Drive/FP/DAM/Contornos de desenvolvemento/AD03/Tarea 3.2/Tarefa3.2/driver/geckodriver.exe");

        driverff = new FirefoxDriver();

	}
	
	@Test
	public void iniciarSesionSinDatos() throws InterruptedException {
		/*Neste caso, ao facer a comprobación da mensaxe por javascript, non sabía como facer para comprobar que non iniciaba sesión, polo que comprobo que o título da páxina sexa o mesmo, pero no navegador
		vese como salta o aviso de que hai que rechear o formulario*/

        String tituloHomeEsperado="Mi Cuenta - El Corte Inglés";

        driverff.get("https://cuenta.elcorteingles.es/oauth/authorize?response_type=code&scope=openid%20profile%20plans&client_id=rjx5snOWlh40SgcE0dg2guk4YnXhECYd&redirect_uri=https%3A%2F%2Fwww.elcorteingles.es%2Fecistore%2Fsession%2Fcallback%3Fto%3D%252F&locale=es#_ga=2.213891356.983254943.1612887197-179536802.1612887197");

        Thread.sleep(3000);

        WebElement buttonAcceder = driverff.findElement(By.className("js-form-submit"));

		buttonAcceder.click();

		Thread.sleep(3000);

		String titulo = driverff.getTitle();
        

		assertEquals(tituloHomeEsperado,titulo);
			
	}//Fin iniciarSesionSinDatos
	
	@Test
	public void accederModaMujer() throws InterruptedException {
		/* Neste caso, ao entrar no enlace dime que non teño acceso ao servidor.
		Entendo que é unha medida antibots. Estiven mirando varias formas de solucionar
		esto, coma engadir o User Agent ou borrar as cookies ao acceder pero ningunha me funcionou  */
		String tituloHomeEsperado="Moda Mujer y Joven Ella · El Corte Inglés (13.877)";

		//Con isto indico o UA utilizado
		FirefoxOptions options = new FirefoxOptions();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0) Gecko/20100101 Firefox/85.0";
        options.addArguments(String.format("user-agent=%s", userAgent));

		
		driverff.get("https://www.elcorteingles.es/");
      
        Thread.sleep(2000);

        WebElement modaMujer = driverff.findElement(By.linkText("HOMBRE"));

		modaMujer.click();

		Thread.sleep(3000);

		String titulo = driverff.getTitle();
        

		assertEquals(tituloHomeEsperado,titulo);


        
	}//Fin accederModaMujer
	@Test
	public void accederSegurosHogar() throws InterruptedException {
		/*  */
		String tituloHomeEsperado="Calcula tu seguro de hogar. Hasta 50% dto | El Corte Inglés Seguros";

		//Con isto indico o UA utilizado
		FirefoxOptions options = new FirefoxOptions();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0) Gecko/20100101 Firefox/85.0";
        options.addArguments(String.format("user-agent=%s", userAgent));

		
		driverff.get("https://www.elcorteingles.es/");
      
        Thread.sleep(2000);

		WebElement menu = driverff.findElement(By.id("burger-handler"));							//Botón do menú	

		WebElement botonAceptarCookies = driverff.findElement(By.id("cookies-agree"));;				//Para aceptar as cookies, xa que molestaban ao navegar polo menú
        botonAceptarCookies.click();

		Actions action = new Actions(driverff);														//declaro unha nova action

		action.moveToElement(menu).click().perform();												//Uso o método moveToElement para mover o rato ao menú e facer clic para que se mostre
		Thread.sleep(1000);
		
		
		WebElement seguros = driverff.findElement(By.linkText("Seguros"));							//Localizo o elemento Seguros
  		action.moveToElement(seguros).perform();													//Uso o método moveToElement para mover o rato a Seguros
		Thread.sleep(1000);


		WebElement segurosHogar = driverff.findElement(By.linkText("Seguros de hogar"));			//Localizo o elemento Seguros de hogar
  		action.moveToElement(segurosHogar).click().perform();										//Uso o método moveToElement para mover o rato a Seguros de hogar e facer clic
		Thread.sleep(15000);  																		//Doulle ese tempo porque me tardaba bastante en cargar a páxina

		String titulo = driverff.getTitle();
		assertEquals(tituloHomeEsperado,titulo);


        
	}//Fin accederSegurosHogar

	@Test
	public void busquedaPantalon() throws InterruptedException {
		/* O mesmo problema que no caso accederModaMujer, o servidor non me deixa acceder. Pero polo resto debería funcionar */
		String tituloHomeEsperado="Pantalón · Resultados de búsqueda  · El Corte Inglés (10.886)";
		driverff.get("https://www.elcorteingles.es/");
		Thread.sleep(2000);

		WebElement barraBusqueda = driverff.findElement(By.id("main_search"));	
		WebElement searchButton = driverff.findElement(By.className("_search"));

		barraBusqueda.sendKeys("Pantalón");
		Thread.sleep(1000);
		searchButton.click();
		Thread.sleep(3000);


		String titulo=driverff.getTitle();
		assertEquals(tituloHomeEsperado,titulo);
        
	}//Fin busquedaPantalon


	@Test
	public void iniciarSesion() throws InterruptedException {
		/* Neste caso teño o mesmo erro, introduzco os datos, fago clic en acceder e o servidor rechaza a conexión, pero se non fora por iso creo que funcionaría.
		A conta utilizada é unha conta creada para este exercicio.
		*/
		

		  			
		//O código comentado aquí sería o necesario para acceder dende a páxina principal ao login
		/*
		driverff.get("https://www.elcorteingles.es/");  
		Thread.sleep(2000);
		WebElement iniciarSesion = driverff.findElement(By.linkText("Iniciar sesión"));	
		iniciarSesion.click();

		Thread.sleep(1000);
		*/

		String tituloHomeEsperado="Mi Cuenta - El Corte Inglés";
		driverff.get("https://cuenta.elcorteingles.es/");		//Teño que iniciar dende esta URL, xa que se o fago a través de código sáltame o erro de que non estou autorizado.
        Thread.sleep(1000);

		WebElement formUsu = driverff.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[1]/div/form/div[1]/div[2]/div/input"));
		WebElement formPass = driverff.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[1]/div/form/div[1]/div[3]/div[1]/input"));
		WebElement acceder = driverff.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[1]/div/form/div[2]/div/input"));


		formUsu.click();
		formUsu.sendKeys("a20blasav@gmail.com");

		formPass.click();
		formPass.sendKeys("ProbaSelenium1");
		Thread.sleep(1000);

		acceder.click();
		Thread.sleep(5000);	


		
		String titulo=driverff.getTitle();
		assertEquals(tituloHomeEsperado,titulo);
		
	}//Fin iniciarSesion




	@After
	public void shutdown() {
		driverff.quit();
		
	}

	public TestCases() {
	}
}
