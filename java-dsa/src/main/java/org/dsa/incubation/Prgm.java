package org.dsa.incubation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prgm {

    public static void main(String[] args) {
        String str="aaaabbddddcccc";

        String reg1="a|d";
        String reg2="b|c";
        int[] freq = new int[4];
        String regex ="^(([ac]*(([ac][ac])*))|([ac]([ac][ac])*))(([bd]*(([bd][bd])*))|([bd]([bd][bd])*))$";

        //String regex="^(([ac]*(([ac][ac])*))|([bd]*(([bd][bd])*)))$";

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.peek();
        pq.remove();

        




    }
}
