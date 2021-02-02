import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testCNTG {
    private WebDriver driver; // Declaramos objeto del webdriver

    @Before // Ejecucion previa a @test para establecer ruta de webdriver
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); // Ruta local
        driver = new ChromeDriver(); // Valor para driver
    }

    @Test // Test CPF1
    public void test1() throws InterruptedException {
        driver.get("https://emprego.xunta.es/cntxes-pro"); // URL de la web

        // Inicialización de variables
        String curso = "Oracle Corporation";
        String cursoWeb = null;

        WebElement Tecnologia = driver.findElement(By.id("aui_3_4_0_1_166")); // Pestaña Tecnoloxia
        Tecnologia.click();
        WebElement imgOracle = driver.findElement(By.cssSelector("[alt='Oracle Corporation']")); // Imagen Oracle
        imgOracle.click();
        WebElement checkboxCursos = driver.findElement(By.id("formFabricante")); // Abrimos el desplegable con el checkbox de los cursos
        checkboxCursos.click();
        List<WebElement> listaCursos = driver.findElements(By.cssSelector("[class='selected']")); // Buscamos los cursos seleccionados dentro del listado de todos los cursos
        for (WebElement c : listaCursos) {
            cursoWeb = c.getText(); // Extraccion del texto visible
        }
        assertEquals(curso, cursoWeb); // Comparación
    }

    @Test // Test CPF7
    public void test2() throws InterruptedException {
        driver.get("https://emprego.xunta.es/cntxes-pro"); // URL de la web
        String titulo = " Resultados de busca de accións formativas da programación actual "; //Título de la búsqueda de cursos

        WebElement searchBox = driver.findElement(By.cssSelector("[class='buscador-input']")); // Caja de búsqueda
        WebElement searchButton = driver.findElement(By.cssSelector("[class='tiny-buscador-button']")); // Botón para realizar la búsqueda
        searchBox.sendKeys("java"); // Introducimos una palabra para la búsqueda
        searchButton.click(); // Pulsamos botón de búsqueda

        WebElement searchTitulo = driver.findElement(By.id("title-actividades")); // Cabecera de la página de búsqueda que muestra los resultados
        String tituloWeb = searchTitulo.getAttribute("innerText"); // Extracción del texto del título
        assertEquals(titulo, tituloWeb); // Comparación
    }

    @Test // Test CPF6
    public void test3() throws ParseException, InterruptedException {
        Actions builder = new Actions(driver);
        driver.get("https://emprego.xunta.es/cntxes-pro"); //URL de la web
        String fecha = "20/02/2021";
        Boolean correcto = false;

        WebElement actividades = driver.findElement(By.linkText("Actividades")); //Menú Actividades
        builder.moveToElement(actividades).perform(); //Ratón encima. Menú 'mouseover'
        WebElement cursos = driver.findElement(By.linkText("Cursos")); //Submenú Cursos
        builder.moveToElement(cursos).click().perform(); //Se coloca ratón encima y click
        WebElement searchBoxDate = driver.findElement(By.id("_busquedaAF_WAR_cntxesuidefinicionportlet_fechaInicio")); //Caja de búsqueda de fecha
        WebElement checkboxExamen = driver.findElement(By.id("_busquedaAF_WAR_cntxesuidefinicionportlet_certificacionCheckbox")); //Checkbox para certificación
        WebElement searchButton = driver.findElement(By.cssSelector("[value='Buscar']")); //Botón de enviar
        searchBoxDate.sendKeys(fecha); //Se escribe la fecha
        checkboxExamen.click();
        searchButton.click(); 
        Thread.sleep(3000); //Pausa para que carguen los cursos
        WebElement tablaCursos = driver.findElement(By.cssSelector("table tr:nth-of-type(1)")); //Primera fila de la tabla
        WebElement dateSorting = tablaCursos.findElement(By.cssSelector("th:nth-of-type(3)")); //Data de inicio
        dateSorting.click(); //Orden de menor a mayor
        Thread.sleep(2000); //Pausa para que carguen los cursos
        WebElement secondRow = driver.findElement(By.cssSelector("table tr:nth-of-type(2)")); //Segunda fila de la tabla
        String fechaWeb = secondRow.findElement(By.cssSelector("td:nth-of-type(3)")).getText(); //Fecha
        String examenWeb = secondRow.findElement(By.cssSelector("td:nth-of-type(7)")).getText(); //Certificación

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Formato de fechas
        Date f = sdf.parse(fecha); //Creamos variable fecha
        Date fW = sdf.parse(fechaWeb); //Variable fecha recogida de la web
        if (fW.compareTo(f) >= 0 && examenWeb.equals("Si")) { //Comprobación de filtros
            correcto=true;
        }
        assertTrue(correcto); 
    }

    @Test //Test CPF4
    public void test4() throws InterruptedException {
        Actions builder = new Actions(driver);
        driver.get("https://emprego.xunta.es/cntxes-pro"); //URL de la web
        int d1, d2;
        Boolean correcto = false;

        WebElement actividades = driver.findElement(By.linkText("Actividades")); //Menú Actividades
        builder.moveToElement(actividades).perform(); //Ratón encima. Menú 'mouseover'
        WebElement agenda = driver.findElement(By.linkText("Axenda")); //Submenú Agenda
        builder.moveToElement(agenda).click().perform(); //Ratón encima y click
        Thread.sleep(3000); //Espera a carga de la página
        String dia=driver.findElement(By.cssSelector("[class='fc-date white-color']")).getText(); //Día del calendario
        d1=Integer.parseInt(dia); //Conversión a entero del día
        String m1=driver.findElement(By.id("custom-month")).getText(); //Mes del calendario
        String a1=driver.findElement(By.id("custom-year")).getText(); //Año del calendario
        dia=driver.findElement(By.cssSelector("[class='day-title-day']")).getText(); //Día de eventos
        d2=Integer.parseInt(dia); //Conversión a entero del día
        String m2=driver.findElement(By.cssSelector("[class='day-title-month']")).getText(); //Mes de eventos
        String a2=driver.findElement(By.cssSelector("[class='day-title-year']")).getText(); //Año de eventos
        if (d1==d2 && m1.equals(m2) && a1.equals(a2)) { //Comparación y comprobación entre fechas calendario/eventos
            correcto=true;
        }
        assertTrue(correcto); 
    }

	@After //Finalizacion del programa
    public void cierre() {
        driver.quit();
    }
}