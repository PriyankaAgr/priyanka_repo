package org.dsa.incubation;

import java.util.*;
import java.util.Map;

public class AllInOneDS{

    public static void main(String[] args) {
        AllInOne obj = new AllInOne();
        obj.inc("hello");
        obj.inc("hello");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
        obj.inc("leet");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }

}
class AllInOne {

    Map<String, Integer> hm;
    PriorityQueue<String> minHeap;
    PriorityQueue<String> maxHeap;


    public AllInOne() {
        hm= new HashMap<>();
        minHeap = new PriorityQueue<>((a,b)-> hm.get(a)-hm.get(b));
        maxHeap = new PriorityQueue<>((a,b)-> hm.get(b)-hm.get(a));
    }

    public void inc(String key) {
        hm.put(key, hm.getOrDefault(key, 0)+1);
        minHeap.remove(key);
        maxHeap.remove(key);
        minHeap.add(key);
        maxHeap.add(key);
       /** if(hm.get(key)>1){
            freqMap.get(hm.get(key)-1).remove(key);
        }
        freqMap.computeIfAbsent(hm.get(key), k->new ArrayList<>()).add(key);**/



    }

    public void dec(String key) {
        hm.put(key, hm.get(key)-1);
       if(hm.get(key)==0) hm.remove(key);

    }

    public String getMaxKey() {
        return maxHeap.peek();

    }

    public String getMinKey() {
        return minHeap.peek();

    }
}


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */