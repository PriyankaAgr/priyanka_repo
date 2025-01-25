package org.example.dsa;

import java.util.*;

public class TwoSumUnsorted {

    static int[] res = new int[2];
    public static void main(String[] args) {
        int[] arr = {2, 8,11,7, 15};
        int n = arr.length;
        int target =23;

        findPair(arr,0, target, new ArrayList<>());

        System.out.println("{"+res[0]+","+res[1]+"}");
    }

    static boolean findPair(int[] arr, int st, int target, List<Integer> list){

        if(st>=arr.length || target<0) return false;
        if(list.size()>=2 && target>0){
            return false;
        }
        if(target == 0 ){
            res[0] = list.get(0);
            res[1]=list.get(1);
            return true;

        }
        for(int i=st; i<arr.length;i++){
            list.add(i);
            if(findPair(arr,i+1, target-arr[i], list)) return true;
            list.remove(list.size()-1);

        }
        return false;

    }
}
