package es.upm.IA_22_23.Practica;

public class Perceptron2x1 {
	private double Alpha;
	private Neurona N01;
	private Neurona N02;
	private Neurona N11;
	private Parametros P;
	private double SalidaDeseada;
	
	public Perceptron2x1() {
		SalidaDeseada = 0.211208913475275;
		Alpha = 0.324269810458645;
		P = new Parametros();
		P.Inicializar();
	}
	
	public void Propagacion() {
		double[] ent = new double[3];
		double[] pes = new double[3];
		ent[0] = P.E0;
		ent[1] = P.E1;
		ent[2] = P.E2;
		pes[0] = P.W011;
		pes[1] = P.W111;
		pes[2] = P.W211;
		//N01 = new Neurona(ent,pes);
		N01 = new Neurona();
		N01.CalcularSalida(ent,pes);
		pes[0] = P.W021;
		pes[1] = P.W121;
		pes[2] = P.W221;
		//N02 = new Neurona(ent,pes);
		N02 = new Neurona();		
		N02.CalcularSalida(ent,pes);
		
		ent[1] = N01.Salida;
		ent[2] = N02.Salida;
		pes[0] = P.W012;
		pes[1] = P.W112;
		pes[2] = P.W212;
		//N11 = new Neurona(ent,pes);
		N11 = new Neurona();
		N11.CalcularSalida(ent,pes);
	}
	
	public void Retropropagacion() {
		double errorSalida = SalidaDeseada - N11.Salida;

	    // 1. Nos aseguramos de que los AW estén a 0.0
	    P.AW011 = 0.0;
	    P.AW021 = 0.0;
	    P.AW111 = 0.0;
	    P.AW121 = 0.0;
	    P.AW211 = 0.0;
	    P.AW221 = 0.0;
	    P.AW011 = 0.0;
	    P.AW021 = 0.0;
	    P.AW111 = 0.0;
	    P.AW121 = 0.0;
	    P.AW211 = 0.0;
	    P.AW221 = 0.0;

	    // 2. Actualizar los pesos de la capa de salida
	    P.AW011 += Alpha * errorSalida * N01.Salida;
	    P.AW021 += Alpha * errorSalida * N02.Salida;

	    // 3. Retropropagar el error a las capas ocultas
	    double errorOculta = N11.Salida * (1 - N11.Salida) * (P.W011 * errorSalida + P.W021 * errorSalida);

	    P.AW111 += Alpha * errorOculta * N01.Salida;
	    P.AW121 += Alpha * errorOculta * N02.Salida;
	    P.AW211 += Alpha * errorOculta * N01.Salida;
	    P.AW221 += Alpha * errorOculta * N02.Salida;

	    // 4. Actualizar los pesos de la capa oculta
	    P.AW011 += Alpha * errorOculta * P.E0;
	    P.AW021 += Alpha * errorOculta * P.E0;
	    P.AW111 += Alpha * errorOculta * P.E1;
	    P.AW121 += Alpha * errorOculta * P.E1;
	    P.AW211 += Alpha * errorOculta * P.E2;
	    P.AW221 += Alpha * errorOculta * P.E2;

	    // Actualizar los pesos
	    P.W011 += P.AW011;
	    P.W021 += P.AW021;
	    P.W111 += P.AW111;
	    P.W121 += P.AW121;
	    P.W211 += P.AW211;
	    P.W221 += P.AW221;
	    P.W011 += P.AW011;
	    P.W021 += P.AW021;
	    P.W111 += P.AW111;
	    P.W121 += P.AW121;
	    P.W211 += P.AW211;
	    P.W221 += P.AW221;
	}
}
