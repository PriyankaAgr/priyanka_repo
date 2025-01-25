import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class EvenOddTree {

    public static void main(String[] args) {

        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(10);
        n.right = new TreeNode(4);
        n.left.left = new TreeNode(3);
        n.right.left = new TreeNode(7);
        n.right.right = new TreeNode(9);
        n.left.left.left = new TreeNode(12);
        n.left.left.right = new TreeNode(8);
        n.right.left.left = new TreeNode(6);
        n.right.right.right = new TreeNode(2);

        System.out.println(isEvenOdd(n));


    }





    public static boolean isEvenOdd(TreeNode root){
        Deque<TreeNode> pq = new ArrayDeque<>();

        if(root==null) return true;
        pq.add(root);
        boolean isEven=true;
        while(!pq.isEmpty()){
            TreeNode prev= new TreeNode(-1);
            int n = pq.size();
            for(int i=0;i<n;i++){
                TreeNode node = pq.poll();

                if(prev.val!=-1){
                    if(isEven && prev.val>=node.val) return false;
                    if(!isEven && prev.val<=node.val) return false;
                }
                else prev=node;

                if(node.left!=null) pq.add(node.left);
                if(node.right!=null) pq.add(node.right);
            }
            isEven=!isEven;
        }
        return true;
    }


}