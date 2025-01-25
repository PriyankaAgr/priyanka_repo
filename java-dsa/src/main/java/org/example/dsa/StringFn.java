package org.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringFn {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abc";

        int n = str.length();
        helper(str, new StringBuilder(""), n);
        list.forEach(s -> System.out.println(s));
    }


    private static void helper(String str, StringBuilder tmp, int n) {

        if (tmp.length() == n) {
            list.add(tmp.toString());
            //System.out.println(tmp);
            tmp = new StringBuilder();
        }
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i)); //ab

            helper(str.substring(0, i) + str.substring(i + 1), tmp, n); // acd
            tmp.deleteCharAt(tmp.length() - 1);


        }
    }
}

