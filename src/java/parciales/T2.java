package parciales;

class T1_ {

    static int n = 0;

    String f(T1_ x) {
        return "AA" + (x.n++);
    }

    String f(T2 x) {
        return "AB" + (x.n--);
    }
}

class T2 extends T1_ {

    String f(T2 x) {
        return "BB" + (x.n--);
    }

    public static void main(String args[]) {
        T1_ a = new T1_();
        T1_ b = new T2();
        System.out.println(a.f(b));
        System.out.println(b.f(b));
        System.out.println(a.f((T2) b));
        System.out.println(b.f((T2) b));
    }
}
