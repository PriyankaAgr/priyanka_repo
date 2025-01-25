/*
package org.example.dsa;

import java.util.PriorityQueue;

public class PlayerGame {


        int stoneGameVI(int[] a, int[] b) {
            int n = a.length;
            int m = b.length;

            // Max heap
            PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>();

            int ans1 = 0;
            int ans2 = 0;

            for(int i=0;i<n;i++) {
                pq.(a[i] + b[i],{a[i], b[i]}});
            }

            bool turn = true;
            while(!pq.empty()) {
                auto k = pq.top();
                pq.pop();
                if(turn) {
                    ans1 += k.second.first;
                } else {
                    ans2 += k.second.second;
                }
                turn = !turn;
            }

            return ans1 == ans2 ? 0 : ans1 > ans2 ? 1 : -1;
        }
    };
}
*/
