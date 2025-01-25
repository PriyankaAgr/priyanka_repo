package org.example.dsa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        String str = "aaabbcaabbddd";

       /* IntStream.range(0,str.length()-1).mapToObj(i->(int)i).map(Character::toLowerCase)
                .collect(Collectors.groupingBy(i-> str.charAt((int)i), LinkedHashMap::new, Collectors.mapping(i-> {
                    if(str.charAt((int)i)!=str.charAt((int)i+1)){
                        Collectors.counting();
                    })));*/


       /* Arrays.stream(str.split("")).map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.mapping(s->s[0]!=s[1]) Collectors.counting())).entrySet()
                .forEach(e-> {StringBuilder s = new StringBuilder();
            for  (int i =0; i< e.getValue();i++){
                s.append(e.getKey());
            }
            System.out.println(s +"->"+e.getValue());
        });;*/
    }
}