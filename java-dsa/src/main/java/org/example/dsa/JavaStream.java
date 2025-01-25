package org.example.dsa;


import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

/**
 * TASK - COMBINE ANIMAL & CITIES AND REMOVE/SKIP THE FRUITS , AND ANIMAL != SPARROW AND CITY != NEW YORK  AND FINALLY COLLECT TO LIST<STRING>
 * 		 Use JAVA- 8 STREAMS
 * 		 - Cities should be distinct(if occur more then one time, remove complete entry ) but Animal can be duplicates
 * 		 - For cities length of city should be greater than or equal to  >= 4 char
 * 		 Map<String, List<String>> maps = new HashMap<String, List<String>>();
 * 			  maps.put("Animals", Arrays.asList("Tiger","Dog","Cat","Deer","Monkey","SPARROW","Tiger","Cat")); // SPARROW
 * 			  maps.put("Fruits", Arrays.asList("apple","mango","banana","chiku")); // all ignore
 * 			 maps.put("Cities", Arrays.asList("Hyderabad","Pune","Mumbai","New York","Goa","Chennai","Pune")); // New York
 */
public class JavaStream {
    public static void main(String[] args) {

        PriorityQueue<?> pq = new PriorityQueue<>();
        Map<String, List<String>> maps = new HashMap<String, List<String>>();
        maps.put("Animals", Arrays.asList("Tiger","Dog","Cat","Deer","Monkey","SPARROW","Tiger","Cat")); // SPARROW
        maps.put("Fruits", Arrays.asList("apple","mango","banana","chiku")); // all ignore
        maps.put("Cities", Arrays.asList("Hyderabad","Pune","Mumbai","New York","Goa","Chennai","Pune")); // New York
        List<String> list = List.of("test1", "test2", "test3-test4", "test5-test6-test7", "test8");

       String res =  list.stream().sorted(Comparator.comparing(String::length, reverseOrder())).findFirst().get();
       System.out.println(res);


     /**   List<String> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> e : maps.entrySet()){
            if(e.getKey().equals("Animals")){
                res.add(e.getValue().stream().filter(v-> v!="SPARROW").collect(Collectors.joining(",")));
            }
            else if(e.getKey().equals("Cities")){
                res.add(e.getValue().stream().filter(v-> !v.equals("New York") && v.length()>=4).collect(Collectors.joining(",")));
            }
        }

        res.forEach(val->System.out.print(val+","));


    }
**/
    }
}
