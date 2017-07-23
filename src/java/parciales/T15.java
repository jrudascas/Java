package parciales;

import java.io.IOException;
class TestExceptions extends RuntimeException {
    public TestExceptions(String string) {
        super(string);
    }
}

class Test2Exceptions extends IOException {
    public Test2Exceptions(String string) {
        super(string);
    }
}

public class T15 {
    public static void f1() throws RuntimeException {
        throw new TestExceptions("Test Exception 1");
    }
    public static void f2() throws TestExceptions {
        throw new TestExceptions("Test Exception 2");
    }
    public static void f3() throws IOException {
        throw new Test2Exceptions("Test Exception 3");
    }
    public static void f4() {
        try {
            f3();
        } catch (IOException ex) {
            System.out.println("Hola Mundo 2");
        }
    }
    public static void main(String[] arg) {
        while (true) {
            try {
                f4();
                System.out.println("Hola Mundo 7");
                f1();
                System.out.println("Hola Mundo 0");
                f2();
                System.out.println("Hola Mundo 2");
                f3();
                System.out.println("Hola Mundo 1");
            } catch (Test2Exceptions e) {
                System.out.println("Hola Mundo 6");
            } catch (IOException e) {
                System.out.println("Hola Mundo 5");
            }
        }
    }
}
