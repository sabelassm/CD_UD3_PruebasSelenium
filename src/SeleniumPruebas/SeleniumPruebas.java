package SeleniumPruebas;
// Librería Utils Java
import java.util.List;

// Librería Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// Librería Junit
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Pruebas con Selenium WebDriver para la página RakayoClothing
 * @author Pablo Sánchez
 * @version 1.0
 */
public class SeleniumPruebas {
	/**
	 * Objeto que carga el Webdriver para ejecutar la ventana del navegador
	 */
	private WebDriver driver;

	/**
	 * Atributo que almacena la URL de la página de inicio de la aplicación
	 */
	private String initPage = "https://www.rakayoclothing.com/";

	/**
	 * Atributo que almacena la ruta HTML para el botón del catálogo
	 */
	private String catalogoButton = "//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]";

	/**
	 * Atributo que almacena el nombre de la clase de la lista del catálogo
	 */
	private String carrito = "product-card";
	
	/**
	 * Atributo que almacena la ruta HTML para el botón del catálogo
	 */
	private String realizarCompra = "//button[@class='btn'][@name='checkout']";

	/**
	 * Permite realizar scroll en la página web actual
	 * @params movimiento Representa el número de píxeles que se mueve la página. 
	 * Valores positivos bajan la página mientras que los negativos las suben.
	 */

	public void scroll(int movimiento){
		JavascriptExecutor js = (JavascriptExecutor) driver; /** Cargar driver de javascript para hacer scroll */
		js.executeScript("window.scrollBy(0," + movimiento + ")", "");
	}

	/**
	 * Cargar el driver del navegador en el objeto Webdriver El navegador utilizado
	 * es Firefox Siempre se ejecuta antes de cada prueba
	 */
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	/**
	 * Prueba de enlaces entre menús Comprueba que las páginas que aparecen en el
	 * menú de navegación estén correctamente enlazadas accediendo a todas desde
	 * cada una de las páginas
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void enlacesMenu() throws InterruptedException {
		/**
		 * Almacena las páginas que aparecen en el menú de navegación en forma de array
		 */
		String[] url = { initPage, "https://www.rakayoclothing.com/collections/all",
				"https://www.rakayoclothing.com/pages/quienes-somos" };

		for (int i = 0; i < 3; i++) { /** Comprueba para cada una de las páginas los enlaces con el resto */
			driver.get(url[i]);  //** Carga el driver desde una de las páginas del menú */
			System.out.println("Prueba " + (i + 1) + " : Iniciar en " + driver.getTitle());  /** Muestra la página en la que se inicia */
			Thread.sleep(1000);

			driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Inicio')]")).click(); /** Pulsar botón Inicio*/
			System.out.println("Botón inicio: Resultado " + driver.getTitle());
			Thread.sleep(1000);

			driver.get(url[i]);
			driver.findElement(By.xpath(catalogoButton)).click(); /** Pulsar botón Catálogo */
			System.out.println("Botón Catálogo: Resultado " + driver.getTitle()); 
			Thread.sleep(1000);

			driver.get(url[i]);
			driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), '¿Quiénes somos?')]")).click(); /** Pulsar botón Quienes somos */
			System.out.println("Botón Quienes Somos: Resultado " + driver.getTitle());
			Thread.sleep(1000);
		}
	}

	/**
	 * Prueba de compra de un producto directamente desde la página del producto
	 * @throws InterruptedException
	 */
	@Test
	public void comprarItem() throws InterruptedException {
		driver.get(initPage);
		driver.findElement(By.xpath(catalogoButton)).click(); /** Abrir Catálogo */
		driver.findElement(By.className(carrito)).click(); /** Seleccionar el primer producto de la lista */
		Thread.sleep(1500);

		scroll(350);

		driver.findElement(By.xpath("//button[@class='shopify-payment-button__button shopify-payment-button__button--unbranded _2ogcW-Q9I-rgsSkNbRiJzA _2EiMjnumZ6FVtlC7RViKtj _2-dUletcCZ2ZL1aaH0GXxT']")).click(); /** Pulsar botón de comprar */
		Thread.sleep(5000);
		System.out.println(driver.getTitle()); /** Mostrar página final */
	}

	/**
	 * Prueba de compra de un producto añadido al carrito primero
	 * @throws InterruptedException
	 */
	@Test
	public void comprarAlternativa() throws InterruptedException {
		driver.get(initPage);  /** Cargar página de inicio */
		driver.findElement(By.xpath(catalogoButton)).click(); /** Abrir el catálogo */
		driver.findElement(By.className(carrito)).click(); //** Selecciona el primer producto */
		Thread.sleep(1500);

		JavascriptExecutor js = (JavascriptExecutor) driver; /** Cargar driver de javascript para hacer scroll */
		js.executeScript("window.scrollBy(0,350)", "");

		driver.findElement(By.id("AddToCartText-product-template")).click(); /** Añadir producto al carrito */
		scroll(350);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[@class='site-header__link site-header__cart']")).click(); /** Abrir carrito */
		Thread.sleep(1500);

		scroll(350);
		Thread.sleep(1000);
		driver.findElement(By.xpath(realizarCompra)).click(); /** Pulsar comprar */
		Thread.sleep(1500);

		System.out.println(driver.getTitle()); /** Mostrar página final */
	}

	/**
	 * Prueba de compra de volumen de compra de unidades inválidas 
	 * La prueba se realiza utilizando valores negativos, iguales a 0 y muy superiores al stock máximo
	 * @throws InterruptedException
	 */
	@Test
	public void comprarUnidadInvalida() throws InterruptedException {

		/**
		 * Valores utilizados para las pruebas
		 */
		String[] unitValue = { "0", "-1", "10000" };

		/**
		 * La prueba se realiza para cada uno de los valores definidos en el array <code>unitValue<code>
		 */
		for (int i = 0; i < unitValue.length; i++) { 
			driver.get(initPage); /** Cargar página de inicio */
			driver.findElement(By.xpath(catalogoButton)).click(); /** Abrir catálogo */
			driver.findElement(By.className(carrito)).click(); /** Seleccionar el primer producto */
			Thread.sleep(1500);

			scroll(350);

			WebElement unitBox = driver.findElement(By.id("Quantity")); /** Seleccionar cuadro de unidades */
			unitBox.clear(); /** Vaciar cuadro */
			unitBox.sendKeys(unitValue[i]); /** Modificar valor */
			driver.findElement(By.id("AddToCartText-product-template")).click(); /** Añadir al carrito */

			scroll(-350);
			Thread.sleep(1500);
			driver.findElement(By.xpath("//a[@class='site-header__link site-header__cart']")).click(); /** Abrir carrito */
			Thread.sleep(1500);


			scroll(-350); 

			List<WebElement> elems = driver.findElements(By.xpath(realizarCompra)); /** Buscar botón de compra */

			/**
			 * Si es posible accede a la opción de compra y muestra la página final.
			 * En caso contrario muestra que no se puede comprar.
			 */
			if (elems.size() > 0) { 
				System.out.println("Algo ha salido mal, es posible realizar la compra."); 
				driver.findElement(By.xpath(realizarCompra)).click(); /** Pulsar comprar */
				Thread.sleep(1500);
				System.out.println(driver.getTitle()); /** Mostar página final */
			} else {
				System.out.println("No hay elementos en el carrito, no se puede comprar.");
				System.out.println(driver.getTitle()); 
			}
		}
	}

	/**
	 * Prueba de inyección de SQL en la pestaña de login
	 * @throws InterruptedException
	 */
	@Test
	public void seguridadLoginSQL() throws InterruptedException {
		
		driver.get(initPage); /** Cargar página de inicio */
		driver.findElement(By.id("customer_login_link")).click(); /** Abrir catálogo */
		Thread.sleep(1500);

		WebElement emailBox = driver.findElement(By.id("CustomerEmail")); /** Guarda el campo de email */
		WebElement passBox = driver.findElement(By.id("CustomerPassword")); /** Guarda el campo de contraseña */


		/**
		 * La configuracion HTML del cuadro de correo no permite introducir elementos
		 * que no tengan un formato de correo electronico. Parte de la vulnerabilidad
		 * que se desea detectar (y con una modificacion sencilla del documento HTML
		 * podria realizarse. Esta linea esta adaptado: NO es propio, pero es necesaria
		 * para realizar la prueba.
		 * 
		 * Reemplaza la etiqueta HTML original por otra igual sin el type=email
		 */
		((JavascriptExecutor) driver).executeScript(
				"var ele=arguments[0]; ele.outerHTML = '<input name=\"customer[email]\" id=\"CustomerEmail\" class=\"\" placeholder=\"Correo electr�nico\" autocorrect=\"off\" autocapitalize=\"none\" autofocus=\"\">';",
				emailBox);
		emailBox = driver.findElement(By.id("CustomerEmail")); // Se actualiza el elemento que estamos buscando

		/**
		 * Inyección de SQL
		 * La comprobación pretende devolver TRUE en caso de existir vulnerabilidad, por lo que se realizaría el login
		 */
		emailBox.sendKeys("'or '1'='1'");
		passBox.sendKeys("'or '1'='1'");
		// Pulsar el botón de login
		driver.findElement(By.xpath("//input[@class='btn'][@value='Registrarse']")).click(); /** Pulsar registrarse */
		Thread.sleep(1500);
		System.out.println(driver.findElement(By.className("errors"))); /** Mostrar si se producen errores */
	}

	@After
	public void close() {
		driver.quit();
	}
}
