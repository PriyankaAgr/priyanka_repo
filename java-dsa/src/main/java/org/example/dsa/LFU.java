package org.example.dsa;

import java.util.*;

public class LFU{
public static void main(String[] args){
    LFUCache obj = new LFUCache(3);
    obj.put(1,1);
    obj.put(2,2);
    obj.put(3,3);
    obj.put(4,4);
    obj.get(4);
    obj.get(3);
    obj.get(2);
    obj.get(1);
    obj.put(5,5);
    obj.get(1);
    obj.get(2);
    obj.get(3);
    obj.get(4);
    obj.get(5);
}
}
class LFUCache {
    Map<Integer,Integer> hm = new HashMap<>();
    Map<Integer,Integer> freqMap = new LinkedHashMap<>();

    Queue<Integer> pq = new PriorityQueue<>((e1,e2)-> freqMap.get(e1)-freqMap.get(e2));


    int size;
    public LFUCache(int capacity) {
        size=capacity;

    }

    public int get(int key) {
        if(hm.containsKey(key)){
            freqMap.put(key, freqMap.get(key)+1);
            pq.remove(key);
            pq.offer(key);
            return hm.get(key);

        }
        return -1;


    }

    public void put(int key, int value) {

        if(!hm.containsKey(key) && hm.size()==size){
            int rem = pq.poll();
            hm.remove(rem);
            freqMap.remove(rem);
        }

        hm.put(key,value);
        freqMap.put(key, freqMap.getOrDefault(key, 0)+1);
        pq.remove(key);
        pq.offer(key);

    }
}
