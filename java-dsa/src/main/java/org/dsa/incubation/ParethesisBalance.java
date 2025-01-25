package org.dsa.incubation;

import java.util.Stack;

public class ParethesisBalance {
    public static void main(String[] args) {
        String str  = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(checkValidString(str));

    }


    public static boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int open=0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            if (s.charAt(i) == ')')
                close++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            }
            else if (s.charAt(i) == '*') {
                if (close > open){
                    st.push('(');
                    open++;
                }
                else if (open > close){
                    st.push(')');
                    close++;
                }
            }
            else if (s.charAt(i) == ')' && !st.isEmpty() && st.peek()=='(') {
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.isEmpty()?true:false;



    }
}
