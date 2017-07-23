
public class Taylor {

    // return n!
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {        
        System.out.println(exponencial(2, 10));

    }

    public static double exponencial(double x, int n) {
        double exp = 1;
        for (int i = 1; i <= n; i++) {
            exp = exp + (Math.pow(x, i)/factorial(i));
        }
        return exp;
    }

}
