package org.example.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
O/P: 5

I/P review = amazing hotel.  O/P=5
I/P the room was quite dirty but the view was nice O/P (-1+1) 0;
I/P i have never been to such a tidy and well-organised hotel O/P (2+3)=5

**/
public class HotelAnalysis {

    public static void main(String[] args) {

        String[] words = {"amazing", "well-organised", "tidy", "nice", "dirty", "horrible"};
        int[] scores = {5, 3, 2, 1, -1, -3};

        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], scores[i]);
        }


        String review = "the room was quite dirty but the view was nice";

        String[] reviews = review.split("[\\s|,|;]+");

        int total = Arrays.stream(reviews).filter(r -> hm.containsKey(r)).map(r -> hm.get(r)).reduce(0, Integer::sum);


        System.out.println(total);
        String[] wordss = {"ad","bd","aaab","baa","badab"};
        countConsistentStrings("ab", wordss);
    }

        public static int countConsistentStrings(String allowed, String[] words) {
            boolean[] isAllow = new boolean[26];
            for(char c : allowed.toCharArray()){
                isAllow[c-'a']=true;
            }
            int count = (int) Arrays.stream(words).filter(word-> word.chars().allMatch(w-> isAllow[w-'a'])).count();

            return count;

        }
    }

