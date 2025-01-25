package org.example.dsa;

import java.util.*;

//Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Exp8 {

    public static void main(String[] args){
//        Node n = new Node(1);
//        n.left=new Node(2);
//        n.right=new Node(3);
//        n.left.left=new Node(4);
//        n.left.right=new Node(5);
//        n.right.left=new Node(6);
//        n.right.right=new Node(7);
//        Node res = helper(n);
//        while(res.next!=null){
//            System.out.println(res.left+","+res.right);
//        }


    }

        public static Node helper(Node head){
            Node root = head;
            Queue<Node> pq = new LinkedList<>();
            pq.add(root);

            while(!pq.isEmpty()){
                Node prev=null;
                int size =pq.size();
                for(int i=0;i<size;i++){
                    Node node = pq.poll();
                    if(prev!=null){
                        prev.next=node;
                    }
                    if(pq.isEmpty()){

                        node.next=null;
                    }
                    else{
                        prev=node;
                    }
                    if(node.left!=null){
                        pq.add(node.left);
                    }
                    if(node.right!=null){
                        pq.add(node.right);
                    }
                }
            }

            return head;
        }
    }