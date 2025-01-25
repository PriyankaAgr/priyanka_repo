package org.example.dsa;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args){
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int[] res = countSortArr(arr);
        Arrays.stream(res).forEach(System.out::println);

    }

    private static int[] countSortArr(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int n = arr.length;
        int[] countArr = new int[max+1];
        for(int i=0;i<n;i++){
            countArr[arr[i]]++;
        }
        int m = countArr.length;
        for(int i=1;i<m;i++){
            countArr[i]+=countArr[i-1];
        }
        int[] output = new int[n];

        for(int j=n-1;j>=0;j--){
            output[countArr[arr[j]]-1] = arr[j];
            countArr[arr[j]]--;
        }
        return output;



    }


}
