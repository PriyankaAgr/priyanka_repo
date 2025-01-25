package org.example.dsa;

import java.util.*;
import java.util.stream.IntStream;


public class DigitOne {

    public static void main(String[] args) {
        int i = 0;

        long l = IntStream.range(0, i+1).boxed().map(e -> Integer.toString(e)).filter(r -> r.contains("1"))
                .flatMap(d -> d.chars().mapToObj(Character::toString)).filter(w -> w.contains("1")).count();

        System.out.println(l);
    }

}