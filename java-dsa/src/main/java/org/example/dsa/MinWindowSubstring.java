package org.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t="ABC";

        System.out.println(minWindow(str,t));
    }
    public static String minWindow(String s, String t) {
        Map<Character,Integer> hm = new HashMap<>();
        for(Character c : t.toCharArray()){
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            }
            hm.put(c, 1);
        }

        int ctr=0;String res="";
        int min = Integer.MAX_VALUE;
        int st=0,e=0;
        while(st<s.length()){
            if(e<s.length()) {
                char ch = s.charAt(e++);

                if (hm.containsKey(ch)) {
                    ctr++;
                    hm.put(ch, hm.get(ch) - 1);
                }
            }

            if(ctr==t.length()){
                if(min>(e-st)){
                    res=s.substring(st, e);
                }
                min=Math.min(min,e-st);
                while(t.indexOf(s.charAt(st))==-1){
                    st++;
                }
                hm.put(s.charAt(st), hm.get(s.charAt(st))+1);
                st++;
                ctr--;

            }


        }



        if(e==s.length() && min>(e-st)){
            res=s.substring(st, e);
        }
        return res;
    }
}

