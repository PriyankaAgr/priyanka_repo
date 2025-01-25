package org.example.dsa;

import java.util.Stack;

/**
Remove all adjacent duplicates characters from string

aAbcCbd*ck1233kda  → Ad
**/
public class Exp4 {

    public static void main(String[] args){
        String str = "aAbcCbd*ck33kc*da";
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();

        for(String s: str.split("")){
            if(!st.isEmpty() && s.equalsIgnoreCase(st.peek())){
                    st.pop();
            }
            else {
                st.push(s);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());

        }
        System.out.println(sb.reverse().toString().trim());
    }
}
