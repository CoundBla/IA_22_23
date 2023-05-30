package es.upm.IA_22_23.Practica;

public class Neurona {
	//public double[] Entradas = new double[3];
	//public double[] Pesos = new double[3];
	public double Salida;
	
	public void CalcularSalida(double[] Entradas, double[] Pesos) {
		 double neta = 0.0;
	        for (int i = 0; i < Entradas.length; i++) {
	            neta += Entradas[i] * Pesos[i];
	        }
	        Salida = funcionActivacion(neta);
	}
	private double funcionActivacion(double neta) {
		 return 1 / (1 + Math.exp(-neta));
	}
	/*public Neurona(double[] e, double[] p) {
		Entradas = e;
		Pesos = p;
	}*/
}
