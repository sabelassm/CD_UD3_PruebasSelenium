import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCases {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Dropbox\\Ciclo Dam\\MP0487. Contornos de desenvolvemento\\UD03\\tarea3\\CD_UD3_PruebasSelenium\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

	}

	@Test
	public void comprobarOfertas() {

		driver.get("https://www.pccomponentes.com"); // Abrimos la p�gina de pccomponentes
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> botones = driver.findElements(By.className("enlaces-clave__tarjeta__a--rounded-border"));
		WebElement ofertas = null;
		for (WebElement we : botones) {
			if (we.getAttribute("data-name").equals("/ofertas-especiales - Ofertas Especiales")) {
				ofertas = we;
			}
		}

		ofertas.click();

		// Cada producto está en un contendor con que tiene la clase
		// "c-product-card__wrapper"
		List<WebElement> productos = driver.findElements(By.className("c-product-card__wrapper"));

		boolean oferta = false;
		for (WebElement we : productos) {
			oferta = false;
			// System.out.println(we1.getAttribute("data-name"));
			List<WebElement> we2 = we.findElements(By.cssSelector("div"));
			for (WebElement w : we2) {
				// System.out.println(w.getAttribute("class"));
				// Los productos con descuento tiene la clase "c-product-card__discount
				// cy-product-discount"
				if (w.getAttribute("class").equals("c-product-card__discount cy-product-discount")) {
					oferta = true;
				}
			}
			if(!oferta){
				break;
			}
		}

		assertTrue(oferta);

	}// Fin comprobarOfertas

	@Test
	public void test_cantidadNegativaBoton() {
		boolean positivo;

		driver.get("https://www.pccomponentes.com"); // Abrimos la p�gina de pccomponentes

		List<WebElement> productos = driver.findElements(By.id("producto-interesa")); // Lista de productos en pagina
																						// principal

		productos.get(0).click(); // Seleccionamos el primer producto enocntrado

		WebElement botonMenos = driver
				.findElement(By.cssSelector("button[class='btn btn-secondary quantity-modify quantity-sub']"));

		int i = 5;
		while (i > 0) {
			int click = 1;
			System.out.println("click: " + 1);
			botonMenos.click();
			i--;
			click++;
		}

		WebElement cantidad = driver.findElement(By.id("article-quantity"));

		positivo = Integer.parseInt(cantidad.getAttribute("value")) > 0;
		System.out.println(positivo);

		assertTrue(positivo);

	}// Fin test_cantidadNegativaBoton

	@Test
	public void test_cantidadNegativaInput() {
		boolean positivo;

		driver.get("https://www.pccomponentes.com"); // Abrimos la p�gina de pccomponentes

		List<WebElement> productos = driver.findElements(By.id("producto-interesa")); // Lista de productos en pagina
																						// principal

		productos.get(0).click(); // Seleccionamos el primer producto enocntrado

		WebElement cantidad = driver.findElement(By.id("article-quantity"));

		cantidad.clear();// eliminamos en valor por defecto
		cantidad.sendKeys("-5");// añadimos cantidad negativa

		System.out.println(cantidad.getAttribute("value"));
		positivo = Integer.parseInt(cantidad.getAttribute("value")) > 0;
		System.out.println(positivo);

		assertTrue(positivo);

	}// Fin test_cantidadNegativaInput

	@Test
	public void test_ordenDescendente() {
		boolean positivo = true;

		driver.get("https://www.pccomponentes.com"); // Abrimos la p�gina de pccomponentes

		WebElement menu = driver.findElement(By.cssSelector("h3[class='c-main-menu__name']"));

		menu.click();

		WebElement smartphonesT = driver.findElement(By.cssSelector("a[title='Smartphones y Telefonía']"));

		Actions actions = new Actions(driver);

		// colocamos cursor sobre Smartphones y telefonía para visualizar más opciones
		// de menú
		actions.moveToElement(smartphonesT).perform();

		WebElement smartphones = driver.findElement(By.cssSelector("a[title='Smartphones']"));

		smartphones.click();

		Select combo = new Select(driver.findElement(By.id("listOrder")));
		combo.selectByValue("price-desc");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //Comprobamos precios de productos

		double price = 1000000000;
        List<WebElement> productos = driver.findElements(By.className("col-xs-6"));

		for(WebElement we: productos){

            WebElement elementoPrecio= we.findElement(By.cssSelector("article"));
            System.out.println(elementoPrecio.getAttribute("data-name"));
			double actualPrice = Double.parseDouble(elementoPrecio.getAttribute("data-price"));
			System.out.println("actual price: " + actualPrice);

			if(price >= actualPrice){
				price = actualPrice;
			}else{
				positivo = false;
				break;
			}
		}

		assertTrue(positivo);
	}//Fin test_ordenDescendente

	@Test
	public void test_ordenAscendente() {
		boolean positivo = true;

		driver.get("https://www.pccomponentes.com"); // Abrimos la p�gina de pccomponentes

		WebElement menu = driver.findElement(By.cssSelector("h3[class='c-main-menu__name']"));

		menu.click();

		WebElement smartphonesT = driver.findElement(By.cssSelector("a[title='Smartphones y Telefonía']"));

		Actions actions = new Actions(driver);

		// colocamos cursor sobre Smartphones y telefonía para visualizar más opciones
		// de menú
		actions.moveToElement(smartphonesT).perform();

		WebElement smartphones = driver.findElement(By.cssSelector("a[title='Smartphones']"));

		smartphones.click();

		Select combo = new Select(driver.findElement(By.id("listOrder")));
		combo.selectByValue("price-asc");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //Comprobamos precios de productos

		double price = 0;
        List<WebElement> productos = driver.findElements(By.className("col-xs-6"));

		for(WebElement we: productos){

            WebElement elementoPrecio= we.findElement(By.cssSelector("article"));
            System.out.println(elementoPrecio.getAttribute("data-name"));
			double actualPrice = Double.parseDouble(elementoPrecio.getAttribute("data-price"));
			System.out.println("actual price: " + actualPrice);

			if(price <= actualPrice){
				price = actualPrice;
			}else{
				positivo = false;
				break;
			}
		}

		assertTrue(positivo);
	}//Fin test_ordenAscendente
	
	@After
	public void shutdown() {
		driver.quit();
	}
}
