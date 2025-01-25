package org.dsa.incubation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**•https://leetcode.com/problems/design-browser-history/description/**/


public class BrowserHistory {
        Node head;
        Node tail;
        int size;


        public BrowserHistory(String homepage) {
            Node n = new Node(homepage);
            head=n;
            tail=n;
            size=1;

        }

        public void visit(String url) {
            Node n = new Node(url);
            if(head==null){
                return;
            }
            tail.next=n;
            Node tmp=tail;
            tail=tail.next;
            tail.prev=tmp;
            size++;
        }

        public String back(int steps) {
            if(steps>=size){
                tail=head;
                return head.data;
            }
            while(steps>0 && tail.prev!=null){
                tail= tail.prev;
                steps--;
            }
            return tail.data;

        }

        public String forward(int steps) {
            while(steps>0 && tail.next!=null){
                tail=tail.next;
                steps--;
            }
            return tail.data;

        }
    }

    class Node{
        Node next;
        Node prev;
        String data;
        Node(String data){
            this.data= data;
        }


    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */


    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("Leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }
}

