package org.example.dsa;


import java.util.*;
public class MaxStack {
    int max = Integer.MIN_VALUE;
    Stack<Integer> st1;
    Stack<Integer> st2;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    public MaxStack() {
        st1 =new Stack<Integer>();
        st2=new Stack<Integer>();
        

    }

    public void push(int x) {
        st1.push(x);
        pq.add(x);
    }

    public void pop() {

        if(!st1.isEmpty()){
          int x = st1.pop();
            System.out.println(x);
            pq.remove(x);
        }
else {
            System.out.println(-1);
        }


    }

    public void top() {
        if(!st1.isEmpty()){
            System.out.println( st1.peek());
        }
        System.out.println( -1);


    }

    public void peekMax() {

        if(!pq.isEmpty()){
            max=pq.peek();
        }
        /**  while(!st1.isEmpty() && st1.peek()!=max){
         st2.push(st1.pop());
         }
         if(st1.isEmpty()){
         return max;
         }
         // int val = st1.peek();
         while(!st2.isEmpty()){
         st1.push(st2.pop());
         }**/

        System.out.println( max);


    }

    public void popMax() {
        if(!pq.isEmpty()){
            max=pq.poll();
        }
        while(!st1.isEmpty() && st1.peek()!=max){
            st2.push(st1.pop());
        }
        // int val = st1.pop();
        if(!st1.isEmpty()) {
            st1.pop();
        }
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }

        System.out.println(max);

    }

public static void main(String[] args){
    MaxStack obj = new MaxStack();
  obj.push(92);
  obj.peekMax();
  obj.push(54);
  obj.peekMax();
  obj.push(22);
  obj.pop();
  obj.pop();
  obj.push(-57);
  obj.peekMax();
  obj.push(-24);
  obj.popMax();
  obj.top();
  obj.push(26);
  obj.push(-71);
  obj.peekMax();
  obj.popMax();
  obj.popMax();



}
}
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */