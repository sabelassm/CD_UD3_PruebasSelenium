//package circulo;
package pruebaSonarCirculo;
/**
 * Pruebas de refactorización en Visual Studio con la clase Punto
 * 
 * @author Romina Blanco
 * @version %1% Viene de Circulito
 */
public class Puntos {
    /**
     * Parametros de la clase Punto 
     * Coordenada X
     * Coordenada Y 
     * radio
     * Constante del LimiteRadio
     */
    private int coordenadaX;
    private int coordenadaY;
    private double radio;
    static final double LIMITERADIO = 0.0;
    /**
     * 
     * Metodos getter y setter de los parametros
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }

    
    /** 
     * Modifica el parametro CoordenadaX
     * @param coordenadaX
     */
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    
    /** 
     * devuelve el parametro de la coordenadaY
     * @return int
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }

    
    /** 
     * Modifica el valor del parametro coordenadaY
     * @param coordenadaY
     */
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    
    /** 
     * Devuelve el valor de radio
     * @return double
     */
    public double getRadio() {
        return radio;
    }

    
    /** 
     * Modifica el valor del parametro radio
     * @param radio
     */
    public void setRadio(double radio) {
        this.radio = (radio < LIMITERADIO ? 0.0 : radio);
    }
    /**
     * Constructor de la clase Puntos
     * @param coordenadaX
     * @param coordenadaY
     * @param radio
     */
    public Puntos(int coordenadaX, int coordenadaY, double radio) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        setRadio(radio);
    }

}
