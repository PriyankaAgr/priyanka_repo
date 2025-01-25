package org.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<List<String>>  list = new ArrayList<>();
    public static void main(String[] args) {
    String s="a";
        if (new StringBuilder(s).reverse().toString().equals(s)) {
            list.add(List.of(s));
        }
        list.stream().forEach(System.out::println);
    }
}
