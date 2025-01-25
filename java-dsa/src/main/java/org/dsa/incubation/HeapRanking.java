package org.dsa.incubation;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class HeapRanking {

    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        findRelativeRanks(score);

    }
    public static void findRelativeRanks(int[] score) {

        int n= score.length;
        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            rank[i]=i;
        }
        int[] sortedRank = Arrays.stream(rank)
                .boxed()
                .sorted((a, b) -> Integer.compare(score[b], score[a]))
                .mapToInt(Integer::intValue).toArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.remove(n);
        String[] str = new String[score.length];

        for(int i=0;i<score.length;i++){
            if(sortedRank[i]==1){
                str[i]="Gold Medal";

            }
            else if(sortedRank[i]==2){
                str[i]="Silver Medal";
            }
            else if(sortedRank[i]==3){
                str[i]="Bronze Medal";
            }
            else {
                str[i]= String.valueOf(i+1);
            }
        }
    }
}