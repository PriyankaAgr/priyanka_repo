package org.example.dsa;

import java.util.*;

public class LeaderElement {

    public static void main(String[] args){

        int[] arr = {18,16,17,4,3,5,2};

        //2 5 17
        int[] r = Arrays.stream(arr).distinct().toArray();
        Set<Integer> res = findLeader(arr);
        res.forEach(System.out::println);

    }

    private static Set<Integer> findLeader(int[] arr) {

        Stack<Integer> st = new Stack<>();
        Set<Integer> res = new LinkedHashSet<>();
        //st.push(arr[arr.length-1]);
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(arr[i]);
            }
            st.push(arr[i]);



        }
        return res;

    }
}
