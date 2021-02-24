package testApp;

/**
 * Archivo main para la ejecución del proyecto de pruebas con Selenium para RakayoClothing
 * @author Pablo Sánchez
 * @version 1.0
 */
public class main {

	/**
	 * Ejecución de todas las pruebas diseñadas en Selenium para la página web
     * Para cada una de las pruebas se inicia el driver, se realzian las pruebas y se cierra el driver
	 * @throws InterruptedException
	 */
    public static void main(String[] args) throws InterruptedException{
        testApp app = new testApp();
        
        app.setUp();
        app.enlacesMenu();
        app.close();

        app.setUp();
        app.comprarItem();
        app.close();

        app.setUp();
        app.comprarAlternativa();
        app.close();

        app.setUp();
        app.comprarUnidadInvalida();
        app.close();

        app.setUp();
        app.seguridadLoginSQL();
        app.close();



    }
}
