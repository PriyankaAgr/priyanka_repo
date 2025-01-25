package org.dsa.incubation;

import java.util.*;
import java.util.PriorityQueue;

/** Given an array of number, you need to select all pairs such that sum is equal
Sample Input = [1,2,3,4,5]
output = [ (1,4),(2,3)], [(1,5),(2,4)], [(2,5), (3,4)] **/

class ListPair<I extends Number> {
    Integer x;
    List<Integer> y;

    ListPair(Integer x, List<Integer> y){
        this.x=x;
        this.y.addAll(y);

    }
}
public class PairSorting {

    public static void main(String[] args) {
        int[] num1={};
        int[] num2={};
        int k=2;

        List<List<Integer>> res = kSmallestPairs(num1,num2, k);
        res.forEach(x-> System.out.println(x));
    }

    private static List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {

        return null;
    }


}
