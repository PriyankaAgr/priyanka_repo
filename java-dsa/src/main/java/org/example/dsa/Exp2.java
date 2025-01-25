package org.example.dsa;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Write a function to return that element.
 *
 * Input: nums = [1,1,2,2,3,4,4,8,8]
 * Output: 2
 */
public class Exp2 {
//12,10,9,8,6,4,3,1
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,5,6,7,8,9,10};
        int k=2;   // {0,1,2,2,4,5,6,7,8,9 55 54

        int res = findELement(nums,k);
        System.out.println(res);

    }

    private static int findELement(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(i<nums.length){
            pq.add(nums[i++]);

        }
        while(k-1>0){
            pq.poll();
            k--;
        }
        return pq.isEmpty()?-1: pq.peek();
    }
}
