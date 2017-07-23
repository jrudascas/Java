package parciales;

public class T3 {

    protected int n;
    protected double s;

    public T3(int c, double i) {
        n = c;
        s = i;
    }

    public void f1(double c) {
        s = s + c;
    }

    public double f2() {
        return s;
    }
}
