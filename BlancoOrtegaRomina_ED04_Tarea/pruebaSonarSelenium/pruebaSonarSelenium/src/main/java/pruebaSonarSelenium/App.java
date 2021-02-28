package pruebaSonarSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *Pruebas javadoc y Sonar
 *@author Romina Blanco
 *@version 1.0 2021/02/28
 */
public class App 
{
    public static void main( String[] args )
    {
        App clases = new App();
        clases.Intento1();
        clases.Intento2();
        clases.Intento3();
        clases.Intento4();
        clases.Intento5();
    }

    public void Intento1 (){   
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        
        try {
            // abrimos la pagina web en pulseras de plata 
            driver.get("https://www.vidal-vidal.com/es/pulseras-de-plata/");
           Thread.sleep(200); 
           // quitamos el popup de newsletter 
            driver.findElement(By.xpath("//*[@id='popupContainer']/div[1]/img")).click();
            Thread.sleep(500); 
            // añadimos la pulsera de plata             
            driver.findElement (By.xpath("//*[@id='app']/div/div[7]/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]")).click ();	 
            Thread.sleep(2500);
            driver.findElement (By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button")).click ();	 
            Thread.sleep(2500); 
            // esperamos a que la ventaña de "se ha añadido el articulo se vaya"
            Thread.sleep(5000);
                        
            // buscamos el buscador e introducimos el anillo a buscar 
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[2]")).click();
            Thread.sleep(1500); 
            WebElement searchBox = driver.findElement (By.xpath("//*[@id='search']"));	 
            Thread.sleep(500);
            searchBox.click();
            Thread.sleep(500);
            searchBox.sendKeys("Collar oro Motivos");
            Thread.sleep(2500);
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a/div[2]/picture/img")).click();
            Thread.sleep(1500);
            
            // nos posicionamos para añadirlo a la cesta 
            driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button/span")).click();
            Thread.sleep(3500);
            Thread.sleep(4500);

            // nos posicionamos en el buscador y escribimos los pendientes a buscar para añadir a la cesta 
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[2]")).click();
            Thread.sleep(1500); 
            WebElement searchBox2 = driver.findElement (By.xpath("//*[@id='search']"));	 
            Thread.sleep(500);
            searchBox2.click();
            Thread.sleep(500);
            searchBox2.sendKeys("Pendientes Horn");
            Thread.sleep(2500);
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a/div[2]/picture/img")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button")).click();
            Thread.sleep(1500);
            Thread.sleep(3500);
            Thread.sleep(3500);

            // pulsamos en el icono de la cesta 
            driver.findElement (By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[4]/div[2]/span")).click ();	 
            Thread.sleep(500); 
            // pulsamos en las cookies para que se quiten 
            driver.findElement (By.xpath("//*[@id='app']/div/div[8]/div/button/span")).click ();	 
            Thread.sleep(500); 
            Thread.sleep(5000);
            // le damos a ver carrito 
            driver.findElement (By.xpath("//*[@id='app']/div/div[2]/div/aside/div[4]/div/button[2]/span")).click ();
            Thread.sleep(1500);
            Thread.sleep(1500);

            //Ahora vamos a el segundo articulo 
            driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div[2]/div/div[5]/div[2]/button/div")).click ();
            Thread.sleep(2500);
            Thread.sleep(2500);
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    public void Intento2 (){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        
        try {
            // Abrimos la pagina de vidal y vidal en el navegador que acabamos de abrir
           driver.get("https://www.vidal-vidal.com/es/");
           Thread.sleep(500); 
           // quitamos el icono de newsletter 
            driver.findElement(By.xpath("//*[@id='popupContainer']/div[1]/img")).click();
            Thread.sleep(500); 
            // vamos al icono de usuario e ingresamos el email y contraseña             
            driver.findElement (By.xpath("//*[@id='my-account-link-wrapper']")).click ();	 
            Thread.sleep(2500);
            WebElement searchBox = driver.findElement (By.xpath("//*[@id='username']"));	 
            Thread.sleep(500);
            searchBox.click();
            Thread.sleep(500);
            searchBox.sendKeys("Rominablancoortega@gmail.com");
            Thread.sleep(500);
            WebElement searchBox1 = driver.findElement (By.xpath("//*[@id='password']"));	 
            Thread.sleep(500);
            searchBox1.click();
            Thread.sleep(500);
            searchBox1.sendKeys("VidalRomina84");
            Thread.sleep(500);
            
            driver.findElement (By.xpath("//*[@id='app']/div/div[3]/aside/div[2]/div/div[1]/div[2]")).click ();	 
            Thread.sleep(500);
            Thread.sleep(2500);
            //elemento ok inicio sesion ** aqui estuvimos en tutoria mirando como quitar este popup y lo dejamos asi
            //driver.findElement (By.linkText("OK")).click ();	 
            //Thread.sleep(500);
            //Thread.sleep(2500);
            

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    public void Intento3 (){
        System.setProperty("webdriver.chrome.driver", "C:/DAWA_curso20202021/contornos/tareaContornos/Selenium/SeleniumProject3/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
       
        try {
            // Abrimos la pagina de vidal y vidal en el navegador que acabamos de abrir
           
            driver.get("https://www.vidal-vidal.com/es/anillo-fino-plata-circonitas-intercaladas.html?childSku=X656751214");
            Thread.sleep(500);
            //quitar la ventana de newsletter 
            driver.findElement(By.xpath("//*[@id='popupContainer']/div[1]/img")).click();
            Thread.sleep(500); 
            // se añade el añillo de la talla que se va agotar 
            driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button/span")).click();
            Thread.sleep(3500);
            Thread.sleep(4500);
            //selecionamos la cesta 
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[4]/div[2]")).click();
            Thread.sleep(3500);
            // quitamos las cookies 
            driver.findElement (By.xpath("//*[@id='app']/div/div[8]/div/button/span")).click ();	 
            Thread.sleep(500); 
            Thread.sleep(1500);
            // vamos al carrito de compra 
            driver.findElement (By.xpath("//*[@id='app']/div/div[2]/div/aside/div[4]/div/button[2]/span")).click ();
            Thread.sleep(1500);
            Thread.sleep(1500);
            // añadimos otra unidad 
            driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div/div/div[3]/div[2]/div/div/div/div[2]")).click ();
            Thread.sleep(1500);
            Thread.sleep(3500);
            // añadimos otra unidad 
            driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div/div/div[3]/div[2]/div/div/div/div[2]")).click ();
            Thread.sleep(1500);
            Thread.sleep(3500);
            //añadimos otra unidad 
            driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div/div/div[3]/div[2]/div/div/div/div[2]")).click ();
            Thread.sleep(1500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

       
    }
    public void Intento4 (){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        
        try {
            // Abrimos la pagina de vidal y vidal en el navegador que acabamos de abrir
           
            driver.get("https://www.vidal-vidal.com/es/");
            Thread.sleep(500);
            // quitamos el popup de newsletter
            driver.findElement(By.xpath("//*[@id='popupContainer']/div[1]/img")).click();
            Thread.sleep(500); 
            // buscamos el buscador e introducimos el anillo a buscar 
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[2]")).click();
            Thread.sleep(1500); 
            WebElement searchBox = driver.findElement (By.xpath("//*[@id='search']"));	 
            Thread.sleep(500);
            searchBox.click();
            Thread.sleep(500);
            searchBox.sendKeys("Anillo fino Plata Circonitas intercaladas");
            Thread.sleep(2500);
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a/div[1]/div[1]")).click();
            Thread.sleep(1500);
            // escogemos la talla 
            driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[5]/div/div[2]/div/ul/li[1]/div")).click();
            Thread.sleep(3500);
            // nos posicionamos para añadirlo a la cesta 
            driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button/span")).click();
            Thread.sleep(3500);
            Thread.sleep(4500);
            // abrimos la cesta pinchando en ella 
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[4]/div[2]")).click();
            Thread.sleep(3500);
            // aceptamos las cookies 
            driver.findElement (By.xpath("//*[@id='app']/div/div[8]/div/button/span")).click ();	 
            Thread.sleep(500); 
            Thread.sleep(1500);
            // vamos al carrito - cesta de compra 
            driver.findElement (By.xpath("//*[@id='app']/div/div[2]/div/aside/div[4]/div/button[2]/span")).click ();
            Thread.sleep(1500);
            Thread.sleep(1500);
            // añadimos una unidad 
            driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div/div/div[3]/div[2]/div/div/div/div[2]")).click ();
            Thread.sleep(1500);
            Thread.sleep(3500);
            Thread.sleep(3500);
            // nos posicionamos en el buscador y escribimos los pendientes a buscar para añadir a la cesta 
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[2]")).click();
            Thread.sleep(1500); 
            WebElement searchBox2 = driver.findElement (By.xpath("//*[@id='search']"));	 
            Thread.sleep(500);
            searchBox2.click();
            Thread.sleep(500);
            searchBox2.sendKeys("Pendientes Horn");
            Thread.sleep(2500);
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a/div[2]/picture/img")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button")).click();
            Thread.sleep(1500);
            Thread.sleep(3500);
            Thread.sleep(3500);
            // vamos a la cesta y nos vamos al carrito
            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[4]/div[2]")).click();
            Thread.sleep(3500);
            driver.findElement (By.xpath("//*[@id='app']/div/div[2]/div/aside/div[4]/div/button[2]/span")).click ();
            Thread.sleep(2500);
            // vamos a añadir una unidad mas de pendientes 
            driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[2]")).click ();
            Thread.sleep(2500);
            Thread.sleep(3500);
            // añadimos otra unidad mas de pendientes para obtener el regalo
            driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[2]")).click ();
            Thread.sleep(2500);
            Thread.sleep(2500);
            

           
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
    public void Intento5 (){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        // Para ver la ejecución, detenemos el hilo 5 segundos
        try {
             // Abrimos la pagina de vidal y vidal en el navegador que acabamos de abrir
           
             driver.get("https://www.vidal-vidal.com/es/");
             Thread.sleep(500);
             // quitamos el popup de newsletter
             driver.findElement(By.xpath("//*[@id='popupContainer']/div[1]/img")).click();
             Thread.sleep(500); 
             // buscamos el buscador e introducimos el anillo a buscar 
             driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[2]")).click();
             Thread.sleep(1500); 
             WebElement searchBox = driver.findElement (By.xpath("//*[@id='search']"));	 
             Thread.sleep(500);
             searchBox.click();
             Thread.sleep(500);
             searchBox.sendKeys("Anillo fino Plata Circonitas intercaladas");
             Thread.sleep(2500);
             driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a/div[1]/div[1]")).click();
             Thread.sleep(1500);
             // escogemos la talla 
             driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[5]/div/div[2]/div/ul/li[1]/div")).click();
             Thread.sleep(3500);
             // nos posicionamos para añadirlo a la cesta 
             driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button/span")).click();
             Thread.sleep(3500);
             Thread.sleep(4500);
             // abrimos la cesta pinchando en ella 
             driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[4]/div[2]")).click();
             Thread.sleep(3500);
             // aceptamos las cookies 
             driver.findElement (By.xpath("//*[@id='app']/div/div[8]/div/button/span")).click ();	 
             Thread.sleep(500); 
             Thread.sleep(1500);
             // vamos al carrito - cesta de compra 
             driver.findElement (By.xpath("//*[@id='app']/div/div[2]/div/aside/div[4]/div/button[2]/span")).click ();
             Thread.sleep(1500);
             Thread.sleep(1500);
            // nos posicionamos en el buscador y escribimos los pendientes a buscar para añadir a la cesta 
             driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[2]")).click();
             Thread.sleep(1500); 
             WebElement searchBox2 = driver.findElement (By.xpath("//*[@id='search']"));	 
             Thread.sleep(500);
             searchBox2.click();
             Thread.sleep(500);
             searchBox2.sendKeys("Pendientes Horn");
             Thread.sleep(2500);
             driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a/div[2]/picture/img")).click();
             Thread.sleep(1500);
             driver.findElement(By.xpath("//*[@id='app']/div/div[7]/div/div/div[1]/div[7]/div/button")).click();
             Thread.sleep(1500);
             Thread.sleep(3500);
             Thread.sleep(3500);
             // vamos a la cesta y nos vamos al carrito
             driver.findElement(By.xpath("//*[@id='app']/div/div[1]/header/div[2]/div[4]/div[2]")).click();
             Thread.sleep(3500);
             driver.findElement (By.xpath("//*[@id='app']/div/div[2]/div/aside/div[4]/div/button[2]/span")).click ();
             Thread.sleep(2500);
             // vamos a añadir una unidad mas de pendientes 
             driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[2]")).click ();
             Thread.sleep(2500);
             Thread.sleep(3500);
             // vamos a meter nuestro usuario 
             driver.findElement (By.xpath("//*[@id='my-account-link-wrapper']")).click ();	 
             Thread.sleep(2500);
             WebElement searchBox3 = driver.findElement (By.xpath("//*[@id='username']"));	 
             Thread.sleep(500);
             searchBox3.click();
             Thread.sleep(500);
             searchBox3.sendKeys("Rominablancoortega@gmail.com");
             Thread.sleep(500);
             WebElement searchBox1 = driver.findElement (By.xpath("//*[@id='password']"));	 
             Thread.sleep(500);
             searchBox1.click();
             Thread.sleep(500);
             searchBox1.sendKeys("VidalRomina84");
             Thread.sleep(500);
             Thread.sleep(5000);
             driver.findElement (By.xpath("//*[@id='app']/div/div[3]/aside/div[2]/div/div[1]/div[2]")).click ();	 
             Thread.sleep(500);
             Thread.sleep(2500);
             Thread.sleep(2500);
             driver.findElement (By.xpath("//*[@id='cart']/div[2]/div[2]/div[1]/div[5]/a[1]/button")).click ();	 
             Thread.sleep(500);
             Thread.sleep(2500);
             // confirmar para pago 
             driver.findElement (By.xpath("//*[@id='app']/div/div[3]/div/div[1]/div/div[2]/div[2]/div/div[4]/div/div")).click ();	 
             Thread.sleep(500);
             Thread.sleep(2500);
             // volver a metodos de envio  
              driver.findElement (By.xpath("//*[@id='app']/div/div[3]/div/div[1]/div/div[2]/div[3]/div/div[4]/div/div[2]")).click ();	 
              Thread.sleep(500);
              Thread.sleep(2500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }



}
