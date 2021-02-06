import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {

	private WebDriver driver;
	

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe"); 
        driver = new FirefoxDriver();
	}
	
	@Test
	public void Testlocalizacion() {

		driver.get("https://www.asos.com/es/?hrd=1");
		
			String tituloesperado="$ USD";

			driver.findElement(By.cssSelector("button[data-testid='country-selector-btn']")).click();
			Select comboboxSimple = new Select(driver.findElement(By.id("country")));
			comboboxSimple.selectByIndex(0);
			driver.findElement(By.cssSelector("button[data-testid='save-country-button']")).click();
		
			WebElement titulomoneda=driver.findElement(By.id("currency"));
			String titulo=titulomoneda.getText();

			assertEquals(tituloesperado, titulo);
		
		}
	
	@Test
		public void testpaginainicio() {

		driver.get("https://www.asos.com/es/?hrd=1"); 						

        	driver.findElement(By.id("chrome-search")).sendKeys("amarillo"+ Keys.ENTER);
			driver.findElement(By.cssSelector("a[data-testid='asoslogo']")).click();
		
			String URL=driver.getCurrentUrl();
			assertTrue(URL.contains("https://www.asos.com/es/?hrd=1"));

		}

		
	@After
	public void shutdown() {
		driver.quit();
	}
}
