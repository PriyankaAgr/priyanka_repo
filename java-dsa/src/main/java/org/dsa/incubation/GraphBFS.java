package org.dsa.incubation;// you can also use imports, for example:
import java.util.*;
import java.util.stream.Collectors;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class GraphBFS {

    public static void main(String[] args){
        int N=7;
        int[] A={0,1,2,1,4,4};
        int[] B ={1,2,0,4,5,6};
        System.out.println(solution(N,A,B));
    }
    public static int solution(int N, int[] A, int[] B) {
        // Implement your solution here
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        int M = A.length;
        for(int K=0;K<M;K++){

            if(!edgeMap.containsKey(A[K])){
                edgeMap.put(A[K], new ArrayList<>());
            }
            edgeMap.get(A[K]).add(B[K]);

            if(!edgeMap.containsKey(B[K])){
                edgeMap.put(B[K], new ArrayList<>());
            }
            edgeMap.get(B[K]).add(A[K]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int t1=0;
        boolean[] vis = new boolean[N];
        pq.addAll(edgeMap.entrySet().stream().filter(e-> e.getValue().size()<=1).map(Map.Entry::getKey).toList());
        while(!pq.isEmpty()){
            int size=pq.size();
        for(int i=0;i<size;i++) {
            int key = pq.poll();
                vis[key] = true;
                for(Integer v : edgeMap.get(key)) {
                    edgeMap.get(v).remove((Integer) key);
                    if(edgeMap.get(v).size()<=1 && !pq.contains(v)){
                        pq.offer(v);
                    }
                }

            }
            t1++;
        }
        return t1;

    }
}
