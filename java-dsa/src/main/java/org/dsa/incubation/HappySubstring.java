package org.dsa.incubation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HappySubstring {

    public static void main(String[] args){
       System.out.println(longestDiverseString(1,4,7));
    }

    static StringBuilder sb = new StringBuilder(" ");
    public static String longestDiverseString(int a, int b, int c) {

        PriorityQueue<CharPair<Character,Integer>> pq = new PriorityQueue<>((p1, p2)-> p2.b-p1.b);
        pq.add(new CharPair<>('a',a));
        pq.add(new CharPair<>('b',b));
        pq.add(new CharPair<>('c',c));

        while(!pq.isEmpty()){
            CharPair<Character, Integer> p1 = pq.poll();
            CharPair<Character, Integer> p2 = pq.poll();
            if(p1!=null && sb.charAt(sb.length()-1)!=p1.a){
                append(pq,p1);
            }
            if(p2!=null && sb.charAt(sb.length()-1)!=p2.a){
                append(pq,p2);
            }
        }
        return sb.toString();

    }
    int[] arr = new int[2];

    static void append(PriorityQueue<CharPair<Character, Integer>> pq, CharPair<Character, Integer> p){
        if(p.b==0){
            return;
        }
        int v=p.b;
        for(int k=0; k<Math.min(2,v);k++){
            sb.append(p.a);
            p.b--;
        }
        if(p.b!=0){
            pq.offer(p);
        }

    }
}

class CharPair<C, I extends Number> {
    Character a;
    Integer b;

    CharPair(Character a, Integer b){
        this.a=a;
        this.b=b;
    }
}
/**
 p1ir = a,1
 sb= aabaabb
 limit=2
 a=7 5 3
 b=3 0
 c=51

 aabbccaabccaaca
 total=9

 aaccbbaaccbaaca

 */


