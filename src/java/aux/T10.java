package aux;

import java.util.ArrayList;
import java.util.List;

//(2) Actividad
//Ajuste la rutina para solucionar el problema del cambio con finitas unidades
//de cada denominacion, contemplar billetes y monedas y el cambio se debe realizar
//utilizando la mayor candidad de denominaciones posibles.

/**
 * Algoritmo voraz para soluciona el problema del cambio, con infinitas unidades
 * de cada denominación (Minimo numero de billetes para el cambio)
 * @author jrudascas
 */
public class T10 {

    public static void main(String[] args) {
        List<Integer> denominaciones = new ArrayList<>();
        denominaciones.add(50000);
        denominaciones.add(20000);
        denominaciones.add(10000);
        denominaciones.add(5000);
        denominaciones.add(2000);
        denominaciones.add(1000);
        
        int cambio = 27000;
        int pago = 50000;
        List<Integer> solucion = cambio(denominaciones, cambio, pago);
        
        for (Integer i:solucion){
             System.out.println(i);  
        }
    }
    
    /**
     * Solución del problema del cambio con infinitas denominaciones utilizando
     * un algoritmo voraz
     * 
     * @param denominaciones Lista de las denominaciones actuales disponibles
     * @param cambio Cambio requerido
     * @param pago Monto con el que se realiza el pago
     * @return Retorna la mejor solucion posible según el caso
     */
    
    public static List<Integer> cambio(List<Integer> denominaciones, int cambio, int pago){
        List<Integer> solucion = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();
        boolean encontrada = false;
        int mejor;
        while (!encontrada){
            mejor = mejorCandidato(denominaciones, cambio, solucion);
            aux = (ArrayList)(((ArrayList)solucion).clone());
            aux.add(mejor);
            if (esFactible(aux, cambio)){
                solucion.add(mejor);                
                if (esSolucion(solucion, cambio)){
                    encontrada = true;
                }
            }
        }
        return solucion;
    }
    
    /**
     * Determina si una solucion prometedora en factible
     * 
     * @param solucionPrometedora Coleccion con la solucion prometedora
     * @param cambio El cambio requerido
     * @return Valor de verdad (true si la solucion es factible)
     */
    
    public static boolean esFactible(List<Integer> solucionPrometedora, int cambio){
        int sum = 0;
        for (Integer i:solucionPrometedora){
            sum = sum + i;
        }  
        return sum <= cambio;
    }
    
    /**
     * Determina si la solucion actual es la solucion del problema
     * 
     * @param solucion Coleccion con la solucion actual
     * @param cambio Cambio requerido
     * @return Valor de verdad (true si la solucion actual es la solucion del problema)
     */
    public static boolean esSolucion(List<Integer> solucion, int cambio){
        int sum = 0;
        for (Integer i:solucion){
            sum = sum + i;
        }        
        
        return cambio == sum;
    }
    
    /**
     * Determina cual es el mejor candidado posible dentro de los elegibles
     * 
     * @param denominaciones Lista de las denominaciones actuales disponibles
     * @param cambio Cambio requerido
     * @param solucion Solucion actual
     * @return Retorna la mejor denominacion posible segun el caso
     */
    public static int mejorCandidato(List<Integer> denominaciones, int cambio, List<Integer> solucion){
        int max = -1;
        
        int sum = 0;
        for (Integer i:solucion){
            sum = sum + i;
        } 
        
        for (Integer i:denominaciones){
            if (i > max && (sum + i) <= cambio){
                max = i;
            }
        }
        return max;
    }
}