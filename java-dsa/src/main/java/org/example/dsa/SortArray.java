package org.example.dsa;

import java.util.Arrays;

/**
 * Given an array A[] consisting of only 0s, 1s, and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.

        Input: {0, 1, 2, 0, 1, 2} Output: {0, 0, 1, 1, 2, 2}

Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1} Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
**/

public class SortArray {

    public static void main(String[] args){
        int[] arr = {1,2,0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int[] res = sortArr(arr);
        Arrays.stream(res).forEach(System.out::println);

    }

    private static int[] sortArr(int[] arr) {
        int l=0;
        int r= arr.length-1;
        int i=0;
        while(i<=r){

            if(arr[i]==0){

                int tmp = arr[l];
                arr[l]=arr[i];
                arr[i]= tmp;
                l++;
                i++;

            }
            else if(arr[i]==2){

                int tmp = arr[r];
                arr[r]=arr[i];
                arr[i]= tmp;
                r--;
            }
            else {
                i++;
            }





        }
        return arr;

    }
}
