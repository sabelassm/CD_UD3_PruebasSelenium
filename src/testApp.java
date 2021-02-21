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

public class testApp {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
        // Pruebas de enlaces del menu
    public void enlacesMenu(String [] args) throws Exception{
            // MENU Y URLS
        String [] url = {"https://www.rakayoclothing.com/", "https://www.rakayoclothing.com/collections/all", "https://www.rakayoclothing.com/pages/quienes-somos"};
        
			// Prueba
		for(int i=0; i<3; i++) { // Realiza la prueba comenzando en cada una de las páginas del menu
        	driver.get(url[i]);
        	System.out.println("Prueba " + (i+1) + " : Iniciar en " + driver.getTitle());
        	Thread.sleep(1000); 
                // Inicio
        	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Inicio')]")).click();  // Seleccion de boton
        	System.out.println("Botón inicio: Resultado " + driver.getTitle());  // Resultado
        	Thread.sleep(1000); 
        		// Catalogo
        	driver.get(url[i]);
        	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]")).click();  // Selecciona el boton
        	System.out.println("Botón Catálogo: Resultado " + driver.getTitle());  // Resultado
        	Thread.sleep(1000);
        		//Quienes Somos
        	driver.get(url[i]);
        	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), '¿Quiénes somos?')]")).click();  // Selecciona el boton
        	System.out.println("Botón Quienes Somos: Resultado " + driver.getTitle());  // Resultado
        	Thread.sleep(1000);
        }
    }

	@Test
		// Comprar desde la página del producto
	public void comprarItem(String[] args) throws Exception {
		driver.get("https://www.rakayoclothing.com/");
		driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]")).click();  // Abrir catalogo
		driver.findElement(By.className("product-card")).click();  // Abre el primer producto de la lista
		Thread.sleep(1500); 
	
			// Hacer Scroll Abajo
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	
		driver.findElement(By.xpath("//button[@class='shopify-payment-button__button shopify-payment-button__button--unbranded _2ogcW-Q9I-rgsSkNbRiJzA _2EiMjnumZ6FVtlC7RViKtj _2-dUletcCZ2ZL1aaH0GXxT']")).click();
		Thread.sleep(5000); 
		System.out.println(driver.getTitle());  // Pagina Resultante
	}

	@Test
		// Pruebas de compra desde carrito
	public void comprarAlternativa(String[] args) throws Exception {
    	driver.get("https://www.rakayoclothing.com/");
    	driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]")).click();  // Abrir catalogo
    	driver.findElement(By.className("product-card")).click();  // Abre el primer producto de la lista
    	Thread.sleep(1500); 
    	
    	// Hacer Scroll Abajo
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        
    	driver.findElement(By.id("AddToCartText-product-template")).click();  // Añadir producto al carrito
    	js.executeScript("window.scrollBy(0,-350)", "");
    	Thread.sleep(1500); 
    	driver.findElement(By.xpath("//a[@class='site-header__link site-header__cart']")).click();  // Abrir carrito
    	Thread.sleep(1500); 
    	
		// Hacer Scroll Abajo
    	js.executeScript("window.scrollBy(0,350)", "");
    	Thread.sleep(1000); 
    	driver.findElement(By.xpath("//button[@class='btn'][@name='checkout']")).click();  // Comprar
    	Thread.sleep(1500); 
		
		System.out.println(driver.getTitle());  // Página Resultante
	}

	@Test
		// Prueba de compra de diferentes unidades de producto (no aceptables)
    public void comprarUnidadInvalida(String[] args) throws Exception {	
		// PRECARGAR VALORES QUE VAN A SER UTILIZADOS
		String [] unitValue = {"0", "-1","10000"};

		// Prueba
		for(int i=0; i<unitValue.length; i++) {  // El bucle permite probar con el valor 0 y con el valor negativo
			// DESPLAZARSE A LA PAGINA DE INTEReS
			driver.get("https://www.rakayoclothing.com/");  // Iniciar instancia del navegador (pagina Inicio)
			driver.findElement(By.xpath("//ul[@id='SiteNav']//li//a[contains(text(), 'Catálogo')]")).click();  // Abrir catalogo
			driver.findElement(By.className("product-card")).click();  // Abrir primer producto de la lista
			Thread.sleep(1500);
		
			// MODIFICAR NUMERO DE UNIDADES Y ACCEDER AL CARRITO
				// Hacer Scroll Abajo
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
	
				// Modificar cantidad
			WebElement unitBox = driver.findElement(By.id("Quantity"));  // Caja de seleccion de cantidad
			unitBox.clear();
			unitBox.sendKeys(unitValue[i]);  // Modificar el valor a 0
			driver.findElement(By.id("AddToCartText-product-template")).click();  // Añadir al carrito
		
				// Acceder a la pagina del carrito
			js.executeScript("window.scrollBy(0,-350)", "");  // Scroll arriba
			Thread.sleep(1500); 
			driver.findElement(By.xpath("//a[@class='site-header__link site-header__cart']")).click();  // Abrir carrito
			Thread.sleep(1500); 
		
				// COMPROBAR QUE SE PUEDE ACCEDER A LA PaGINA DE COMPRA
			js.executeScript("window.scrollBy(0,-350)", "");  // Scroll abajo
		
				// Generamos un objeto que almacena los elementos que coinciden con la busuqueda (boton de comprar)
			List<WebElement> elems = driver.findElements(By.xpath("//button[@class='btn'][@name='checkout']"));

		
			if (elems.size() > 0) { // Si hay elementos en la lista, es posible comprar 
				System.out.println("Algo ha salido mal, es posible realizar la compra.");  //Resultado
				driver.findElement(By.xpath("//button[@class='btn'][@name='checkout']")).click();  // Moverse a la p�gina de compra
				Thread.sleep(1500);
				System.out.println(driver.getTitle());  // Mostrar la p�gina final 
			}
			else {
				System.out.println("No hay elementos en el carrito, no se puede comprar.");
				System.out.println(driver.getTitle());  // Pagina Resultante
			}
		}
	}

	@Test
		// Prueba Login por Inyección SQL
	public void seguridadLoginSQL(String[] args) throws Exception {	
    // DESPLAZARSE A LA PaGINA DE INTERéS
    	driver.get("https://www.rakayoclothing.com/");  // Iniciar instancia del navegador (pagina Inicio)
    	driver.findElement(By.id("customer_login_link")).click();  // Abrir catalogo
    	Thread.sleep(1500);
    
    	// INTRODUCIR CAMPOS Y REALIZAR LOGIN
    		// Buscar los campos para el email y la contraseña
    	WebElement emailBox = driver.findElement(By.id("CustomerEmail"));
		WebElement passBox = driver.findElement(By.id("CustomerPassword"));  

		// MODIFICACIONES HTML
		/* La configuracion HTML del cuadro de correo no permite introducir elementos que no tengan un formato de correo electronico.
		 * Parte de la vulnerabilidad que se desea detectar (y con una modificacion sencilla  del documento HTML podria realizarse.
		 * Esta linea esta adaptado: NO es propio, pero es necesaria para realizar la prueba. 
		 * 
		 * Reemplaza la etiqueta HTML original por otra igual sin el type=email*/
		((JavascriptExecutor)driver).executeScript("var ele=arguments[0]; ele.outerHTML = '<input name=\"customer[email]\" id=\"CustomerEmail\" class=\"\" placeholder=\"Correo electr�nico\" autocorrect=\"off\" autocapitalize=\"none\" autofocus=\"\">';", emailBox);
		emailBox = driver.findElement(By.id("CustomerEmail"));  // Se actualiza el elemento que estamos buscando
	
		// Inyectar SQL (resultado TRUE)
		emailBox.sendKeys("'or '1'='1'");
		passBox.sendKeys("'or '1'='1'");
		// Pulsar el botón de login
    	driver.findElement(By.xpath("//input[@class='btn'][@value='Registrarse']")).click();
    	Thread.sleep(1500);
    	System.out.println(driver.findElement(By.className("errors")));  // Muestra si se han producido errores	
	}

	@After
	public void close(){
		driver.quit();
	}
}
