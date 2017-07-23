package test.ref_valor;

public class D {

    public static void main(String[] arg) {
        System.out.println(f1(72, 6));
    }

    static int f1(int a, int b) {
        if (b > a) {
            return 0;
        } else {
            return f1(a - b, b) + 1;
        }
    }
}
