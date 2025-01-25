package org.dsa.incubation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LC1813 {

    public static void main(String[] args) {
        String s1 = "My name is Haley";
        String s2 = "My Haley";
        System.out.println(areSentencesSimilar(s1, s2));
    }



    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        int l1 = sentence1.length();
        int l2 = sentence2.length();

        if (l2 > l1) {
            String tmp = sentence2;
            sentence2 = sentence1;
            sentence1 = tmp;

        }
        boolean isInserted = false;

        String[] str = sentence2.split("\\s");
        int i = 0;
        int wc = 0;
        int st = 0;
        for (String w : str) {
            // String pattern = "\\b" + Pattern.quote(str[i]) + "\\b";
            // st = wc + 1;


        }

        return !isInserted ? true : (isInserted && wc-1 == sentence1.length()) ? true : false;
    }
}
