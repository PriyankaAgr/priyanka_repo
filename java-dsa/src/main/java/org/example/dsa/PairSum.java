package org.example.dsa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
Input: arr[] = {92, 75, 65, 48, 45, 35}, k = 10
Output: True
**/
public class PairSum {

    public static void main(String[] args){
        int[] arr = {91, 74, 66, 48};
        int k = 10;
       // System.out.println(findPairs(arr,k));
        String str = "aaabbcaabbddd";
      /* LinkedHashMap<String, Long> hm = str.chars().mapToObj(i1 ->(char)i1).map(s==s.n)
               .forEach((s1,s2)->{if(s1.charValue()==
        if(s1.!=s2){);collect(Collectors.groupingBy(s -> s, LinkedHashMap::new,
                       Collectors.mapping((s1,s2)->
                       return s1.length();
                   }
               })));
        LinkedHashMap<Character, Long> hm = str.chars().mapToObj(i->(char)i).map(i->{
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            if(i!=i){



            }
        }.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        hm.forEach((key, value) -> System.out.println(key + "->" + value));
        str.regionMatches(arg0, arg1)*/

    }

    private static boolean findPairs(int[] arr, int k) {
        int n = arr.length;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = arr[i] + arr[n - i-1];
            if (sum % k == 0) {
                return true;
            }
        }
        return false;
    }

}
