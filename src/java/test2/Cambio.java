/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test2;

public class Cambio {

    private int[][] matrizCambio;
    private int[] vectorDenominaciones;
    private int cantidad;
    private int[] vectorSeleccion;

    public static void main(String[] args) {
        int[] denominaciones = new int[]{1, 4, 6};

        Cambio c = new Cambio(7, denominaciones);

        for (int i = 0; i < denominaciones.length; i++) {
            System.out.println("Billetes de " + denominaciones[i] + " : " + c.getVectorSeleccion()[i]);
        }
    }

    Cambio(int cantidad, int[] denominaciones) {
        this.cantidad = cantidad;
        this.vectorDenominaciones = denominaciones;
        matrizCambio = calcularMonedas(cantidad, denominaciones);
        vectorSeleccion = seleccionarMonedas(cantidad, denominaciones, matrizCambio);
    }

    public int[] getVectorSeleccion() {
        return this.vectorSeleccion;
    }

    private int[][] calcularMonedas(int cantidad, int[] denominaciones) {

        int[][] matrizCambio = new int[denominaciones.length+1][cantidad + 1];

        for (int i = 0; i <= denominaciones.length; i++) {
            matrizCambio[i][0] = 0;
        }

        for (int j = 1; j <= cantidad; j++) {
            matrizCambio[0][j] = j;
        }

        for (int i = 1; i <= denominaciones.length; i++) {
            for (int j = 1; j <= cantidad; j++) {
                if (j < denominaciones[i - 1]) {
                    matrizCambio[i][j] = matrizCambio[i - 1][j];
                } else {
                    int minimo = 0;
                    minimo = Math.min(matrizCambio[i - 1][j], matrizCambio[i][j - denominaciones[i - 1]] + 1);
                    matrizCambio[i][j] = minimo;
                }
            }
        }

        return matrizCambio;
    }

    private int[] seleccionarMonedas(int c, int[] monedas, int[][] tabla) {
        int i, j;
        int[] seleccion = new int[monedas.length];
        for (i = 0; i < monedas.length; i++) {
            seleccion[i] = 0;
        }
        i = monedas.length;
        j = c;
        
        imprimirMatriz(tabla);
        
        while (j > 0) {
            if (i > 1 && tabla[i][j] == tabla[i - 1][j]) {
                i--;
            } else {
                seleccion[i - 1]++;
                j = j - monedas[i - 1];
            }
        }

        return seleccion;
    }

    private void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
