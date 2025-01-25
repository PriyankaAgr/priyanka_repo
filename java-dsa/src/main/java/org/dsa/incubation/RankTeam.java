/*
package org.dsa.incubation;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class RankTeam {

    public static void main(String[] args) {
        String[] arr = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String res = rankTeams(arr);

        System.out.println(res);

    }

    public static String rankTeams(String[] votes) {
        HashMap<Integer, Map<Character, Integer>> hm = new HashMap<>();
        for (String v : votes) {
            char[] ch = v.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                hm.computeIfAbsent(i+1, k -> new HashMap<>()).put(ch[i], hm.get(i+1).getOrDefault(ch[i],0)+1);
            }
        }
       // StringBuilder sb = new StringBuilder();
        boolean[] vis = new boolean[votes[0].length()];
        for (Map.Entry<Integer, Map<Character, Integer>> e : hm.entrySet()) {
            Map<Character, Integer> vMap = e.getValue();
            StringBuilder sb  = vMap.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue())
                    .reduce((sb,entry1,entry2)-> {
                        if(!vis[entry1.getKey()]) {
                            sb.append(entry1.getKey());
                            vis[entry1.getKey()] = true;
                        }


                        return sb;
                    });



            for(Map.Entry<Character, Integer> en : res){

               if(!vis[en.getKey()]){
                   sb.append(en.getKey());


                sb.append(e1.getKey());
            }
            });
            res.ifPresent(characterIntegerEntry -> sb.append(characterIntegerEntry.getKey()));
        }
        return sb.toString();
    }
}*/
