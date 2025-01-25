package org.expertifie.lld;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Given a string s, find the longest substring without repeating characters.




Example 1:


Input: s = "abcabcbb"
Output: abc
Explanation: The answer is "abc", with the length of 3.
Example 2:


Input: s = "bbbbb"
Output: b
Explanation: The answer is "b", with the length of 1.

**/


public class MAxWIndowSubstring {

    public static void main(String[] args){
        String str= "abcbcadbcd";
        int n = str.length();
       String res =  findMaxLengthSub(str,n);
       System.out.println(res);
    }
   // abc cbdecd
    private static String findMaxLengthSub(String str, int n) {

        int st=0,e=0;String res="";
        int max=Integer.MIN_VALUE; int len=0; int begin=0;
        Map<Character, Integer> hm = new HashMap<>();

        while(e<n){
            char ch = str.charAt(e);
            if(!hm.containsKey(ch)) {
                hm.put(ch, e);
                e++;


            }

            else{
                if(e-st>max){
                    res= str.substring(st,e);
                    max=e-st;
                }
                int idx=st;
                st=Math.max(hm.get(ch),st)+1;
                while(idx<st){
                    hm.remove(str.charAt(idx));
                    idx++;

                }



            }

            }


        return res;

    }

}














