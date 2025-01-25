package org.example.dsa;

import java.util.Arrays;
import java.util.*;

/**
Find the pair of array elements which sum are equals to target.
Note: same element should not be added
input = {5, 2, 11, 2, -1, 3};
target = 10;
expected output = [11,-1]
**/

public class TargetSumPair {
    public static void main(String[] args){
        int[] arr = {5,2,11,2,-1,3};
        int target = 10;
        int[] res = findPairs(arr,target);
        Arrays.stream(res).forEach(System.out::println);

    }

    private static int[] findPairs(int[] arr, int sum) {
        int n = arr.length;
        int[] res = new int[2];
        Set<Integer> hs = new HashSet<>();
        for (int j : arr) {
            if (hs.contains(sum - j)) {
                res[0] = j;
                res[1] = sum - j;
            } else {
                hs.add(j);

            }
        }
        return res;
    }
}
