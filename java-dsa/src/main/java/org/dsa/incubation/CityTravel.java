
package org.dsa.incubation;

import java.util.*;


class Solution {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        findTheCity(n, edges, distanceThreshold);

    }


    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        Map<Integer, Pair<Integer, Integer>> hm = new HashMap<>();
        HashMap<Integer, List<int[]>> adj = new HashMap();

        for (int[] e : edges) {
            Pair<Integer, Integer> p1 = new Pair<>(e[1], e[2]);
            hm.put(e[0], p1);

            Pair<Integer, Integer> p2 = new Pair<>(e[0], e[2]);
            hm.put(e[1], p2);

            // adj.getOrDefault(e[0], new ArrayList<>()).add(e[1],e[2]);
            // adj.getOrDefault(e[1], new ArrayList<>()).add(e[0],e[2]);

            // hm.put(p,e[2]);
        }
        HashMap<Integer, Integer> res = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        int count = 0;

        while (!pq.isEmpty()) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Pair<Integer, Integer> wt = hm.get(new Pair<>(i, j));
                    if (wt.y <= distanceThreshold) {
                        count++;
                    }
                }


            }

        }
        return count;
    }
}
