package es.upm.IA_22_23.Practica;

public class Perceptron2x1 {
    private Parametros parametros;
    private double salidaDeseada;
    private Neurona N01;
    private Neurona N02;
    private Neurona N11;

    public Perceptron2x1() {
        parametros = new Parametros();
        parametros.Inicializar();
        salidaDeseada = 0.211208913475275;
        N01 = new Neurona();
        N02 = new Neurona();
        N11 = new Neurona();
    }

    public void propagacion() {
        double[] entradas = {parametros.E0, parametros.E1, parametros.E2};
        double[] pesos;

        N01 = new Neurona();
        pesos = new double[]{parametros.W011, parametros.W111, parametros.W211};
        N01.CalcularSalida(entradas, pesos);

        N02 = new Neurona();
        pesos = new double[]{parametros.W021, parametros.W121, parametros.W221};
        N02.CalcularSalida(entradas, pesos);

        entradas[1] = N01.Salida;
        entradas[2] = N02.Salida;

        N11 = new Neurona();
        pesos = new double[]{parametros.W012, parametros.W112, parametros.W212};
        N11.CalcularSalida(entradas, pesos);

        parametros.S01 = entradas[0];
        parametros.S11 = N01.Salida;
        parametros.S12 = N02.Salida;
        parametros.S21 = N11.Salida;
    }

    public void retropropagacion() {
        double errorSalida = salidaDeseada - parametros.S21;

        // Reinicializar los AW a 0
        parametros.AW011 = 0.0;
        parametros.AW012 = 0.0;
        parametros.AW021 = 0.0;
        parametros.AW111 = 0.0;
        parametros.AW112 = 0.0;
        parametros.AW121 = 0.0;
        parametros.AW211 = 0.0;
        parametros.AW212 = 0.0;
        parametros.AW221 = 0.0;

        // Calcular los AW correspondientes
        parametros.AW021 += parametros.alpha * errorSalida * parametros.S11;
        parametros.AW121 += parametros.alpha * errorSalida * parametros.S12;

        // Calcular el error de la capa oculta
        double errorOculta = parametros.S11 * (1 - parametros.S11) * (parametros.W121 * errorSalida);

        // Calcular los lambdas
        parametros.Lambda11 = parametros.W111 * errorOculta;
        parametros.Lambda12 = parametros.W121 * errorOculta;
        parametros.Lambda21 = parametros.W211 * errorOculta;

        // Actualizar los AW de la capa oculta
        parametros.AW011 += parametros.alpha * errorOculta * parametros.S01;
        parametros.AW111 += parametros.alpha * errorOculta * parametros.S11;
        parametros.AW211 += parametros.alpha * errorOculta * parametros.S01;
        parametros.AW121 += parametros.alpha * errorOculta * parametros.S12;

        // Actualizar los AW de la capa de entrada
        parametros.AW012 += parametros.alpha * parametros.Lambda12 * parametros.S01;
        parametros.AW112 += parametros.alpha * parametros.Lambda11 * parametros.S11; // Corregido
        parametros.AW212 += parametros.alpha * parametros.Lambda11 * parametros.S01;

        // Actualizar los pesos con los AW calculados
        parametros.W011 += parametros.AW011;
        parametros.W012 += parametros.AW012;
        parametros.W021 += parametros.AW021;
        parametros.W111 += parametros.AW111;
        parametros.W112 += parametros.AW112;
        parametros.W121 += parametros.AW121;
        parametros.W211 += parametros.AW211;
        parametros.W212 += parametros.AW212;
        parametros.W221 += parametros.AW221;

        // Asignar los nuevos pesos a los correspondientes _prima
        parametros.W011_prima = parametros.W011;
        parametros.W012_prima = parametros.W012;
        parametros.W021_prima = parametros.W021;
        parametros.W111_prima = parametros.W111;
        parametros.W112_prima = parametros.W112;
        parametros.W121_prima = parametros.W121;
        parametros.W211_prima = parametros.W211;
        parametros.W212_prima = parametros.W212;
        parametros.W221_prima = parametros.W221;
    }
}
