package test.ref_valor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    public static void main(String[] a) {
        List<Integer> l = new ArrayList(
                Arrays.asList(31, 41, 1, -4, 
                     4, 5, 151, 51, 3, -9));

        System.out.println(l.stream().
                filter(t -> t % 3 == 0).
                mapToInt(Integer::signum).
                filter(k -> k > 0).count());
    }
}
