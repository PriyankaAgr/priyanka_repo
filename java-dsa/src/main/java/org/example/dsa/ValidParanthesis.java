package org.example.dsa;

import java.util.*;

public class ValidParanthesis {
    static Set<String> res = new HashSet<>();

    public static void main(String[] args){

       // Output: ["(())()","()()()"]
        String str = ")(";
        removeInvalidParentheses(str, res);
        res.forEach(System.out::println);


    }


    public static Set<String> removeInvalidParentheses(String s, Set<String> res) {
        int open=0,close=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }
            else if(s.charAt(i)==')'){
                close++;
            }

        }

        if(open==close && isValid(s, res)){
            res.add(s);
            return res;
        }
        if(open>close){
            char ch = '(';
            dfs(s,0,s.length(),ch,new StringBuilder());
        }
        else if(close > open){
            char ch =')';
            dfs(s,0,s.length(),ch,new StringBuilder());
        }
        return res;


    }

    public static void dfs(String s, int idx, int n, char ch, StringBuilder tmp){

        if(idx>n){
            return;
        }
        if(!tmp.isEmpty() && isValid(tmp.toString(), res)) {
            res.add(tmp.toString());
        }
        tmp=new StringBuilder();
        idx=s.indexOf(ch,idx);
        if(idx==-1 || idx>n){
            return;
        }
        tmp.append(s.substring(0, idx)).append(s.substring(idx+1));
        dfs(s,idx+1,n,ch,tmp);
       // tmp.deleteCharAt(tmp.length()-1);




    }

    public static boolean isValid(String tmp, Set<String> res){
        if(res.contains(tmp)){
            return true;
        }

        Stack<Character> st = new Stack<>();
        String regex="[a-z]";

        for(char v: tmp.toCharArray()){
            if(v==')'){
                if(!st.isEmpty()&& st.peek()=='('){

                    st.pop();
                }

                else{
                    return false;
                }
            }
            else if(v=='(') {

                st.push(v);
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;

    }
}