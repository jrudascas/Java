package aux;


//(1.5) Actividad 1
//Ajuste la rutina tal que el criterio de parada del algoritmo de enfriamiento
//simulado sea el siguiente:
//El algoritmo debera deternese cuando la varianza de las ultimas k soluciones
//sea inferior a un umbral p.

//(1) Actividad 2
//Ajuste la rutina tal que las soluciones generadas fuera del espacio de busqueda
//sean descartadas.

//(0.5) Actividad 3
//Optimice la funcion z = -v² -(w+17)² - (x-12)² - (y+PI)²

/**
 * Algoritmo de enfriamiento simulado version clasica
 * @author jrudascas
 */

public class T20 {
    
    static double Ti = 10000;
    static double Tf = 0;
    static double dP = 0.05;
    
    static double dT = 0.5;
    static double C = 0.00013;
    static int maxV = 100;
    static int minV = -100;
    static int N = 100;

    public static void main(String[] args) {
        
        double[] punto = new double[2];
        punto[0] = (Math.random() * (maxV - minV)) + minV;        
        punto[1] = (Math.random() * (maxV - minV)) + minV;

        double T = Ti;
        
        while (T > Tf) {
            int nIteracciones = N;
            while (nIteracciones > 0) {
                double puntoPrima[] = perturbar(punto);
                double dZ = funcion(puntoPrima) - funcion(punto);
                if (dZ > 0) {
                    punto = puntoPrima;
                } 
                else {
                    if (Math.random() < funcionProbabilidad(dZ, T)) {
                        punto = puntoPrima;
                    }
                }
                nIteracciones--;
            }
            T = T - dT;
        }

        System.out.println("Solución Final");
        for (int i = 0; i < punto.length; i++) {
            System.out.println(punto[i]);
        }
    }

    public static double funcionProbabilidad(double deltaFuncion, double temperatura) {        
        return Math.exp(deltaFuncion / (C*temperatura));
    }

    public static double[] perturbar(double[] punto) {
        double factorPerturbacion;
        double[] puntoAux = new double[punto.length];
        for (int i = 0; i < punto.length; i++) {
            factorPerturbacion = ((Math.random() < 0.5) ? -1 : 1) * dP;
            puntoAux[i] = punto[i] + factorPerturbacion;
        }

        return puntoAux;
    }

    public static double funcion(double[] punto) {
        return -1*((punto[0]+14) * (punto[0]+14)) -1*((punto[1]-23) * (punto[1]-23));
    }
}
