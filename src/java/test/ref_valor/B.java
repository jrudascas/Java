package test.ref_valor;

class A {
    private final int n;
    private double[] data;
    
    public A(double[] data) {
        this.n = data.length;
        this.data = data;
    }
    public int length() {
        return n;
    }
    public double f1(A that) {
        double b = 0.0;
        for (int i = 0; i < n; i++) {
            b = b + (this.data[i] * that.data[i]);
        }
        return b;
    }
}
public class B {
    public static void main(String arg[]) {
        double[] data1 = {5.0, 6.0, -3.0, -1.0};
        double[] data2 = {-5.0, 8.0, -3.0, 12.0};
        System.out.println(new A(data1).f1(new A(data2)));
    }
}
