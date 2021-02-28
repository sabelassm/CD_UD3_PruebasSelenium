//package circulo;
package pruebaSonarCirculo;
import java.text.DecimalFormat;

/**
 * Pruebas de refactorización de la clase Main
 * 
 * @author Romina Blanco
 * @version %1% de Circulito
 */

public class Main {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        Puntos punto = new Puntos(37, 43, 2.5);
        Circulito circulo = new Circulito(punto);
        String salida = "La coordenada X es " + punto.getCoordenadaX() + "\nLa coordenada Y es "
                + punto.getCoordenadaY() + "\nEl radio es " + punto.getRadio();
        punto.setCoordenadaX(35);
        punto.setCoordenadaY(20);
        punto.setRadio(4.2);
        DecimalFormat dosDigitos = new DecimalFormat("0.00");
        salida += "\nEl diámetro es " + dosDigitos.format(circulo.obtenerDiametro()) ;
        salida += "\nLa circunferencia es " + dosDigitos.format(circulo.obtenerCircunferencia());
        salida += "\nEl área es " + dosDigitos.format(circulo.obtenerAreaCirculo());
        System.out.println(salida);
        System.out.println(salida);
        System.exit(0);

    }

}
