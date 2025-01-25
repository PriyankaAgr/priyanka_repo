package org.example.dsa;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}, start = TOON, target = PLEA
 * Output: 7
 * Explanation: TOON – POON – POIN – POIE – PLIE – PLEE – PLEA
 * <p>
 * Input: Dictionary = {ABCD, EBAD, EBCD, XYZA}, start = ABCV, target = EBAD
 * Output: 4
 * Explanation: ABCV – ABCD – EBCD – EBAD
 **/
public class WordLadder {

    public static void main(String[] args) {

        String[] str = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};

        String start = "TOON";
        String target = "PLEA";

        findLadder(str, start, target);
    }

    private static void findLadder(String[] str, String start, String target) {

        Set<String> hs =  Arrays.stream(str).filter(s -> s.startsWith(start.substring(0,1))).collect(Collectors.toSet());

    }
    }
