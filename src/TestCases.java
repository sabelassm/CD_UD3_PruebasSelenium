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
		System.setProperty("webdriver.chrome.driver", "C:/Users/Alvaro/Desktop/ciclo dew/Contornos de desemvolvemento/seleniumtest/driver/chromedriver.exe");

        driver = new ChromeDriver();

	}
	
		
	@Test
	public void test_busquedas(){
	int i;
	driver.get("https://www.rakayoclothing.com/");   
    for (i=0;i<5;i++){//haberia que poñer 1000
    WebElement searchBox = driver.findElement(By.id("SiteNavSearch"));
    searchBox.sendKeys("sudadera");
    searchBox.submit();
        }
	driver.navigate().back();
	}
	@Test
	public void test_Busquedasinresultado(){
		driver.get("https://www.rakayoclothing.com/");   
		String busqueda = "RESULTADOS DE LA BÚSQUEDA 0 resultados para 1E3 BUSCAR" ; 
		WebElement searchBox = driver.findElement(By.id("SiteNavSearch"));
		searchBox.sendKeys("1E3");   
		searchBox.submit();
		WebElement resultado = driver.findElement(By.id("MainContent"));
		assertEquals(busqueda,resultado.getText());
		System.out.println(resultado.getText());
		System.out.println(busqueda);
	}    
		
	@Test
	public void test_buscador() {
		driver.get("https://www.rakayoclothing.com/"); 
		WebElement searchBox = driver.findElement(By.id("SiteNavSearch"));
   		searchBox.sendKeys("sudadera");
    	searchBox.submit();
		WebElement busqueda =driver.findElement(By.id("MainContent"));
		System.out.println("*********************");
   		System.out.println(busqueda.getText());
    	System.out.println("*********************");
	
	}
	@Test
	public void test_quienessomos() throws InterruptedException {
		driver.get("https://www.rakayoclothing.com/"); 
		WebElement searchBox = driver.findElement(By.linkText("¿QUIÉNES SOMOS?"));
	 	searchBox.click();
		Thread.sleep(2000); 
		driver.navigate().back(); 
		
	}
	@Test
	public void test_cuenta() throws InterruptedException {
		driver.get("https://www.rakayoclothing.com/"); 
		WebElement cuenta = driver.findElement(By.id("customer_login_link"));
	 	cuenta.click();
		Thread.sleep(2000); 
		WebElement registarse = driver.findElement(By.id("CustomerEmail"));
		registarse.submit();
	}
	@After
	public void shutdown() {
		driver.quit();
	}
}
