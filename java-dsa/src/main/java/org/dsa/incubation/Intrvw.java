package org.dsa.incubation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intrvw {
    public static void main(String[] args) throws IOException {

        List<Integer> num = List.of(1, 2, 3, 4, 1, 5);
        List<String> result = bitPattern(num);
        result.forEach(System.out::println);

    }

    /*
     * Complete the 'bitPattern' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER_ARRAY num as parameter.
     */

    public static List<String> bitPattern(List<Integer> num) {
        // Write your code here

        StringBuilder st = new StringBuilder();
        StringBuilder last = new StringBuilder();
        int n = num.size() - 1;
        Map<Integer, Boolean> m1 = new HashMap<>();
        Map<Integer, Boolean> m2 = new HashMap<>();
   
        for (int i = 0; i <= n; i++) {
            if (m1.getOrDefault(num.get(i), false)) st.append('1');
            else st.append('0');
            if (m2.getOrDefault(num.get(n - i), false)) last.insert(0, '1');
            else last.insert(0, '0');

            m1.put(num.get(i), true);
            m2.put(num.get(n - i), true);

        }


        return List.of(st.toString(), last.toString());

    }

}
