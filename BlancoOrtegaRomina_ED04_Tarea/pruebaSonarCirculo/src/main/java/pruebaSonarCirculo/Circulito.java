//package circulo;
package pruebaSonarCirculo;
/**
 * Pruebas de refactorización en Visual Studio con la clase Circulo
 * 
 * @author Romina Blanco
 * @version %1% añadiendo la clase Puntos
 * {@link C:\DAWA_curso20202021\contornos\tareaContornos\Tarea4\Circulo\javadoc\index.html}
 */
public class Circulito {

    /**
     * Instanciamos la clase Puntos
     */
    private Puntos punto = null;

    /**
     * Constructor
     * 
     * @param punto
     */
    public Circulito(Puntos punto) {
        this.punto = punto;
    }

    /**
     * devuelve el valor del diametro
     * utilizando el metodo getRadio 
     * de la clase Puntos
     * @return 
     */
    public double obtenerDiametro() {
        return punto.getRadio() * 2;
    }

    /**
     * devuelve el valor del diametro de la circunferencia
     * utilizando el metodo obtenerDiametro
     * @return 
     */
    public double obtenerCircunferencia() {
        return Math.PI * obtenerDiametro();
    }

    /**
     * devuelve el valor del area del circulo
     * utilizando el metodo de getRadio de la clase Puntos 
     * @return 
     */
    public double obtenerAreaCirculo() {
        return Math.PI * punto.getRadio() * punto.getRadio();
    }

    /**
     * Para trasladar el centro
     */
    public void trasladarCentro() {
        punto.setCoordenadaX(punto.getCoordenadaX() + 5);
        punto.setCoordenadaY(punto.getCoordenadaY() + 5);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Centro = [" + punto.getCoordenadaX() + "," + punto.getCoordenadaY() + "]; Radio = " + punto.getRadio();
    }

}
