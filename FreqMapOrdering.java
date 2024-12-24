import javax.lang.model.element.Element;
import java.util.*;

public class FreqMapOrdering {

    public static void main(String[] args) {
        MostPopularContent solution = new MostPopularContent();
        solution.increment("k1"); // popularity counter for k1 becomes 1
        solution.increment("k2"); // popularity counter for k2 becomes 1
        solution.increment("k3"); // popularity counter for k3 becomes 1
        System.out.println(solution.getMostPopularContent()); // k2 & k3 have same value, should return k3 as it is last updated.
        solution.increment("k2"); // popularity counter for k2 becomes 2
        solution.increment("k3"); // popularity counter for k3 becomes 2
        solution.decrement("k3"); // popularity counter for k3 becomes 1
        solution.increment("k1"); // popularity counter for k1 becomes 2
        System.out.println(solution.getMostPopularContent()); // k2 & k3 have same value, should return k3 as it is last updated.



    }
}
class MostPopularContent {
    static int time=1;

    Map<String, Element> freqMap = new LinkedHashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((k1, k2)->{
             int cmp = Integer.compare(freqMap.get(k2).freq, freqMap.get(k1).freq);
             if(cmp!=0) return cmp;
             else return Integer.compare(freqMap.get(k2).time, freqMap.get(k1).time);
        });
       public void increment(String id) {
            Element e = freqMap.getOrDefault(id,  new Element(id, 0, 1));
            e.freq++;
            e.setTime(time++);
           freqMap.put(id, e);
           pq.remove(id);
           pq.add(id);

       }
       public void decrement(String id) {
           Element e = freqMap.get(id);
           e.freq--;
           e.setTime(time++);
           freqMap.put(id, e);
           pq.remove(id);
           pq.add(id);

       }
       public String getMostPopularContent() {
           return  pq.peek();


       }

       class Element{
           String id;
           int freq;
           int time;

           Element(String id, int freq, int time){
               this.id = id;
               this.freq=freq;
               this.time=time;
           }

           void setTime(int time){
               this.time=time;
           }
       }
}