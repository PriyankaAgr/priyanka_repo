package org.example.dsa;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidDigits {

    public static void main(String[] args) {
        int[] arr = {14, 123, 323, 321, 3234, 431, 53635};
        //validDigit(arr);
        System.out.println(validDigit(arr));


    }

    static int validDigit(int[] arr) {

        int max = Integer.MIN_VALUE;

        Map<Character, List<String>> hm = new HashMap<>();

        for (int i : arr) {
            char idx = String.valueOf(i).charAt(0);
            hm.computeIfAbsent(idx, k -> new ArrayList<>()).add(String.valueOf(i));
            hm.put(idx, hm.get(idx));

        }

        for (Map.Entry<Character, List<String>> e : hm.entrySet()) {
            for (String s : e.getValue()) {
                char ch = s.charAt(s.length() - 1);
                Optional<String> res = hm.get(ch).stream().filter(v -> !v.equals(s) && Integer.parseInt(v) > Integer.parseInt(s)).map(v -> s + v).filter(v -> v.charAt(0) == v.charAt(v.length() - 1)).max(Comparator.comparingInt(String::length));
                if (res.isPresent()) {
                    System.out.println(res.get());
                    max = Math.max(res.get().length(), max);

                }
            }
        }

        return max;

    }
}
