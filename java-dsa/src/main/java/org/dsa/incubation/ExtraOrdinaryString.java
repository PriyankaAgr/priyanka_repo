package org.dsa.incubation;

import java.util.HashMap;
import java.util.Map;

public class ExtraOrdinaryString {

    /*
     * Complete the 'countSubstrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING input_str as parameter.
     */
    static Map<Character, Integer> hm;
    static int count =0;
    public static int countSubstrings(String input_str) {
        // Write your code here
        hm = new HashMap<>();
        hm.put('a',1);
        hm.put('b',1);
        for(char c ='c'; c<='e';c++){
            hm.put(c,2);
        }
        for(char c ='f'; c<='h';c++){
            hm.put(c,3);
        }
        for(char c ='i'; c<='k';c++){
            hm.put(c,4);
        }
        for(char c ='l'; c<='n';c++){
            hm.put(c,5);
        }for(char c ='o'; c<='q';c++){
            hm.put(c,6);
        }
        for(char c ='r'; c<='t';c++){
            hm.put(c,7);
        }
        for(char c ='u'; c<='w';c++){
            hm.put(c,8);
        }
        for(char c ='x'; c<='z';c++){
            hm.put(c,9);
        }


        int n = input_str.length();
        int count= helper(input_str);
        return count;
    }



    static int helper(String str){
        int n = str.length();
        for(int i=0; i<n;i++){
            for(int j=i+1; j<=n; j++){
                String sub = str.substring(i,j);
                if(check(sub)){
                    count++;
                }
            }

        }
        return count;
    }

    static boolean check(String sub){
        int sum=0;
        for(char ch : sub.toCharArray()){
            sum+=hm.get(ch);

        }
        if(sum%sub.length()==0){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String str = "asdf";
        System.out.println(countSubstrings(str));
    }
}