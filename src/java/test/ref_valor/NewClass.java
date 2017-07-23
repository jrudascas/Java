package test.ref_valor;

import java.util.Scanner;

public class NewClass {

    public static void main(String[] args) {
        int max = 3000;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantas parejas desea buscar? ");
        System.out.println();
        int n = scanner.nextInt();
        
        int cont = 0;
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < max; j++) {
                if (sumaDiv(i) == j && sumaDiv(j) == i && i < j ) {
                    System.out.println(i + " - " + j);
                    cont++;
                }
            }
            if (cont == n)
                break;
        }
    }

    public static int sumaDiv(int n) {
        int suma = 0;
        for (int i = 1; i < n / 2 + 1; i++) {
            if ((n % i) == 0) {
                suma += i;
            }
        }
        return suma;
    }
}
