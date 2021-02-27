package SeleniumPruebas;

/**
 * Archivo main para la ejecución del proyecto de pruebas con Selenium para RakayoClothing
 * @author Pablo Sánchez
 * @version 1.0
 */
public class Main {
	/**
	 * Ejecución de todas las pruebas diseñadas en Selenium para la página web
     * Para cada una de las pruebas se inicia el driver, se realzian las pruebas y se cierra el driver
	 * @throws InterruptedException
	 */
    public static void main (String[] args) throws InterruptedException{
        SeleniumPruebas app = new SeleniumPruebas();
        /** Ejecuta las pruebas de enlaces */
        app.setUp();
        app.enlacesMenu();
        app.close();
        /** Ejecuta las pruebas de compra directa */
        app.setUp();
        app.comprarItem();
        app.close();
        /** Ejecuta las pruebas de compra con carrito */
        app.setUp();
        app.comprarAlternativa();
        app.close();
        /** Ejecuta las pruebas de compra con valores inválidos */
        app.setUp();
        app.comprarUnidadInvalida();
        app.close();
        /** Ejecuta la pruebas de inyección de SQL */
        app.setUp();
        app.seguridadLoginSQL();
        app.close();
    }
}
