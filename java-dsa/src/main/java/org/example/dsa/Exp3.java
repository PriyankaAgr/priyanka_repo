package org.example.dsa;

import java.util.Arrays;
import java.util.List;

/**
Maximum Difference between Two Elements such that Larger Element Appears after the Smaller Element

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.
**/
public class Exp3 {

    public static void main(String[] args) throws UnsupportedOperationException{
        int[] nums = {2, 3, 10, 6, 4, 8, 1};
        Integer[] test = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.asList(test);
        System.out.println(list);
        list.set(2,10);
        System.out.println(list.get(2));   //output 1
        System.out.println(test[2]);        //output 2
        int res = findDiff(nums);
        System.out.println(res);

    }

    private static int findDiff(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    int diff = nums[i]-nums[j];
                    max=Math.max(max,diff);

                }

            }
        }

        return max;
    }
}
