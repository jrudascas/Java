package aux;

public class T8 {

    int[] subvectorIzquierdo = null;
    int[] subVectorDerecho = null;

    public int[] f1(int p, int q, int[] vector) {
        int[] resultado = null;
        if (Math.abs(p - q) == 1) {
        } else {
            subvectorIzquierdo = f1(p, (p + q) / 2, vector);
            subVectorDerecho = f1((p + q) / 2 + 1, q, vector);
            resultado = combinar(subvectorIzquierdo);
        }

        return resultado;
    }

    int[] combinar(int[] a) {
        //Implementación omitida
        return null;
    }
}
