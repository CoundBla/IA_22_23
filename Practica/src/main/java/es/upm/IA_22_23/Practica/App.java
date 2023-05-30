package es.upm.IA_22_23.Practica;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Perceptron2x1 P2x1;
    public static void main( String[] args )
    {
        P2x1 = new Perceptron2x1();
        P2x1.Propagacion();
        P2x1.Retropropagacion();
    }
}
