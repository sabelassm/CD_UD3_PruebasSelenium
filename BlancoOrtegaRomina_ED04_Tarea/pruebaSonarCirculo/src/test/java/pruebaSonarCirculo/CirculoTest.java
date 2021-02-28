//package circulo;
package pruebaSonarCirculo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Pruebas de refactorización en Visual Studio con la clase Circulo
 * 
 * @author Romina Blanco
 * @version %1% añadiendo la clase Puntos
 * {@link C:\DAWA_curso20202021\contornos\tareaContornos\Tarea4\Circulo\javadoc\index.html}
 * {@link }
 */
public class CirculoTest {

    /**
     * Test of establecerX method, of class Circulo.
     */
    @Test
    public void testEstablecerX() {
        System.out.println("establecerX");
        int valorX = 0;
        Puntos instance = new Puntos(0, 0, 0.1);
        instance.setCoordenadaX(valorX);
                
    }

    /**
     * Test of establecerY method, of class Circulo.
     */
    @Test
    public void testEstablecerY() {
        System.out.println("establecerY");
        int valorY = 0;
        Puntos instance = new Puntos(0, 0, 0.1);
        instance.setCoordenadaY(valorY);
    }

    /**
     * Test of establecerRadio method, of class Circulo.
     */
    @Test
    public void testEstablecerRadio() {
        System.out.println("establecerRadio");
        Puntos instance = new Puntos(0, 0, 0.1);
        instance.setRadio(0.0);
        instance.setRadio(0.1);
        instance.setRadio(-0.1);
    }

    /**
     * Test of obtenerX method, of class Circulo.
     */
    @Test
    public void testObtenerX() {
        System.out.println("obtenerX");
        Puntos instance = new Puntos(0, 0, 0.1);
        int expResult = 0;
        int result = instance.getCoordenadaX();
        assertEquals(expResult, result);
    }


    /**
     * Test of obtenerY method, of class Circulo.
     */
    @Test
    public void testObtenerY() {
        System.out.println("obtenerY");
        Puntos instance = new Puntos(0, 0, 0.1);
        int expResult = 0;
        int result = instance.getCoordenadaY();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerRadio method, of class Circulo.
     */
    @Test
    public void testObtenerRadio() {
        System.out.println("obtenerRadio");
        Puntos instance = new Puntos(0, 0, 0.1);
        double result = instance.getRadio();
        assertEquals(0.1, result,0);

        instance.setRadio(0.1);
        result= instance.getRadio();
        assertEquals(0.1, result,0);

        instance.setRadio(-0.1);
        result= instance.getRadio();
        assertEquals(0.0, result,0);
    }

    /**
     * Test of obtenerDiametro method, of class Circulo.
     */
    @Test
    public void testObtenerDiametro() {
        System.out.println("obtenerDiametro");
        Puntos instance = new Puntos(0, 0, 0.1);
        Circulito circulo = new Circulito(instance);
        double result = circulo.obtenerDiametro();
        assertEquals(0.2, result,0);
    }

    /**
     * Test of obtenerCircunferencia method, of class Circulo.
     */
    @Test
    public void testObtenerCircunferencia() {
        System.out.println("obtenerCircunferencia");
        Puntos instance = new Puntos(0, 0, 0.1);
        Circulito circulo = new Circulito(instance);
        double expResult = 0.6283185;
        double result = circulo.obtenerCircunferencia();
        assertEquals(expResult, result,1e-6);
    }

    /**
     * Test of obtenerArea method, of class Circulo.
     */
    @Test
    public void testObtenerArea() {
        System.out.println("obtenerArea");
        Puntos instance = new Puntos(0, 0, 0.1);
        Circulito circulo = new Circulito(instance);
        double expResult = 0.0314159;
        double result = circulo.obtenerAreaCirculo();
        assertEquals(expResult, result,1e-6);
    }

    
    /**
     * Test of trasladarCentro method, of class Circulo.
     */
    @Test
    public void testTrasladarCentro() {
        System.out.println("trasladarCentro");
        Puntos instance = new Puntos(0, 0, 0.1);
        Circulito circulo = new Circulito(instance);
        int resultx=instance.getCoordenadaX();
        int resulty=instance.getCoordenadaY();
        circulo.trasladarCentro();
        int resultnx = instance.getCoordenadaX();
        int resultny = instance.getCoordenadaY();
        
        assertEquals("El resultado esta mal",resultx +5, resultnx);
        assertEquals(" El resultado esta mal",resulty +6, resultny);
        
    }
   

}