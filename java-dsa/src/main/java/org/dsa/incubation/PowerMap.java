package org.dsa.incubation;

import java.util.*;
import java.util.stream.Collectors;

public class PowerMap {
    static int[] dp;
    public static void main(String[] args){
        int  lo = 12, hi = 15, k = 2;
        int res = getKth(lo,hi,k);

    }
    public static int getKth(int lo, int hi, int k) {
        dp = new int[1001];
        Arrays.fill(dp, -1);
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=lo; i<=hi;i++){
            int power = findPower(i,1);
            System.out.println(power-1);
            hm.put(i, power-1);

        }
        List<Integer> res =  hm.entrySet().stream().sorted((e1,e2)-> e1.getValue()-e2.getValue()).map(Map.Entry::getKey).limit(k).toList();

        return res.get(res.size()-1);

    }


    static int findPower(int num, int count){

        if(num<=1){
            return count;

        }


        if(dp[num]!=-1){
            return dp[num];

        }
        if(num%2==0){
           return dp[num]=count+findPower(num/2, count);
        }
        else{
            return dp[num]= count + findPower(3 * num + 1, count);
        }

    }



}