	package es.upm.IA_22_23.Practica;
	
	public class Parametros {
		public double alpha;
		public double AW011;
		public double AW012;
		public double AW021;
		public double AW111;
		public double AW112;
		public double AW121;
		public double AW211;
		public double AW212;
		public double AW221;
		//Entrada 0
		public double E0;
		//Entrada 1
		public double E1;
		//Entrada 2
		public double E2;
		
		public double Lambda11;
		public double Lambda12;
		public double Lambda21;
		public double S01;
		public double S11;
		public double S12;
		public double S21;
		public double Sd;
		public double V11;
		public double V21;
		public double W011;
		public double W011_prima;
		public double W012;
		public double W012_prima;
		public double W021;
		public double W021_prima;
		public double W111;
		public double W111_prima;
		public double W112;
		public double W112_prima;
		public double W121;
		public double W121_prima;
		public double W211;
		public double W211_prima;
		public double W212;
		public double W212_prima;
		public double W221;
		public double W221_prima;
		
		public void Inicializar() {
			E0 = 1.0;
			E1 = 0.386124387383461;
			E2 = 0.0957537812646478;
			//Capa oculta
			W011 = 0.619945486541837;
			W111 = 3.05990373715758;
			W211 = -0.392925175838172;
			W021 = 2.45627271244302;
			W121 = 1.62006904603913;
			W221 = -1.1863021692261;
			//Capa 1
			W012 = -1.69834141153842;
			W112 = -2.02845993684605;
			W212 = 1.75631897058338;	
			
			//alpha
			alpha = 0.324269810458645;
		}
		
		
	}
