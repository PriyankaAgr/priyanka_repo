package org.dsa.incubation;

import java.util.*;

/**•https://leetcode.com/problems/design-browser-history/description/**/

//lfu invalidate and if more than 1 lfu  invlaidate lru
//mfu move to top and mru move to top
public class BrowserHistoryLFU {

    int size;
    Map<String, Integer> hm = new LinkedHashMap<>();
    PriorityQueue<String> pq = new PriorityQueue<>((k1,k2)->hm.get(k1)-hm.get(k2));

BrowserHistoryLFU(int size){
    this.size = size;

}

public void add(String key){
    if(!hm.containsKey(key) && hm.size()==size){
        //invalidate lfu
        String x = pq.poll();
        hm.remove(x);
    }
    hm.put(key,hm.getOrDefault(key,0)+1);
    pq.remove(key);
    pq.add(key);
}

public String access(String key){
    if(!hm.containsKey(key)){
        return null;
    }
    hm.put(key, hm.get(key)+1);
    pq.remove(key);
    pq.add(key);



    return key;

}



    public static void main(String[] args) {
        BrowserHistoryLFU browserHistory = new BrowserHistoryLFU(3);

        browserHistory.add("https://example1.com");
        browserHistory.add("https://example2.com");
        browserHistory.add("https://example3.com");
        browserHistory.access("https://example1.com");
        browserHistory.access("https://example1.com");
        browserHistory.access("https://example2.com");
        browserHistory.add("https://example4.com");
        browserHistory.add("https://example2.com");
        browserHistory.add("https://example3.com");
        browserHistory.add("https://example5.com");
        browserHistory.add("https://example2.com");
        browserHistory.add("https://example3.com");
        browserHistory.add("https://example4.com");
        browserHistory.add("https://example5.com"); // This should trigger invalidation
 }
}

